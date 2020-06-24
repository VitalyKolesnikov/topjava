package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_ID = 100000;
    public static final int ADMIN_ID = 100001;
    public static final int NOT_FOUND = 10;
    public static final int BREAKFAST_ID = START_SEQ + 2;
    public static final int DINNER_ID = START_SEQ + 3;

    public static final Meal USER_DINNER = new Meal(DINNER_ID, LocalDateTime.of(2020, 6, 19, 16, 45), "Обед", 1200);

    public static Meal getNew() {
        return new Meal(LocalDateTime.of(2020, 6, 24, 17, 30), "New meal", 555);
    }

    public static Meal getUpdated() {
        Meal updated = new Meal(USER_DINNER);
        updated.setDescription("Updated Meal");
        updated.setCalories(888);
        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}
