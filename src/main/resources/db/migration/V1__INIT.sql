CREATE TABLE member
(
    id             BIGINT AUTO_INCREMENT,
    address        VARCHAR(255),
    address_detail VARCHAR(255),
    age            INTEGER NOT NULL ,
    email          VARCHAR(255),
    name           VARCHAR(255),
    nickname       VARCHAR(255),
    password       VARCHAR(20),
    tel            VARCHAR(255),
    zip_code       VARCHAR(5),
    PRIMARY KEY (id)
)
