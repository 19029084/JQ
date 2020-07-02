package com.jq.entity;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

import java.util.Iterator;

import com.jq.entity.JQModuleConfig;


public class JQModule
{
	private int id;
	private String name;
	private String path;
	
	public JQModule(){
	
		subModules = new ArrayList();
		dataList = new ArrayList();
		configList= new ArrayList();
		
		
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
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void setName(String name)
	{
		this.name=name;
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
	

	public void addSubModule(JQModule module)
	{
		subModules.add(module);
	}
	
	
	public List<JQModule> getSubModules()
	{
		return subModules;	
	}
	
	public void setSubModules(List<JQModule> subModules)
	{
	
		this.subModules = subModules;
	}
	
	public List<JQModuleConfig> getModuleConfigs()
	{
		return configList;
	}
	
	
	
	public List<JQModuleData> getModuleData()
	{
	
		return dataList;
	}
	
	public void addConfig(JQModuleConfig config)
	{
		configList.add(config);
	}
	
	public void addData(JQModuleData data)
	{
		dataList.add(data);
	
	}
	
	
	Stack<JQModuleConfig> configStack;
	
	List<JQModule> subModules;
	
	List<JQModuleConfig> configList;
	
	List<JQModuleData> dataList;
	
	

}
