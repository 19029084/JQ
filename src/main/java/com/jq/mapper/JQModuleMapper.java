package com.jq.mapper;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQPropertyValue;


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
import java.util.Map;


@Mapper
public interface JQModuleMapper{

	List<JQModule> getModules(int pid,String username);
	int createModule(JQModule module,int pid,int urlId);
	int updateModule(JQModule module,int parentId,int urlId);
	int deleteModule(JQModule module);
	
	void deleteModuleById(int moduleId);
	
	JQModule findModuleByName(String name);
	
	JQModule findModuleById(int moduleId);
	
	List<Integer> findModuleIdByConfigId(int configId);
	
	
	List<JQModuleConfig> getModuleConfig(int mid);
	
	JQModuleConfig findModuleConfigByName(String module, String config);
	JQModuleConfig findModuleConfigById(int moduleId, int configId);
	
	//int addModuleConfig(String mid,JQModuleConfig config);
	int createModuleConfig(JQModuleConfig moduleConfig);
	int updateModuleConfig(int moduleId,JQModuleConfig config);
	int deleteModuleConfig(int moduleId, int configId);
	
	List<JQModuleData> getModuleData(String tableName,int moduleId,int configId,int parentId);
	
	int addModuleData(String tableName,int fieldId, int propertyId, int rowId, int parentId,String value);
	
	int updateModuleData(String tableName,int rowId, int fieldId,int widgetId, String value);
	
	int deleteModuleData(String tableName,int moduleId, int configId,int rowId);
	
	JQModuleData getModuleDataByRowId(String tableName,int moduleId,int configId,int rowId);
	
	
	int getTotalQuantity(String tableName,int moduleId,int configId);
	
	List<Integer> queryRowIds(String tableName,int moduleId, int configId, int widgetId,int propertyId,String value, List<Integer> rowIds);
	
	List<Integer> queryRowIdsByPropertyValue(String tableName,int moduleId, int configId, JQPropertyValue propertyValue, List<Integer> rowIds);
	

	
	int existDataTable(@Param("tableName") String tableName);
	
	int dropDataTable(@Param("tableName") String tableName);
	
	int createDataTable(@Param("tableName") String tableName);

	List<Map<String, String>> getModulePermissions(int moduleId);
}
