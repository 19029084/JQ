package com.jq.entity;

import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQPropertyType;

import java.util.List;
import java.util.ArrayList;

import lombok.Data;
import lombok.Getter;
import lombok.AccessLevel;



@Data
public class JQWidget extends JQObject
{

	private int id;
	private int moduleId;
	private int propertyId;
	private int widgetId;
	private int configId;
	
	private boolean visible;
	private boolean searchable;
	private boolean shareable;
	private boolean required;
	
	private int dataSource;
	
	private String name;
	private String value;
	private String ref;
	
	private String type;
	
	private String key;
	
	@Getter(AccessLevel.NONE)
	private JQProperty property;
	
	List<JQWidget> children;
	
	public JQWidget()
	{
		dataSource=0;
		
		moduleId = -1;
		configId=-1;
		widgetId=-1;
		propertyId=-1;

		visible = true;
		searchable = false;
		shareable= false;
		required = false;
		
		name="";
		value="";
		ref="";
		type="text";
		
		children = new ArrayList<JQWidget>();
	
	}
	
	public JQProperty reference()
	{
		return property;	
	}


	
}
