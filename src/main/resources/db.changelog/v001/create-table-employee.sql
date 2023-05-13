--liquibase formatted sql
--changeset AndMosc:create-table-employees

create table IF NOT EXISTS spring_security.employees
(
    id            serial,
    name          varchar(255) not null,
    surname       varchar(255) not null,
    age           integer check ( age > 0 and age <= 100 ),
    department_id int,
    primary key (id),
    foreign key (department_id) REFERENCES spring_security.departments (id)
);