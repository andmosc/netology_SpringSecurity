--liquibase formatted sql
--changeset AndMosc:create_table_authorities
create table if not exists spring_security.authorities
(
    username varchar(25),
    authority varchar(25),
    foreign key (username) REFERENCES spring_security.users (username)
);