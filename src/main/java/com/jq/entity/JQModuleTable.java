package com.jq.entity;

import com.jq.entity.JQModuleData;
import java.util.HashMap;


public class JQModuleTable
{

public void addData(JQModuleData data)
{

  if(table == null)
  {
  	table = new HashMap<Integer,JQModuleData>();
  }
  
  int rowId = data.getRowId();
  
  if(!table.containsKey(rowId))
  {
  	table.put(rowId,data);
  }
  else
  {
  	JQModuleData row = table.get(rowId);
  	
  	row.addData(data);  
  }

}

private HashMap<Integer,JQModuleData> table;
}
