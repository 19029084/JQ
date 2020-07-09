package com.jq.entity;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import com.jq.entity.JQColumn;
import com.jq.entity.JQConfig;


public class JQModuleConfig
{
	public JQModuleConfig()
	{
	 	//propertyStack = new Stack<JQColumn>();
	 	//propertyMap = new TreeMap<Integer,JQProperty>();
	 	//columns = new ArrayList<JQColumn>();
		
	}
	
	//public JQModuleConfig(JQConfig config)
	//{
	//	this.config = config;
	//}

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

	
	boolean isConfig()
	{
		return true;
	}
	
	public String toString()
	{
		return ""+configId;
	}
	
	
	public void setJQConfig(JQConfig jqConfig)
	{
	
		this.jqConfig=jqConfig;
	}
	
	public JQConfig getJQConfig()
	{
		return jqConfig;
	}
	
	
	private int id;
	private int configId;
	private int moduleId;
	
	//private Stack<JQColumn> propertyStack;
	//private TreeMap<Integer,JQProperty> propertyMap;
	
	//private List<JQColumn> columns;
	
	private JQConfig jqConfig;
	
	
}

