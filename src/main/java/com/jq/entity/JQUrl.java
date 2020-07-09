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

	private String url;

	private String description;

	public JQUrl(String url)
	{
	
		this.url = url;
	}
	
	public String getUrl()
	{
		return url;
	}
	
	public int getId()
	{
		return id;
	}






}
