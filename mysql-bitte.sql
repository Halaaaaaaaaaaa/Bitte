create database bitte;
show databases;
use bitte;

-- 회원 테이블
-- 컬럼: 아이디, 비번, 이름, 이메일, 폰번호, 주소, 상세주소, 등급, 가입일
create table users (
   id varchar(20) primary key,
   pwd varchar(30) not null,
   name varchar(15) not null,
   email varchar(25) not null,
   phone varchar(13) not null,
   address_kakao varchar(100) not null,
   address_detail varchar(50) not null,
   grade varchar(10) default 'Silver',
   userDate DATETIME  default CURRENT_TIMESTAMP
);

SELECT * FROM users order by userDate;

---------------------------------------------------------------------------------
-- 관리자 테이블
-- 컬럼명 : 아이디, 비번, 이름, 폰번호
create table admin (
   aId varchar(20) primary key,
   aPwd varchar(30) not null,
   aName varchar(15) not null,
   aPhone varchar(13) not null
);

select * from admin;

---------------------------------------------------------------------------------
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

SET @last_p_code = LAST_INSERT_ID();
---------------------------------------------------------------------------------
-- 색상별 상품 테이블
-- 컬럼: 상품코드, 상품 색상, 상품재고량, 상품판매량
create table product_color (
    p_code int primary key,
        constraint fk_color_pcode foreign key(p_code) references total_shop(p_code),
    p_color varchar(20) not null,
    p_color_stock int not null,
    p_color_sell int,
    p_img varchar(30) not null,
    p_img_detail varchar(30) not null
);

select * from product_color order by p_code;

-- 사이즈별 상품 테이블
-- 컬럼: 상품코드, 상품 사이즈, 상품재고량, 상품판매량
CREATE TABLE product_size (
    p_code INT,
    p_size VARCHAR(10) NOT NULL,
    p_size_stock INT NOT NULL,
    p_size_sell INT,
    CONSTRAINT pk_product_size PRIMARY KEY (p_code, p_size),
    CONSTRAINT fk_size_pcode FOREIGN KEY (p_code) REFERENCES total_shop(p_code)
);

select * from product_size order by p_code;

insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'brouwn', '15', '0', 'coat_brown', 'coat_brown_d');
insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'black', '20', '0', 'coat_black', 'coat_black_d');

insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code,'white', '15', '0', 'top_white', 'top_white_d');
insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'black', '25', '0', 'top_black', 'top_black_d');

insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'grey', '27', '0', 'bottom_grey', 'bottom_grey_d');
insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'black', '30', '0', 'bottom_black', 'bottom_black_d');
insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'jean', '35', '0', 'bottom_jean', 'bottom_jean_d');

insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'white', '18', '0', 'dress_white', 'dress_white_d');
insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'ivory', '27', '0', 'dress_ivory', 'dress_ivory_d');
insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'black', '29', '0', 'dress_black', 'dress_black_d');

insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'red', '31', '0', 'bag_red', 'bag_red_d');
insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'black', '32', '0', 'bag_black', 'bag_black_d');
insert into product_color(p_code, p_color, p_color_stock, p_color_sell, p_img, p_img_detail) values (@last_p_code, 'brown', '33', '0', 'bag_brown', 'bag_brown_d');


INSERT INTO product_size(p_code, p_size, p_size_stock, p_size_sell)
VALUES (23, 'S', 50, 0),
       (23, 'M', 50, 0),
       (23, 'L', 50, 0);

INSERT INTO product_size(p_code, p_size, p_size_stock, p_size_sell)
VALUES (20, 'ONE', 50, 0);
INSERT INTO product_size(p_code, p_size, p_size_stock, p_size_sell)
VALUES (21, 'ONE', 50, 0);
INSERT INTO product_size(p_code, p_size, p_size_stock, p_size_sell)
VALUES (22, 'ONE', 50, 0);



---------------------------------------------------------------------------------
-- 상품 이미지 테이블
-- 컬럼: 이미지번호, 상품코드, 상세이미지경로
create table product_img(
    img_code int primary key,
    p_code int not null,
        constraint fk_pCode foreign key(p_code) references total_shop(p_code),
    img_path varchar(50) not null
);

select * from product_img;

