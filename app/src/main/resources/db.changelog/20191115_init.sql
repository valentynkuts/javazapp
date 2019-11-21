
CREATE TABLE section
(
    id_section   BIGSERIAL PRIMARY KEY,
    name VARCHAR   NOT NULL
);

CREATE TABLE category
(
    id_category   BIGSERIAL PRIMARY KEY,
    name VARCHAR   NOT NULL,
    section_id BIGINT NOT NULL,

    FOREIGN KEY(section_id) REFERENCES section(id_section)
);

CREATE TABLE product
(
    id_product   BIGSERIAL  PRIMARY KEY,
    title  TEXT   NOT NULL,
    description  TEXT   NOT NULL,
    price  NUMERIC (9,2)   NOT NULL,
    category_id  BIGINT NOT NULL,
    creator_id  BIGINT NOT NULL,

    FOREIGN KEY(creator_id) REFERENCES profile(id),
    FOREIGN KEY(category_id) REFERENCES category(id_category)
);

CREATE TABLE parametr_name
(
    id_parametr BIGSERIAL  PRIMARY KEY,
    name_key VARCHAR   NOT NULL
);

CREATE TABLE photo
(
    id_photo   BIGSERIAL  PRIMARY KEY,
    name VARCHAR   NOT NULL,
    path  VARCHAR   NOT NULL
);

CREATE TABLE product_parametrval
(
    product_id  BIGINT NOT NULL,
    parametr_id BIGINT NOT NULL,
    value_param VARCHAR   NOT NULL,

    CONSTRAINT   product_parametr_pk PRIMARY KEY(product_id,parametr_id),

    FOREIGN KEY(product_id) REFERENCES product(id_product),

    FOREIGN KEY(parametr_id) REFERENCES parametr_name(id_parametr)
);

CREATE TABLE product_photo
(
    product_id  BIGINT NOT NULL,
    photo_id BIGINT NOT NULL,

    CONSTRAINT   product_photo_pk PRIMARY KEY(product_id,photo_id),

    FOREIGN KEY(product_id) REFERENCES product(id_product),

    FOREIGN KEY(photo_id) REFERENCES photo(id_photo)
);

