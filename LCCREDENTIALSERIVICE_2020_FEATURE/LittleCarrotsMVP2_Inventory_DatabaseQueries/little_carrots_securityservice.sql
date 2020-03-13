#create database little_carrots_securityservice;
#CreatING User 'little_carrots_authentications'
#create user 'littlesecurity'@'localhost' identified by 'littlesecurity';
#Granting all permission to the user 'littlesecurity'
GRANT ALL PRIVILEGES ON little_carrots_securityservice.* TO 'littlesecurity'@'localhost';

use little_carrots_securityservice;

create table securitykeymanagement(
keyid bigint auto_increment,
keyname varchar(100),
keyvalue varchar(1000),
constraint securitykeymanagement_pk primary key (keyid)
);

ALTER TABLE securitykeymanagement AUTO_INCREMENT = 1000;

insert securitykeymanagement(keyname, keyvalue) values('AUTH_API_ACCESS_KEY', 'LRtt3I-ARtlos-51TCOi-er1212-1819TE-Tlcr92-01820L-Sa2015');
insert securitykeymanagement(keyname, keyvalue) values('SECU_API_ACCESS_KEY', 'LSt15I-Tlos18-20TOir-121819-TRtr91-LRta20-3EALC2-05ce12');
insert securitykeymanagement(keyname, keyvalue) values('INVENTORY_API_ACCESS_KEY', 'Li20Il-t920TS-t1212T-Tls5LO-et319E-Rco120-CRar18-15Ar18');



create table serviceurls
(
servicename varchar(30) unique,
url varchar(1000),
timeout bigint,
method varchar(20),
constraint serviceurls_pk2 primary key (servicename)

);

alter table serviceurls add column serviceip varchar(1000);



