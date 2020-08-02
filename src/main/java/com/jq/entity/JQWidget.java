package com.jq.entity;

import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQPropertyType;

import java.util.List;
import java.util.ArrayList;

import lombok.Data;



@Data
public class JQWidget extends JQObject
{

	private int id;
	private int moduleId;
	private int propertyId;
	private int widgetId;
	private int configId;
	
	private boolean visiable;
	private boolean searchable;
	private boolean shareable;
	private boolean required;
	
	private int dataSource;
	
	private String name;
	private String value;
	private String ref;
	
	private String type;
	
	//private List<JQProperty> properties;
	
	private JQProperty property;
	
	
	List<JQWidget> children;
	
	public JQWidget()
	{
		dataSource=0;
		
		moduleId = -1;
		configId=-1;
		widgetId=-1;
		propertyId=-1;

		visiable = true;
		searchable = true;
		shareable= true;
		required = true;
		
		name="";
		value="";
		ref="";
		type="text";
		
		children = new ArrayList<JQWidget>();
		
	
	}
	
	public String getRef()
	{
		if(propertyId == -1 && widgetId==-1 && configId==-1)
			return ref==null?name:ref;
		else
			return ref;
	}
	
	

	
	//private List<JQPropertyOption> options;
	
	//public void addOption(JQPropertyOption option)
	//{
	//	if(options == null)
	//	{
	//		options = new ArrayList<JQPropertyOption>();
	//	}
	//	options.add(option);
	//}
	
	public String getType()
	{
		return type==null?"text":type;
			
	}
	
	public String getValue()
	{
		return value==null?"":value;
			
	}	
	//public void addProperty(JQProperty property)
	//{
	//	if(properties==null)
	//	{
	//		properties = new ArrayList<JQProperty>();		
	//	}	
		
	//	properties.add(property);
	
	//}
	
}
