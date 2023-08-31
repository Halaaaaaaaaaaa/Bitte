--회원 테이블
--컬럼: 아이디, 비번, 이름, 이메일, 폰번호, 주소, 등급, 가입일
create table users (
   id varchar2(20) primary key,
   pwd varchar2(30) not null,
   name varchar2(15) not null,
   email varchar2(25) not null,
   phone varchar2(13) not null,
   address varchar2(50) not null,
   grade varchar(10) default 'Silver',
   userDate Date default sysdate
);

select * from users;

----------------------------------------------------------------------------------------
--관리자 테이블
--컬럼명 : 아이디, 비번, 이름, 폰번호
create table admin (
   aId varchar2(20) primary key,
   aPwd varchar2(30) not null,
   aName varchar2(15) not null,
   aPhone varchar2(13) not null
);

select * from admin;

----------------------------------------------------------------------------------------
--상품 테이블
--컬럼: 상품코드, 상품분류번호, 상품명, 상품가격, 재고량, 판매량, 상품대표이미지, 상품등록일
create table product (
   pCode number primary key,
   pCage number not null,
   pName varchar2(30) not null,
   price number not null,
   pStock number not null,
   pSell number not null,
   pMainImg varchar2(30) not null,
   pRegdate Date default sysdate
);

--상품코드 시퀀스
create sequence pCode
   start with 1
   increment by 1;
   
select * from product;
----------------------------------------------------------------------------------------
--상품 이미지 테이블
--컬럼: 이미지번호, 상품코드, 상세이미지경로
create table product_img(
    imgCode number primary key,
    pCode number not null,
        constraint fk_pCode foreign key(pCode) references product(pCode),
    imgPath varchar2(50) not null
);

select * from product_img;



commit;
