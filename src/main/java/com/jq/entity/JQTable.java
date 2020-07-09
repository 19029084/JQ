package com.jq.entity;

import com.jq.entity.JQRow;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class JQTable
{
	public void setModuleConfig(JQModuleConfig config)
	{	
		this.config = config;
	}
	
	public void setRows(PageInfo<JQRow> rows)
	{
		this.rows = rows;
	}
	
	private JQModuleConfig config;
	private PageInfo<JQRow> rows;
	
}
