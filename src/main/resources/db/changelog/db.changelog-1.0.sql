--liquibase formatted sql

-- changeset example:1
CREATE TABLE shop
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    address     VARCHAR(255),
    phone       VARCHAR(50),
    email       VARCHAR(100),
    website     VARCHAR(100),
    category    VARCHAR(100),
    description TEXT
);

