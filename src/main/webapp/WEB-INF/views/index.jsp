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
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Movies:</h2>
<div style="overflow-x:auto">
    <table>
        <tr>
            <th>Title</th>
            <th>Year</th>
            <th>Genre</th>
            <th>Watched</th>
            <th>Action</th>
        </tr>
        <c:forEach var="movie" items="${movieList}">
            <tr>
                <td>${movie.title}</td>
                <td>${movie.year}</td>
                <td>${movie.genre}</td>
                <td>${movie.watched}</td>
                <td>
                    <c:url value="/edit${movie.id}" var="edit"/>
                    <a href="${edit}">EDIT   </a>
                    <c:url value="/delete${movie.id}" var="delete"/>
                    <a href="${delete}">   DELETE</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new film</a>
</body>
</html>
