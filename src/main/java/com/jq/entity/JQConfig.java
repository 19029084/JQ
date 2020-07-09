package com.jq.entity;


public class JQConfig
{
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}


	public void setTitle(String title)
	{
		this.title=title;
	}


	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return this.id;
	}


	public void setValid(boolean valid)
	{
		this.valid=valid;
	}

	private String name;
	private String title;	
	private int id;
	private boolean valid;
	
}
