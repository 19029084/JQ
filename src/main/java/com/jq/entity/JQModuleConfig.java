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
	
	public void setPropertyName(String name)
	{
		property.setName(name);
	}
	
	public void setPropertyId(int id)
	{
		property.setId(id);
		
	}
	
	public JQProperty getProperty()
	{
		return property;
	}	


private int id;
private JQProperty property = new JQProperty();
}