---------------------------------------------------------------------------------
-- 후기 테이블
-- 컬럼명: 후기번호, 아이디, 공연번호, 후기작성일, 평점, 내용 
CREATE TABLE review (
   r_code int auto_increment NOT NULL primary key,
   id VARCHAR(20) NULL,
		constraint fk_re_id foreign key(id) references users(id),
   p_code int NOT NULL,
        constraint fk_re_p_code foreign key(p_code) references total_shop(p_code),
   regdate DATETIME  default CURRENT_TIMESTAMP,
   r_point int NOT NULL,
   r_content VARCHAR(150) NOT NULL
);

select * from review;
TRUNCATE review;

---------------------------------------------------------------------------------
-- 고객센터 테이블
-- 컬럼명: 문의번호, 회원id, 상품번호, 이메일, 문의제목, 문의내용, 문의상태, 작성일, 답변
create table cs (
    c_code int auto_increment primary key,
    id varchar(20) not null,
        constraint fk_cs_id foreign key(id) references users(id),
	p_code int not null,
		constraint fk_cs_pCode foreign key(p_code) references total_shop(p_code),
    c_email varchar(25) not null,
    c_title varchar(50) not null, 
    c_content varchar(500) not null,
    c_status varchar(15) default '답변대기',
    c_regdate TIMESTAMP default CURRENT_TIMESTAMP,
    reply varchar(500)
);

select * from cs;

---------------------------------------------------------------------------------
-- 주문 테이블
-- 컬럼명: 주문번호, 아이디, 이름, 핸드폰, 이메일, 주소, 상세주소, 총결제금액, 주문날짜, 배송요청사항, 주문상품개수, 주문현황(1 주문완료, 2 출고완료, 3 배송완료)
create table orders (
	orderCode	int auto_increment primary key,
    id			varchar(20) not null,
				constraint fk_orders_id foreign key(id) references users(id),
	name		varchar(15) not null,
    phone		varchar(13) not null,
    email		varchar(25) not null,
    address_kakao	varchar(100) not null,
    address_detail	varchar(50) not null,
    totalPrice	int not null,
    orderDate	TIMESTAMP default CURRENT_TIMESTAMP,
    orderReq	varchar(100) default '안전하게 배송해주세요.',
    orderCNT	int not null,
    status		int default '1'
);

select * from orders;

---------------------------------------------------------------------------------
-- 주문상세 테이블
-- 컬럼명: 주문상세번호, 주문번호, 상품번호, 가격, 개수
create table orderDetail (
	orderDetCode	int auto_increment primary key,
    orderCode		int not null,
					constraint fk_orderD_orderCode foreign key(orderCode) references orders(orderCode),
	p_code			int not null,
					constraint fk_orderD_pCode foreign key(p_code) references total_shop(p_code),
	price			int not null,
    cnt				int not null	
);

select * from orderDetail;

---------------------------------------------------------------------------------
-- 장바구니 테이블
-- 컬럼명: 장바구니코드, 상품코드, 아이디, 각상품수량
create table cart (
	cartCode	int auto_increment primary key,
    p_code		int not null,
				constraint fk_cart_pCode foreign key(p_code) references total_shop(p_code),
    id			varchar(20) not null,
				constraint fk_cart_id foreign key(id) references users(id),
    itemCNT		int not null
);

select * from cart;

---------------------------------------------------------------------------------
-- 위시리스트 테이블
-- 컬럼명: 회원ID, 상품코드, 찜한 날짜
create table wish_list (
	id varchar(20),
		constraint fk_wishList_id foreign key(id) references users(id),
    p_code int,
        constraint fk_wishList_pcode foreign key(p_code) references total_shop(p_code),
    wish_date DATETIME default CURRENT_TIMESTAMP,
    primary key(id, p_code)
);

SELECT * FROM wish_list order by wish_date;

INSERT INTO wish_list (id, p_code)
VALUES ('heysh2', '20');
INSERT INTO wish_list (id, p_code)
VALUES ('heysh2', '21');
INSERT INTO wish_list (id, p_code)
VALUES ('heysh11', '19');
        
SELECT * FROM wish_list 
WHERE id='heysh2';
SELECT * FROM wish_list 
WHERE id='heysh11';





commit;