package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

public class UsersUtil {

    public static final List<User> USERS = Arrays.asList(
            new User(null, "Vitaly", "kvs07@ya.ru", "qwe", Role.ADMIN, Role.USER),
            new User(null, "Vasya", "vpupkin@ya.ru", "123", Role.USER),
            new User(null, "Vasya", "vdudkin@ya.ru", "123", Role.USER),
            new User(null, "Nastya", "doclog@ya.ru", "asdasd", Role.USER),
            new User(null, "Alisher", "ali@ya.ru", "ghm", Role.USER),
            new User(null, "Zoidberg", "zoid@ya.ru", "sfjn", Role.USER)
    );
}