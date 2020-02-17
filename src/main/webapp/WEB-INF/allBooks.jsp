
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Home</a>
<ul>
    <c:forEach items="${books}" var="book">
        <li>${book.title} ${book.description} - ${book.author.name} ${book.author.surname}
        </li>
    </c:forEach>
</ul>
</body>
</html>
