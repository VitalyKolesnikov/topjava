package ru.javawebinar.topjava.crud;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;

public interface MealCrud {
    void add(Meal meal);
    void delete(int id);
    void edit(int id, LocalDateTime dateTime, String description, int calories);
}