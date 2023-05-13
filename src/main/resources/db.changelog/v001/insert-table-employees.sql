--liquibase formatted sql
--changeset AndMosc:insert-value-table-employees

insert into spring_security.employees(name, surname, age, department_id)
values ('Андрей', 'Иванов', 25, 1),
       ('Андрей', 'Петров', 35, 2),
       ('Максим', 'Сидоров', 27, 3),
       ('Александр', 'Баранов', 39, 1);