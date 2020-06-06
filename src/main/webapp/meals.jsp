<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <style><%@include file="/WEB-INF/css/meal-table.css"%></style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<table class="meal-table">

    <thead>
        <tr>
            <th>Date/time</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>
    </thead>

<jsp:useBean id="meals" scope="request" type="java.util.List"/>

<c:forEach var="meal" items="${meals}">
    <tr style="color: ${meal.excess ?  'red': 'green'}">
        <td>${meal.dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm"))}</td>
        <td>${meal.description}</td>
        <td>${meal.calories}</td>
    </tr>

</c:forEach>
</table>
</body>
</html>