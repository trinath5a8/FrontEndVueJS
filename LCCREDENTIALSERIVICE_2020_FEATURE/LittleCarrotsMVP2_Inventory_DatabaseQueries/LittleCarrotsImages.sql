
create database little_carrots_images;

use little_carrots_images;
drop table images;

create table images(imgid  bigint AUTO_INCREMENT, productid bigint,imageurl varchar(50),
constraint images_pk1 primary key (imgid));

select * from images;