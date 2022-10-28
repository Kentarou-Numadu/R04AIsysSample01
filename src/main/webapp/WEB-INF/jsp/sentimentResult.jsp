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
<%	
	 Object a = request.getAttribute("string");
     Object b = request.getAttribute("positive");
     Object c = request.getAttribute("neutral");
     Object d = request.getAttribute("negative");
     float positive = (float)b;
     float neutral = (float)c;
     float negative = (float)d;
     
     String string = (String)a;
%>

<body>
<span><a href="./hello">Hello,World!</a></span>
<span><a href="./result"> language(固定)</a></span>
<span><a href="./languageRequest"> language（入力）</a></span>
<span><a href="./SentimentResult"> Sentiment(固定)</a></span>
<span><a href="./SentimentRequest"> Sentiment(入力、強調)</a></span>
<h1>元の文</h1>
	<h2><%= string%></h2>
<h1>Sentiments</h1>
	<h2>Positive:<%= positive%></h2>
	<h2>Neutral:<%= neutral%></h2>
	<h2>Negative:<%= negative%></h2>

</body>
</html>