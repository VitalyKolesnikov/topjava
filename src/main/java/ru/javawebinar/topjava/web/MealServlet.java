package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.crud.MealRepository;
import ru.javawebinar.topjava.crud.MemoryMealRepository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@WebServlet("/meals")
public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    MealRepository mealRepository = new MemoryMealRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("mealId");
        int id = idStr == null ? 0 : Integer.parseInt(idStr);

        String action = req.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                mealRepository.delete(id);
                log.debug("delete meal [id = " + id + "]");
                resp.sendRedirect("meals");
                break;
            case "edit":
                req.setAttribute("meal", mealRepository.get(id));
                log.debug("forward to mealEdit - edit");
                req.getRequestDispatcher("/meal-edit.jsp").forward(req, resp);
                break;
            case "all":
            default:
                log.info("getAll");
                List<MealTo> mealsList = MealsUtil.filteredByStreams(mealRepository.getAll(), LocalTime.MIN, LocalTime.MAX, 2000);
                req.setAttribute("meals", mealsList);
                log.debug("forward to meals");
                req.getRequestDispatcher("/meals.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");

        Meal meal = new Meal(id == null ? null : Integer.valueOf(id),
                LocalDateTime.parse(req.getParameter("dateTime")),
                req.getParameter("description"),
                Integer.parseInt(req.getParameter("calories")));

        log.info(meal.isNew() ? "Create {}" : "Update {}", meal);
        mealRepository.save(meal);
        resp.sendRedirect("meals");
    }
}