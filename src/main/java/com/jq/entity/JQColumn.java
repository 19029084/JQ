package com.jq.entity;

import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQWidget;

import java.util.List;

import java.util.ArrayList;

public class JQColumn extends JQObject

{
	public void setId(int id)
	{
		this.id=id;
	
	}
	
	public int getId()
	{	
		return id;
	}

	public JQColumn()
	{
		widgets = new ArrayList<JQWidget>();
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
 
 	public void addWidget(JQWidget widget)
 	{
 		widgets.add(widget);
 	}
	
	public List<JQWidget> getWidget()
	{
		return widgets;
	}
	
	public void setWidget(List<JQWidget> widgets)
	{
		this.widgets =widgets;
	}
	
	private int id;
	
	private int sortKey;
	
	private List<JQWidget> widgets;
	
	//private JQProperty property;


}
