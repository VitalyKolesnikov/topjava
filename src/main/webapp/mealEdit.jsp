<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add/edit meal</title>
</head>
<body>

<jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.Meal"/>

    <form method="post" action="meal-controller?action=add">
        <label for="dateTime">
            Date/time
            <input type="datetime-local" id="dateTime" name="dateTime" value="${meal.dateTime}">
        </label>
        <label for="description">
            Description
            <input type="text" id="description" name="description" value="${meal.description}">
        </label>
        <label for="calories">
            Calories
            <input type="text" id="calories" name="calories" value="${meal.calories}">
        </label>
        <input type="submit">
    </form>
</body>
</html>