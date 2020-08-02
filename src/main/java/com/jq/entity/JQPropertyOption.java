package com.jq.entity;


import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import java.util.HashMap;

import com.jq.api.JQPropertyOptionBase;

public class JQPropertyOption extends JQObject
{


	public JQPropertyOption()
	{
		base = new JQPropertyOptionBase();
	
	}
	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return id;
	}
	
	
	public void setPropertyId(int propertyId)
	{
		this.propertyId=propertyId;
	}
	
	public int getPropertyId()
	{
		return propertyId;
	}
	

	
	public void setValue(String value)
	{
		base.setValue(value);
	}
	
	public String getValue()
	{
		return base.getValue();
	}
	
	public void setCode(String code)
	{
		base.setCode(code);
	}
	
	public String getCode()
	{
		return base.getCode();
	}

	public void setSortKey(String value)
	{
		base.setSortKey(value);
	}
	
	public String getSortKey()
	{
		return base.getSortKey();
	}	
	
	public void addChildren(JQPropertyOption option)
	{
		if(children == null)
		{
			children=new ArrayList<JQPropertyOption>();
		}
		children.add(option);
	}
	
	public List<JQPropertyOption> getChildren()
	{
		return children;
	}
	
	public void setChildren(List<JQPropertyOption> children)
	{
		this.children=children;
	}
	
	public int getParentId()
	{
		return parentId;
	}
	
	public void toBase(Map<String, Object> output, boolean explore)
	{
		output.put("value",getValue());
		output.put("code",getCode());
		output.put("sortKey",getSortKey());
		
		List<JQPropertyOption> children = getChildren();
		
		List<Map<String,Object> > childList = new ArrayList<Map<String,Object> >();
		
		if(children != null)
		{
			for(int i=0;i<children.size();i++)
			{
				Map<String,Object> c = new HashMap<String,Object>();
				
				children.get(i).toBase(c,explore);
				
				childList.add(c);
			
			}
		}
		output.put("children",childList);
	
	}
	

	private int id;
	private int propertyId;
	private int parentId;
	
	private JQPropertyOptionBase base;
		
	private List<JQPropertyOption> children;
}
