
drop database IF EXISTS JQ;

create database IF NOT EXISTS JQ;

USE JQ;

CREATE TABLE Module
(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	PARENTID INT(10) NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	PRIMARY KEY(ID)

)AUTO_INCREMENT=1;


CREATE TABLE Property
(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(255) NOT NULL,
	TYPE INT(11) NOT NULL,
	PRIMARY KEY(ID)
)AUTO_INCREMENT=1;

CREATE TABLE PropertyOption
(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	PID INT(11) NOT NULL,
	Options VARCHAR(255) NOT NULL,
	PRIMARY KEY(ID)
)AUTO_INCREMENT=1;

CREATE TABLE ModuleConfig
(

	ID INT(11) NOT NULL AUTO_INCREMENT,
	ModuleID INT(11) NOT NULL,
	PropertyID INT(11) NOT NULL,
	PRIMARY KEY(ID)

)AUTO_INCREMENT=1;


CREATE TABLE ModuleData
(
	ID INT(11) NOT NULL AUTO_INCREMENT,
	RID INT(11) NOT NULL,
	ModuleID INT(11) NOT NULL,
	PropertyID INT(11) NOT NULL,
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

Insert into Module(ParentID, Name) values(0,'数据大屏'); 
Insert into Module(ParentID, Name) values(0,'数据中心');
Insert into Module(ParentID, Name) values(0,'组织与人员');
Insert into Module(ParentID, Name) values(0,'模板管理');
Insert into Module(ParentID, Name) values(0,'用户管理');
Insert into Module(ParentID, Name) values(0,'系统管理');
Insert into Module(ParentID, Name) values(0,'AI机器人管理');

Insert into Module(ParentID, Name) values(0,'巡查上报-待受理');
Insert into Module(ParentID, Name) values(0,'属性分类管理');
Insert into Module(ParentID, Name) values(0,'字典管理');



Insert into Module(ParentID, Name) values(2,'扶贫管理'); 
Insert into Module(ParentID, Name) values(2,'名人管理');
Insert into Module(ParentID, Name) values(2,'公共设施管理');
Insert into Module(ParentID, Name) values(2,'交通信息管理');
Insert into Module(ParentID, Name) values(2,'养老设施管理');
Insert into Module(ParentID, Name) values(2,'卫生设施管理');
Insert into Module(ParentID, Name) values(2,'教育信息管理');
Insert into Module(ParentID, Name) values(2,'文体设施管理'); 
Insert into Module(ParentID, Name) values(2,'集体资产管理');
Insert into Module(ParentID, Name) values(2,'土地资源管理');
Insert into Module(ParentID, Name) values(2,'农业设施管理');
Insert into Module(ParentID, Name) values(2,'工业信息管理');
Insert into Module(ParentID, Name) values(2,'商贸信息管理');
Insert into Module(ParentID, Name) values(2,'旅游景点管理');




Insert into Module(ParentID, Name) values(3,'城镇管理');
Insert into Module(ParentID, Name) values(3,'行政村管理');
Insert into Module(ParentID, Name) values(3,'自然村/村民小组管理');
Insert into Module(ParentID, Name) values(3,'干部管理');
Insert into Module(ParentID, Name) values(3,'工会管理');
Insert into Module(ParentID, Name) values(3,'村民管理');
Insert into Module(ParentID, Name) values(3,'家庭户管理');
Insert into Module(ParentID, Name) values(3,'党支部管理');
Insert into Module(ParentID, Name) values(3,'党员管理');


Insert into Module(ParentID, Name) values(4,'模块列表');
Insert into Module(ParentID, Name) values(4,'模块分类');


Insert into Module(ParentID, Name) values(5,'员工管理');
Insert into Module(ParentID, Name) values(5,'角色管理');


Insert into Module(ParentID, Name) values(6,'指令管理');
Insert into Module(ParentID, Name) values(6,'系统白名单');
Insert into Module(ParentID, Name) values(6,'打印设置');
Insert into Module(ParentID, Name) values(6,'菜单管理');


Insert into Property(Name,Type) values ('所属城镇',0);
Insert into Property(Name,Type) values ('所属行政村',0);
Insert into Property(Name,Type) values ('所属自然村',0);
Insert into Property(Name,Type) values ('贫困户姓名',0);
Insert into Property(Name,Type) values ('改房情况',0);
Insert into Property(Name,Type) values ('所属村民小组',0);
Insert into Property(Name,Type) values ('贫困状态',0);
Insert into Property(Name,Type) values ('帮扶责任人',0);
Insert into Property(Name,Type) values ('改水情况',0);
Insert into Property(Name,Type) values ('脱贫属性',0);
Insert into Property(Name,Type) values ('脱贫年度',0);

Insert into Property(Name,Type) values ('致贫原因',0);
Insert into Property(Name,Type) values ('危房户',0);
Insert into Property(Name,Type) values ('是否解决安全饮用水',0);
Insert into Property(Name,Type) values ('首次识别时间',0);

Insert into Property(Name,Type) values ('贫困人员识别时间',0);
Insert into Property(Name,Type) values ('简介',0);

Insert into ModuleConfig(ModuleId,PropertyId) values (11,1);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,2);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,3);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,4);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,5);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,6);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,7);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,8);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,9);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,10);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,11);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,12);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,13);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,14);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,15);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,16);
Insert into ModuleConfig(ModuleId,PropertyId) values (11,17);


Insert into PropertyOption(PID,Options) values(0,'均桥镇0');
Insert into PropertyOption(PID,Options) values(0,'均桥镇1');
Insert into PropertyOption(PID,Options) values(0,'均桥镇2');
Insert into PropertyOption(PID,Options) values(0,'均桥镇3');
Insert into PropertyOption(PID,Options) values(0,'均桥镇4');



Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(1,11,0,'1');
Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(1,11,2,'2');
Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(1,11,3,'3');


Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(2,11,0,'2');
Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(2,11,2,'2');
Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(2,11,3,'2');






























