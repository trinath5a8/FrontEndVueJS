create database little_carrots_authentications;
#CreatING User 'little_carrots_authentications'
create user 'littleauthentication'@'localhost' identified by 'littleauthentication';
#Granting all permission to the user 'LittleInventory'
GRANT ALL PRIVILEGES ON little_carrots_authentications.* TO 'littleauthentication'@'localhost';

use little_carrots_authentications;


create table authorization(
RoleName 	varchar(20),	
Descriptions	varchar(200),
authorization_status boolean,
constraint authorization_pk1 primary key (ROLENAME));

create table authorizedusers(	
username	varchar(60)	,	
email	varchar(60)	Unique Not Null	,
password	varchar(60)	,	
authuserstatus	boolean	,	
rolename varchar(50)	,
constraint authorizedusers_pk primary key (username),
constraint authorizedusers_fk foreign key (rolename) references authorization(rolename)
);

#----13-01-2020--- data queries
alter table authorizedusers add column lastlogindate datetime;
ALTER TABLE authorizedusers MODIFY password VARCHAR(1500);

select * from authorization;
select * from authorizedUsers;

create table Seller
(
sellerid	bigint auto_increment,
sellername	varchar(100),	
sellercompanyname	varchar(100) unique,	
phonenumber	bigint,	
address	varchar(2000)	,
email	varchar(100)	,
isocode	varchar(10)	,
status boolean,
constraint seller_pk primary key (sellerid)
);

create table sellerusers
(
username varchar(100), 
password varchar(2000),
email varchar(200) unique,
sellerid bigint, 
fullname varchar(100),
status boolean,
rolename varchar(100),
lastlogin	date,		
constraint selleruser_pk primary key (username),
constraint selleruser_fk foreign key (sellerid) references seller(sellerid),
constraint selleruser_fk1 foreign key (rolename) references authorization(rolename)
);

#use little_carrots_authentications;
#select * from sellerusers;
create table securitykeymanagement(
keyid bigint auto_increment,
keyname varchar(100),
keyvalue varchar(1000),
constraint securitykeymanagement_pk primary key (keyid)
);

ALTER TABLE securitykeymanagement AUTO_INCREMENT = 1000;

insert securitykeymanagement(keyname, keyvalue) values('AUTH_API_ACCESS_KEY', 'LRtt3I-ARtlos-51TCOi-er1212-1819TE-Tlcr92-01820L-Sa2015');
insert securitykeymanagement(keyname, keyvalue) values('SECU_API_ACCESS_KEY', 'LSt15I-Tlos18-20TOir-121819-TRtr91-LRta20-3EALC2-05ce12');
insert securitykeymanagement(keyname, keyvalue) values('CLIENT_API_ACCESS_KEY', 'Li20Il-t920TS-t1212T-Tls5LO-et319E-Rco120-CRar18-15Ar18');

#09-MAR-2020 SHAIK ADDED QUERIES
insert securitykeymanagement(keyname, keyvalue) values('EMAIL_API_ACCESS_KEY', 'Li20Il-t920TS-t1212T-Tls5LO-et319E-Rco120-CRar18-15Ar18');
