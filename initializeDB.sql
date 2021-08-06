CREATE DATABASE world_covid19_vaccination;

USE world_covid19_vaccination;

CREATE TABLE country (
country_name              VARCHAR(30) NOT NULL, 
country_abbreviation      VARCHAR(10) NOT NULL,
vaccine_type   		  	  VARCHAR(30) NOT NULL, 
PRIMARY KEY (country_name)
);
INSERT INTO country (country_name, country_abbreviation, vaccine_type)
VALUES ('United States', 'USA', 'Phizer');
INSERT INTO country (country_name, country_abbreviation, vaccine_type)
VALUES ('China', 'CHN', 'Sinopharm COVID19 Vaccine');
INSERT INTO country (country_name, country_abbreviation, vaccine_type)
VALUES ('India', 'IN', 'Covaxin');



CREATE TABLE vaccine (
name               VARCHAR(30) NOT NULL, 
type      		   VARCHAR(30) NOT NULL,
company    		   VARCHAR(60) NOT NULL, 
protection_rate    DECIMAL(3, 1) NOT NULL,	
PRIMARY KEY (name)
);
INSERT INTO vaccine (name, type, company, protection_rate)
VALUES ('Phizer', 'mRNA', 'BioNTech', 95);
INSERT INTO vaccine (name, type, company, protection_rate)
VALUES ('Sinopharm COVID19 Vaccine', 'Inactivated vaccines', 'China National Pharmaceutical Group Corporation', 79.34);
INSERT INTO vaccine (name, type, company, protection_rate)
VALUES ('Covaxin', 'Inactivated vaccines', 'Bharat Biotech', 77.8);


CREATE TABLE country_vaccine_relationship(
country_name              VARCHAR(30) NOT NULL, 
vaccine_name              VARCHAR(30) NOT NULL, 
PRIMARY KEY (country_name, vaccine_name), 
FOREIGN KEY (country_name) REFERENCES country(country_name) ON DELETE CASCADE,
FOREIGN KEY (vaccine_name) REFERENCES vaccine(name) ON DELETE CASCADE
);
INSERT INTO country_vaccine_relationship (country_name, vaccine_name)
VALUES ('United States', 'Phizer');
INSERT INTO country_vaccine_relationship (country_name, vaccine_name)
VALUES ('China', 'Sinopharm COVID19 Vaccine');
INSERT INTO country_vaccine_relationship (country_name, vaccine_name)
VALUES ('India', 'Covaxin');


CREATE TABLE state (
state_name   		     VARCHAR(30) NOT NULL,
country_name      		 VARCHAR(30) NOT NULL, 
population    		 	 INT UNSIGNED NOT NULL, 
PRIMARY KEY (state_name),
FOREIGN KEY (country_name) REFERENCES country(country_name) ON DELETE CASCADE
);
INSERT INTO state (state_name, country_name, population)
VALUES ('Illinois', 'United States', 12775352);
INSERT INTO state (state_name, country_name, population)
VALUES ('Hubei', 'China', 25852345);
INSERT INTO state (state_name, country_name, population)
VALUES ('Tamil Nadu', 'India', 230000000);
INSERT INTO state (state_name, country_name, population)
VALUES ('Washington', 'United States', 39613493);
INSERT INTO state (state_name, country_name, population)
VALUES ('Arizona', 'United States', 29730311);
INSERT INTO state (state_name, country_name, population)
VALUES ('Xinjiang', 'China', 126012510);
INSERT INTO state (state_name, country_name, population)
VALUES ('Shandong', 'China', 101527453);
INSERT INTO state (state_name, country_name, population)
VALUES ('Telangana', 'India', 112374333);


