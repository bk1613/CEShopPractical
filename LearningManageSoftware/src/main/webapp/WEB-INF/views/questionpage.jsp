<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Form</title>

<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/questionpage.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

<h1>Questions</h1>
<div id="percent"></div>
<c:forEach items="${questions}" var="ques">
<div>${ques.id}. ${ques.question}</div>
<p><input class="form-control" type="text" id="${ques.id}" name="question[]"/></p>
</c:forEach>
<input class="btn-sm btn-primary sbtButton" type="button" id="submitBtn" value="submit"/>
</body>
</html>