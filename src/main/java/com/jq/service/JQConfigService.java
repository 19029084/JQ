package com.jq.service;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQUrl;
import com.jq.entity.JQConfig;


import com.jq.mapper.JQModuleMapper;
import com.jq.mapper.JQPropertyMapper;
import com.jq.mapper.JQConfigMapper;

import com.jq.entity.JQColumn;
import com.jq.entity.JQRow;
import com.jq.entity.JQModuleTable;



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

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class JQConfigService
{
	//@Resource
	//IJQModuleDAO moduleDAO;

	@Autowired
	JQConfigMapper jqConfigMapper;
	//@Autowired
	//JQPropertyMapper jqPropertyMapper;
	
	@Resource
	JQPropertyService propertyService;
	
	@Resource 
	JQResourceService resourceService;

	public List<JQConfig> getConfigs()
	{	
		return jqConfigMapper.getConfigs();                
	}
	
	
/*	
	public JQModule getModuleByName(String name,String pid)
	{
		return jqModuleMapper.getModuleByName(name,pid);
	}
	
*/	
	public int createConfigs(List<JQConfig> configs)
	{
		for(int i=0;i<configs.size();i++)
		{
			JQConfig config = configs.get(i);
			
			createConfig(config);
		}	
		
		return 0;
	
	}
	
	public int createConfig(JQConfig config)
	{
		int configId = jqConfigMapper.createConfig(config);
		
		JQConfig newConfig = jqConfigMapper.getConfigByName(config.getName());
		
		config.setId(newConfig.getId());
		
		return newConfig.getId();
		
	}	

/*
	public int updateModules(List<JQModule> modules, String pid)
	{
		for(int i=0;i<modules.size();i++)
		{
			
			JQModule module = modules.get(i);
			
			String urlId = null;
			
			if(module.getPath() != null)
			{
				urlId = String.valueOf(resourceService.createUrl(new JQUrl(module.getPath())));
			}			
			
			jqModuleMapper.updateModule(module,pid,urlId);
		
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




	public List<JQModuleTable> getModuleData(String mid,Integer pageNum,Integer pageSize)
	{
		//Map<Integer,JQModuleData> table = new TreeMap<Integer,JQModuleData>();
		
		List<JQModuleTable> result = new ArrayList<JQModuleTable>();
		
		List<JQModuleConfig> configs = getModuleConfig(mid);
		
		for(int i=0;i<configs.size();i++)
		{
			JQModuleConfig config = configs.get(i);
			
			JQModuleTable table = new JQModuleTable();
			
			table.setModuleConfig(config);
			
			PageHelper.startPage(pageNum,pageSize);
			
			List<JQModuleData> rows = jqModuleMapper.getModuleData(mid,String.valueOf(config.getConfigId()));
			
			PageInfo<JQModuleData> pageInfo = new PageInfo<>(rows);
			
			table.setModuleData(pageInfo);
			
			
			result.add(table);
			
			//data.setConfigId(config.getConfigId());
			
			//List<JQColumn> columns = jqModuleMapper.getModuleData(mid,String.valueOf(config.getConfigId()));
			
			//List<JQProperty> properties = new ArrayList<JQProperty>();
			
			//int rowId=0;
			
			//for(int j=0;j<columns.size();j++)
			//{
			//	JQColumn col = columns.get(j);
			//	if(rowId==0)
			//	{
			//		rowId=col.getRowId();
			//		properties.add(col);
			//	}
			//	else
			//	{
			//		if(rowId!= col.getRowId())
			//		{
			//			data.setProperties(properties);
			//			data.setParentId(rowId);
			//			result.add(data);
						
			//			data= new JQModuleData();
			//			data.setModuleId(config.getModuleId());
			//			data.setConfigId(config.getConfigId());
			//			properties = new ArrayList();
			//			rowId=col.getRowId();
			//			properties.add(col);
					
			//		}
			//		else
			//		{
			//			properties.add(col);

			//		}
			//	}
				
			//	if(j==(columns.size()-1))
			//	{
			//		data.setProperties(properties);
			//		data.setParentId(rowId);
			//		result.add(data);
			//	}
					
			
			//}
			
					
		}			
	
		return result;
	}
	
	
	
	public int addModuleData(String mid, List<JQModuleData> moduleData)
	{
		for(int i=0;i<moduleData.size();i++)
		{
		
			int configId = moduleData.get(i).getConfigId();
			
			int total = jqModuleMapper.getTotalQuantity(String.valueOf(mid),String.valueOf(configId));
			
			//List<JQProperty> data = moduleData.get(i).getProperties();
			
			//for(int j=0;j<data.size();j++)
			{
			//jqModuleMapper.addModuleData(String.valueOf(mid),String.valueOf(configId),total+1,data.get(j));			
			}	
		}
		
		return 0;
	
	}
	
	public int updateModuleData(String mid, List<JQModuleData> moduleData)
	{
		for(int i=0;i<moduleData.size();i++)
		{
		
			//int rowId = moduleData.get(i).getRowId();
			
			//List<JQProperty> data = moduleData.get(i).getProperties();
			
			//for(int j=0;j<data.size();j++)
			{
			//	jqModuleMapper.updateModuleData(mid,rowId,data.get(j));			
			}	
		}
		
		return 0;
	
	}

	public int deleteModuleData(String mid, List<JQModuleData> moduleData)
	{
		for(int i=0;i<moduleData.size();i++)
		{
		
			//int rowId = moduleData.get(i).getRowId();
			
			//List<JQProperty> data = moduleData.get(i).getProperties();
			
			//for(int j=0;j<data.size();j++)
			{
			//	jqModuleMapper.deleteModuleData(mid,rowId,data.get(j));			
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
			
			propertyService.loadPropertyByConfig(c);

		}
		
		return configs;
	}
	
	
	public int addModuleConfig(String mid,List<JQModuleConfig> configs)
	{
		for(int i=0;i<configs.size();i++)
		{
			JQModuleConfig config = configs.get(i);
			
			List<JQColumn> columns = config.getProperties();
			
			
			//propertyService.createProperties(properties);
			
			for(int j=0;j<columns.size();j++)
			{
				JQColumn column = columns.get(j);
				
				JQProperty property = column.getProperty();
				
				propertyService.createProperty(property);
				
				jqModuleMapper.addModuleConfig(mid,String.valueOf(column.getSortKey()),
								String.valueOf(property.getId()),
								String.valueOf(config.getConfigId()));
				
			}
			
			
			
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
	*/

}
