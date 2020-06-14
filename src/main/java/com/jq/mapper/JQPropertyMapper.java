package com.jq.mapper;


import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface JQPropertyMapper
{
	List<JQProperty> getProperties();
	int createProperty(JQProperty property);	
	int updateProperty(JQProperty property);	
	int deleteProperty(JQProperty property);

	
		
	List<JQPropertyOption> getProperyOptions(String pid);
	int addPropertyOption(String pid,JQPropertyOption option);
	int updatePropertyOption(String pid,JQPropertyOption option);
	int deletePropertyOption(String pid,JQPropertyOption option);
	
	
	

}
