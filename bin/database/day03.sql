DROP database IF EXISTS mydb0807;
CREATE DATABASE mydb0807;

use mydb0807; -- ctrl+shift+enter : 전체실행 , ctrl+enter : 한줄실행

CREATE table test(
    번호 INT AUTO_INCREMENT,
    constraint PRIMARY KEY(번호) ,
    이름 VARCHAR(30) NOt NULL UNIQUE,
    개수 int DEFAULT 2
)

--DML : 조작어, 1)insert 레코드 삽입 2) select 레코드조합 3) update 레코드 수정 4)delete 레코드 삭제
-- 레코드란? 테이블내 행/가로 단위
-- [1] insert : insert into 테이블명(속성명1, 속성명2) values(값1, 값2)

INSERT into test(번호,이름,개수) VALUES(1,"유재석",10);

INSERT into test(이름, 개수) VALUES("강호동",20) -- 번호 값 제외

-- [2] select : select * from 테이블명

select * from test;

insert into test(이름) VALUES("신동엽"); -- 번호(auto) , 계수(default) 제외한 삽입
insert into test(이름) VALUES("노홍철");
INSERT INTO test VALUES(4,"하하",30); -- 모든 속성값을 정의 순서대로 값 대입시 속성명 생략

INSERT INTO test( 이름) VALUES("박명수") , ("수박"), ("바나나"); -- 3개의 레코드 삽입

# [2]select : select * from 테이블명 where 조건
-- select * from 테이블명 where 조건

select * from test; -- 테이블내 모든 속성[*]의 레코드 조회
select 이름 from test -- 이름 속성명 

select 이름 , 개수 from test -- 이름 개수 속성명 

select * from test where 이름 = "유재석";  -- 이름 속성명의 값이 유재석이면 조회

select * from test where 개수 >= 5;  -- 이름 속성명의 값이 유재석이면 조회

--[3] update : update 테이블명 set 속성명 = 새로운 값, 속성명 = 새로운 값 where조건

UPDATE test SET 개수 = 10;

UPDATE test set 개수 = 30 WHERE 이름 = "유재석";

UPDATE test set 개수 = 40, 이름 = "강호동2" WHERE 번호 = 2;  -- 번호가 2인 이름,개수를 각각 강호동2, 40으로 업데이트


#[4] delete : delete from 테이블명 where 조건
-- DELETE FROM test;  --테이블내 모든 레코드 제거

delete from test WHERE 이름="유재석";
DELETE FROM test WHERE 번호 = 2;

-- (DML)delete 테이블내 레코드 삭제 [vs] (DDL)truncate table : 테이블내 레코드 삭제 [vs] drop table 테이블 자체 삭제
-- DML 취소(ROLLBACK) 가능,   DDL 은 취소 불가능





# SQL 연산자
# 1. 회원테이블
create table member(    # 아이돌 그룹
 mid char(8) not null ,   # 식별키   최대 8자리
    mname varchar(10) not null , # 그룹명  최대 10자리
    mnumber int not null ,   # 인원수  정수 +-21억정도
    maddr char(2) not null ,   # 지역  최대 2자리
    mphone1 char(3) ,    # 지역번호 최대 2자리
    mphone2 char(8) ,    # 전화번호  최대 8자리
    mheight smallint ,    # 평균키   정수 +-3만정도
 mdebut date ,     # 데뷔일   yyyy-mm-dd
    constraint primary key ( mid )    # 제약조건
);
# 2. 구매테이블
create table buy(
 bnum int auto_increment ,    # 구매번호 정수  자동번호 부여
    mid char(8),      # 구매자  FK
    bpname char(6) not null ,   # 제품명  최대 6자리
    bgname char(4) ,      # 분류명   최대 4자리
    bprice int not null ,    # 가격   정수
    bamount smallint not null ,   # 구매수량 정수
    constraint primary key(bnum) ,     # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);
# 샘플데이터
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

#[1] as 별칭 키워드 , 조회 결과의 속성명 변경 , AS 생략하고 띄어쓰기 사용가능

SELECT mid from member;

SELECT mid as 회원아이디 FROM member;
SELECT mid as 회원아이디 FROM member as 회원테이블;

SELECT mid 회원아이디 FROM member 회원테이블


# [2] distinct , 조회결과의 속성값 중복 제거
select maddr FROM member;

select DISTINCT maddr FROM member;

#[3] 산술 연산자 : +더하기 -뺴기 /나누기 *곱하기 div몫 mod 나머지

SELECT mnumber 인원수, mnumber+3 더하기, mnumber-3 빼기, mnumber/3 나누기,
    mnumber*3 곱하기, mnumber div 3 몫, mnumber mod 3 나머지 FROM member;

    SELECT * from member WHERE mname ="블랙핑크"

    SELECT * FROM member where mnumber =4;

    SELECT * FROM member where mname != "블랙핑크";

    SELECT * FROM member WHERE not mname = "블랙핑크"    -- 블랙핑크 이면 반대(not 부정)

    SELECT * FROM member WHERE mheight <= 162;

    SELECT * FROM member WHERE mheight >=  165 AND mheight <= 170;

    SELECT * FROM member WHERE mheight BETWEEN 165 AND 170;

    SELECT * FROM member WHERE maddr = "경기" OR maddr = "전남" OR maddr = "경남"; -- "지역" 속성값이 3개중 하나이면

    SELECT * FROM member WHERE maddr in("경기", "전남", "경남"); 


    -- 데이터베이스에서 null 처리방법, = null 대신에 is null , !=null 대신에 is not null
    SELECT * FROM member WHERE mphone1 = null;

    SELECT * FROM member WHERE mphone1 is NULL;  -- 주의 = NULL[x] is NULL

    SELECT * FROM member WHERE mname like "에이%";
    SELECT * FROM member WHERE mname like "에이_";

    SELECT * FROM member WHERE mname LIKE "%이%"; -- '이' 가 포함된 모든 문자

    SELECT * FROM member WHERE mname like "_이__";


    


