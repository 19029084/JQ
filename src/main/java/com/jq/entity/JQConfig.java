package com.jq.entity;

import java.util.List;
import java.util.ArrayList;

import java.util.UUID;

import com.jq.api.JQConfigBase;

public class JQConfig extends JQObject
{
	public JQConfig()
	{
		columns = new ArrayList<JQColumn>();
		
		base = new JQConfigBase();
		
		base.setName(UUID.randomUUID().toString());
		
		children = new ArrayList<JQConfig>();
		
		parentId =0;
		
	}
	
	
	public JQConfig(JQConfigBase base)
	{
		columns = new ArrayList<JQColumn>();
		
		this.base=base;
		
		children = new ArrayList<JQConfig>();
		
		parentId=0;
	
	}	
	public void setName(String name)
	{
		this.base.setName(name);
	}
	
	public String getName()
	{
		return this.base.getName();
	}


	public void setTitle(String title)
	{
		this.title=title;
	}
	
	public String getTitle()
	{
		return this.title;
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
	
	public String getRef()
	{
		return ref;
	}
	
	public void setRef(String ref)
	{
		this.ref=ref;
	}
	
	public void addChildren(JQConfig config)
	{
		children.add(config);
	}
	
	public List<JQConfig> getChildren()
	{
		return children;
	}
	
	public void setChildren(List<JQConfig> children)
	{
		this.children = children;
	}
	
	public int getParentId()
	{
		return parentId;
	}
	
	public void setParentId(int parentId)
	{
		this.parentId = parentId;
	}
	
	private JQConfigBase base;
	private String title;	
	private int id;
	private boolean valid;
	
	private String ref;
	
	private int parentId;
	
	private List<JQColumn> columns;
	
	private List<JQConfig> children;
	
}
