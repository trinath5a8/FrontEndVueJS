#Database Queries Created by Mastanvali Shaik on 10-01-2020 

create user 'littleinventory'@'localhost' identified by 'littleinventory';
drop database Little_Carrots_Inventory;
create database Little_Carrots_Inventory;
#Granting all permission to the user 'LittleInventory'
GRANT ALL PRIVILEGES ON Little_Carrots_Inventory.* TO 'littleinventory'@'localhost';

use Little_Carrots_Inventory;

#-- TABLE CREATION PROCESS
#--------COUNTRIES TABLE--------
CREATE TABLE COUNTRIES(
ISOCODE	varchar(10),
Country	varchar(50)	 Not Null,
ISDCODE	varchar(10)	 Not Null,
status boolean,
constraint countries_pk PRIMARY KEY (ISOCODE)
);

INSERT INTO COUNTRIES VALUES("AFG","Afghanistan","93",FALSE);
INSERT INTO COUNTRIES VALUES("ALB","Albania","355",FALSE);
INSERT INTO COUNTRIES VALUES("DZA","Algeria","213",FALSE);
INSERT INTO COUNTRIES VALUES("ASM","American Samoa","684",FALSE);
INSERT INTO COUNTRIES VALUES("AND","Andorra","376",FALSE);
INSERT INTO COUNTRIES VALUES("AGO","Angola","244",FALSE);
INSERT INTO COUNTRIES VALUES("AIA","Anguilla","264",FALSE);
INSERT INTO COUNTRIES VALUES("ATA","Antarctica","672",FALSE);
INSERT INTO COUNTRIES VALUES("ATG","Antiguaand Barbuda","268",FALSE);
INSERT INTO COUNTRIES VALUES("ARG","Argentina","54",FALSE);
INSERT INTO COUNTRIES VALUES("ARM","Armenia","374",FALSE);
INSERT INTO COUNTRIES VALUES("ABW","Aruba","297",FALSE);
INSERT INTO COUNTRIES VALUES("AUS","Australia","61",FALSE);
INSERT INTO COUNTRIES VALUES("AUT","Austria","43",FALSE);
INSERT INTO COUNTRIES VALUES("AZE","Azerbaijan","994",FALSE);
INSERT INTO COUNTRIES VALUES("BHS","Bahamas","242",FALSE);
INSERT INTO COUNTRIES VALUES("BHR","Bahrain","973",FALSE);
INSERT INTO COUNTRIES VALUES("BGD","Bangladesh","880",FALSE);
INSERT INTO COUNTRIES VALUES("BRB","Barbados","246",FALSE);
INSERT INTO COUNTRIES VALUES("BLR","Belarus","375",FALSE);
INSERT INTO COUNTRIES VALUES("BEL","Belgium","32",FALSE);
INSERT INTO COUNTRIES VALUES("BLZ","Belize","501",FALSE);
INSERT INTO COUNTRIES VALUES("BEN","Benin","229",FALSE);
INSERT INTO COUNTRIES VALUES("BMU","Bermuda","441",FALSE);
INSERT INTO COUNTRIES VALUES("BTN","Bhutan","975",FALSE);
INSERT INTO COUNTRIES VALUES("BOL","Bolivia","591",FALSE);
INSERT INTO COUNTRIES VALUES("BIH","Bosniaand Herzegovina","387",FALSE);
INSERT INTO COUNTRIES VALUES("BWA","Botswana","267",FALSE);
INSERT INTO COUNTRIES VALUES("BRA","Brazil","55",FALSE);
INSERT INTO COUNTRIES VALUES("IOT","British IndianOcean Territory","246",FALSE);
INSERT INTO COUNTRIES VALUES("VGB","British Virgin Islands","284",FALSE);
INSERT INTO COUNTRIES VALUES("BRN","Brunei","673",FALSE);
INSERT INTO COUNTRIES VALUES("BGR","Bulgaria","359",FALSE);
INSERT INTO COUNTRIES VALUES("BFA","Burkina Faso","226",FALSE);
INSERT INTO COUNTRIES VALUES("BDI","Burundi","257",FALSE);
INSERT INTO COUNTRIES VALUES("KHM","Cambodia","855",FALSE);
INSERT INTO COUNTRIES VALUES("CMR","Cameroon","237",FALSE);
INSERT INTO COUNTRIES VALUES("CAN","Canada","1",FALSE);
INSERT INTO COUNTRIES VALUES("CPV","CapeVerde","238",FALSE);
INSERT INTO COUNTRIES VALUES("CYM","Cayman Islands","345",FALSE);
INSERT INTO COUNTRIES VALUES("CAF","Central African Republic","236",FALSE);
INSERT INTO COUNTRIES VALUES("TCD","Chad","235",FALSE);
INSERT INTO COUNTRIES VALUES("CHL","Chile","56",FALSE);
INSERT INTO COUNTRIES VALUES("CHN","China","86",FALSE);
INSERT INTO COUNTRIES VALUES("CXR","Christmas Island","61",FALSE);
INSERT INTO COUNTRIES VALUES("CCK","Cocos Islands","61",FALSE);
INSERT INTO COUNTRIES VALUES("COL","Colombia","57",FALSE);
INSERT INTO COUNTRIES VALUES("COM","Comoros","269",FALSE);
INSERT INTO COUNTRIES VALUES("COK","Cook Islands","682",FALSE);
INSERT INTO COUNTRIES VALUES("CRI","Costa Rica","506",FALSE);
INSERT INTO COUNTRIES VALUES("HRV","Croatia","385",FALSE);
INSERT INTO COUNTRIES VALUES("CUB","Cuba","53",FALSE);
INSERT INTO COUNTRIES VALUES("DNK","Denmark","45",FALSE);
INSERT INTO COUNTRIES VALUES("DJI","Djibouti","253",FALSE);
INSERT INTO COUNTRIES VALUES("TLS","East Timor","670",FALSE);
INSERT INTO COUNTRIES VALUES("ECU","Ecuador","593",FALSE);
INSERT INTO COUNTRIES VALUES("EGY","Egypt","20",FALSE);
INSERT INTO COUNTRIES VALUES("SLV","ElSalvador","503",FALSE);
INSERT INTO COUNTRIES VALUES("GNQ","Equatorial Guinea","240",FALSE);
INSERT INTO COUNTRIES VALUES("ERI","Eritrea","291",FALSE);
INSERT INTO COUNTRIES VALUES("EST","Estonia","372",FALSE);
INSERT INTO COUNTRIES VALUES("ETH","Ethiopia","251",FALSE);
INSERT INTO COUNTRIES VALUES("FLK","Falkland Islands","500",FALSE);
INSERT INTO COUNTRIES VALUES("FRO","Faroe Islands","298",FALSE);
INSERT INTO COUNTRIES VALUES("FJI","Fiji","679",FALSE);
INSERT INTO COUNTRIES VALUES("FIN","Finland","358",FALSE);
INSERT INTO COUNTRIES VALUES("FRA","France","33",FALSE);
INSERT INTO COUNTRIES VALUES("PYF","French Polynesia","689",FALSE);
INSERT INTO COUNTRIES VALUES("GAB","Gabon","241",FALSE);
INSERT INTO COUNTRIES VALUES("GMB","Gambia","220",FALSE);
INSERT INTO COUNTRIES VALUES("GEO","Georgia","995",FALSE);
INSERT INTO COUNTRIES VALUES("DEU","Germany","49",FALSE);
INSERT INTO COUNTRIES VALUES("GHA","Ghana","233",FALSE);
INSERT INTO COUNTRIES VALUES("GIB","Gibraltar","350",FALSE);
INSERT INTO COUNTRIES VALUES("GRC","Greece","30",FALSE);
INSERT INTO COUNTRIES VALUES("GRL","Greenland","299",FALSE);
INSERT INTO COUNTRIES VALUES("GTM","Guatemala","502",FALSE);
INSERT INTO COUNTRIES VALUES("GIN","Guinea","224",FALSE);
INSERT INTO COUNTRIES VALUES("GNB","Guinea-Bissau","245",FALSE);
INSERT INTO COUNTRIES VALUES("GUY","Guyana","592",FALSE);
INSERT INTO COUNTRIES VALUES("HTI","Haiti","509",FALSE);
INSERT INTO COUNTRIES VALUES("HND","Honduras","504",FALSE);
INSERT INTO COUNTRIES VALUES("HKG","Hong Kong","852",FALSE);
INSERT INTO COUNTRIES VALUES("HUN","Hungary","36",FALSE);
INSERT INTO COUNTRIES VALUES("ISL","Iceland","354",FALSE);
INSERT INTO COUNTRIES VALUES("IND","India","91",FALSE);
INSERT INTO COUNTRIES VALUES("IDN","Indonesia","62",FALSE);
INSERT INTO COUNTRIES VALUES("IRN","Iran","98",FALSE);
INSERT INTO COUNTRIES VALUES("IRL","Ireland","353",FALSE);
INSERT INTO COUNTRIES VALUES("ISR","Israel","972",FALSE);
INSERT INTO COUNTRIES VALUES("ITA","Italy","39",FALSE);
INSERT INTO COUNTRIES VALUES("CIV","Ivory Coast","225",FALSE);
INSERT INTO COUNTRIES VALUES("JPN","Japan","81",FALSE);
INSERT INTO COUNTRIES VALUES("JOR","Jordan","962",FALSE);
INSERT INTO COUNTRIES VALUES("KAZ","Kazakhstan","7",FALSE);
INSERT INTO COUNTRIES VALUES("KEN","Kenya","254",FALSE);
INSERT INTO COUNTRIES VALUES("KIR","Kiribati","686",FALSE);
INSERT INTO COUNTRIES VALUES("XKX","Kosovo","383",FALSE);
INSERT INTO COUNTRIES VALUES("KWT","Kuwait","965",FALSE);
INSERT INTO COUNTRIES VALUES("KGZ","Kyrgyzstan","996",FALSE);
INSERT INTO COUNTRIES VALUES("LAO","Laos","856",FALSE);
INSERT INTO COUNTRIES VALUES("LVA","Latvia","371",FALSE);
INSERT INTO COUNTRIES VALUES("LBN","Lebanon","961",FALSE);
INSERT INTO COUNTRIES VALUES("LSO","Lesotho","266",FALSE);
INSERT INTO COUNTRIES VALUES("LBR","Liberia","231",FALSE);
INSERT INTO COUNTRIES VALUES("LBY","Libya","218",FALSE);
INSERT INTO COUNTRIES VALUES("LIE","Liechtenstein","423",FALSE);
INSERT INTO COUNTRIES VALUES("LTU","Lithuania","370",FALSE);
INSERT INTO COUNTRIES VALUES("LUX","Luxembourg","352",FALSE);
INSERT INTO COUNTRIES VALUES("MAC","Macau","853",FALSE);
INSERT INTO COUNTRIES VALUES("MKD","Macedonia","389",FALSE);
INSERT INTO COUNTRIES VALUES("MDG","Madagascar","261",FALSE);
INSERT INTO COUNTRIES VALUES("MWI","Malawi","265",FALSE);
INSERT INTO COUNTRIES VALUES("MYS","Malaysia","60",FALSE);
INSERT INTO COUNTRIES VALUES("MDV","Maldives","960",FALSE);
INSERT INTO COUNTRIES VALUES("MLI","Mali","223",FALSE);
INSERT INTO COUNTRIES VALUES("MLT","Malta","356",FALSE);
INSERT INTO COUNTRIES VALUES("MHL","Marshall Islands","692",FALSE);
INSERT INTO COUNTRIES VALUES("MRT","Mauritania","222",FALSE);
INSERT INTO COUNTRIES VALUES("MUS","Mauritius","230",FALSE);
INSERT INTO COUNTRIES VALUES("MYT","Mayotte","262",FALSE);
INSERT INTO COUNTRIES VALUES("MEX","Mexico","52",FALSE);
INSERT INTO COUNTRIES VALUES("FSM","Micronesia","691",FALSE);
INSERT INTO COUNTRIES VALUES("MDA","Moldova","373",FALSE);
INSERT INTO COUNTRIES VALUES("MCO","Monaco","377",FALSE);
INSERT INTO COUNTRIES VALUES("MNG","Mongolia","976",FALSE);
INSERT INTO COUNTRIES VALUES("MNE","Montenegro","382",FALSE);
INSERT INTO COUNTRIES VALUES("MSR","Montserrat","664",FALSE);
INSERT INTO COUNTRIES VALUES("MAR","Morocco","212",FALSE);
INSERT INTO COUNTRIES VALUES("MOZ","Mozambique","258",FALSE);
INSERT INTO COUNTRIES VALUES("MMR","Myanmar","95",FALSE);
INSERT INTO COUNTRIES VALUES("NAM","Namibia","264",FALSE);
INSERT INTO COUNTRIES VALUES("NRU","Nauru","674",FALSE);
INSERT INTO COUNTRIES VALUES("NPL","Nepal","977",FALSE);
INSERT INTO COUNTRIES VALUES("NLD","Netherlands","31",FALSE);
INSERT INTO COUNTRIES VALUES("ANT","Netherlands Antilles","599",FALSE);
INSERT INTO COUNTRIES VALUES("NCL","New Caledonia","687",FALSE);
INSERT INTO COUNTRIES VALUES("NZL","New Zealand","64",FALSE);
INSERT INTO COUNTRIES VALUES("NIC","Nicaragua","505",FALSE);
INSERT INTO COUNTRIES VALUES("NER","Niger","227",FALSE);
INSERT INTO COUNTRIES VALUES("NGA","Nigeria","234",FALSE);
INSERT INTO COUNTRIES VALUES("NIU","Niue","683",FALSE);
INSERT INTO COUNTRIES VALUES("PRK","North Korea","850",FALSE);
INSERT INTO COUNTRIES VALUES("MNP","Northern Mariana Islands","670",FALSE);
INSERT INTO COUNTRIES VALUES("NOR","Norway","47",FALSE);
INSERT INTO COUNTRIES VALUES("OMN","Oman","968",FALSE);
INSERT INTO COUNTRIES VALUES("PAK","Pakistan","92",FALSE);
INSERT INTO COUNTRIES VALUES("PLW","Palau","680",FALSE);
INSERT INTO COUNTRIES VALUES("PSE","Palestine","970",FALSE);
INSERT INTO COUNTRIES VALUES("PAN","Panama","507",FALSE);
INSERT INTO COUNTRIES VALUES("PNG","Papua New Guinea","675",FALSE);
INSERT INTO COUNTRIES VALUES("PRY","Paraguay","595",FALSE);
INSERT INTO COUNTRIES VALUES("PER","Peru","51",FALSE);
INSERT INTO COUNTRIES VALUES("PHL","Philippines","63",FALSE);
INSERT INTO COUNTRIES VALUES("PCN","Pitcairn","64",FALSE);
INSERT INTO COUNTRIES VALUES("POL","Poland","48",FALSE);
INSERT INTO COUNTRIES VALUES("PRT","Portugal","351",FALSE);
INSERT INTO COUNTRIES VALUES("QAT","Qatar","974",FALSE);
INSERT INTO COUNTRIES VALUES("COG","Republicofthe Congo","242",FALSE);
INSERT INTO COUNTRIES VALUES("REU","Reunion","262",FALSE);
INSERT INTO COUNTRIES VALUES("ROU","Romania","40",FALSE);
INSERT INTO COUNTRIES VALUES("RUS","Russia","7",FALSE);
INSERT INTO COUNTRIES VALUES("RWA","Rwanda","250",FALSE);
INSERT INTO COUNTRIES VALUES("BLM","Saint Barthelemy","590",FALSE);
INSERT INTO COUNTRIES VALUES("SHN","Saint Helena","290",FALSE);
INSERT INTO COUNTRIES VALUES("KNA","Saint Kittsand Nevis","869",FALSE);
INSERT INTO COUNTRIES VALUES("LCA","Saint Lucia","758",FALSE);
INSERT INTO COUNTRIES VALUES("MAF","Saint Martin","590",FALSE);
INSERT INTO COUNTRIES VALUES("SPM","Saint Pierreand Miquelon","508",FALSE);
INSERT INTO COUNTRIES VALUES("VCT","Saint Vincentandthe Grenadines","784",FALSE);
INSERT INTO COUNTRIES VALUES("WSM","Samoa","685",FALSE);
INSERT INTO COUNTRIES VALUES("SMR","SanMarino","378",FALSE);
INSERT INTO COUNTRIES VALUES("STP","Sao Tomeand Principe","239",FALSE);
INSERT INTO COUNTRIES VALUES("SAU","Saudi Arabia","966",FALSE);
INSERT INTO COUNTRIES VALUES("SEN","Senegal","221",FALSE);
INSERT INTO COUNTRIES VALUES("SRB","Serbia","381",FALSE);
INSERT INTO COUNTRIES VALUES("SYC","Seychelles","248",FALSE);
INSERT INTO COUNTRIES VALUES("SLE","Sierra Leone","232",FALSE);
INSERT INTO COUNTRIES VALUES("SGP","Singapore","65",FALSE);
INSERT INTO COUNTRIES VALUES("SXM","Sint Maarten","721",FALSE);
INSERT INTO COUNTRIES VALUES("SVK","Slovakia","421",FALSE);
INSERT INTO COUNTRIES VALUES("SVN","Slovenia","386",FALSE);
INSERT INTO COUNTRIES VALUES("SLB","Solomon Islands","677",FALSE);
INSERT INTO COUNTRIES VALUES("SOM","Somalia","252",FALSE);
INSERT INTO COUNTRIES VALUES("ZAF","South Africa","27",FALSE);
INSERT INTO COUNTRIES VALUES("KOR","South Korea","82",FALSE);
INSERT INTO COUNTRIES VALUES("SSD","South Sudan","211",FALSE);
INSERT INTO COUNTRIES VALUES("ESP","Spain","34",FALSE);
INSERT INTO COUNTRIES VALUES("LKA","Sri Lanka","94",FALSE);
INSERT INTO COUNTRIES VALUES("SDN","Sudan","249",FALSE);
INSERT INTO COUNTRIES VALUES("SUR","Suriname","597",FALSE);
INSERT INTO COUNTRIES VALUES("SJM","Svalbardand Jan Mayen","47",FALSE);
INSERT INTO COUNTRIES VALUES("SWZ","Swaziland","268",FALSE);
INSERT INTO COUNTRIES VALUES("SWE","Sweden","46",FALSE);
INSERT INTO COUNTRIES VALUES("CHE","Switzerland","41",FALSE);
INSERT INTO COUNTRIES VALUES("SYR","Syria","963",FALSE);
INSERT INTO COUNTRIES VALUES("TWN","Taiwan","886",FALSE);
INSERT INTO COUNTRIES VALUES("TJK","Tajikistan","992",FALSE);
INSERT INTO COUNTRIES VALUES("TZA","Tanzania","255",FALSE);
INSERT INTO COUNTRIES VALUES("THA","Thailand","66",FALSE);
INSERT INTO COUNTRIES VALUES("TGO","Togo","228",FALSE);
INSERT INTO COUNTRIES VALUES("TKL","Tokelau","690",FALSE);
INSERT INTO COUNTRIES VALUES("TON","Tonga","676",FALSE);
INSERT INTO COUNTRIES VALUES("TTO","Trinidadand Tobago","868",FALSE);
INSERT INTO COUNTRIES VALUES("TUN","Tunisia","216",FALSE);
INSERT INTO COUNTRIES VALUES("TUR","Turkey","90",FALSE);
INSERT INTO COUNTRIES VALUES("TKM","Turkmenistan","993",FALSE);
INSERT INTO COUNTRIES VALUES("TCA","Turksand Caicos Islands","649",FALSE);
INSERT INTO COUNTRIES VALUES("TUV","Tuvalu","688",FALSE);
INSERT INTO COUNTRIES VALUES("VIR","U.S.Virgin Islands","340",FALSE);
INSERT INTO COUNTRIES VALUES("UGA","Uganda","256",FALSE);
INSERT INTO COUNTRIES VALUES("UKR","Ukraine","380",FALSE);
INSERT INTO COUNTRIES VALUES("ARE","United Arab Emirates","971",FALSE);
INSERT INTO COUNTRIES VALUES("GBR","United Kingdom","44",FALSE);
INSERT INTO COUNTRIES VALUES("USA","United States","1",FALSE);
INSERT INTO COUNTRIES VALUES("URY","Uruguay","598",FALSE);
INSERT INTO COUNTRIES VALUES("UZB","Uzbekistan","998",FALSE);
INSERT INTO COUNTRIES VALUES("VUT","Vanuatu","678",FALSE);
INSERT INTO COUNTRIES VALUES("VAT","Vatican","379",FALSE);
INSERT INTO COUNTRIES VALUES("VEN","Venezuela","58",FALSE);
INSERT INTO COUNTRIES VALUES("VNM","Vietnam","84",FALSE);
INSERT INTO COUNTRIES VALUES("WLF","Wallisand Futuna","681",FALSE);
INSERT INTO COUNTRIES VALUES("ESH","Western Sahara","212",FALSE);
INSERT INTO COUNTRIES VALUES("YEM","Yemen","967",FALSE);
INSERT INTO COUNTRIES VALUES("ZMB","Zambia","260",FALSE);
INSERT INTO COUNTRIES VALUES("ZWE","Zimbabwe","263",FALSE);




