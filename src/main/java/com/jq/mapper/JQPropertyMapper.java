package com.jq.mapper;


import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQConfig;
import com.jq.entity.JQColumn;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jq.entity.JQPropertyType;

import java.util.List;
@Mapper
public interface JQPropertyMapper
{
	List<JQProperty> findAllProperties();
	
	JQProperty findPropertyByName(String name);
	
	int createProperty(JQProperty property);
		
	int updateProperty(JQProperty property);
		
	int deleteProperty(JQProperty property);
	

	
	//List<JQProperty> getPropertyByConfig(JQModuleConfig config);
	List<JQColumn> findColumnByConfigId(int configId);

	
		
	List<JQPropertyOption> findProperyOptionsById(int pid);
	
	int assignPropertyOption(int pid,JQPropertyOption option);
	
	int updatePropertyOption(String pid,JQPropertyOption option);
	int deletePropertyOption(String pid,JQPropertyOption option);
	
	
	List<JQPropertyType> findAllProperyTypes();
	JQPropertyType findPropertyTypeByType(String type);
		
	int createPropertyType(JQPropertyType type);	
	int updatePropertyType(JQPropertyType type);	
	int deletePropertyType(JQPropertyType type);	

	
	
	

}