CREATE TABLE hospital (
hospital_name			 	 VARCHAR(30) NOT NULL,
state_name      			 VARCHAR(30) NOT NULL, 
city					 	 VARCHAR(30) NOT NULL,  
vaccinated_people		 	 INT UNSIGNED NOT NULL, 
PRIMARY KEY (hospital_name),
FOREIGN KEY (state_name) REFERENCES state(state_name) ON DELETE CASCADE
);
INSERT INTO hospital (hospital_name, state_name, city, vaccinated_people)
VALUES ('UIHealth', 'Illinois', 'Chicago', 18189);
INSERT INTO hospital (hospital_name, state_name, city, vaccinated_people)
VALUES ('Wuhan Central Hospital', 'Hubei', 'Wuhan', 100000);
INSERT INTO hospital (hospital_name, state_name, city, vaccinated_people)
VALUES ('Apollo Hospital', 'Tamil Nadu', 'Chennai', 76907);
INSERT INTO hospital (hospital_name, state_name, city, vaccinated_people)
VALUES ('UW Medical Center', 'Washington', 'Seattle', 55000);
INSERT INTO hospital (hospital_name, state_name, city, vaccinated_people)
VALUES ('Banner', 'Arizona', 'Tucson', 73890);
INSERT INTO hospital (hospital_name, state_name, city, vaccinated_people)
VALUES ('People\'s Hospital', 'Xinjiang', 'Urumqi', 89320);
INSERT INTO hospital (hospital_name, state_name, city, vaccinated_people)
VALUES ('Jinan Hospital', 'Shandong', 'Jinan', 139809);
INSERT INTO hospital (hospital_name, state_name, city, vaccinated_people)
VALUES ('Billroth Hospitals', 'Tamil Nadu', 'Chennai', 92341);
INSERT INTO hospital (hospital_name, state_name, city, vaccinated_people)
VALUES ('Care Hospital', 'Telangana', 'Hyderabad', 67537);



CREATE TABLE people (
number					 SMALLINT AUTO_INCREMENT NOT NULL,
hospital_name		 	 VARCHAR(30) NOT NULL, 
ID      			 	 INT UNSIGNED NOT NULL,  
name			 		 VARCHAR(30) NOT NULL, 
age   		     		 TINYINT UNSIGNED NOT NULL,
date_of_birth    		 Date NOT NULL,
PRIMARY KEY (number),
FOREIGN KEY (hospital_name) REFERENCES hospital(hospital_name) ON DELETE CASCADE
);
INSERT INTO people (hospital_name, ID, name, age, date_of_birth)
VALUES ('UIHealth', 677447670, 'Jiangni Ren', 21, '2000-01-04');
INSERT INTO people (hospital_name, ID, name, age, date_of_birth)
VALUES ('Wuhan Central Hospital', 671847966, 'Jiaqi Yin', 21, '1999-09-19');
INSERT INTO people (hospital_name, ID, name, age, date_of_birth)
VALUES ('Apollo Hospital', 657001198, 'Adnan Sami', 27, '1994-02-12');
INSERT INTO people (hospital_name, ID, name, age, date_of_birth)
VALUES ('UIHealth', 677447675, 'Jiangni', 10, '2010-01-04');
INSERT INTO people (hospital_name, ID, name, age, date_of_birth)
VALUES ('UIHealth', 677447680, 'Ren', 23, '1998-01-04');
INSERT INTO people (hospital_name, ID, name, age, date_of_birth)
VALUES ('Wuhan Central Hospital', 671847976, 'Jia', 8, '2012-09-19');
INSERT INTO people (hospital_name, ID, name, age, date_of_birth)
VALUES ('Wuhan Central Hospital', 671847986, 'Yin', 18, '2003-09-19');
INSERT INTO people (hospital_name, ID, name, age, date_of_birth)
VALUES ('Apollo Hospital', 657001185, 'Adnan', 15, '2006-02-12');
INSERT INTO people (hospital_name, ID, name, age, date_of_birth)
VALUES ('Apollo Hospital', 657001165, 'Sami', 19, '2002-02-12');


CREATE TABLE tb_user (
  username 		VARCHAR(50),
  password 		VARCHAR(50) NOT NULL,
  email 		VARCHAR(50) NOT NULL,
  PRIMARY KEY (username)
);
INSERT INTO tb_user (username, password, email)
VALUES ('Jiangni', 'jiangni', 'jren24@uic.edu');
INSERT INTO tb_user (username, password, email)
VALUES ('Jiaqi', 'jiaqi', 'jyin22@uic.edu');
INSERT INTO tb_user (username, password, email)
VALUES ('JRen', 'jiaqiyin', 'jqyyy@gmail.com');
