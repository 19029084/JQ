package com.jq.entity;

import java.util.List;
import java.util.ArrayList;

import java.util.UUID;

public class JQConfig
{
	public JQConfig()
	{
		name = UUID.randomUUID().toString();
		columns = new ArrayList<JQColumn>();
	}
	
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
	
	public void push(JQColumn property)
	{
		//System.out.println("  PUSH:: "+property.getName());
		//propertyStack.push(property);
		columns.add(property);
	}
	
	public JQColumn pop()
	{
		//System.out.println(" POP ");
		int size = columns.size();
		JQColumn column = null;
		if(size>0)
		{
			column = columns.get(size-1);
			columns.remove(size-1);
		}
		return column;
	}
	
	public JQColumn peek()
	{
		//System.out.println("----"+propertyStack.empty());
		//return propertyStack.peek();
		int size = columns.size();
		JQColumn column = null;
		
		if(size>0)
		{
			column = columns.get(size-1);			
		}
		
		return column;
		
	}
	
	public List<JQColumn> getProperties()
	{
		//List<JQColumn> propertyList = new ArrayList<JQColumn>(propertyStack);
		
		//return propertyList;
		return columns;
	}	
	
	public void setProperties(List<JQColumn> columns)
	{
	
		//while(!propertyStack.empty())
		//{
		//	propertyStack.pop();
		//}
		
		//propertyStack.addAll(properties);
		this.columns = columns;
	
	
	}
	private String name;
	private String title;	
	private int id;
	private boolean valid;
	
	private List<JQColumn> columns;
	
}
