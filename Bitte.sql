--ȸ�� ���̺�
--�÷�: ���̵�, ���, �̸�, �̸���, ����ȣ, �ּ�, ���, ������
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
--������ ���̺�
--�÷��� : ���̵�, ���, �̸�, ����ȣ
create table admin (
   aId varchar2(20) primary key,
   aPwd varchar2(30) not null,
   aName varchar2(15) not null,
   aPhone varchar2(13) not null
);

select * from admin;

----------------------------------------------------------------------------------------
--��ǰ ���̺�
--�÷�: ��ǰ�ڵ�, ��ǰ�з���ȣ, ��ǰ��, ��ǰ����, ���, �Ǹŷ�, ��ǰ��ǥ�̹���, ��ǰ�����
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

--��ǰ�ڵ� ������
create sequence pCode
   start with 1
   increment by 1;
   
select * from product;
----------------------------------------------------------------------------------------
--��ǰ �̹��� ���̺�
--�÷�: �̹�����ȣ, ��ǰ�ڵ�, ���̹������
create table product_img(
    imgCode number primary key,
    pCode number not null,
        constraint fk_pCode foreign key(pCode) references product(pCode),
    imgPath varchar2(50) not null
);

select * from product_img;



commit;
