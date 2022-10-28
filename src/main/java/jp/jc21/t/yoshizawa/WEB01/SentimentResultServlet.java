package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SentimentResult")
public class SentimentResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SentimentResultServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String string = "『機動戦士ガンダム』（きどうせんしガンダム）は、1979年から放映された日本サンライズ制作のロボットアニメ。";
		try {
		Sentiments result = Sentiment.getLanguage(string);
		 float positive = result.documents[0].confidenceScores.positive;
		 float neutral = result.documents[0].confidenceScores.neutral;
		 float negative = result.documents[0].confidenceScores.negative;
		request.setAttribute("positive", positive);
		request.setAttribute("neutral", neutral);
		request.setAttribute("negative", negative);
		request.setAttribute("string",string);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sentimentResult.jsp");
		dispatcher.forward(request, response);
					
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		.setCharacterEncoding("UTF-8");
	String string = 
		request.getParameter("string");
	
	
	
	try {
		Sentiments result = Sentiment.getLanguage(string);
		float positive = result.documents[0].confidenceScores.positive;
		float neutral = result.documents[0].confidenceScores.neutral;
		 float negative = result.documents[0].confidenceScores.negative;
		request.setAttribute("positive", positive);
		request.setAttribute("neutral", neutral);
		request.setAttribute("negative", negative);
		request.setAttribute("string",string);
		request.getRequestDispatcher("/WEB-INF/jsp/sentimentResult.jsp")
			.forward(request, response);
	} catch (IOException e) {
		e.printStackTrace();
	} catch (URISyntaxException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		doGet(request, response);
	}

}