#--------warehouses TABLE--------
create table warehouses
(WarehouseID bigint(20)	auto_increment,	
WarehouseName	varchar(50),		
ContactPersonName	varchar(50)	,	
ContactPhone	bigint(15)	unique not null,	
Email	varchar(500)	unique not null	,
Address	varchar(500)	,	
PinCode	bigint(7)	not null	,
EST	int(8)	,	
warehouse_Status	boolean	,	
WhoCreated	varchar(50),		
DateofCreation	date,		
WhoUpdated	varchar(50),		
ModifyDate	date,
ISOCODE	varchar(10),
CONSTRAINT warehouse_pk PRIMARY KEY (warehouseid)
);

ALTER TABLE warehouses AUTO_INCREMENT = 101;

create table SellerToWarehouse(
SerialId bigint auto_increment,
warehouseid bigint,
sellerid bigint,
constraint sellertowarehouse_pk primary key (serialid),
constraint sellertowarehouse_fk foreign key (warehouseid) references warehouses(warehouseid)
);

ALTER TABLE SellerToWarehouse AUTO_INCREMENT = 101;

create table Batch(
BatchID	bigint auto_increment,
WarehouseID	bigint,
DateofPurchase	dateTime,
purchasedby	varchar(50),
InvAmount	double,
WhoInserted	varchar(50),
DateInsertion	DATEtime,
Status	boolean,
ISOCODE	varchar(10),
QTY	bigint,
Sellerid	bigint,
constraint batch_pk primary key (batchid),
constraint batch_fk1 foreign key (warehouseid) references warehouses(warehouseid),
constraint batch_fk2 foreign key (isocode) references countries(isocode));

