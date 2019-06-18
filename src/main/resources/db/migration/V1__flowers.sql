CREATE TABLE customer(LOGIN VARCHAR(255) PRIMARY KEY, PASSWORD  VARCHAR(255),
ADDRESS VARCHAR(255),
PHONE CHAR(10) check(phone not like '%[^0-9]%'),
MONEY DECIMAL(10,2) check(Money>=0),
DISCOUNT INT CHECK(discount>=0));

CREATE TABLE FLOWER(NAME VARCHAR(255) PRIMARY KEY,
COST DECIMAL(10,2) CHECK(COST>0),
Stock INT check(stock>=0));

insert into flower values ('rose', 10.00, 10);
insert into flower values ('Alyssum', 15.00, 10);
insert into flower values ('Orchid', 20.00, 10);

CREATE TABLE ORDER_INFO (ID int primary key, OrderID integer,
FLOWER VARCHAR(255), FlowerAmount int, COST decimal(10,2),item_cost decimal (10,2));


insert into customer values('test','test', 'donskogo', 12345678, 3500.47, 50);

CREATE TABLE orders(orderID int  primary key, LOGIN VARCHAR(255), TOTAL decimal(10,2),
opendate timestamp, closedate timestamp, state varchar(255) );

CREATE TABLE ADMIN(LOGIN VARCHAR(255) PRIMARY KEY, PASSWORD  VARCHAR(255));

INSERT into admin values('admin','admin123');

CREATE SEQUENCE ORDER_INFO_SEQ
START WITH 0
INCREMENT BY 1
MINVALUE 0
NO MAXVALUE;

CREATE SEQUENCE ORDER_SEQ
START WITH 0
INCREMENT BY 1
MINVALUE 0
NO MAXVALUE;