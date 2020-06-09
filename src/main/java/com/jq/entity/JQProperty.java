package com.jq.entity;

import com.jq.entity.JQPropertyOption;

import java.util.List;
import java.util.ArrayList;

public class JQProperty
{


	public void setId(int id)
	{
		this.id=id;
	}


	public int getId()
	{
		return id;
	}


	public void setName(String name)
	{
		this.name=name;
	}


	public String getName()
	{
		return name;
	}
	
	public void setValue(String value)
	{
		this.value=value;		
	}
	
	public void setType(int type)
	{
		this.type=type;
	}
	public String getValue()
	{
		return this.value;		
	}
	
	public int getType()
	{
		return this.type;
	}		
	
	public void addOption(JQPropertyOption option)
	{
		if(options!=null)
		{
			options = new ArrayList<JQPropertyOption>();
		}
	
		options.add(option);
	}	

	public void setOptions(List<JQPropertyOption> options)
	{
		this.options = options;
	}
	
	public List<JQPropertyOption> getOptions()
	{
		return options;
	}	

	private int id;
	private int type;
	private String name;
	private String value;

	private List<JQPropertyOption> options;




}
