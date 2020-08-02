package com.jq.service;

import com.jq.entity.*;
import com.jq.mapper.JQWidgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JQWidgetService
{
	@Autowired
	JQWidgetMapper jqWidgetMapper;

	public List<JQWidget> getWidgets()
	{

		return jqWidgetMapper.getWidgets();
	}

	public JQWidget getWidgetByName(String name){
		return jqWidgetMapper.getWidgetByName(name);
	}
	
	
	public void assignProperty(int widgetId,int propertyId)
	{
		jqWidgetMapper.assignProperty(widgetId,propertyId);
	}



}
