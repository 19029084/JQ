package com.jq.mapper;


import com.jq.entity.JQUrl;
import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQModuleConfig;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface JQResourceMapper
{
	//List<JQProperty> getProperties();
	//int createProperty(JQProperty property);	
	//int updateProperty(JQProperty property);	
	//int deleteProperty(JQProperty property);
	//JQProperty findPropertyByName(String name);
	
	//List<JQProperty> getPropertyByConfig(JQModuleConfig config);

	
		
	//List<JQPropertyOption> getProperyOptions(String pid);
	//int addPropertyOption(String pid,JQPropertyOption option);
	//int updatePropertyOption(String pid,JQPropertyOption option);
	//int deletePropertyOption(String pid,JQPropertyOption option);
	
	List<JQUrl> getUrls();
	
	int createUrl(JQUrl jqUrl);
	
	JQUrl findUrlByName(String name);
	
	
	List<JQRoles> getRoles();
	

}
