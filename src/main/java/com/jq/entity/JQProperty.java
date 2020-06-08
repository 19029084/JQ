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

	public void addOption(JQPropertyOption option)
	{
		if(options!=null)
		{
			options = new ArrayList<JQPropertyOption>();
		}
	
		options.add(option);
	}	

	public void addOptions(List<JQPropertyOption> options)
	{
		this.options = options;
	}
	
	public List<JQPropertyOption> getOptions()
	{
		return options;
	}	

	private int id;
	private String name;

	private List<JQPropertyOption> options;




}
