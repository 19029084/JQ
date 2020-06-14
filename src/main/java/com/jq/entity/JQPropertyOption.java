package com.jq.entity;

public class JQPropertyOption
{
	public void setId(int id)
	{
		this.id=id;
	}
	
	
	public void setPropertyId(int propertyId)
	{
		this.propertyId=propertyId;
	}
	
	public int getPropertyId()
	{
		return propertyId;
	}
	
	//public int getId()
	//{
	//	return id;
	//}
	
	public void setValue(String value)
	{
		this.value=value;
	}
	
	public String getValue()
	{
		return value;
	}

	private int id;
	private int propertyId;
	private String value;
}
