package ru.javawebinar.topjava.crud;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealStorage;

import java.time.LocalDateTime;

public class MealCrudMemoryImpl implements MealCrud {
    @Override
    public void add(Meal meal) {
        MealStorage.getMeals().add(meal);
    }

    @Override
    public void delete(int id) {
        MealStorage.getMeals().removeIf(meal -> meal.getId() == id);
    }

    @Override
    public void edit(int id, LocalDateTime dateTime, String description, int calories) {
        Meal editedMeal = MealStorage.getById(id);
        editedMeal.setDateTime(dateTime);
        editedMeal.setDescription(description);
        editedMeal.setCalories(calories);
    }
}