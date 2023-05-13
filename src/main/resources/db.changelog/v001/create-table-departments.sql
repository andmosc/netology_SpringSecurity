--liquibase formatted sql
--changeset AndMosc:create-table-departments

create table if not exists spring_security.departments
(
    id     serial,
    name   varchar(255) UNIQUE,
    salary int NOT NULL,
    primary key (id)
);