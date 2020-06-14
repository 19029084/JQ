package com.jq.service;

import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;

import java.util.List;

import com.jq.mapper.JQPropertyMapper;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

@Service
public class JQPropertyService
{
	@Autowired 
	JQPropertyMapper jqPropertyMapper;

	public List<JQProperty> getProperties()
	{
		List<JQProperty> properties = jqPropertyMapper.getProperties();
		
		
		return properties;
		
	}
	
	public int createProperties(List<JQProperty> properties)
	{
	
		for(int i=0;i<properties.size();i++)
		{
			jqPropertyMapper.createProperty(properties.get(i));	
		
		}
		
		return 0;
	
	
	}
	
	public int updateProperties(List<JQProperty> properties)
	{
	
		for(int i=0;i<properties.size();i++)
		{
			jqPropertyMapper.updateProperty(properties.get(i));	
		
		}
		
		return 0;
	
	
	}
	
	
	public int deleteProperties(List<JQProperty> properties)
	{
	
		for(int i=0;i<properties.size();i++)
		{
			jqPropertyMapper.deleteProperty(properties.get(i));	
		
		}
		
		return 0;
	
	
	}


	public List<JQPropertyOption> getPropertyOptions(String propertyId)
	{
		List<JQPropertyOption> propertyOptions = jqPropertyMapper.getProperyOptions(propertyId);
		
		
		return propertyOptions;
		
	}
	
	
	public int addPropertyOptions(String propertyId,List<JQPropertyOption> propertyOptions)
	{
		for(int i=0;i<propertyOptions.size();i++)
		{
			jqPropertyMapper.addPropertyOption(propertyId,propertyOptions.get(i));
		}
		
		return 0;
	}
	
	
	public int updatePropertyOptions(String propertyId,List<JQPropertyOption> propertyOptions)
	{
		for(int i=0;i<propertyOptions.size();i++)
		{
			jqPropertyMapper.updatePropertyOption(propertyId,propertyOptions.get(i));
		}
		
		return 0;
	}
	
	
	public int deletePropertyOptions(String propertyId,List<JQPropertyOption> propertyOptions)
	{
		for(int i=0;i<propertyOptions.size();i++)
		{
			jqPropertyMapper.deletePropertyOption(propertyId,propertyOptions.get(i));
		}
		
		return 0;
	}

	
	

}
