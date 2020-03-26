<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty movie.title}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty movie.title}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty movie.title}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty movie.title}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty movie.title}">
        <input type="hidden" name="id" value="${movie.id}">
    </c:if>
    <label for="title">Title</label>
    <input type="text" name="title" id="title" value="${movie.title}">
    <label for="year">Year</label>
    <input type="text" name="year" id="year" value="${movie.year}">
    <label for="genre">Genre</label>
    <input type="text" name="genre" id="genre" value="${movie.genre}">
    <label for="watched">Watched</label>
    <input type="text" name="watched" id="watched" value="${movie.watched}">
    <c:if test="${empty movie.title}">
        <input type="submit" value="Add new movie">
    </c:if>
    <c:if test="${!empty movie.title}">
        <input type="submit" value="Edit movie">
    </c:if>
</form>
</body>
</html>