package com.jq.entity;

import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQPropertyType;

import java.util.List;
import java.util.ArrayList;

public class JQProperty
{

	public JQProperty()
	{
		propertyType = new JQPropertyType();
		propertyType.setType("text");
	}

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
		System.out.println(name+":"+reference);
		return name==null?reference:name;
	}
	
	public String getValue()
	{
		return this.value;		
	}
	
	public void setValue(String value)
	{
		this.value=value;		
	}
	
	public void setPropertyType(JQPropertyType propertyType)
	{
		this.propertyType = propertyType;
	}

	public JQPropertyType getPropertyType()
	{
		return this.propertyType;
	}	
	
	
	public void setReference(String reference)
	{
		this.reference = reference;
	}
	
	public void addOption(JQPropertyOption option)
	{
		
		if(options==null)
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
	private JQPropertyType propertyType;
	private String name;
	private String value;
	
	private String reference;

	private List<JQPropertyOption> options;




}
