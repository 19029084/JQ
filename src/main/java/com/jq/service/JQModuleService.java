package com.jq.service;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;



import com.jq.mapper.JQModuleMapper;
import com.jq.mapper.JQPropertyMapper;

import com.jq.mapper.JQColumn;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

@Service
public class JQModuleService
{
	//@Resource
	//IJQModuleDAO moduleDAO;

	@Autowired
	JQModuleMapper jqModuleMapper;
	@Autowired
	JQPropertyMapper jqPropertyMapper;

	public List<JQModule> getModules(String pid)
	{
		return jqModuleMapper.getModules(pid);
	}
	
	
	
	public int createModules(List<JQModule> modules, String pid)
	{
		for(int i=0;i<modules.size();i++)
		{
			jqModuleMapper.createModule(modules.get(i),pid);
		
		}	
		
		return 0;
	
	}	


	public int updateModules(List<JQModule> modules, String pid)
	{
		for(int i=0;i<modules.size();i++)
		{
			jqModuleMapper.updateModule(modules.get(i),pid);
		
		}	
		
		return 0;
	
	}
	
	
	
	public int deleteModules(List<JQModule> modules, String pid)
	{
		for(int i=0;i<modules.size();i++)
		{
			jqModuleMapper.deleteModule(modules.get(i),pid);
		
		}	
		
		return 0;
	
	}




	public List<JQModuleData> getModuleData(String mid)
	{
		List<JQModuleConfig> configs = getModuleConfig(mid);
		Map<Integer,JQModuleData> table = new TreeMap<Integer,JQModuleData>();
		
		JQModuleData configRow = new JQModuleData();
		configRow.setRowId(0);
		table.put(0,configRow);
		
				
		for(int i=0;i< configs.size();i++)
		{
			configRow.addData(configs.get(i).getProperty());
		}
		
		List<JQColumn> data = jqModuleMapper.getModuleData(mid);
		
		for(int i=0;i< data.size();i++)
		{
			int rowID = data.get(i).getRowId();
			
			JQModuleData row = null;
			
			if(! table.containsKey(rowID))
			{
				row = new JQModuleData();
				row.setRowId(rowID);
				table.put(rowID,row);
			}
			else
			{
				row = table.get(rowID);
			}
			
			JQProperty property =  data.get(i);
			
			row.addData(property);
		}
		
		ArrayList<JQModuleData> result = new ArrayList<JQModuleData>();
		
		Set<Integer> keys = table.keySet();
		
		Iterator<Integer> iter = keys.iterator();
		
		while(iter.hasNext())
		{
			result.add(table.get(iter.next()));
		}		
	
		return result;
	}
	
	
	
	public int addModuleData(String mid, List<JQModuleData> moduleData)
	{
		for(int i=0;i<moduleData.size();i++)
		{
		
			int rowId = moduleData.get(i).getRowId();
			
			List<JQProperty> data = moduleData.get(i).getData();
			
			for(int j=0;j<data.size();j++)
			{
				jqModuleMapper.addModuleData(mid,rowId,data.get(j));			
			}	
		}
		
		return 0;
	
	}
	
	public int updateModuleData(String mid, List<JQModuleData> moduleData)
	{
		for(int i=0;i<moduleData.size();i++)
		{
		
			int rowId = moduleData.get(i).getRowId();
			
			List<JQProperty> data = moduleData.get(i).getData();
			
			for(int j=0;j<data.size();j++)
			{
				jqModuleMapper.updateModuleData(mid,rowId,data.get(j));			
			}	
		}
		
		return 0;
	
	}

	public int deleteModuleData(String mid, List<JQModuleData> moduleData)
	{
		for(int i=0;i<moduleData.size();i++)
		{
		
			int rowId = moduleData.get(i).getRowId();
			
			List<JQProperty> data = moduleData.get(i).getData();
			
			for(int j=0;j<data.size();j++)
			{
				jqModuleMapper.deleteModuleData(mid,rowId,data.get(j));			
			}	
		}
		
		return 0;
	
	}
	
	
	public List<JQModuleConfig> getModuleConfig(String mid)
	{
		List<JQModuleConfig> configs = jqModuleMapper.getModuleConfig(mid);
		
		for(int i=0;i< configs.size();i++)
		{
			JQModuleConfig c = configs.get(i);
			List<JQPropertyOption> options = jqPropertyMapper.getProperyOptions(""+c.getProperty().getId());
			c.getProperty().setOptions(options);
		}
		
		return configs;
	}
	
	
	public int addModuleConfig(String mid,List<JQModuleConfig> configs)
	{
		for(int i=0;i<configs.size();i++)
		{
			jqModuleMapper.addModuleConfig(mid,configs.get(i));
		}
		return 0;
	}
	
	public int deleteModuleConfig(String mid,List<JQModuleConfig> configs)
	{
		for(int i=0;i<configs.size();i++)
		{
			jqModuleMapper.deleteModuleConfig(mid,configs.get(i));
		}	
		return 0;
	}
	

}
