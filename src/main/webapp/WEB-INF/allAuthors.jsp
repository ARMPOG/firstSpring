
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Home</a>
<ul>
    <c:forEach items="${authors}" var="author">
        <c:if test="${author.picUrl != null}">
            <img src="/image?fileName=${author.picUrl}" width="60"/>
        </c:if>
        <li>${author.name} ${author.surname} ${author.age}
            <a href="/deleteAuthor?id=${author.id}">X</a>
        </li>
        <ul>
        <c:forEach items="${author.books}" var="book">
            <ol>${book.title} </ol>
        </c:forEach>
        </ul>
    </c:forEach>
</ul>
</body>
</html>
