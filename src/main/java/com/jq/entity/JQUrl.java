package com.jq.entity;

import lombok.Data;


import com.jq.entity.JQRole;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
public class JQUrl
{

	private int id;

	private String name;

	private String description;

	public JQUrl(String name)
	{
	
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getId()
	{
		return id;
	}






}
