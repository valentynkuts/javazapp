CREATE TABLE section
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE category
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR NOT NULL,
    section_id BIGINT  NOT NULL,

    FOREIGN KEY (section_id) REFERENCES section (id) --
);

CREATE TABLE product
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR       NOT NULL,
    description TEXT          NOT NULL,
    price       NUMERIC(9, 2) NOT NULL,
    category_id BIGINT        NOT NULL,
    creator_id  BIGINT        NOT NULL,
    version     BIGINT        NOT NULL,

    FOREIGN KEY (creator_id) REFERENCES profile (id),
    FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE photo
(
    id         BIGSERIAL PRIMARY KEY,
    link       VARCHAR NOT NULL,
    sequence      INT     NOT NULL,
    product_id BIGINT  NOT NULL,

    FOREIGN KEY (product_id) REFERENCES product (id)
);

CREATE TABLE parameter
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE product_parameter
(
    product_id   BIGINT  NOT NULL,
    parameter_id BIGINT  NOT NULL,
    value        VARCHAR NOT NULL,

    PRIMARY KEY (product_id, parameter_id),

    FOREIGN KEY (product_id) REFERENCES product (id),

    FOREIGN KEY (parameter_id) REFERENCES parameter (id)
);

