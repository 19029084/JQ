package com.jq.entity;

public class JQModuleConfig
{

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}	
	public String getPropertyName()
	{
		return property.getName();
	}
	
	public void setPropertyName(String name)
	{
		property.setName(name);
	}
	
	
	public int getPropertyId()
	{
		return property.getId();
	}
	
	public void setPropertyId(int id)
	{
		property.setId(id);
		
	}


private int id;
private JQProperty property = new JQProperty();
}

