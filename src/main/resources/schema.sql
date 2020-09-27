drop table student if exists;

CREATE TABLE student (
    student_id   BigInt      NOT NULL AUTO_INCREMENT,
    username VARCHAR(128) NOT NULL,
    password VARCHAR(128),
    email VARCHAR(128),
    PRIMARY KEY (student_id)
);