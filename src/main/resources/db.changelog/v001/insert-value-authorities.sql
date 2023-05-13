--liquibase formatted sql
--changeset AndMosc:insert_value_authorities

insert into spring_security.authorities(username, authority)
values ('IvanovA', 'ROLE_ADMIN'),
       ('PetrovA', 'ROLE_USER'),
       ('SidorovM', 'ROLE_USER'),
       ('BaranovA', 'ROLE_USER'),
       ('BaranovA', 'ROLE_USER');
