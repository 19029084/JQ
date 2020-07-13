package com.jq.entity;

import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQWidget;

import java.util.List;

public class JQColumn ///extends JQProperty

{
	public void setId(int id)
	{
		this.id=id;
	
	}

	public JQColumn()
	{
		widget = new JQWidget();
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
	
	//public void setProperty(JQProperty property)
	//{
	//	this.property = property;
	
	//}
	
//	public void addOption(JQPropertyOption option)
//	{
//		property.addOption(option);
//	}
	
//	public void setOptions(List<JQPropertyOption> options)
//	{
//		property.setOptions(options);
//	}
	
	//public JQProperty getProperty()
	//{
	//	return this.property;	
	//}
	
	public JQWidget getWidget()
	{
		return widget;
	}
	
	public void setWidget(JQWidget widget)
	{
		this.widget=widget;
	}
	
	private int id;
	
	private int sortKey;
	
	private JQWidget widget;
	
	//private JQProperty property;


}
