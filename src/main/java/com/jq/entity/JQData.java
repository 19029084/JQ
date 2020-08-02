package com.jq.entity;

import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQPropertyType;

import java.util.List;
import java.util.ArrayList;

public class JQData extends JQObject
{
	private String value;
	private List<JQData> children;

	public JQData(String root)
	{
		children = new ArrayList<JQData>();
	}

	public void setValue(String value)
	{
		this.value = value;
	}


	public String getValue()
	{
		return value;
	}


	public void addChild(JQData data)
	{

		children.add(data);
	}	

	public void setChildren(List<JQData> children)
	{
		this.children = children;
	}
	
	public List<JQData> getChildren()
	{
		return children;
	}	

	




}
