package com.jq.entity;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import com.jq.entity.JQColumn;
import com.jq.entity.JQConfig;

import java.util.Map;


public class JQModuleConfig extends JQObject
{
	public JQModuleConfig()
	{
	 	//propertyStack = new Stack<JQColumn>();
	 	//propertyMap = new TreeMap<Integer,JQProperty>();
	 	//columns = new ArrayList<JQColumn>();
	 	jqConfig = new JQConfig();
		
	}
	
	public JQModuleConfig(JQConfig config)
	{
		this.jqConfig = config;
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
		//this.configId=configId;
		this.jqConfig.setId(configId);
	}
	
	public int getConfigId()
	{
		return this.jqConfig.getId();	
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
	
	public void toBase(Map<String,String> base)
	{
		base.put("configId",String.valueOf(jqConfig.getId()));
		base.put("configName", this.jqConfig.getName());	
	}
	
	
	public void setParentId(int parentId)
	{
	
		this.parentId=parentId;
	}
	
	
	public int getParentId()
	{
	
		return parentId;
	}
	private int id;
	private int parentId;
	private int configId;
	private int moduleId;
	
	
	private JQConfig jqConfig;
	
	List<JQModuleConfig> children;
	

	
	
}

