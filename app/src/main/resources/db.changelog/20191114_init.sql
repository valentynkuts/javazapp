CREATE SEQUENCE hibernate_sequence;

CREATE TABLE profile
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR   NOT NULL,
    surname VARCHAR   NOT NULL,
    password VARCHAR   NOT NULL,
    email VARCHAR   NOT NULL,
    username VARCHAR   NOT NULL,
    birthday VARCHAR   NOT NULL,
    role VARCHAR   NOT NULL,

    PRIMARY KEY (id)
);