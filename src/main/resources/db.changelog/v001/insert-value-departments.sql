--liquibase formatted sql
--changeset AndMosc:insert-value-table-departments

insert into spring_security.departments(name, salary)
values ('IT', 700),
       ('Бухгалтерия', 600),
       ('HR', 850);