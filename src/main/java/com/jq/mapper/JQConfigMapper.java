package com.jq.mapper;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQConfig;


import com.jq.entity.JQProperty;

import com.jq.entity.JQRow;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface JQConfigMapper{
	
	List<JQConfig> getConfigs();
	int createConfig(JQConfig config);
	/*int updateModule(JQModule module,String pid,String urlId);
	int deleteModule(JQModule module,String pid);*/
	JQConfig getConfigByName(String name);
	
	int addConfigProperty(String sortKey, String propertyId,String configId );
	
	/*
	List<JQModuleConfig> getModuleConfig(String mid);
	//int addModuleConfig(String mid,JQModuleConfig config);
	int addModuleConfig(String mid, String sortKey, String propertyId,String configId );
	//int updateModuleConfig(String mid,JQModuleConfig config);
	int deleteModuleConfig(String mid,JQModuleConfig config);
	
	List<JQModuleData> getModuleData(String mid,String configId);
	int addModuleData(String mid, String configId, int parentId,JQProperty property);
	int updateModuleData(String mid, int rowId,JQProperty property);
	int deleteModuleData(String mid, int rowId, JQProperty property);
	
	
	int getTotalQuantity(String mid,String configId);*/
	

}
