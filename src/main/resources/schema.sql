drop table student if exists;

CREATE TABLE student (
    student_id   BigInt      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (student_id)
);