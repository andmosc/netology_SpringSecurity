--liquibase formatted sql
--changeset AndMosc:insert_value_users

insert into spring_security.users(username, password, enabled)
values ('IvanovA', '$2y$10$MgGWsLpzbZuffjnEFXYea.BhF8/paGiFV.cJRlaQ8/iMZEieGKBnm', 1), --Password: IvanovA
       ('PetrovA', '$2y$10$aXAbgQLD4JVDBrO4FexMN.dGt6X46HPCzNRPW/9jLEclcxfYc.ILS', 1), --Password: PetrovA
       ('BaranovA', '$2y$10$weG/sOI31toy1YzfgcVO.ubD6Tbrgoi.ATXAxeQoimjOaD1cf61pK', 1),
       ('SidorovM', '$2y$10$7msQ3ywqQ8MY4CHj3q1LFO6GBFu2KODlPK50n9j8eqonxXD1j56YC', 1);