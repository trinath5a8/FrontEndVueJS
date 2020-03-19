
create database little_carrots_images;
create user 'little_carrots_images'@'localhost' identified by 'littleinventory';
#Granting all permission to the user 'LittleInventory'
GRANT ALL PRIVILEGES ON little_carrots_images.* TO 'littleinventory'@'localhost';
use little_carrots_images;
drop table images;

create table images(imgid  bigint AUTO_INCREMENT, productid bigint,imageurl varchar(50),
constraint images_pk1 primary key (imgid));

select * from images;