insert serviceurls(servicename, serviceip, url,timeout,method) values
('AUTHORIZATION_GET','http://localhost:8282','/authorization',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('AUTHORIZATION_POST','http://localhost:8282','/authorization',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('AUTHORIZATION_PUT','http://localhost:8282','/authorization',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('AUTHORIZED_USER_GET','http://localhost:8282','/authorizeduser',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('AUTHORIZED_USER_POST','http://localhost:8282','/authorizeduser',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('AUTHORIZED_USER_LOGIN_POST','http://localhost:8282','/authuserlogin',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('AUTHORIZED_USER_PUT','http://localhost:8282','/authorizeduser',1000,'PUT');


insert serviceurls(servicename, serviceip, url,timeout,method) values
('SELLER_POST','http://localhost:8282','/sellers',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('SELLER_PUT','http://localhost:8282','/sellers',1000,'PUT');


insert serviceurls(servicename, serviceip, url,timeout,method) values
('SELLER_USER_GET','http://localhost:8282','/salesusers',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('SELLER_USER_PUT','http://localhost:8282','/salesusers',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('SELLER_USER_POST_LOGIN','http://localhost:8282','/salesuserslogin',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('SELLER_USER_POST','http://localhost:8282','/salesusers',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('COUNTRIES_GET','http://localhost:8383','/countries',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('COUNTRIES_PUT','http://localhost:8383','/countries',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('COUNTRIES_ACTIVE_GET','http://localhost:8383','/activecountries',1000,'GET');



insert serviceurls(servicename, serviceip, url,timeout,method) values
('COLORSERVICE_POST','http://localhost:8383','/color',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('COLORSERVICE_GET','http://localhost:8383','/color',1000,'GET');
insert serviceurls(servicename, serviceip, url,timeout,method) values
('COLORSERVICE_PUT','http://localhost:8383','/color',1000,'PUT');
insert serviceurls(servicename, serviceip, url,timeout,method) values
('COLOR_ACTIVE_GET','http://localhost:8383','/color',1000,'GET');


# satya 

insert serviceurls(servicename, serviceip, url,timeout,method) values
('BATCHES_GET','http://localhost:8383','/batches',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('BATCHES_PUT','http://localhost:8383','/batches',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('BATCHES_POST','http://localhost:8383','/batches',1000,'POST');


------------ # Satya-----------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('GENDERS_GET','http://localhost:8383','/genders',1000,'GET');

--------     # Phani (colors) --------
#insert serviceurls(servicename, serviceip, url,timeout,method) values
#('COLORSERVICE_POST','http://localhost:8383','/color',1000,'POST');
#insert serviceurls(servicename, serviceip, url,timeout,method) values
#('COLORSERVICE_GET','http://localhost:8383','/color',1000,'GET');
#insert serviceurls(servicename, serviceip, url,timeout,method) values
#('COLORSERVICE_PUT','http://localhost:8383','/color',1000,'PUT');
#insert serviceurls(servicename, serviceip, url,timeout,method) values
#('COLOR_ACTIVE_GET','http://localhost:8383','/color',1000,'GET');

----------------- # Satya -----------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('MATERIALTYPES_GET','http://localhost:8383','/material',1000,'GET');
insert serviceurls(servicename, serviceip, url,timeout,method) values
('MATERIALTYPES_POST','http://localhost:8383','/material',1000,'POST');
insert serviceurls(servicename, serviceip, url,timeout,method) values
('MATERIALTYPES_PUT','http://localhost:8383','/material',1000,'PUT');


---------# satya (Batches)----------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('BATCHES_GET','http://localhost:8383','/batches',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('BATCHES_PUT','http://localhost:8383','/batches',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('BATCHES_POST','http://localhost:8383','/batches',1000,'POST');



---------------- # Trinath (seasonwear, productType & Occasional Wear) -------------

insert serviceurls(servicename, serviceip, url,timeout,method) values
('SEASONWEAR_GET','http://localhost:8383','/seasonwear',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('SEASONWEAR_POST','http://localhost:8383','/seasonwear',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('SEASONWEAR_PUT','http://localhost:8383','/seasonwear',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTTYPE_GET','http://localhost:8383','/producttype',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTTYPE_POST','http://localhost:8383','/producttype',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTTYPE_PUT','http://localhost:8383','/producttype',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('OCCASIONALWEAR_GET','http://localhost:8383','/occasionalwear',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('OCCASIONALWEAR_POST','http://localhost:8383','/occasionalwear',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('OCCASIONALWEAR_PUT','http://localhost:8383','/occasionalwear',1000,'PUT');


------------------------------- # Rekha (Material Composition) ------------------

insert serviceurls(servicename, serviceip, url,timeout,method) values
('MATERIALCOMPOSITION_GET','http://localhost:8383','/materialcomp',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('MATERIALCOMPOSITION_PUT','http://localhost:8383','/materialcomp',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('MATERIALCOMPOSITION_POST','http://localhost:8383','/materialcomp',1000,'GET');


---------------------- # Aadarsh (PriceTable) -------------------

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRICESTABLE_POST','http://localhost:8383','/pricestable',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRICESTABLE_PUT','http://localhost:8383','/pricestable',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRICESTABLE_GET','http://localhost:8383','/pricestable',1000,'GET');

------------------------------- # Rekha (Product Quantities)------------------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTQUANTITIES_GET','http://localhost:8383','/productquantities',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTQUANTITIES_PUT','http://localhost:8383','/productquantities',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTQUANTITIES_POST','http://localhost:8383','/productquantities',1000,'POST');

----------------------# Aadarsh ----------------------------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTDESCRIPTION_POST','http://localhost:8383','/productdescriptions',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTDESCRIPTION_PUT','http://localhost:8383','/productdescriptions',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTDESCRIPTION_GET','http://localhost:8383','/productdescriptions',1000,'GET');


--------- # satya (wareHouses)----------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('WAREHOUSES_GET','http://localhost:8383','/warehouses',1000,'GET');
insert serviceurls(servicename, serviceip, url,timeout,method) values
('WAREHOUSES_POST','http://localhost:8383','/warehouses',1000,'POST');
insert serviceurls(servicename, serviceip, url,timeout,method) values
('WAREHOUSES_PUT','http://localhost:8383','/warehouses',1000,'PUT');

----------------- # Trinath (Patterns) --------------

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PATTERNS_GET','http://localhost:8383','/patterns',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PATTERNS_POST','http://localhost:8383','/patterns',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PATTERNS_PUT','http://localhost:8383','/patterns',1000,'PUT');


---------------------- # Aadarsh (Warehouses & Products) -------------------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('WAREHOUSETOSELLER_POST','http://localhost:8383','/sellertowarehouse',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('WAREHOUSETOSELLER_GET','http://localhost:8383','/sellertowarehouse',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTS_POST','http://localhost:8383','/products',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTS_PUT','http://localhost:8383','/products',1000,'PUT');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTS_GET','http://localhost:8383','/products',1000,'GET');


---------------------- # Phani (no of pieces) -------------------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('NOOFPIECES_GET','http://localhost:8383','/noofpieces',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('NOOFPIECES_POST','http://localhost:8383','/noofpieces',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('NOOFPIECES_PUT','http://localhost:8383','/noofpieces',1000,'PUT');




---------------------- # Phani (productage) -------------------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTAGE_GET','http://localhost:8383','/productage',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTAGE_POST','http://localhost:8383','/productage',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('PRODUCTAGE_PUT','http://localhost:8383','/productage',1000,'PUT');




---------------------- # Aadarsh (categories) -------------------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('CATEGORIES_GET','http://localhost:8383','/categories',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('CATEGORIES_POST','http://localhost:8383','/categories',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('CATEGORIES_PUT','http://localhost:8383','/categories',1000,'PUT');


---------------------- # Trinath (SubCategories) -------------------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('SUBCATEGORIES_GET','http://localhost:8383','/subcategories',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('SUBCATEGORIES_POST','http://localhost:8383','/subcategories',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('SUBCATEGORIES_PUT','http://localhost:8383','/subcategories',1000,'PUT');



---------------------- # Aadarsh (sizes) -------------------
insert serviceurls(servicename, serviceip, url,timeout,method) values
('SIZES_GET','http://localhost:8383','/sizes',1000,'GET');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('SIZES_POST','http://localhost:8383','/sizes',1000,'POST');

insert serviceurls(servicename, serviceip, url,timeout,method) values
('SIZES_PUT','http://localhost:8383','/sizes',1000,'PUT');


insert serviceurls(servicename, serviceip, url,timeout,method) values
('SELLER_GET','http://localhost:8282','/sellers',1000,'GET');
insert serviceurls(servicename, serviceip, url,timeout,method) values
('SELLER_POST','http://localhost:8282','/sellers',1000,'POST');
insert serviceurls(servicename, serviceip, url,timeout,method) values
('SELLER_PUT','http://localhost:8282','/sellers',1000,'PUT');

#09-MAR-2020 SHAIK ADDED QUERIES
insert securitykeymanagement(keyname, keyvalue) values('EMAIL_API_ACCESS_KEY', 'Li20Il-t920TS-t1212T-Tls5LO-et319E-Rco120-CRar18-15Ar18');

insert serviceurl(servicename, serviceip, url, timeout, method) values
('EMAIL_POST', 'http://localhost:8281', '/mail/v1/push1', 1000, 'POST');