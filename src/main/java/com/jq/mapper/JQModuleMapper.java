package com.jq.mapper;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQPropertyOption;


import com.jq.entity.JQProperty;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface JQModuleMapper{
	
	List<JQModule> getModules(String pid);
	int createModule(JQModule module,String pid,String urlId);
	int updateModule(JQModule module,String pid,String urlId);
	int deleteModule(JQModule module,String pid);
	JQModule getModuleByName(String name,String pid);
	
	
	
	List<JQModuleConfig> getModuleConfig(String mid);
	//int addModuleConfig(String mid,JQModuleConfig config);
	int addModuleConfig(String mid, String propertyId,String configId );
	//int updateModuleConfig(String mid,JQModuleConfig config);
	int deleteModuleConfig(String mid,JQModuleConfig config);
	
	List<JQColumn> getModuleData(String mid,String configId);
	int addModuleData(String mid, String configId, int parentId,JQProperty property);
	int updateModuleData(String mid, int rowId,JQProperty property);
	int deleteModuleData(String mid, int rowId, JQProperty property);
	
	
	int getTotalQuantity(String mid,String configId);
	

}
