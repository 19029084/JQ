package com.jq.entity;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class JQModuleConfig
{
	public JQModuleConfig()
	{
	 propertyStack = new Stack<JQProperty>();
		
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
	
	public void push(JQProperty property)
	{
		System.out.println("  PUSH:: "+property.getName());
		propertyStack.push(property);
	}
	
	public JQProperty pop()
	{
		System.out.println(" POP ");
		return propertyStack.pop();
	}
	
	public JQProperty peek()
	{
		System.out.println("----"+propertyStack.empty());
		return propertyStack.peek();
	}
	
	public List<JQProperty> getProperties()
	{
		List<JQProperty> propertyList = new ArrayList<JQProperty>(propertyStack);
		
		return propertyList;
	}	
	
	public void setProperties(List<JQProperty> properties)
	{
	
		while(!propertyStack.empty())
		{
			propertyStack.pop();
		}
		
		propertyStack.addAll(properties);
	
	
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
	
	private Stack<JQProperty> propertyStack;
	
	
}

