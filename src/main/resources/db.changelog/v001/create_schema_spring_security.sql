--liquibase formatted sql;
--changeset AndMosc:create-schema-spring_security;
create  schema  IF NOT EXISTS spring_security;
