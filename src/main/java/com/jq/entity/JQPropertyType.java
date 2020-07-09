package com.jq.entity;

public class JQPropertyType
{

	public JQPropertyType()
	{
		id=-1;
		type = "UNKNOWN";
		description = null;
	
	}
	
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return id;
	}
	
	
	public void setType(String type)
	{
		this.type=type;
	}
	
	public String getType()
	{
		return type;
	}
	

	
	public void setDescription(String description)
	{
		this.description=description;
	}
	
	public String getDescription()
	{
		return description;
	}

	private int id;
	private String type;
	private String description;
}