ALTER TABLE Batch AUTO_INCREMENT = 101;

#----sreerekha-----#
create table Genders(
GenderID varchar(10) ,
Gender varchar(10),
constraint gender_pk primary key (genderid)
);


insert into Genders(genderid, gender) values
('B','Boy');
insert into Genders(genderid, gender) values
('G','Girl');
insert into Genders(genderid, gender) values
('U','Unique');

#------Satya-------
create table ProductAge(
ageid varchar(50),
des varchar(200),
constraint productage_pk primary key(ageid) 
);

#--------Phani----------
create table color(
colorID bigint auto_increment,
colorname varchar(50),
hashcode varchar(50) unique not null,
constraint color_pk primary key (colorid));

ALTER TABLE color AUTO_INCREMENT = 101;

#------Aadarsh----------#
create table sizes(
sizeid bigint auto_increment,
ageid varchar(50),
sizeno varchar(50),
height varchar(50),
weight varchar(50),
chest varchar(50),
waist varchar(50),
hip varchar(50),
gender varchar(10),
constraint sizes_pk primary key (sizeid),
constraint sizes_fk1 foreign key (ageid) references productage(ageid),
constraint sizes_fk2 foreign key (gender) references genders (genderid));

ALTER TABLE sizes AUTO_INCREMENT = 101;

