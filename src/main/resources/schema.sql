CREATE SEQUENCE PRODUCT_SEQ;
CREATE SEQUENCE DISCOUNT_SEQ;
CREATE SEQUENCE DISCOUNT_GROUP_SEQ;
CREATE SEQUENCE PRODUCT_DISCOUNT_GROUP_ASSOCIATION_SEQ;

CREATE TABLE PRODUCT (
   id BIGINT PRIMARY KEY NOT NULL,
   uuid UUID NOT NULL,
   name VARCHAR(100) NOT NULL,
   base_price NUMERIC(20,2) NOT NULL
);
CREATE TABLE DISCOUNT_GROUP(
    id BIGINT PRIMARY KEY  NOT NULL,
    name VARCHAR(100)
);

CREATE TABLE DISCOUNT(
    id  BIGINT  PRIMARY KEY NOT NULL,
    discount_group_id BIGINT,
    type ENUM('count','percentage') NOT NULL,
    discount_value NUMERIC(2,2),
    min_product_amount INT,
    base_discount NUMERIC(2,2),
    max_discount NUMERIC(2,2),
    discount_step NUMERIC(2,2),
    foreign key (discount_group_id) references DISCOUNT_GROUP(id)
);

CREATE TABLE PRODUCT_DISCOUNT_GROUP_ASSOCIATION(
    id  BIGINT  PRIMARY KEY NOT NULL,
    product_id BIGINT NOT NULL,
    discount_group_id BIGINT NOT NULL,
    foreign key (discount_group_id) references DISCOUNT_GROUP(id),
    foreign key (product_id) references PRODUCT(id)
)






