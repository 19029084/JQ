package com.jq.entity;

import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQPropertyType;

import java.util.List;
import java.util.ArrayList;

import lombok.Data;



@Data
public class JQWidget
{
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
	
}
