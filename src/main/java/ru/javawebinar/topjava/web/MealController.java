package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.crud.MealCrud;
import ru.javawebinar.topjava.crud.MealCrudMemoryImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealController extends HttpServlet {
    private static final Logger log = getLogger(MealController.class);
    MealCrud mealCrud = new MealCrudMemoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("mealId"));
        switch (req.getParameter("action")) {
            case "delete":
                mealCrud.deleteMeal(id);
                log.debug("delete meal [id = " + id + "]");
                resp.sendRedirect("meals");
                break;
            case "edit":
                req.setAttribute("meal", MealStorage.getById(id));
                log.debug("forward to mealEdit");
                req.getRequestDispatcher("/mealEdit.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("add".equals(req.getParameter("action"))) {
            LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("dateTime"));
            String description = req.getParameter("description");
            int calories = Integer.parseInt(req.getParameter("calories"));
            mealCrud.addMeal(new Meal(dateTime, description, calories));
            log.debug("add new meal");
            resp.sendRedirect("meals");
        }
    }
}