package com.jq.service;

import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQPropertyType;

import com.jq.entity.JQWidget;

import com.jq.entity.JQColumn;
import com.jq.entity.JQConfig;

import java.util.List;

import com.jq.mapper.JQPropertyMapper;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

import java.util.HashMap;

import java.util.ArrayList;

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
		
		List<JQColumn> columns = config.getProperties();
		
		for(int i=0;i<columns.size();i++)
		{
			JQColumn column = columns.get(i);
			
			List<JQWidget> widgets = column.getWidget();
			
			for(int j=0;j<widgets.size();j++)
			{
				
				//@todo
				/*
				List<JQProperty> properties = widgets.get(j).getProperties();
				
				for(int k=0;k<properties.size();k++)
				{
					JQProperty property = properties.get(k);
					
					loadPropertyOptions(property);
					
				}*/
			}
		
		}
	
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
	
	
	/*public int deleteProperties(List<JQProperty> properties)
	{
	
		for(int i=0;i<properties.size();i++)
		{
			jqPropertyMapper.deleteProperty(properties.get(i));
		
		}
		
		return 0;
	
	
	}*/
	
	public void deleteProperty(int id)
	{
		jqPropertyMapper.deleteProperty(id);
	}
	
	

	public void loadPropertyOptions(JQProperty property)
	{
		int propertyId = property.getId();
		List<JQPropertyOption> options = getPropertyOptions(propertyId);
		if(options !=null)
		{
			property.setOptions(options);
		}
	}
	
	
	public List<JQPropertyOption> getPropertyOptions(int propertyId)
	{
		
		
		List<JQPropertyOption> propertyOptions = jqPropertyMapper.findProperyOptionsById(propertyId);
		
		HashMap<Integer, List<JQPropertyOption> > cache = new HashMap<Integer,List<JQPropertyOption> >();
		
		for(int i=0;i<propertyOptions.size();i++)
		{
			JQPropertyOption option = propertyOptions.get(i);
			
			List<JQPropertyOption> children = cache.get(option.getParentId());
			
			if(children == null)
			{
				children = new ArrayList<JQPropertyOption>();
				
				cache.put(option.getParentId(), children);
			}
			
			children.add(option);
		}
		
		List<JQPropertyOption> children = cache.get(0);
		
		if(children != null)
		{
			
			for(int i=0;i<children.size();i++)
			{
				JQPropertyOption option = children.get(i);
				
				List<JQPropertyOption> c = cache.get(option.getId());
				
				if(c!=null)
				{
					option.setChildren(c);
				}
			
			}
			
					
		}
		
		return children;
	}
	
	
	
	
	
	public int assignPropertyOptions(int propertyId,List<JQPropertyOption> propertyOptions)
	{
		for(int i=0;i<propertyOptions.size();i++)
		{
			JQPropertyOption option = propertyOptions.get(i);
			
			createPropertyOption(propertyId,0,option);			
			
			
			
			List<JQPropertyOption> children = option.getChildren();
			
			if(children != null)
			{
				for(int j=0;j<children.size();j++)
				{
				
					
					JQPropertyOption child = children.get(j);
					
					createPropertyOption(propertyId,option.getId(),child);
					
				}
			}
			
			
			
			
		}
		
		return 0;
	}
	
	
	public void createPropertyOption(int propertyId, int parentId, JQPropertyOption option)
	{
		JQPropertyOption existOption = jqPropertyMapper.findPropertyOptionByValue(propertyId,parentId,option.getValue());
		
		if(existOption ==null)
		{
			jqPropertyMapper.assignPropertyOption(propertyId,parentId, option);
			System.out.println("option: "+option.getId());
		}
		else
		{
			option.setId(existOption.getId());
		}
			
	
	}
	
	
	public int updatePropertyOptions(int propertyId,List<JQPropertyOption> propertyOptions)
	{
		for(int i=0;i<propertyOptions.size();i++)
		{
			jqPropertyMapper.updatePropertyOption(propertyId,propertyOptions.get(i));
		}
		
		return 0;
	}
	
	
	/*public int deletePropertyOptions(String propertyId,List<JQPropertyOption> propertyOptions)
	{
		for(int i=0;i<propertyOptions.size();i++)
		{
			jqPropertyMapper.deletePropertyOption(propertyId,propertyOptions.get(i));
		}
		
		return 0;
	}*/
	
	public void deletePropertyOptionByIds(int propertyId,List<Integer> optionIds)
	{
		for(int i=0;i<optionIds.size();i++)
		{
			jqPropertyMapper.deletePropertyOption(propertyId,optionIds.get(i));
		}
	
	}

	
	

}
