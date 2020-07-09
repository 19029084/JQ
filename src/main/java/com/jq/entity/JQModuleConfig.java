package com.jq.entity;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import com.jq.entity.JQColumn;


public class JQModuleConfig
{
	public JQModuleConfig()
	{
	 //propertyStack = new Stack<JQColumn>();
	 //propertyMap = new TreeMap<Integer,JQProperty>();
	 	columns = new ArrayList<JQColumn>();
		
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(int moduleId)
	{
		this.moduleId = moduleId;
	}
	
	public void setConfigId(int configId)
	{
		this.configId=configId;
	}
	
	public int getConfigId()
	{
		return configId;	
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
	
	boolean isConfig()
	{
		return true;
	}
	
	public String toString()
	{
		return ""+configId;
	}
	
	
	private int id;
	private int configId;
	private int moduleId;
	
	//private Stack<JQColumn> propertyStack;
	//private TreeMap<Integer,JQProperty> propertyMap;
	
	private List<JQColumn> columns;
	
	
}