#-------Trinath-------#
create table Categories(catid bigint auto_increment, 
category varchar(200),
gender varchar(10),
constraint categories_pk primary key (catid),
constraint categories_fk1 foreign key (gender) references genders (genderid));

ALTER TABLE Categories AUTO_INCREMENT = 101;

#-------Trinath-------#
create table subcategories(subcatid bigint auto_increment, 
catid bigint, 
categoryname varchar(50), 
constraint subcategories_pk primary key (subcatid),
constraint subcategories_fk1 foreign key (catid) references categories (catid));

ALTER TABLE subcategories AUTO_INCREMENT = 101;

 #--Aadarsh--#
Create table seasonwear(
seasonid bigint auto_increment,
subcatid bigint,
season varchar(50),
constraint seasonid_pk primary key (seasonid),
constraint subcatid_fk foreign key (subcatid) references subcategories(subcatid));

ALTER TABLE seasonwear AUTO_INCREMENT = 101;

#------phaneendra--------#
  create table producttype
    (
    protypeid bigint auto_increment,
    subcatid bigint,
    producttypename varchar(60),
    constraint protypeid_pk primary key (protypeid),
    constraint producttype_fk foreign key (subcatid) references subcategories(subcatid));

ALTER TABLE producttype AUTO_INCREMENT = 101;

