package com.jq.mapper;

import com.jq.entity.JQProperty;

public class JQColumn extends JQProperty

{

	void setRowId(int rowId)
	{
		this.rowId=rowId;
	}
	
	public int getRowId()
	{
		return rowId;
	}
	
	private int rowId;


}
