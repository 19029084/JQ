
drop database IF EXISTS JQ;

create database IF NOT EXISTS JQ;

USE JQ;
    
Drop table  if exists oauth_access_token;
create table oauth_access_token (
  create_time timestamp default now(),
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


Drop table  if exists oauth_refresh_token;
create table oauth_refresh_token (
  create_time timestamp default now(),
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
      
    create table if not exists sys_role
    (
      id char(32) not null,
      name varchar(50) null,
      name_cn varchar(255) null,      
      constraint sys_role_id_uindex
        unique (id)
    );
    alter table sys_role 
      add primary key (id);
      
      
    create table if not exists sys_user
    (
      username varchar(50) not null,
      email varchar(50) null,
      password varchar(500) null,
      activated tinyint null,
      activationkey varchar(50) null,
      resetpasswordkey varchar(50) null,
      id char(32) not null,
      constraint sys_user_id_uindex
        unique (id)
    );
    alter table sys_user
      add primary key (id);
      
      
    create table if not exists sys_user_role
    (
      id char(32) not null,
      user_id char(32) null,
      role_id char(32) null,
      constraint sys_user_role_id_uindex
        unique (id)
    );
    alter table sys_user_role
      add primary key (id);
      
      
      
CREATE TABLE if not exists sys_permission
(
	id int auto_increment primary key,
	permission_code varchar(32) null,
	permission_name varchar(32) null
);


CREATE TABLE sys_role_permission
(
	id int auto_increment primary key,
	role_id int null,
	permission_id int null


);

CREATE TABLE sys_url
(
	id int not null auto_increment,
	url varchar(128) not null,
	description varchar(128) null,
	primary key(id)

);

CREATE TABLE sys_url_permission
(

	id int null,
	url_id int null,
	permission_id int null

);



CREATE TABLE Module
(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	PARENTID INT(10) NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	URLID INT(11) NULL,
	VALID BOOLEAN NOT NULL,
	PRIMARY KEY(ID)

)AUTO_INCREMENT=1;


CREATE TABLE Property
(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(255) NOT NULL,
	TYPE INT(11) NOT NULL,
	VALID BOOLEAN NOT NULL,
	PRIMARY KEY(ID)
)AUTO_INCREMENT=1;

CREATE TABLE PropertyOption
(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	PID INT(11) NOT NULL,
	VALUE VARCHAR(255) NOT NULL,
	VALID BOOLEAN NOT NULL,
	PRIMARY KEY(ID)
)AUTO_INCREMENT=1;

CREATE TABLE ModuleConfig
(

	ID INT(11) NOT NULL AUTO_INCREMENT,
	ModuleID INT(11) NOT NULL,
	PropertyID INT(11) NOT NULL,
	ConfigID INT(11) NOT NULL,
	VALID BOOLEAN NOT NULL,
	PRIMARY KEY(ID)

)AUTO_INCREMENT=1;


CREATE TABLE ModuleData
(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	FieldID INT(11) NOT NULL,
	ParentID INT(11) NOT NULL,
	Data VARCHAR(255) NOT NULL,
	PRIMARY KEY(ID)
	
)AUTO_INCREMENT=1;

CREATE TABLE Employee
(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	EMPID VARCHAR(255) NOT NULL,
	EMPNAME VARCHAR(255) NOT NULL,
	ENABLE BOOLEAN,
	VALID BOOLEAN,
	PRIMARY KEY(ID)

);

CREATE TABLE Role
(
	ID INT(10) NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(255) NOT NULL,
	ROLES VARCHAR(255) NOT NULL,
	PRIMARY KEY(ID)
);

CREATE TABLE Population
(
	ID INT(10) NOT NULL AUTO_INCREMENT,
	
	PID VARCHAR(255) NOT NULL,
	
	NAME VARCHAR(255) NOT NULL,
	PRIMARY KEY(ID)



);


CREATE TABLE WhiteList
(
	ID INT(10) NOT NULL AUTO_INCREMENT,
	
	IP VARCHAR(255) NOT NULL,
	
	STATUS BOOLEAN,
	PRIMARY KEY(ID)

);


    INSERT INTO JQ.sys_user (username, email, password, activated, activationkey, resetpasswordkey, id) VALUES ('admin', 'admin@qq.com', '$2a$10$arpqY6Mvt8VatFMcbuYtzuzeLj1ZGaQ9lFOQ9b8BSPJJ6KeG8mBuK', 1, null, null, '1');
    INSERT INTO JQ.sys_role (id, name,name_cn) VALUES ('1', 'ROLE_ADMIN','管理员');
    INSERT INTO JQ.sys_role (id, name,name_cn) VALUES ('2', 'ROLE_USER','用户');
    INSERT INTO JQ.sys_user_role (id, user_id, role_id) VALUES ('1', '1', '1');








