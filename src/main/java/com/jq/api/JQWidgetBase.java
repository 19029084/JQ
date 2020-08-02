package com.jq.api;

import lombok.Data;

import java.util.List;


@Data
public class JQWidgetBase
{
	private int id;
	
	private String name;
	
	private String value;
	
	private List<JQWidgetBase> properties;





}
