-- 데이터 베이스: 여러 사람이나 여러 프로그램이 공유하여 사용할 수 있도록 데이터 집합
    -- - 데이터베이스 서버: mysql , 요청에 따라 데이터 처리하고 응답하는 프로그램
    -- - 특징: 실시간 접근 , 동시 공유, 데이터 참조, 지속적인 변화
    -- - 종류 : 1)관계형데이터베이스 2)NOSQL 
-- [sql] : 관계형데이터베이스 데이터를 조작/제어 하기 위한 표준 언어
    --1)DDL 데이터 정의어 : 데이터베이스/테이블 정의하고 변경 CREATE ~ , drop ~ , alter ~

    --2)DML 데이터 조작어 : 테이블 내 데이터들을 조작
    --3)DCL 데이터제어어 : 데이터베이스 접근권한 / 계정관리
    --4)TCL 트랜잭션 제어어 : DML 실행 결과를 취소/적용

    DROP DATABASE IF EXISTS mydb0805;
    CREATE DATABASE mydb0805;
    SHOW DATABASES;
    USE mydb0805;

    #----------------------------------------------------------------------#
    # DDL : 데이터베이스/테이블 생성 /삭제/수정 질의어 (** 트랜잭션 불가능 / 오토 커밋**)

    CREATE Table test1(필드명1 int , 필드명2 double , 필드명3 text)

    show tables;

    DESCRIBE test1;

    drop table test1;

    alter table test1 add 필드명4 FLOAT;
    #2) 필드/속성 수정
    alter table test1 MODIFY 필드명3 longtext;
    

    alter table test1 CHANGE 필드명1 필드명5 bigint;

    RENAME table test1 to new_test1;

    DESCRIBE new_test1;

    TRUNCATE table new_test1;


    #----------------------------------------------------------------------#
    # 테이블의 속성/필드 타입 *DBMS* 회사마다 차이*
    use mydb0805;
    
    create table test2( 필드명 타입, 필드명 타입, 필드명 타입  );


    create table test2( 정수필드 TINYINT, 정수필드2 SMALLINT, 정수필드3 MEDIUMINT, 
                        정수필드4 INT, 정수필드5 BIGINT, 정수필드6 int UNSIGNED,
                        -- UNSIGNED 부호 없다 0~225
                        실수필드1 FLOAT, 실수필드2 DOUBLE, 실수필드3 DECIMAL,
                        -- DECIMAL 문자타입 이면서 소수점 오차 없음
                        날짜월드 date , 시간필드 time , 날짜시간필드 datetime ,
                        문자월드1 char(3) , 문자필드2 VARCHAR(3), 문자필드3 text, 문자필드4 longtext,
                        -- char (문자 고정 길이) vs VARCHAR( 문자 가변길이)
                        -- 예]"수박" --> char( [수][박][x]) vs VARCHAR([수][박])
                        -- 첨부파일 저장시,사진 포함 게시글 : 4G 가능한 longtext
                        논리필드 BOOLEAN 
                       
                         );
                        --boolean(1비트) -->tinyint(1)로 됨 바이트 저장이라
                        --마지막 필드 타입 뒤로 ,넣지 않기

                        DESCRIBE test2;


#----------------------------------------------------------------------#
# 테이블의 속성/필드 타입 *DBMS* 회사마다 차이*

create table test3(
    필드명1 TINYINT not NULL,           -- 해당 필드/속성 에는 null 저장할 수 없도록 설정 * 값이 null이면 오류 발생
    필드명2 smallint UNIQUE,            -- 해당 필드 /속성 에는 중복값을 저장할 수 없도록 설정 *값이 다른 레코드와 같다면
    필드명3 int DEFAULT 100,            -- 해당 필드/속성 에 레코드 (행)추가시 기본값이 10 대입된다.
    필드명4 datetime DEFAULT now(),     -- 예] 레코드삽입시 현재 날짜/시간/now() 자동 대입된다.
    필드명5 BIGINT AUTO_INCREMENT ,
    constraint PRIMARY KEY(필드명5) -- 특정 필드/속성을 pk로 넣는다
    -- AUTO_INCREMENT: 레코드(행)삽입 시 자동으로 순서번호 대입된다. , 1 2 3 4 5 6 ~
    -- primary key(pk) : 기본/식별 키 , 식별 가능한 고유 한 값 갖는 필드(not null+ UNIQUE 내장됨)
    -- foreign key(fk): 참조/왜래 키 (pk가 다른 테이블에 위치한 경우), 다른 테이블의 기본키 참조하는 키
    -- 수강신청한학번, 급여지금사번 , 판매된제품코드
    -- 참조 옵션 : pk가 삭제/수정된 경우 FK 어떻게??
        -- on delete/update CASCADE  : pk가 삭제/수정 되면 fk도 같이 삭제/수정
        -- on delete/update set null : pk가 삭제/수정 되면 fk는 null 로 수정
        -- on delete/update RESTRICT : (생략시 기본값) pk가 fk로부터 참조 중이면 삭제/수정 불가능
);

CREATE table test4(필드명1 BIGINT, 
constraint FOREIGN KEY(필드명1) REFERENCES test3(필드명5) ON delete CASCADE);


# 예제 회원제 게시판 서비스
drop DATABASE IF exists boardService0805;

create DATABASE boardService0805;

use boardService0805;

create table member(
    mno int AUTO_INCREMENT, -- 자동 회원번호
    constraint PRIMARY KEY(mno) , -- 회원번호pk 설정
    mid VARCHAR(30) not null UNIQUE , -- 회원아이디 이면서 최대 30글자, 공백불가능, 중복불가능 설정
    mpwd VARCHAR(20) not NULL , -- 회원비밀번호 이면서 최대 20글자 ,공백불가능, 중복가능 설정
    mname VARCHAR(10) not null , -- 회원닉네임
    mdate DATETIME DEFAULT now() -- 회원가입날짜/시간 , 현재 날짜/시간 자동으로 기본값 설정
)

create table board(
    bno int AUTO_INCREMENT ,
    constraint PRIMARY KEY(bno), -- 게시물  번호 pk 설정 * 테이블 1개당 pk1개이상 권장
    btitle VARCHAR(255), -- 게시물제목
    bcontent longtext , -- 게시물 내용, 대용랑(사진)포함한 최대 4G까지
    pview int DEFAULT 0, -- 조회수
    mno int , -- 작성자(mid/회원아이디 가 아니고 mno/회원번호)
    constraint Foreign Key (mno) REFERENCES member(mno)
        on delete CASCADE -- 회원이 탈퇴/삭제 하면 그 회원이 작성한 게시물도 같이 삭제
)




