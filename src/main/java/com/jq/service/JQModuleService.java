package com.jq.service;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQUrl;



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

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class JQModuleService
{
	//@Resource
	//IJQModuleDAO moduleDAO;

	@Autowired
	JQModuleMapper jqModuleMapper;
	//@Autowired
	//JQPropertyMapper jqPropertyMapper;
	
	@Resource
	JQPropertyService propertyService;
	
	@Resource 
	JQResourceService resourceService;

	public List<JQModule> getModules(String pid)
	{	

		String pass= "admin";
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		String hashPass = bcryptPasswordEncoder.encode(pass);
		System.out.println(hashPass);

		return jqModuleMapper.getModules(pid);                
	}
	
	
	
	public JQModule getModuleByName(String name,String pid)
	{
		return jqModuleMapper.getModuleByName(name,pid);
	}
	
	
	public int createModules(List<JQModule> modules, String pid)
	{
		for(int i=0;i<modules.size();i++)
		{
			JQModule module = modules.get(i);
			
			if(module == null)
			{
				continue;
			}
			System.out.println("Module:"+module.getName());
			
			String urlId = null;
			
			if(module.getPath() != null)
			{
				urlId = String.valueOf(resourceService.createUrl(new JQUrl(module.getPath())));
			}
			
			int moduleId = jqModuleMapper.createModule(module,pid,urlId);
			
			JQModule newModule = jqModuleMapper.getModuleByName(module.getName(),pid);
			
			module.setId(newModule.getId());
			
			System.out.println(module.getName()+"Module: " + moduleId);
			
			System.out.println(":::"+newModule.getId());
			
			List<JQModule> subModules = module.getSubModules();
			
			if(subModules !=null)
			{
				createModules(subModules,String.valueOf(module.getId()));
			}
			
			List<JQModuleConfig> configs = module.getModuleConfigs();
			
			addModuleConfig(String.valueOf(module.getId()),configs);
			
			List<JQModuleData> data= module.getModuleData();
			
			addModuleData(String.valueOf(module.getId()),data);	
		
		}	
		
		return 0;
	
	}	


	public int updateModules(List<JQModule> modules, String pid)
	{
		for(int i=0;i<modules.size();i++)
		{
			
			JQModule module = modules.get(i);
			
			String urlId = null;
			
			if(module.getPath() != null)
			{
				JQUrl url = resourceService.findUrlByName(module.getPath());
				if(url !=null)
				{
					urlId = String.valueOf(url.getId());
				}
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




	public List<JQModuleData> getModuleData(String mid)
	{
		Map<Integer,JQModuleData> table = new TreeMap<Integer,JQModuleData>();
		
		List<JQModuleData> result = new ArrayList<JQModuleData>();
		
		List<JQModuleConfig> configs = getModuleConfig(mid);
		
		for(int i=0;i<configs.size();i++)
		{
			JQModuleConfig config = configs.get(i);
			
			JQModuleData data = new JQModuleData();
			
			data.setModuleId(config.getModuleId());
			
			data.setConfigId(config.getConfigId());
			
			List<JQColumn> columns = jqModuleMapper.getModuleData(mid,String.valueOf(config.getConfigId()));
			
			List<JQProperty> properties = new ArrayList<JQProperty>();
			
			int rowId=0;
			
			for(int j=0;j<columns.size();j++)
			{
				JQColumn col = columns.get(j);
				if(rowId==0)
				{
					rowId=col.getRowId();
					properties.add(col);
				}
				else
				{
					if(rowId!= col.getRowId())
					{
						data.setProperties(properties);
						data.setParentId(rowId);
						result.add(data);
						
						data= new JQModuleData();
						data.setModuleId(config.getModuleId());
						data.setConfigId(config.getConfigId());
						properties = new ArrayList();
						rowId=col.getRowId();
						properties.add(col);
					
					}
					else
					{
						properties.add(col);

					}
				}
				
				if(j==(columns.size()-1))
				{
					data.setProperties(properties);
					data.setParentId(rowId);
					result.add(data);
				}
					
			
			}
			
					
		}			
	
		return result;
	}
	
	
	
	public int addModuleData(String mid, List<JQModuleData> moduleData)
	{
		for(int i=0;i<moduleData.size();i++)
		{
		
			int configId = moduleData.get(i).getConfigId();
			
			int total = jqModuleMapper.getTotalQuantity(String.valueOf(mid),String.valueOf(configId));
			
			List<JQProperty> data = moduleData.get(i).getProperties();
			
			for(int j=0;j<data.size();j++)
			{
			jqModuleMapper.addModuleData(String.valueOf(mid),String.valueOf(configId),total+1,data.get(j));			
			}	
		}
		
		return 0;
	
	}
	
	public int updateModuleData(String mid, List<JQModuleData> moduleData)
	{
		for(int i=0;i<moduleData.size();i++)
		{
		
			//int rowId = moduleData.get(i).getRowId();
			
			List<JQProperty> data = moduleData.get(i).getProperties();
			
			for(int j=0;j<data.size();j++)
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
			
			List<JQProperty> data = moduleData.get(i).getProperties();
			
			for(int j=0;j<data.size();j++)
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
			
			List<JQProperty> properties = config.getProperties();
			
			
			propertyService.createProperties(properties);
			
			for(int j=0;j<properties.size();j++)
			{
				JQProperty property = properties.get(j);
				
				jqModuleMapper.addModuleConfig(mid,String.valueOf(property.getId()),String.valueOf(config.getConfigId()));
				
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
	

}
