package com.jq.mapper;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQConfig;


import com.jq.entity.JQProperty;
import com.jq.entity.JQWidget;

import com.jq.entity.JQRow;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import com.jq.entity.JQWidget;

@Mapper
public interface JQConfigMapper{
	
	List<JQConfig> findAllConfigs();
	int createConfig(JQConfig config);
	/*int updateModule(JQModule module,String pid,String urlId);
	int deleteModule(JQModule module,String pid);*/
	JQConfig findConfigByName(String name);
	JQConfig findConfigById(int configId);
	
	int numOfWidgets(int configId);
	int numOfReferences(int configId);
	
	
	List<JQWidget> findWidgetByConfigId(int configId, boolean searchable,
						           boolean visible,
						           boolean shareable );
	
	JQWidget findWidgetByName(String name);
	
	int createWidget(JQWidget widget);
	
	int assignWidget(int configId,int widgetId, String sortKey);
	
	void deleteConfig(int configId);
	
	void updateConfig(JQConfig config);
	
	void deleteConfigWidget(int configId);
	
	void updateWidget(JQWidget widget);
	
	
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
