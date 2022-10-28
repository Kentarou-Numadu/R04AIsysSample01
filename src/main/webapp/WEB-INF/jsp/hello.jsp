<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	span{
	margin-right : 20px;
	}
</style>
</head>
<%
	String message = 
		(String) request.getAttribute("message");

%>

<body>
<span><a href="./hello">Hello,World!</a></span>
<span><a href="./result"> language(固定)</a></span>
<span><a href="./languageRequest"> language（入力）</a></span>
<span><a href="./SentimentResult"> Sentiment(固定)</a></span>
<span><a href="./SentimentRequest"> Sentiment(入力)</a></span>
<H1><%= message %></H1>
</body>
</html>