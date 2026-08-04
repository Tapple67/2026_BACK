-- 1. sql 문법 작성. 2.;세미콜론 마침 3. 실행할 SQL 문법에 커서 두고

SHOW DATABASES;

SHOW VARIABLES LIKE 'datadir';


CREATE DATABASE mydb0804;

DROP DATABASE mydb0804;

DROP DATABASE IF EXISTS mydb0804;

USE mydb0804;



--초기화 후 사용
DROP DATABASE IF EXISTS boardService;

CREATE DATABASE boardService;

USE boardService;