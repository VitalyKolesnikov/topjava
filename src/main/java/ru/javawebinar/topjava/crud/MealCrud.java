package ru.javawebinar.topjava.crud;

import ru.javawebinar.topjava.model.Meal;

public interface MealCrud {
    void addMeal(Meal meal);
    void deleteMeal(int id);
}
