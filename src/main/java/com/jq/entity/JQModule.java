package com.jq.entity;

import java.util.List;

public class JQModule
{
	private int id;
	private String name;
	private String path;
	
	public JQModule(){
	}

	JQModule(int id,String name)
	{

		this.id = id;
		this.name = name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPath()
	{
		return path;
	}
	
	public void setPath(String path)
	{
		this.path=path;
	}
	
	

}
