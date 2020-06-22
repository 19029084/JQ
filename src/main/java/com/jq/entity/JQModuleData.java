package com.jq.entity;


import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class JQModuleData extends JQModuleConfig
{

	

	public void setData(List<JQProperty> properties)
	{
		if(row==null)
		{
			row = new HashMap<Integer,JQProperty>();
		}
		
		row.clear();
		
		for(int i=0;i<properties.size();i++)
		{
			JQProperty property = properties.get(i);
		
			row.put(property.getId(),property);
		}
	}


	//public void addData(JQProperty property)
	//{
	//	if(row==null)
	//	{
	//		row = new HashMap<Integer,JQProperty>();
	//	}
		
	//	row.put(property.getId(),property);
	//
	
		

	
	public void setParentId(int parentId)
	{
	
		this.parentId=parentId;
	}
	
	//public List<JQProperty> getData()
	//{
	//	List<JQProperty> propertyList = new ArrayList<JQProperty>();
	//	if(row != null)
	//	{
	//		for(JQProperty property : row.values())
	//		{
	//			propertyList.add(property);
	//		}
	//	}
	//	return propertyList;
	//}
	
	
	public boolean isConfig()
	{
		return false;
	}

	
	private int parentId;
	
	private HashMap<Integer,JQProperty> row = new HashMap<Integer,JQProperty>();
	
}
