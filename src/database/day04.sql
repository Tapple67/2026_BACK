# DB 생성
drop database if exists mydb0811;
create database mydb0811;
use mydb0811;

# 1. 회원 테이블 (member)
create table member(
 mid char(8) not null,   # 식별키 (최대 8자리)
    mname varchar(10) not null,  # 그룹명 (최대 10자리)
    mnumber int not null,   # 인원수
    maddr char(2) not null,   # 지역 (최대 2자리)
    mphone1 char(3),    # 지역번호
    mphone2 char(8),    # 전화번호
    mheight smallint,    # 평균키
 mdebut date,     # 데뷔일 (yyyy-mm-dd)
    constraint primary key (mid)
);

# 2. 구매 테이블 (buy)
create table buy(
 bnum int auto_increment,   # 구매번호 (자동증가)
    mid char(8),     # 구매자 (FK)
    bpname char(6) not null,  # 제품명
    bgname char(4),     # 분류명
    bprice int not null,   # 가격
    bamount smallint not null,  # 구매수량
    constraint primary key(bnum),
    constraint foreign key (mid) references member(mid)
);

# 샘플 데이터
INSERT INTO member VALUES
('TWC','트와이스',9,'서울','02','11111111',167,'2015-10-19'),('BLK','블랙핑크',4,'경남','055','22222222',163,'2016-08-08'),
('WMN','여자친구',6,'경기','031','33333333',166,'2015-01-15'),('OMY','오마이걸',7,'서울',NULL,NULL,160,'2015-04-21'),
('GRL','소녀시대',8,'서울','02','44444444',168,'2007-08-02'),('ITZ','잇지',5,'경남',NULL,NULL,167,'2019-02-12'),
('RED','레드벨벳',4,'경북','054','55555555',161,'2014-08-01'),('APN','에이핑크',6,'경기','031','77777777',164,'2011-02-10'),
('SPC','우주소녀',13,'서울','02','88888888',162,'2016-02-25'),('MMU','마마무',4,'전남','061','99999999',165,'2014-06-19');

INSERT INTO buy VALUES
(NULL,'BLK','지갑',NULL,30,2),(NULL,'BLK','맥북프로','디지털',1000,1),
(NULL,'APN','아이폰','디지털',200,1),(NULL,'MMU','아이폰','디지털',200,5),
(NULL,'BLK','청바지','패션',50,3),(NULL,'MMU','에어팟','디지털',80,10),
(NULL,'GRL','혼공SQL','서적',15,5),(NULL,'APN','혼공SQL','서적',15,2),
(NULL,'APN','청바지','패션',50,1),(NULL,'MMU','지갑',NULL,30,1),
(NULL,'APN','혼공SQL','서적',15,1),(NULL,'MMU','지갑',NULL,30,4);

# 샘플 확인
select * from member;
select * from buy;

SELECT * FROM buy GROUP BY bpname;
SELECT bpname FROM buy GROUP BY bpname;

SELECT bpname, mid FROM buy GROUP BY bpname;

SELECT sum(bamount) from buy;
SELECT avg(bamount) from buy;
SELECT min(bamount) from buy;
SELECT max(bamount) from buy;
SELECT count(bamount) from buy;
SELECT count(*) from buy;

SELECT bpname,sum(bamount) FROM buy GROUP BY bpname;

SELECT mid, sum(bamount) 총구매수량 FROM buy GROUP BY mid;

SELECT mid, sum(bamount * bprice) 총구매가격 FROM buy GROUP BY mid;

SELECT COUNt(*), mid FROM buy GROUP BY mid;


# [4] 그룹절의 조건절, where 그룹*전* 조건 [VS] having 그룹*후* 조건
SELECT * FROM buy where bamount > 3;
SELECT mid, sum(bamount) 총구매수량
 FROM buy GROUP BY mid HAVING 총구매수량 > 5;

SELECT mid, sum(bamount) 총구매수량 FROM buy where 총구매수량 > 5 GROUP BY mid;

-- select 필드명 from 테이블명 where 조건절 group by 그룹 필드 having 그룹조건

#[5] order by 정렬 , desc(내림차순) asc(오름차순)

SELECT * FROM member order by mdebut;

SELECT * FROM member order by mdebut desc;

SELECT * FROM member ORDER BY maddr desc, mdebut asc;

-- [6] limit: 레코드 제한, *페이징처리*

SELECT * FROM member; -- 10개

SELECT * FROM member LIMIT 2;

SELECT * FROM member LIMIT 0, 2;

SELECT * FROM member LIMIT 5, 5;



