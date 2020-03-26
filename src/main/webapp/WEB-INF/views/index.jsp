<%--
  Created by IntelliJ IDEA.
  User: Family
  Date: 26.03.2020
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>All movies</title>
</head>
<body>
<h2>Movies:</h2>
<table>
    <tr>
        <th>title</th>
        <th>year</th>
        <th>genre</th>
        <th>watched</th>
        <th>action</th>
    </tr>
    <c:forEach var="movie" items="${movieList}">
        <tr>
            <td>${movie.title}</td>
            <td>${movie.year}</td>
            <td>${movie.genre}</td>
            <td>${movie.watched}</td>
            <td>
                <c:url value="/edit/${movie.id}" var="edit"/>
                <a href="${edit}">Edit</a>
                <a href="/delete/${movie.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new film</a>
</body>
</html>
