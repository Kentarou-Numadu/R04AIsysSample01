<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sentiment</title>
<style>
	span{
	margin-right : 20px;
	}
</style>
</head>

<body>
<span><a href="./hello">Hello,World!</a></span>
<span><a href="./result"> language(固定)</a></span>
<span><a href="./languageRequest"> language（入力）</a></span>
<span><a href="./SentimentResult"> Sentiment(固定)</a></span>
<span><a href="./SentimentRequest"> Sentiment(入力)</a></span>

<h1>CognitiveServiceを使うサイト(Sentiment)</h1>

<h3>感情分析をしたい文字列を入力してください</h3>

<form method="POST" action="./SentimentResult">
<textarea name="string" cols="30" rows="5" /></textarea>
<input type="submit" />
</form>
</body>
</html>