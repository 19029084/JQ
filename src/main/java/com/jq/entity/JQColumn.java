package com.jq.entity;

import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;

import java.util.List;

public class JQColumn ///extends JQProperty

{

	public JQColumn()
	{
		property = new JQProperty();
		sortKey = -1;	
	}

//	public int getId()
//	{
//		return property.getId();
//	}

	public void setSortKey(int sortKey)
	{
		this.sortKey=sortKey;
	}
	
	public int getSortKey()
	{
		return sortKey;
	}
	
	public void setProperty(JQProperty property)
	{
		this.property = property;
	
	}
	
//	public void addOption(JQPropertyOption option)
//	{
//		property.addOption(option);
//	}
	
//	public void setOptions(List<JQPropertyOption> options)
//	{
//		property.setOptions(options);
//	}
	
	public JQProperty getProperty()
	{
		return this.property;	
	}
	
	private int sortKey;
	
	private JQProperty property;


}
