<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form action="/addBook" method="post" modelAttribute="book">
    <br> <spring:label path="title">Title</spring:label>
    <spring:input path="title"/><br>
    <br> <spring:label path="description">Description</spring:label>
    <spring:textarea path="description"/><br>
    <br> <spring:label path="author">Author</spring:label>
    <spring:select path="author" items="${authors}" itemLabel="name"></spring:select>
    <input type="submit" value="Add">


</spring:form>
</body>
</html>
