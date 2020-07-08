package ru.javawebinar.topjava.service.meal;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.model.Meal;

import static ru.javawebinar.topjava.UserTestData.*;
import static ru.javawebinar.topjava.MealTestData.*;

@ActiveProfiles("datajpa")
public class DatajpaMealServiceTest extends MealServiceTest {
    @Test
    public void getWithUser() throws Exception {
        Meal actual = service.getWithUser(MEAL1_ID, USER_ID);
        Meal expected = getMealWithUser();
        MEAL_MATCHER.assertMatch(actual, expected);
        USER_MATCHER.assertMatch(actual.getUser(), expected.getUser());
    }
}
