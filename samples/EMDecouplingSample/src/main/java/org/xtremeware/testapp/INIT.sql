CREATE USER 'testapp'@'localhost' IDENTIFIED BY 'testapp';
CREATE DATABASE testapp;
GRANT ALL ON testapp.* TO 'testapp'@'localhost';
USE testapp;
CREATE TABLE usertest (
    id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);
