-- day12 Exam2 연동
DROP DATABASE If EXISTS mydb0813;
CREATE DATABASE mydb0813;

use mydb0813;

CREATE Table board(
    no int AUTO_INCREMENT ,
    content VARCHAR(30),
    writer VARCHAR(30),
    constraint PRIMARY KEY(no)
);

insert into board( content, writer )values( "안녕하세요", "유재석" ),( "하하", "강호동");

CREATE TABLE test(
    no int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30)
);