CREATE schema kj905;

create table kj905.ht_device (
imei BIGINT not null,
product_number varchar(45) not null,
model_number varchar(45) not null,
allocation varchar(4) default null,
ht_mobile_number varchar(25) default null,
allocation_date date default null,
primary key (imei)
);

create table kj905.ht_fom (
idFom int not null auto_increment,
first_name varchar(45) not null,
last_name varchar(45) not null,
email varchar(45) not null,
password varchar(45) not null,
primary key (idFom)
);

create table kj905.ht_image (
idImage int not null auto_increment,
"DATE" date not null,
photo blob not null,
verification_status varchar(45) default null,
verification_date date default null,
verification_comment varchar(100) default null,
employee_type varchar(25) not null,
primary key (idImage)
);

create table kj905.ht_country (
idCountry int not null auto_increment,
title varchar(45) not null,
description varchar(45) not null,
primary key (idCountry)
);

create table kj905.ht_region (
idRegion int not null auto_increment,
title varchar(45) not null,
description varchar(45) not null,
ht_country_idCountry int not null,
primary key (idRegion),
constraint fk_ht_country_idCountry foreign key (ht_country_idCountry) references ht_country (idCountry)
);

create table kj905.ht_district (
idDistrict int not null auto_increment,
title varchar(45) not null,
description varchar(45) not null,
ht_region_idRegion int not null,
primary key (idDistrict),
constraint fk_ht_region_idRegion foreign key (ht_region_idRegion) references ht_region (idRegion)
);

create table kj905.ht_verifier (
idVerifier int not null auto_increment,
first_name varchar(45) default null,
middle_name varchar(45) default null,
last_name varchar(45) default null,
gender varchar(1) default null,
dob date default null,
email varchar(45) not null,
telephone_number varchar(25) default null,
password varchar(45) not null,
education_type varchar(45) default null,
education_level varchar(45) default null,
status varchar(45) not null,
status_date date not null,
start_date date default null,
ht_vacancy_idVacancy int default null,
verification_status varchar(45) default null,
verification_date date default null,
verification_comment varchar(100) default null,
ht_device_imei BIGINT default null,
ht_image_idImage int default null,
primary key (idVerifier),
constraint fk_ht_device_imei foreign key (ht_device_imei) references ht_device (imei),
constraint fk_ht_image_idImage foreign key (ht_image_idImage) references ht_image (idImage)
);

create table kj905.ht_identity_document (
idIdentityDocument int not null auto_increment,
"NUMBER" varchar(25) not null,
type varchar(25) not null,
issue_date date not null,
expiry_date date not null,
verification_status varchar(45) default null,
verification_date date default null,
verification_comment varchar(100) default null,
employee_type varchar(25) not null,
emp_id int not null,
primary key (idIdentityDocument),
constraint fk_emp_id_identity_document foreign key (emp_id) references ht_verifier (idVerifier)
);

create table kj905.ht_interview (
idInterview int not null auto_increment,
"DATE" date default null,
address varchar(100) default null,
status varchar(45) not null,
comment varchar(100) default null,
employee_type varchar(25) not null,
emp_id int not null,
ht_fom_idFom int not null,
primary key (idInterview),
constraint fk_emp_id_interview foreign key (emp_id) references ht_verifier (idVerifier),
constraint fk_ht_fom_idFom_interview foreign key (ht_fom_idFom) references ht_fom (idFom)
);

create table kj905.ht_address (
idAddress int not null auto_increment,
street varchar(45) default null,
village varchar(45) default null,
postcode varchar(45) not null,
town varchar(45) default null,
city varchar(45) default null,
verification_status varchar(45) default null,
verification_date date default null,
verification_comment varchar(100) default null,
employee_type varchar(25) not null,
emp_id int not null,
ht_country_idCountry int not null,
ht_region_idRegion int not null,
ht_district_idDistrict int not null,
primary key (idAddress),
constraint fk_emp_id_address foreign key (emp_id) references ht_verifier (idVerifier),
constraint fk_ht_country_idCountry_address foreign key (ht_country_idCountry) references ht_country (idCountry),
constraint fk_ht_region_idRegion_address foreign key (ht_region_idRegion) references ht_region (idRegion),
constraint fk_ht_district_idDistrict_address foreign key (ht_district_idDistrict) references ht_district (idDistrict)
);

create table kj905.ht_reference (
idReference int not null auto_increment,
organisation_name varchar(45) not null,
contact_number varchar(25) not null,
address varchar(100) not null,
employee_type varchar(25) not null,
title varchar(10) default null,
full_name varchar(45) default null,
designation varchar(45) default null,
email varchar(45) default null,
verification_status varchar(45) default null,
verification_date date default null,
verification_comment varchar(100) default null,
emp_id int not null,
primary key (idReference),
constraint fk_ht_verifier_idVerifier_reference foreign key (emp_id) references ht_verifier (idVerifier)
);

create table kj905.ht_bank (
idBank int not null auto_increment,
accountNumber varchar(15) not null,
bank_name varchar(45) not null,
address varchar(100) not null,
sort_code varchar(10) default null,
iban varchar(45) default null,
contact_number varchar(25) default null,
verification_status varchar(45) default null,
verification_date date default null,
verification_comment varchar(100) default null,
employee_type varchar(25) not null,
emp_id int not null,
primary key (idBank),
constraint fk_ht_verifier_idVerifier_bank foreign key (emp_id) references ht_verifier (idVerifier)
);