#----------Satya------------
create table occasionalwear(
occasionid int(10) auto_increment,
occaName varchar(50),
subcatid bigint,
constraint occasionalwear_pk primary key (occasionid),
constraint occasionalwear_fk1 foreign key (subcatid) references subcategories(subcatid)
);

ALTER TABLE occasionalwear AUTO_INCREMENT = 101;

#----------Satya------------
create table ProductDescriptions(
descriptionid bigint auto_increment,
description varchar(200),
constraint productdescriptions_pk primary key(descriptionid)
);

ALTER TABLE ProductDescriptions AUTO_INCREMENT = 101;

#---------------Trinath-------------#
create table productquantities(custid bigint auto_increment, 
quantity bigint, 
sizeid bigint, 
constraint productquantities_pk primary key (custid),
constraint productquantities_fk1 foreign key (sizeid) references sizes (sizeid));

ALTER TABLE productquantities AUTO_INCREMENT = 101;


#-----sreerekha----#
create table materialtype(
materialid bigint auto_increment,
materialname varchar(50),
description varchar(200),
occasionid int(10),
seasonid bigint,
catid bigint,
constraint materialtype_pk primary key(materialid),
constraint materialtype_fk1 foreign key (occasionid) references occasionalwear (occasionid),
constraint materialtype_fk2 foreign key (seasonid) references seasonwear (seasonid),
constraint materialtype_fk3 foreign key (catid) references categories (catid));

