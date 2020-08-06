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
	
	JQProperty findPropertyById(int propertyId);
	
	int createProperty(JQProperty property);
		
	int updateProperty(JQProperty property);
		
	int deleteProperty(int id);
	

	
	//List<JQProperty> getPropertyByConfig(JQModuleConfig config);
	//List<JQColumn> findColumnByConfigId(int configId);

	List<JQPropertyOption> findPropertyOptionsByParentId(int parentId);
		
	List<JQPropertyOption> findProperyOptionsById(int propertyId);
	
	JQPropertyOption findPropertyOptionByValue(int propertyId,int parentId, String value);
	
	int assignPropertyOption(int propertyId, int parentId, JQPropertyOption option);
	
	int updatePropertyOption(int propertyId,JQPropertyOption option);
	//int deletePropertyOption(String pid,JQPropertyOption option);
	
	void deletePropertyOption(int propertyId,int optionId);
	
	
	List<JQPropertyType> findAllProperyTypes();
	JQPropertyType findPropertyTypeByType(String type);
		
	int createPropertyType(JQPropertyType type);	
	int updatePropertyType(JQPropertyType type);	
	int deletePropertyType(JQPropertyType type);
	
	
		

	
	
	

}