create table kj905.ht_static_data (
idStaticData int not null auto_increment,
type varchar(45) not null,
value varchar(45) not null,
description varchar(45) not null,
primary key (idStaticData)
);


INSERT INTO KJ905.HT_DEVICE (IMEI, PRODUCT_NUMBER, MODEL_NUMBER, HT_MOBILE_NUMBER, ALLOCATION) VALUES (123, '3456', '345678', '07944169877', 'no');
INSERT INTO KJ905.HT_DEVICE (IMEI, PRODUCT_NUMBER, MODEL_NUMBER, HT_MOBILE_NUMBER, ALLOCATION) VALUES (333, '4545566', '6867565', '789999999', 'no');
INSERT INTO KJ905.HT_DEVICE (IMEI, PRODUCT_NUMBER, MODEL_NUMBER, ALLOCATION, HT_MOBILE_NUMBER, ALLOCATION_DATE) VALUES (444, '5465656767', '67676767', 'yes', '077777777', '2010-09-28');

INSERT INTO KJ905.HT_COUNTRY (TITLE, DESCRIPTION) VALUES ('tanzania', 'Tanzania');
INSERT INTO KJ905.HT_COUNTRY (TITLE, DESCRIPTION) VALUES ('colombia', 'Colombia');
INSERT INTO KJ905.HT_COUNTRY (TITLE, DESCRIPTION) VALUES ('uganda', 'Uganda');

INSERT INTO KJ905.HT_REGION (TITLE, DESCRIPTION, HT_COUNTRY_IDCOUNTRY) VALUES ('blue', 'Blue', 1);
INSERT INTO KJ905.HT_REGION (TITLE, DESCRIPTION, HT_COUNTRY_IDCOUNTRY) VALUES ('red', 'Red', 1);
INSERT INTO KJ905.HT_REGION (TITLE, DESCRIPTION, HT_COUNTRY_IDCOUNTRY) VALUES ('green', 'Green', 1);
INSERT INTO KJ905.HT_REGION (TITLE, DESCRIPTION, HT_COUNTRY_IDCOUNTRY) VALUES ('northern', 'Northern ', 2);
INSERT INTO KJ905.HT_REGION (TITLE, DESCRIPTION, HT_COUNTRY_IDCOUNTRY) VALUES ('southern', 'Southern', 2);
INSERT INTO KJ905.HT_REGION (TITLE, DESCRIPTION, HT_COUNTRY_IDCOUNTRY) VALUES ('eastern', 'Eastern', 2);
INSERT INTO KJ905.HT_REGION (TITLE, DESCRIPTION, HT_COUNTRY_IDCOUNTRY) VALUES ('central', 'Central', 3);
INSERT INTO KJ905.HT_REGION (TITLE, DESCRIPTION, HT_COUNTRY_IDCOUNTRY) VALUES ('western', 'Western', 3);
INSERT INTO KJ905.HT_REGION (TITLE, DESCRIPTION, HT_COUNTRY_IDCOUNTRY) VALUES ('south-western', 'South-western', 3);

INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('east blue', 'East Blue', 1);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('west blue', 'West Blue', 1);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('east red', 'East Red', 2);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('west red', 'West Red', 2);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('east green', 'East Green', 3);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('west green', 'West Green', 3);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('east kent', 'East Kent', 4);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('west kent', 'West Kent', 4);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('north devon', 'North Devon', 5);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('south devon', 'South Devon', 5);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('lake district', 'Lake District', 6);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('newham', 'Newham', 6);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('greenwich', 'Greenwich', 7);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('west bank', 'West Bank', 7);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('east bank', 'East Bank', 8);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('central bank', 'Central Bank', 8);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('south bank', 'South Bank', 9);
INSERT INTO KJ905.HT_DISTRICT (TITLE, DESCRIPTION, HT_REGION_IDREGION) VALUES ('barking', 'Barking', 9);

INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('gender', 'm', 'Male');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('gender', 'f', 'Female');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('education level', 'level 1', 'Level 1');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('education level', 'level 2', 'Level 2');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('education type', 'type 1', 'Type 1');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('education type', 'type 2', 'Type 2');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('employment status', 'preregistered', 'Preregistered');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('employment status', 'registered', 'Registered ');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('employment status', 'verified', 'Verified');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('employment status', 'employed', 'Employed');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('employment status', 'failed', 'Failed');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('employee type', 'vpa', 'Village Payment Agent');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('employee type', 'ver', 'Verifier');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('employee type', 'far', 'Farmer');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('employee type', 'fom', 'Field Operative Manager');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('verification status', 'verified', 'Verified');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('verification status', 'unverified', 'Unverified');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('verification status', 'awaiting verification', 'Awaiting Verification');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('identity document type', 'passport', 'Passport');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('identity document type', 'identity card', 'Identity Card');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('identity document type', 'driving licence', 'Driving Licence ');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('title', 'mr', 'Mr');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('title', 'mrs', 'Mrs');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('title', 'miss', 'Miss');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('interview status', 'awaiting arrangement', 'Awaiting Arrangement');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('interview status', 'arranged', 'Arranged');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('interview status', 'completed', 'Completed');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('interview status', 'cancelled', 'Cancelled');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('device allocation', 'yes', 'Yes');
INSERT INTO KJ905.HT_STATIC_DATA ("TYPE", "VALUE", DESCRIPTION) VALUES ('device allocation', 'no', 'No');







