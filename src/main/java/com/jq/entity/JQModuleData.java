package com.jq.entity;


import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class JQModuleData
{

	public void setRowId(int rowId)
	{
		this.rowId=rowId;
	}	

	public void addData(JQProperty property)
	{
		if(row==null)
		{
			row = new HashMap<Integer,JQProperty>();
		}
		
		row.put(property.getId(),property);
	}
	
	public int getRowId()
	{
		return rowId;
	}

	
	//public HashMap<Integer,JQProperty> getData()
	//{
	//	return row;
	//}
	
	public List<JQProperty> getData()
	{
		List<JQProperty> propertyList = new ArrayList<JQProperty>();
		if(row != null)
		{
			for(JQProperty property : row.values())
			{
				propertyList.add(property);
			}
		}
		return propertyList;
	}
	

	private int rowId;
	private HashMap<Integer,JQProperty> row = new HashMap<Integer,JQProperty>();
	
}
