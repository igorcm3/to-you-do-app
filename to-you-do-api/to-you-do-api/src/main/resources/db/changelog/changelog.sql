--liquibase formatted sql
--changeset igor:V1_CREATE_USER.01

CREATE TABLE "public"."todo"(
    todo_id INT PRIMARY KEY,
    descricao VARCHAR(255) not null,
    version numeric
);

CREATE TABLE "public"."user" (
    user_id serial PRIMARY KEY,
    username VARCHAR ( 50 ) UNIQUE NOT NULL,
    password VARCHAR ( 50 ) NOT NULL,
    version numeric
);