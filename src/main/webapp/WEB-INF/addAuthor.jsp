<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Home</a><br>

<br>ADD
<spring:form action="/addAuthor" method="post" modelAttribute="author" enctype="multipart/form-data">
    <br><spring:label path="name">Name</spring:label>
    <spring:input path="name"/><br>
    <br>  <spring:label path="surname">Surname</spring:label>
    <spring:input path="surname"/><br>
    <br>  <spring:label path="email">Email</spring:label>
    <spring:input path="email"/><br>
    <br> <spring:label path="age">Age</spring:label>
    <spring:input path="age"/><br>
    <br><input type="file" name="picture"><br>
   <br> <input type="submit" value="Add">
</spring:form>
</body>
</html>
