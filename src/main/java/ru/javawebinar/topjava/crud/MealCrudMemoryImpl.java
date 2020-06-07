package ru.javawebinar.topjava.crud;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealStorage;
import ru.javawebinar.topjava.util.MealsUtil;

public class MealCrudMemoryImpl implements MealCrud {
    @Override
    public void addMeal(Meal meal) {
        MealStorage.getMeals().add(meal);
    }

    @Override
    public void deleteMeal(int id) {
        MealStorage.getMeals().removeIf(meal -> meal.getId() == id);
    }
}