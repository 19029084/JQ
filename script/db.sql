

Insert into Module(ParentID, Name,URL,Valid) values(0,'数据大屏','',1); 
Insert into Module(ParentID, Name,URL,Valid) values(0,'数据中心','/DataCenter',1);
Insert into Module(ParentID, Name,URL,Valid) values(0,'组织与人员','',1);
Insert into Module(ParentID, Name,URL,Valid) values(0,'模板管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(0,'用户管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(0,'系统管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(0,'AI机器人管理','',1);

Insert into Module(ParentID, Name,URL,Valid) values(0,'巡查上报-待受理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(0,'属性分类管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(0,'字典管理','',1);



Insert into Module(ParentID, Name,URL,Valid) values(2,'扶贫管理','',1); 
Insert into Module(ParentID, Name,URL,Valid) values(2,'名人管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(2,'公共设施管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(2,'交通信息管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(2,'养老设施管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(2,'卫生设施管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(2,'教育信息管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(2,'文体设施管理','',1); 
Insert into Module(ParentID, Name,URL,Valid) values(2,'集体资产管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(2,'土地资源管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(2,'农业设施管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(2,'工业信息管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(2,'商贸信息管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(2,'旅游景点管理','',1);




Insert into Module(ParentID, Name,URL,Valid) values(3,'城镇管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(3,'行政村管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(3,'自然村/村民小组管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(3,'干部管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(3,'工会管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(3,'村民管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(3,'家庭户管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(3,'党支部管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(3,'党员管理','',1);


Insert into Module(ParentID, Name,URL,Valid) values(4,'模块列表','',1);
Insert into Module(ParentID, Name,URL,Valid) values(4,'模块分类','',1);


Insert into Module(ParentID, Name,URL,Valid) values(5,'员工管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(5,'角色管理','',1);


Insert into Module(ParentID, Name,URL,Valid) values(6,'指令管理','',1);
Insert into Module(ParentID, Name,URL,Valid) values(6,'系统白名单','',1);
Insert into Module(ParentID, Name,URL,Valid) values(6,'打印设置','',1);
Insert into Module(ParentID, Name,URL,Valid) values(6,'菜单管理','',1);


Insert into Property(Name,Type,Valid) values ('所属城镇',0,1);
Insert into Property(Name,Type,Valid) values ('所属行政村',0,1);
Insert into Property(Name,Type,Valid) values ('所属自然村',0,1);
Insert into Property(Name,Type,Valid) values ('贫困户姓名',0,1);
Insert into Property(Name,Type,Valid) values ('改房情况',0,1);
Insert into Property(Name,Type,Valid) values ('所属村民小组',0,1);
Insert into Property(Name,Type,Valid) values ('贫困状态',0,1);
Insert into Property(Name,Type,Valid) values ('帮扶责任人',0,1);
Insert into Property(Name,Type,Valid) values ('改水情况',0,1);
Insert into Property(Name,Type,Valid) values ('脱贫属性',0,1);
Insert into Property(Name,Type,Valid) values ('脱贫年度',0,1);

Insert into Property(Name,Type,Valid) values ('致贫原因',0,1);
Insert into Property(Name,Type,Valid) values ('危房户',0,1);
Insert into Property(Name,Type,Valid) values ('是否解决安全饮用水',0,1);
Insert into Property(Name,Type,Valid) values ('首次识别时间',0,1);

Insert into Property(Name,Type,Valid) values ('贫困人员识别时间',0,1);
Insert into Property(Name,Type,Valid) values ('简介',0,1);

Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,1,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,2,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,3,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,4,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,5,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,6,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,7,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,8,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,9,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,10,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,11,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,12,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,13,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,14,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,15,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,16,1);
Insert into ModuleConfig(ModuleId,PropertyId,Valid) values (11,17,1);


Insert into PropertyOption(PID,VALUE,Valid) values(1,'均桥镇0',1);
Insert into PropertyOption(PID,VALUE,Valid) values(1,'均桥镇1',1);
Insert into PropertyOption(PID,VALUE,Valid) values(1,'均桥镇2',1);
Insert into PropertyOption(PID,VALUE,Valid) values(1,'均桥镇3',1);
Insert into PropertyOption(PID,VALUE,Valid) values(1,'均桥镇4',1);



Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(1,11,0,'1');
Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(1,11,2,'2');
Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(1,11,3,'3');


Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(2,11,0,'2');
Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(2,11,2,'2');
Insert into ModuleData(RID,ModuleID,PropertyID,Data) values(2,11,3,'2');






