ALTER TABLE materialtype AUTO_INCREMENT = 101;

#--------Sreerekha-------#
create table products(
productid bigint auto_increment,
descriptionid bigint unique,
BatchID bigint,
genderid varchar(10),
catid bigint,
subcatid bigint,
seasonid bigint,
occasionid int,
ageid varchar(50),
materialid bigint,
colorid bigint,
custid bigint unique,
status boolean,
constraint products_pk primary key (productid),
constraint products_fk1 foreign key (descriptionid) references productdescriptions (descriptionid),
constraint products_fk2 foreign key (BatchID) references batch (BatchID),
constraint products_fk3 foreign key (genderid) references genders (genderid),
constraint products_fk4 foreign key (catid) references categories (catid),
constraint products_fk5 foreign key (subcatid) references subcategories (subcatid),
constraint products_fk6 foreign key (seasonid) references seasonwear (seasonid),
constraint products_fk7 foreign key (occasionid) references occasionalwear (occasionid),
constraint products_fk8 foreign key (ageid) references productage (ageid),
constraint products_fk9 foreign key (materialid) references materialtype (materialid),
constraint products_fk10 foreign key (colorid) references color (colorid),
constraint product_fk11 foreign key (custid) references productquantities (custid));

ALTER TABLE products AUTO_INCREMENT = 101;

