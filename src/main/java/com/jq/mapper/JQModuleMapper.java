package com.jq.mapper;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQPropertyOption;


import com.jq.entity.JQProperty;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface JQModuleMapper{
	@Select("select id,name from Module where parentid= #{pid}")
	List<JQModule> getModules(String pid);
	
	@Select("select value,PID as PropertyId from PropertyOption where PID = #{pid}")
	List<JQPropertyOption> getProperyOptions(String pid);
	
	@Select("select md.rid as rowId, md.data as value, md.propertyid as id,p.name as name, p.type as type from ModuleData md,ModuleConfig mc,Property p where mc.moduleid = #{mid} and mc.propertyid = md.propertyid and mc.moduleid=md.moduleid and p.id=md.propertyid")
	List<JQColumn> getModuleData(String mid);
	
	@Select("select mc.id as id, p.id as propertyId,p.name as propertyName from ModuleConfig mc ,Property p where mc.propertyid =p.id and mc.moduleid = #{mid}")
	List<JQModuleConfig> getModuleConfig(String mid);
	
	@Insert("insert into Module(name,parentid) value(#{module.name},#{pid})")
	int createModule(JQModule module,String pid);
	
	

}
