package com.jq.entity;


import javax.persistence.*;
import java.util.Objects;
import java.util.List;
//import org.codehaus.jackson.annotate.JsonBackReference;

//@Entity
//@Table(name="sys_permission")

public class JQPermission
{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id")
	private int id;
	//@Column(name="code")
	//private String code;
	//@Column(name="name")
	private String name;
	//@Column(name="url")
	private String url;

	private int parentid;

	private int urlId;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id=id;	
	}
	
	public void setUrlId(int urlId)
	{
		this.urlId=urlId;
	}

	public int getUrlId()
	{
		return this.urlId;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;	
	}
	
	
	public String getUrl()
	{
		return url==null?"xxx":url;
	}
	
	public void setUrl(String url)
	{
		this.url=url;	
	}
	
	//@JsonBackReference
	//@ManyToMany(mappedBy="permissions")
	//private List<JQRole> roles;
	
		
	
	


}
