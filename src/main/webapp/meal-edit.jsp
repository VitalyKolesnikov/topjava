<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <title>Add/edit meal</title>
</head>
<body>

<jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.Meal"/>

<form method="post" action="meals?action=edit">
    <input type="hidden" name="id" value="${meal.id}">

    <p>
        <label for="dateTime">
            Date/time
            <input type="datetime-local" id="dateTime" name="dateTime" value="${meal.dateTime}" required>
        </label>
    </p>

    <p>
        <label for="description">
            Description
            <input type="text" id="description" name="description" value="${meal.description}" required>
        </label>
    </p>

    <p>
        <label for="calories">
            Calories
            <input type="number" id="calories" name="calories" value="${meal.calories}" required>
        </label>
    </p>

    <input type="submit">
    <button onclick="window.history.back()" type="button">Cancel</button>
</form>
</body>
</html>