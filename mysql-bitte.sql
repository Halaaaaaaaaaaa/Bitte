create database bitte;
show databases;
use bitte;

-- 회원 테이블
-- 컬럼: 아이디, 비번, 이름, 이메일, 폰번호, 주소, 등급, 가입일
create table users (
   id varchar(20) primary key,
   pwd varchar(30) not null,
   name varchar(15) not null,
   email varchar(25) not null,
   phone varchar(13) not null,
   address varchar(50) not null,
   grade varchar(10) default 'Silver',
   userDate DATETIME  default CURRENT_TIMESTAMP
);

SELECT * FROM users;

----------------------------------------------------------------------------------------
-- 관리자 테이블
-- 컬럼명 : 아이디, 비번, 이름, 폰번호
create table admin (
   aId varchar(20) primary key,
   aPwd varchar(30) not null,
   aName varchar(15) not null,
   aPhone varchar(13) not null
);

select * from admin;

----------------------------------------------------------------------------------------
-- 상품 테이블
-- 컬럼: 상품코드, 상품분류번호, 상품명, 상품가격, 상품등록일
create table total_shop (
   p_code int auto_increment primary key,
   p_category varchar(1) not null,   -- 1:Outer, 2:Top, 3:Bottom, 4: Dress, 5:Acc
   p_name varchar(30) not null,
   p_price varchar(8) not null,
   p_regdate TIMESTAMP default CURRENT_TIMESTAMP
);

select * from total_shop;



insert into total_shop(p_category, p_name, p_price) values(1, 'fall coate', '110,000');
insert into total_shop(p_category, p_name, p_price) values(2, 'fall top', '90,000');
insert into total_shop(p_category, p_name, p_price) values(3, 'fall bottom', '80,000');
insert into total_shop(p_category, p_name, p_price) values(4, 'fall dress', '89,000');
insert into total_shop(p_category, p_name, p_price) values(5, 'fall bag', '140,000');
-- insert into total_shop(p_code, p_category, p_name, p_price, p_img) values(pCode.NEXTVAL, 1, 'fall coate', '110,000', '가을 코트');
-- insert into total_shop(p_code, p_category, p_name, p_price, p_img) values(pCode.NEXTVAL, 2, 'fall top', '90,000', '가을 상의');
-- insert into total_shop(p_code, p_category, p_name, p_price, p_img) values(pCode.NEXTVAL, 3, 'fall bottom', '80,000', '가을 하의');
-- insert into total_shop(p_code, p_category, p_name, p_price, p_img) values(pCode.NEXTVAL, 4, 'fall dress', '89,000', '가을 드레스');
-- insert into total_shop(p_code, p_category, p_name, p_price, p_img) values(pCode.NEXTVAL, 5, 'fall bag', '140,000', '가을 백');

----------------------------------------------------------------------------------------
-- 색상별 상품 테이블
-- 컬럼: 상품코드, 상품 색상, 상품재고량, 상품판매량
create table product_color (
    p_code int,
        constraint fk_color_pcode foreign key(p_code) references total_shop(p_code),
    p_color varchar(20) not null,
    p_color_stock int not null,
    p_color_sell int,
    p_img varchar(30) not null
);


select * from product_color order by p_code;

-- 사이즈별 상품 테이블
-- 컬럼: 상품코드, 상품 사이즈, 상품재고량, 상품판매량
create table product_size (
    p_code int,
    p_size varchar(10) not null,
    p_size_stock int not null,
    p_size_sell int,
        constraint fk_size_pcode foreign key(p_code) references total_shop(p_code)
);

select * from product_size order by p_code;

-- a.p_code, a.p_category, a.p_name, a.p_price, a.p_regdate, b.p_color, b.p_stock, b.p_sell, b.p_img, c.p_size, c.p_stock, c.p_sell
select a.p_code, a.p_category, a.p_name, a.p_price, a.p_regdate, b.p_color, b.p_color_stock, b.p_img
from  total_shop a, product_color b
where a.p_code = b.p_code
ORDER BY a.p_code DESC;


SELECT a.p_code, a.p_category, a.p_name, a.p_price, a.p_regdate, b.p_color, b.p_color_stock, b.p_img, c.p_size, c.p_size_stock, c.p_size_sell
		FROM total_shop a, product_color b, product_size c
		WHERE a.p_code = b.p_code AND a.p_code = c.p_code AND c.p_code = b.p_code
			AND p_category = '1' AND b.p_color = 'black' AND c.p_size = 'S'
		ORDER BY p_code DESC;

-- SELECT  a.p_code, a.p_category, a.p_name, a.p_price, a.p_regdate, b.p_color, b.p_color_stock, b.p_color_sell, b.p_img, c.p_size, c.p_size_stock, c.p_size_sell
--		FROM total_shop a, product_color b, product_size c
--		WHERE a.p_code = b.p_code AND a.p_code = c.p_code AND c.p_code = b.p_code
--		    AND a.p_code = '1' AND a.p_name = 'Fall Coat' AND b.p_color = 'black';

SELECT  a.p_code, a.p_category, a.p_name, a.p_price, a.p_regdate, b.p_color, b.p_color_stock, b.p_color_sell, b.p_img
		FROM total_shop a, product_color b
		WHERE a.p_code = b.p_code
		    AND a.p_code = '1' AND a.p_name = 'Fall Coat' AND b.p_color = 'black';

insert into product_color values ('1', 'brouwn', '15', '0', 'coat_brown');
insert into product_color values ('1', 'black', '20', '0', 'coat_black');
insert into product_color values ('2', 'white', '15', '0', 'top_white');
insert into product_color values ('2', 'black', '25', '0', 'top_black');
insert into product_color values ('3', 'grey', '27', '0', 'bottom_grey');
insert into product_color values ('3', 'black', '30', '0', 'bottom_black');
insert into product_color values ('3', 'jean', '35', '0', 'bottom_jean');
insert into product_color values ('4', 'white', '18', '0', 'dress_white');
insert into product_color values ('4', 'ivory', '27', '0', 'dress_ivory');
insert into product_color values ('4', 'black', '29', '0', 'dress_black');
insert into product_color values ('5', 'red', '31', '0', 'bag_red');
insert into product_color values ('5', 'black', '32', '0', 'bag_black');
insert into product_size values ('1', 'S', '3', '0');
insert into product_size values ('1', 'M', '8', '0');
insert into product_size values ('1', 'L', '10', '0');
insert into product_size values ('2', 'S', '4', '0');
insert into product_size values ('2', 'M', '9', '0');
insert into product_size values ('2', 'L', '11', '0');
insert into product_size values ('3', 'S', '5', '0');
insert into product_size values ('3', 'M', '10', '0');
insert into product_size values ('3', 'L', '12', '0');
insert into product_size values ('4', 'S', '6', '0');
insert into product_size values ('4', 'M', '11', '0');
insert into product_size values ('4', 'L', '13', '0');
insert into product_size values ('5', '0', '30', '0');

----------------------------------------------------------------------------------------
-- 상품 이미지 테이블
-- 컬럼: 이미지번호, 상품코드, 상세이미지경로
create table product_img(
    img_code int primary key,
    p_code int not null,
        constraint fk_pCode foreign key(p_code) references total_shop(p_code),
    img_path varchar(50) not null
);

select * from product_img;


commit;