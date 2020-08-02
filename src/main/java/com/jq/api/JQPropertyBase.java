package com.jq.api;

import lombok.Data;

import java.util.List;


@Data
public class JQPropertyBase
{

	private int id;	
	private String name;
	private String value;
	private String code;
	private String sortKey;
	private String description;
	private String status;
	private String type;
	
	private List<JQPropertyOptionBase> options;

}
