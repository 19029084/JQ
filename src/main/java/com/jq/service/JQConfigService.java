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
import com.jq.entity.JQWidget;
import com.jq.entity.JQProperty;


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

import com.jq.utils.JQUtils;

@Service
public class JQConfigService
{
	static List< JQConfig > g_data = new ArrayList< JQConfig >();
	//@Resource
	//IJQModuleDAO moduleDAO;

	@Autowired
	JQConfigMapper jqConfigMapper;
	//@Autowired
	//JQPropertyMapper jqPropertyMapper;

	@Resource
	JQModuleService moduleService;
	
	@Resource
	JQPropertyService propertyService;
	
	@Resource 
	JQResourceService resourceService;
	
	@Resource 
	JQWidgetService widgetService;
	
	
	public void refresh(int moduleId, int configId)
	{
		List< Map<String,String> > rows = new ArrayList< Map<String,String> >();
		
		for(int i=0;i<g_data.size();i++)
		{
			rows.add(new HashMap<String,String>());
		}
		
		JQModuleConfig mc = moduleService.getModuleConfigById(moduleId,configId);
		
		List<JQWidget> cwidgets = mc.toWidgets();
		
		if(cwidgets.size()>0)
		{
			
			for(int i=0;i<cwidgets.size();i++)
			{
				JQWidget cwidget = cwidgets.get(i);
				switch(cwidget.getValue())
				{
					case "{config.id}":
						for(int j=0; j<g_data.size();j++)
						{
							rows.get(j).put(cwidget.getName(),""+g_data.get(j).getId());
						}
						break;
					case "{config.name}":
						for(int j=0; j<g_data.size();j++)
						{
							rows.get(j).put(cwidget.getName(),g_data.get(j).getName());
						}
						break;			
					case "{config.widgets}":
						for(int j=0; j<g_data.size();j++)
						{
							rows.get(j).put(cwidget.getName(),""+g_data.get(j).getId());
						}
						break;					
				}
				//rows.get(i).put("rowId",g_data.get(j).getId());
				
			}
		
		}
		
		moduleService.addModuleData(moduleId,configId,rows);
		g_data.clear();
	}

	public List<JQConfig> getConfigs()
	{	
		 List<JQConfig> configs = jqConfigMapper.findAllConfigs();

		 return configs;                
	}
	
	public JQConfig loadConfig(int configId)
	{
		JQConfig newConfig = jqConfigMapper.findConfigById(configId);
		
		return newConfig;	
	}
	
	
	
	public JQConfig findConfigByName(String name)
	{
		return jqConfigMapper.findConfigByName(name);
	}
	
	
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
		
		
		JQConfig existConfig = jqConfigMapper.findConfigByName(config.getName());
		
		if(existConfig ==null)
		{
			jqConfigMapper.createConfig(config);
			
			g_data.add(config);
		}
		else
		{
			config.setId(existConfig.getId());
		}
		
		List<JQColumn> columns = config.getProperties();
			
		for(int j=0;j<columns.size();j++)
		{
			JQColumn column = columns.get(j);
				
			//JQProperty property = column.getProperty();
				
			//propertyService.createProperty(property);
				
			//jqConfigMapper.assignProperty(config.getId(),property.getId(),String.valueOf(column.getSortKey()));
			
			List<JQWidget> widgets = column.getWidget();
			
			for(int k=0;k<widgets.size();k++)
			{
				JQWidget widget = widgets.get(k);
				
				createWidget(widget,0);
			
				jqConfigMapper.assignWidget(config.getId(),widget.getId(), String.valueOf(j+1));
				
				List<JQWidget> children = widget.getChildren();
				if(children != null)
				{
					for(int i=0;i<children.size();i++)
					{
						jqConfigMapper.assignWidget(config.getId(),widget.getId(), String.valueOf(j+1));
						
					}
				}				
				
			}
				
		}
		
