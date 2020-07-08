package ru.javawebinar.topjava.service.user;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.model.User;

import static ru.javawebinar.topjava.UserTestData.*;

@ActiveProfiles("datajpa")
public class DatajpaUserServiceTest extends UserServiceTest {
//    @Test
//    public void getWithMeals() throws Exception {
//        User user = service.getWithMeals(USER_ID);
//        USER_MATCHER.assertMatch(user, getUserWithMeals());
//    }
}