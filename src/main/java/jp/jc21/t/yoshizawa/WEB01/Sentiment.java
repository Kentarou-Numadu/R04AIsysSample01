package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Sentiment {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Sentiments message = getLanguage("Stepover Toehold With Facelock");
		if (message != null) {
			System.out.println("Positive:"+message.documents[0].confidenceScores.positive);
			System.out.println("Neutral:"+message.documents[0].confidenceScores.neutral);
			System.out.println("Negative:"+message.documents[0].confidenceScores.negative);
		}
	}

	static Sentiments getLanguage(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();
		String lang="";
		
		try {
			Language result = Json05.getLanguage(s);
			lang = result.documents[0].detectedLanguage.iso6391Name;
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String url = "https://r04jk3b12-text.cognitiveservices.azure.com/"
				+"text/analytics/v3.0/sentiment";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "75619835205245c88a0db12a2a6e8220");

		Docs2 doc = new Docs2();
		doc.language = lang;
		doc.id = "1";
		doc.text = s;

		Source2 src = new Source2();
		src.documents = new Docs2[1];
		src.documents[0] = doc;

		String jsonData = new Gson().toJson(src);

		//InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		
		JsonReader reader = WebApiConnector.postJsonReader(url, map, jsonData);
		//JsonReader reader = WebApiConnector.postJsonReader(url, proxy, map, jsonData);
		Sentiments message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Sentiments.class);
			reader.close();
		}
		return message;
	}

}

class Sentiments {
	Documents2[] documents;
	String[] errors;
	String modelVersion;
}

class Documents2 {
	String id;
	String sentiment;
	ConfidenceScores confidenceScores;
	
}

class  ConfidenceScores{
	float positive;
	float neutral;
	float negative;
}

class Source2 {
	Docs2[] documents;
}

class Docs2 {
	String language;
	String id;
	String text;
}
