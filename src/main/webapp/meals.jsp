<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.javawebinar.topjava.util.DateTimeUtil" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <style>
        <%@include file="/WEB-INF/css/meal-table.css" %>
        .normal {color: green;}
        .excess {color: red;}
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<table class="meal-table">

    <thead>
    <tr>
        <th>ID</th>
        <th>Date/time</th>
        <th>Description</th>
        <th>Calories</th>
        <th rowspan="2">Action</th>
        <th></th>
    </tr>
    </thead>

    <jsp:useBean id="meals" scope="request" type="java.util.List"/>
    <c:forEach var="meal" items="${meals}">
        <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
        <tr class="${meal.excess ? 'excess' : 'normal'}">
            <td>${meal.id}</td>
            <td><%=DateTimeUtil.toString(meal.getDateTime())%>
            </td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?action=edit&mealId=<c:out value="${meal.id}"/>">Edit</a></td>
            <td><a href="meals?action=delete&mealId=<c:out value="${meal.id}"/>">Delete</a></td>
        </tr>

    </c:forEach>
</table>

<hr/>
<h2>Add meal</h2>

<form method="post" action="meals?action=add">
    <p>
        <label for="dateTime">
            Date/time
            <input type="datetime-local" id="dateTime" name="dateTime" required>
        </label>
    </p>

    <p>
        <label for="description">
            Description
            <input type="text" id="description" name="description" required>
        </label>
    </p>

    <p>
        <label for="calories">
            Calories
            <input type="number" id="calories" name="calories" required>
        </label>
    </p>
    <input type="submit" value="Add">
</form>

</body>
</html>