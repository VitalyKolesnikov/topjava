package ru.javawebinar.topjava.service.user;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.model.User;

import static ru.javawebinar.topjava.MealTestData.MEAL_MATCHER;
import static ru.javawebinar.topjava.UserTestData.*;

@ActiveProfiles("datajpa")
public class DatajpaUserServiceTest extends UserServiceTest {
    @Test
    public void getWithMeals() throws Exception {
        User actual = service.getWithMeals(USER_ID);
        User expected = getUserWithMeals();
        USER_MATCHER.assertMatch(actual, expected);
        MEAL_MATCHER.assertMatch(actual.getMeals(), expected.getMeals());
    }
}