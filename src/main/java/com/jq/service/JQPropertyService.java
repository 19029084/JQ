package com.jq.service;

import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQPropertyType;

import com.jq.entity.JQColumn;
import com.jq.entity.JQConfig;

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
	
	public JQProperty findPropertyByName(String name)
	{	
		System.out.println("property: "+name);
		System.out.println("jqPropertyMapper:"+jqPropertyMapper);
		return jqPropertyMapper.findPropertyByName(name);
	
	}

	public List<JQProperty> getProperties()
	{
		List<JQProperty> properties = jqPropertyMapper.findAllProperties();		
		
		return properties;
		
	}
	
	public void loadPropertyByConfig(JQConfig config)
	{
		//List<JQProperty> properties = jqPropertyMapper.getPropertyByConfig(config);
		
		
		//config.setProperties(properties);
		
		//loadPropertyOptions(properties);
		
		//@TODO
		//List<JQColumn> columns = jqPropertyMapper.findColumnByConfigId(config.getId());
		
		//config.setProperties(columns);
		
		//loadPropertyOptions(columns);
	
	}	


	public int createProperties(List<JQProperty> properties)
	{
		for(int i=0;i<properties.size();i++)
		{
		
			JQProperty property = properties.get(i);

			createProperty(property);	
		
		}
		return 0;
	}
	public int createProperty(JQProperty property)
	{
	
		//for(int i=0;i<properties.size();i++)
		{
			//JQProperty property = properties.get(i);
			JQProperty existProperty  = findPropertyByName(property.getName());
			
			if(existProperty != null)
			{
				property.setId(existProperty.getId());
			}
			else
			{
			
				//property =properties.get(i);
				
				JQPropertyType type = property.getPropertyType();
				
				createPropertyType(type);	

				property.setPropertyType(type);//setTypeId(type.getId());
				 			
				jqPropertyMapper.createProperty(property);
				
				System.out.println("Property:"+property.getId()+":"+property.getName());
				
			}
			
			List<JQPropertyOption> options = property.getOptions();
			
			if(options != null)
			{
			
				assignPropertyOptions(property.getId(),options);
			
			}
		}
		
		return 0;
	
	
	}
	
	
	public void createPropertyType(JQPropertyType type)
	{
	
		JQPropertyType existType = jqPropertyMapper.findPropertyTypeByType(type.getType());
		
		if(existType == null)
		{
			jqPropertyMapper.createPropertyType(type);
		}
		else
		{
			type.setId(existType.getId());
		}
	
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
	
	public void loadPropertyOptions(List<JQColumn> columns)
	{
		for(int i=0;i<columns.size();i++)
		{
			JQColumn column = columns.get(i);
			//@TODO
			//JQProperty property = column.getProperty();
			
			//List<JQPropertyOption> options = getPropertyOptions(property.getId());
			
			//property.setOptions(options);		
		}
	
	}

	public List<JQPropertyOption> getPropertyOptions(int propertyId)
	{
		List<JQPropertyOption> propertyOptions = jqPropertyMapper.findProperyOptionsById(propertyId);
		
		
		return propertyOptions;
		
	}
	
	
	public int assignPropertyOptions(int propertyId,List<JQPropertyOption> propertyOptions)
	{
		for(int i=0;i<propertyOptions.size();i++)
		{
			jqPropertyMapper.assignPropertyOption(propertyId,propertyOptions.get(i));
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
