DELETE FROM meals;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (user_id, date_time, description, calories) VALUES
  (100000, '2020-06-19 09:45', 'Завтрак', 500),
  (100000, '2020-06-19 16:45', 'Обед', 1200),
  (100000, '2020-06-24 09:45', 'Завтрак', 500),
  (100000, '2020-06-24 15:30', 'Обед', 1000),
  (100000, '2020-06-24 19:00', 'Ужин', 550),
  (100000, '2020-06-28 09:45', 'Завтрак', 500),
  (100000, '2020-06-28 16:45', 'Обед', 1200),
  (100001, '2020-06-23 11:00', 'Админ завтрак', 550),
  (100001, '2020-06-23 15:00', 'Админ обед', 1550);