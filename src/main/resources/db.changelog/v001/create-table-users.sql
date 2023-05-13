--liquibase formatted sql
-- changeset AndMosc:create_table_usesrs

create table spring_security.users
(
    username varchar(25) PRIMARY KEY,
    password varchar(100),
    enabled smallint
);