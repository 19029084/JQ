package com.jq.service;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;



import com.jq.mapper.JQModuleMapper;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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

	public List<JQModule> getModules(String pid)
	{
		return jqModuleMapper.getModules(pid);
	}	


	public List<JQModuleData> getModuleData(String mid)
	{
		List<JQModuleConfig> configs = getModuleConfig(mid);
		
		for(int i=0;i< configs.size();i++)
		{
			JQModuleConfig c = configs.get(i);
			List<JQPropertyOption> options = jqModuleMapper.getProperyOptions(""+c.getPropertyId());
			c.Property().addOptions(options);
		}
		
		List<JQModuleData> data = jqModuleMapper.getModuleData(mid);
		
		Map<Integer,JQModuleData> table = new TreeMap<Integer,JQModuleData>();
		
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
			
			System.out.println(data.get(i));	
			
			
			row.addData(data.get(i));
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
	
	public List<JQModuleConfig> getModuleConfig(String mid)
	{
		return jqModuleMapper.getModuleConfig(mid);
	}

}