#-------Sreerekha-------#
create table materialcomposition(
materialid bigint,
description varchar(200),
constraint materialcomposition_fk foreign key (materialid) references materialtype (materialid));

#--Aadarsh--#
create table pricestable(
priceid bigint auto_increment,
mrp double,
productid bigint unique,
lcprice double,
tax double,
sellingprice double,
finalprice double,
constraint pricestable_pk primary key (priceid),
constraint pricestable_fk foreign key (productid) references products(productid));

ALTER TABLE pricestable AUTO_INCREMENT = 101;

#---------------Trinath-------------#
create table patterns(patid bigint auto_increment, 
description text, 
productid bigint, 
constraint patterns_pk primary key (patid),
constraint patterns_fk1 foreign key (productid) references products (productid)
);

ALTER TABLE patterns AUTO_INCREMENT = 101;

#-----phani
create table noofpieces(
pieceid bigint auto_increment,
productid bigint,
noofset bigint,
constraint noofpieces_pk primary key (pieceid),
constraint noofpieces_fk foreign key (productid) references products(productid));

use little_carrots_inventory;
#select * from sellerusers;
create table securitykeyinventory(
keyid bigint auto_increment,
keyname varchar(100),
keyvalue varchar(1000),
constraint securitykeyinventory_pk primary key (keyid)
);

ALTER TABLE securitykeyinventory AUTO_INCREMENT = 1000;

insert securitykeyinventory(keyname, keyvalue) values('AUTH_API_ACCESS_KEY', 'LRtt3I-ARtlos-51TCOi-er1212-1819TE-Tlcr92-01820L-Sa2015');
insert securitykeyinventory(keyname, keyvalue) values('SECU_API_ACCESS_KEY', 'LSt15I-Tlos18-20TOir-121819-TRtr91-LRta20-3EALC2-05ce12');
insert securitykeyinventory(keyname, keyvalue) values('INVENTORY_API_ACCESS_KEY', 'Li20Il-t920TS-t1212T-Tls5LO-et319E-Rco120-CRar18-15Ar18');

select * from securitykeyinventory;