		return 0;
		
	}
	

	public void updateConfig(JQConfig config)
	{	
	
		jqConfigMapper.updateConfig(config);
		
		List<JQWidget> widgets = config.toWidgets();
		
		if(widgets != null)
		{
			jqConfigMapper.deleteConfigWidget(config.getId());
			
			for(int i=0;i<widgets.size();i++)
			{
				JQWidget widget = widgets.get(i);
				
				if(widget.getId()>0)
				{			
					jqConfigMapper.updateWidget(widget);
				}
				else
				{
					jqConfigMapper.createWidget(widget);
				}

				jqConfigMapper.assignWidget(config.getId(),widget.getId(), ""+i);//@todo
				
			}
		}
		
		
		/*JQConfig existConfig = jqConfigMapper.findConfigById(configId);
		
		List<Integer> moduleIds = moduleService.findModuleIdByConfigId(configId);
		
		HashMap<Integer,List<JQModuleData> > cache = new HashMap<>();
		
		for(int i=0;i<moduleIds.size();i++)
		{
			 
			List<JQModuleData> data = moduleService.loadModuleData(moduleIds.get(i).intValue(),configId);
			
			cache.put(moduleIds.get(i),data);
			
			moduleService.deleteModuleConfig(moduleIds.get(i).intValue(),configId);
		}
		
		deleteConfig(configId);		
		
		createConfig(config);
		
		for(int i=0;i<moduleIds.size();i++)
		{
			JQModuleConfig moduleConfig=new JQModuleConfig();
			
			moduleConfig.setConfigId(config.getId());
			moduleConfig.setModuleId(moduleIds.get(i).intValue());
			
			moduleService.assignModuleConfig(moduleIds.get(i).intValue(),moduleConfig);
			
			List<JQModuleData> data = cache.get(moduleIds.get(i));
			
			List< Map<String,String> > updatedData = new ArrayList<>();
			//@TODO  update sub data
			for(int j=0;j<data.size();j++)
			{
				JQModuleData original = data.get(j);
				
				List<JQWidget> originalWidget = original.toWidgets();
				
				List<JQWidget> newWidget = config.toWidgets();
				
				HashMap<String, JQWidget> key2Widget = new HashMap<>();
				
				HashMap<String,String> values = new HashMap<>();
				
				for(int k=0;k<newWidget.size();k++)
				{
					key2Widget.put(newWidget.get(k).getName(),newWidget.get(k));
				}
				
				for(int k=0;k<originalWidget.size();k++)
				{
					JQWidget sameWidget = key2Widget.get(originalWidget.get(k).getName());
					
					if(sameWidget!=null)
					{
						values.put(sameWidget.getName(),originalWidget.get(k).getValue());
					}
				}
				
				updatedData.add(values);
			}
			
			moduleService.addModuleData(moduleIds.get(i).intValue(),configId,updatedData);
			
		}*/
		
		
	}
	
	public void deleteConfig(int configId)
	{
		jqConfigMapper.deleteConfig(configId);
	}
	
	public int numOfWidgets(int configId)
	{
		return jqConfigMapper.numOfWidgets(configId);
	
	}
	
	
	public void createWidget(JQWidget widget,int parentId)
	{	
	
		JQWidget existWidget = findWidgetByName(widget.getName());
		if(existWidget != null)
		{
			widget.setId(existWidget.getId());
		}
		else
		{
		

			switch(widget.getDataSource())
			{
				case 0:
				
					JQProperty property = widget.reference();

					if(property ==null)
					{
						widget.setDataSource(-1);
					}
					else
					{
						propertyService.createProperty(property);
						
						widget.setPropertyId(property.getId());
						
						
					}
				
					/*List<JQProperty> properties = widget.getProperties();
					
					if(properties !=null)
						System.out.println("properties:" + properties.size());
					
					if(properties == null || properties.size()==0 )
					{
						

						JQProperty property = new JQProperty();
						property.setName(widget.getName());
						propertyService.createProperty(property);
						widget.addProperty(property);
					}
					else
					{
						for(int i=0;i<properties.size();i++)
						{
							propertyService.createProperty(properties.get(i));
						}
					}*/
					
					break;
				case 1:
					/*if(widget.getWidgetId() == -1)
					{
						JQWidget refWidget = findWidgetByName(widget.getRef());
						if(refWidget == null)
						{
							//@TODO
							System.out.println("ERROR !!!");
							return;
						}
						else
						{
							widget.setWidgetId(refWidget.getId());
						}
					}*/				
					break;			
				case 2:
					/*if(widget.getConfigId() == -1)
					{
						JQConfig refJQConfig = findConfigByName(widget.getRef());
						if(refJQConfig == null)
						{
							
							JQConfig config = new JQConfig();
							config.setName(widget.getRef());						
							createConfig(config);
						}
						else
						{
							widget.setConfigId(refJQConfig.getId());
						}
					}*/
					break;	
					
				default:
					System.out.println("ERROR DataSource:"+widget.getDataSource());		
			
			}			

			jqConfigMapper.createWidget(widget);
			
			/*List<JQProperty> properties = widget.getProperties();
			
			for(int i=0;i<properties.size();i++)
			{
				widgetService.assignProperty(widget.getId(),properties.get(i).getId());
			}*/
		}
		
		
		List<JQWidget> children = widget.getChildren();
		if(children != null)
		{
			for(int i=0;i<children.size();i++)
			{
				JQWidget child = children.get(i);
				
				createWidget(child,widget.getId());
				
			}
		}
	}
	
	
	public JQWidget findWidgetByName(String name)
	{
		return jqConfigMapper.findWidgetByName(name);
	}
	
	public List<JQWidget> findWidgetByConfigId(int configId,boolean searchable,
						                  boolean visible,
						                  boolean shareable)
	{
		return jqConfigMapper.findWidgetByConfigId(configId,searchable,visible,shareable);
	}
	
	
		
	public JQConfig toConfig(Map<String,String> data)	    
	{


		JQModuleConfig moduleConfig = moduleService.getConfigService();
    	
		List<JQWidget> widgets = moduleConfig.toWidgets();
			
		Map<String,String> reverseMap = new HashMap<String,String>();
			
		for(int j=0;j<widgets.size();j++)
		{
			JQWidget widget = widgets.get(j);
		
			String value = data.get(widget.getName());
				
			if(value!=null)
			{
				reverseMap.put(widget.getValue(),value);
			}

 		}
 	
    		JQConfig config = new JQConfig();
    	
    		for(Map.Entry<String,String> entry:data.entrySet()){
	    		switch(entry.getKey())
	    		{
	    			case "{config.name}":
	    				config.setName(entry.getValue());
	    				break;
	    			case "{config.id}":
					config.setId(Integer.parseInt(entry.getValue()));
	    				break;
				default:
					
	    				
	    		}
    	
    		}

	   	return config;
	    
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
