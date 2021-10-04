CREATE TABLE member
(
    id             BIGINT AUTO_INCREMENT,
    address        VARCHAR(255),
    address_detail VARCHAR(255),
    age            INTEGER NOT NULL ,
    name           VARCHAR(255),
    nickname       VARCHAR(255),
    password       VARCHAR(20),
    tel            VARCHAR(255),
    zip_code       VARCHAR(5),
    PRIMARY KEY (id)
);

CREATE TABLE email
(
    id        BIGINT AUTO_INCREMENT,
    auth_date TIMESTAMP,
    email     VARCHAR(255),
    send_date TIMESTAMP,
    member_id BIGINT,
    PRIMARY KEY (id)
);

ALTER TABLE email
    ADD CONSTRAINT email_member_id FOREIGN KEY (member_id) REFERENCES member(id)
;