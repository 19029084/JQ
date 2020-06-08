package com.jq.entity;

public class JQPropertyOption
{
	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setOption(String option)
	{
		this.option=option;
	}
	
	public String getOption()
	{
		return option;
	}

	private int id;
	private String option;
}
