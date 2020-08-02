package com.jq.entity;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

import java.util.Iterator;

import com.jq.entity.JQModuleConfig;

import com.jq.api.JQModuleBase;

import java.util.Map;
import java.util.UUID;

public class JQModule extends JQObject
{
	private int id;
	private int parentId;
	private JQUrl url;
	
	private JQModuleBase base;
	

	
	public JQModule(){
	
		subModules = new ArrayList();
		dataList = new ArrayList();
		configList= new ArrayList();
		base = new JQModuleBase();
		url = new JQUrl(UUID.randomUUID().toString());
		
		
	}


	public JQModule(JQModuleBase base){
	
		subModules = new ArrayList();
		dataList = new ArrayList();
		configList= new ArrayList();
		url = new JQUrl(UUID.randomUUID().toString());
		this.base = base;
		
		
		
	}

	JQModule(int id,String name)
	{
		subModules = new ArrayList();
		dataList = new ArrayList();
		configList= new ArrayList();
		url = new JQUrl(UUID.randomUUID().toString());
		
		base = new JQModuleBase();
		this.base.setName(name);
		this.base.setId(id);
	}
	
	public void setUrlId(int urlId)
	{
		this.url.setId(urlId);
	}

	public int getUrlId()
	{
		return url.getId();
	}	
	
	public int getId()
	{
		return base.getId();
	}
	
	public void setId(int id)
	{
		this.base.setId(id);
	}
	
	public String getStatus()
	{
		return base.getStatus()==null?"":base.getStatus();
	}
	
	public void setStatus(String status)
	{
		this.base.setStatus(status);
	}	
	
	public int getParentId()
	{
		return parentId;
	}
	
	public void setParentId(int parentId)
	{
		this.parentId=parentId;
	}

	public String getIcon() {
		return base.getIcon()==null?"":base.getIcon();
	}

	public void setIcon(String icon) {
		base.setIcon(icon);
	}

	public void setName(String name)
	{
		this.base.setName(name);
	}
	
	
	public String getName()
	{
		return base.getName();
	}
	
	public String getPath()
	{
		return url.getName()==null?"":url.getName();
	}
	
	public void setPath(String path)
	{
		this.url.setName(path);
	}
	
	public void setSortKey(String sortKey)
	{
		this.base.setSortKey(sortKey);
	}
	public String getSortKey()
	{
		return base.getSortKey();
	}
	
	public JQUrl getUrl()
	{
		return url;
	}

	public void addChildren(JQModule module)
	{
		module.setSortKey(String.valueOf(subModules.size()+1));
		subModules.add(module);
	}
	
	
	public List<JQModule> getChildren()
	{
		return subModules;	
	}
	
	public void setChildren(List<JQModule> subModules)
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
	
	
	public JQModuleBase toBase()
	{
		return base;
	}
	
	public void toBase(Map<String,String> output)
	{
		output.put("moduleId",String.valueOf(getId()));
		output.put("moduleName",String.valueOf(getName()));
		output.put("moduleIcon",String.valueOf(getIcon()));
		output.put("moduleStatus",String.valueOf(getStatus()));
		output.put("moduleSortKey", String.valueOf(getSortKey()));
		output.put("moduleUrl",String.valueOf(getPath()));		
	}
	
	Stack<JQModuleConfig> configStack;
	
	List<JQModule> subModules;
	
	List<JQModuleConfig> configList;
	
	List<JQModuleData> dataList;
	
	

}
