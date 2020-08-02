package com.jq.entity;

import com.jq.entity.JQModuleData;
import java.util.HashMap;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;

public class JQModuleTable implements Serializable
{
	private static final long serialVersionUID=1L;
/*
public void addData(JQModuleData data)
{

  if(table == null)
  {
  	table = new HashMap<Integer,JQModuleData>();
  }
  
  int rowId = data.getRowId();
  
  if(!table.containsKey(rowId))
  {
  	table.put(rowId,data);
  }
  else
  {
  	JQModuleData row = table.get(rowId);
  	
  	row.addData(data);  
  }

}



private HashMap<Integer,JQModuleData> table;*/
	public void setModuleConfig(JQModuleConfig config)
	{
		this.config=config;
	
	}

	public void setModuleData(PageInfo<JQModuleData> data)
	{
		this.data=data;
	}

private JQModuleConfig config;
private PageInfo<JQModuleData> data;
}
