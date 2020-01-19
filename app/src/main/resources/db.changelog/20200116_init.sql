CREATE TABLE basket
(
    id      BIGINT    NOT NULL,
    user_id BIGINT    NOT NULL,
    last_access_date    TIMESTAMP NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES profile (id)
);

CREATE TABLE basket_item
(
    basket_id  BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    amount     BIGINT NOT NULL,

    PRIMARY KEY (basket_id, product_id),
    FOREIGN KEY (basket_id) REFERENCES basket (id),
    FOREIGN KEY (product_id) REFERENCES product (id)
);