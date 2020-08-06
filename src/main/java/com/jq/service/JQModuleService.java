package com.jq.service;

import com.jq.entity.*;


import com.jq.mapper.JQModuleMapper;
import com.jq.mapper.JQPropertyMapper;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.jq.utils.JQUtils;

import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;

import java.io.File;
import java.net.URLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Collectors;

import java.util.UUID;

import java.util.Date;

@Service
public class JQModuleService
{

	@Autowired
	JQModuleMapper jqModuleMapper;
	//@Autowired
	//JQPropertyMapper jqPropertyMapper;
	
	@Resource
	JQPropertyService propertyService;
	
	@Resource 
	JQResourceService resourceService;
	
	@Resource
	JQConfigService configService;
	
	
	public int createModule(JQModule module,int pid)
	{
	
		int urlId = -1;
		
		int moduleId=-1;
		
		if(module.getPath() != null)
		{
			urlId = resourceService.createUrl(new JQUrl(module.getPath()));
			
			module.setUrlId(urlId);
		}
		
		JQModule existModule = jqModuleMapper.findModuleByName(module.getName());
		
		if(existModule ==null)
		{
			int success = jqModuleMapper.createModule(module,pid,urlId);
			
	
			moduleId=module.getId();
		}
		else
		{
			module.setId(existModule.getId());
			
			moduleId = existModule.getId();
		}
		
		JQPermission jQPermission = new JQPermission();
		jQPermission.setId(moduleId);
		jQPermission.setName(module.getName());
		jQPermission.setUrlId(urlId);
		JQModule parent = jqModuleMapper.findModuleById(pid);
		if(parent != null){
			JQPermission permission = resourceService.findPermissionByName(parent.getName());
			if(permission != null){
				pid = permission.getId();
			}
		}
		resourceService.createPerssion(jQPermission,pid);
            	
		return moduleId;
	}
	
	
	
	

	public List<JQModule> getModules(int pid)
	{	

		String pass= "admin";
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		String hashPass = bcryptPasswordEncoder.encode(pass);
		System.out.println(hashPass);
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=user.getUsername();
		return jqModuleMapper.getModules(pid,username);
	}
	
	
	
	public JQModule getModuleByName(String name)
	{
		return jqModuleMapper.findModuleByName(name);
	}
	
	public JQModule getModuleById(int id)
	{
		return jqModuleMapper.findModuleById(id);
	}	

	protected boolean isUuid(String uuid)
	{
	
		try{
			UUID.fromString(uuid).toString();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public int createModules(List<JQModule> modules, int pid)
	{
		for(int i=0;i<modules.size();i++)
		{
			JQModule module = modules.get(i);
			
			if(module == null)
			{
				continue;
			}
			System.out.println("Module:"+module.getName());
			
			int moduleId = createModule(module,pid);

			List<JQModule> subModules = module.getChildren();
			
			if(subModules !=null)
			{
				createModules(subModules,module.getId());
			}
			
			List<JQModuleConfig> configs = module.getModuleConfigs();
			
			for(int j=0;j<configs.size();j++)
			{
				JQConfig config = configs.get(j).getJQConfig();
				
				configService.createConfig(config);
				
				configs.get(j).setConfigId(config.getId());
			}
			
			////////////////////////////////////////////////////////////////////////////////////
			JQUrl url = module.getUrl();
			
			if(url !=null)
			{
				String strUrl = url.getName();
				
				if(isUuid(strUrl))
				{
					if(configs.size()>0)
					{
						url.setName("/p/"+module.getId()+"/"+configs.get(0).getConfigId());
						
					}
					else
					{
						url.setName("");
					}
					resourceService.updateUrl(url);
				
				}
			}



			
			assignModuleConfig(module.getId(),configs);
			
			List<JQModuleData> data= module.getModuleData();
			
			addModuleData(module.getName(),data);	
		
		}	
		
		return 0;
	
	}
	
	public JQModule findModuleById(int moduleId)
	{
	
		return jqModuleMapper.findModuleById(moduleId);
	
	}	


	public int updateModule(JQModule module)
	{
		JQUrl url = module.getUrl();

		resourceService.updateUrl(url);
			
		jqModuleMapper.updateModule(module,module.getParentId(),url.getId());

		return 0;
	
	}
	
	
	
	public int deleteModules(List<JQModule> modules)
	{
		for(int i=0;i<modules.size();i++)
		{
			jqModuleMapper.deleteModule(modules.get(i));
		
		}	
		
		return 0;
	
	}
	
	public int deleteModule(int moduleId)
	{
		jqModuleMapper.deleteModuleById(moduleId);
		return 0;	
	}
	
	
	
	public JQModuleConfig getModuleConfigById(int moduleId,int configId)
	{
	
		JQModuleConfig moduleConfigId = findModuleConfigById(moduleId,configId);

		return moduleConfigId;
	
	}

	public JQModuleConfig findModuleConfigByName(String module,String config)
	{
	
		JQModuleConfig moduleConfigId = jqModuleMapper.findModuleConfigByName(module,config);

		return moduleConfigId;
	
	}
	
	public void updateModuleConfig(int moduleId,JQModuleConfig moduleConfig)
	{
		jqModuleMapper.updateModuleConfig(moduleId,moduleConfig);
	
	}
	
	
	
	public  List<JQModuleData> loadModuleData(int moduleId,int configId)
	{
		List<JQModuleData> moduleData = getModuleData(moduleId,configId,0);
		
		for(int i=0;i<moduleData.size();i++)
		{
			JQConfig md = moduleData.get(i).getJQConfig();
			List<JQModuleData> subModuleData = getModuleData(moduleId,configId,md.getId());
			//System.out.println("module:"+md.getId()+":"+md.getParentId()+":"+children.size());
			for(int j=0;j< subModuleData.size();j++)
			{
				md.addChildren(subModuleData.get(j).getJQConfig());
			}
		
		}
		
		return moduleData;
	}
	

	protected  List<JQModuleData> getModuleData(int moduleId,int configId,int parentId)
	{
		//Map<Integer,JQModuleData> table = new TreeMap<Integer,JQModuleData>();
		
		//List<JQModuleTable> result = new ArrayList<JQModuleTable>();
		
		//List<JQModuleConfig> configs = getModuleConfig(mid);
		
		//for(int i=0;i<configs.size();i++)
		{
			//JQModuleConfig config = configs.get(i);
			
			//JQModuleTable table = new JQModuleTable();
			
			//table.setModuleConfig(config);
			
			
			List<JQModuleData> rows = new ArrayList<JQModuleData>();
			
			String tableName = JQUtils.getModuleDataTable(moduleId,configId);
			
			if(jqModuleMapper.existDataTable(tableName)>0)
			{
			
				JQModuleConfig moduleConfig = jqModuleMapper.findModuleConfigById(moduleId, configId);
				
				List<JQWidget> configWidgets = moduleConfig.toWidgets();			
			
			
				rows = jqModuleMapper.getModuleData(tableName,moduleId,configId,parentId);
				
				for(int i=0;i<rows.size();i++)
				{
					rows.get(i).setModuleId(moduleId);
					rows.get(i).setConfigId(configId);
					
					List<JQWidget> dataWidgets = rows.get(i).toWidgets();
					
					for(int j=0;j<dataWidgets.size();j++)
					{
						int dataSource = dataWidgets.get(j).getDataSource();
						switch(dataSource)
						{
							case 0:
								
								break;	
							
							case 1:
								break;
							case 2:
							
								break;
							default:
								JQWidget cwidget = configWidgets.get(j);
								JQWidget dwidget = dataWidgets.get(j);
								System.out.println("id: "+cwidget.getId()+":"+dwidget.getId());
								System.out.println("v:"+cwidget.getValue());
								if(cwidget.getId() == dwidget.getId())
								{
									switch(cwidget.getValue())
									{
										case "{config.widgets}":
										int numOfWidgets = configService.numOfWidgets(Integer.parseInt(dwidget.getValue()));					
										dwidget.setValue(""+numOfWidgets);						
											break;
										default:
									}
										
							
								}
								else
								{
									System.out.println("Miss Matching!");
								}
							
								
						}
					}
				}
			}
			
			return rows;
		
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
	
		
	}
	public int addModuleDataByPropertyValue(int moduleId,int configId, List< List<JQPropertyValue> > data)
	
	{
		String tableName = JQUtils.getModuleDataTable(moduleId,configId);
		
		if(jqModuleMapper.existDataTable(tableName)==0)
		{
			jqModuleMapper.createDataTable(tableName);
		}
		
		
		
		HashMap< Integer, HashMap<String,ArrayList<String> > > cache = new HashMap<Integer, HashMap<String,ArrayList<String> > >();
		
		JQModuleConfig existModuleConfig = jqModuleMapper.findModuleConfigById(moduleId, configId);
		
		if(existModuleConfig != null)
		{
			JQConfig existConfig = existModuleConfig.getJQConfig();

			HashMap<String,ArrayList<String>> configWidget = cache.get(configId);
				
			if(configWidget == null)
			{
				configWidget = new HashMap<String,ArrayList<String> >();
					
				List<JQColumn> columns = existConfig.getProperties();
					
				System.out.println("columns:"+columns.size());
					
				for(int j=0;j<columns.size();j++)
				{
					List<JQWidget> widgets  = columns.get(j).getWidget();
						
					for(int m=0;m<widgets.size();m++)
					{
						JQWidget w = widgets.get(m);
						
						ArrayList<String> result = new ArrayList<String>();
						result.add(String.valueOf(columns.get(j).getId()));
						result.add(String.valueOf(w.getId()));
						result.add(w.getValue());
						configWidget.put(w.getName(),result);						
						
						List<JQWidget> children = w.getChildren();
							
						for(int n=0;n<children.size();n++)
						{
							//ArrayList<String> result = new ArrayList<String>();
							result.add(String.valueOf(columns.get(j).getId()));
							result.add(String.valueOf(children.get(n).getId()));
							result.add(children.get(n).getValue());
							configWidget.put(children.get(n).getName(),result);
						}
					}
						
				}
					
				cache.put(configId,configWidget);
			}

		
			for(int i=0; i<data.size();i++)
			{
		
				List<JQPropertyValue> pv = data.get(i);

				HashMap<String,ArrayList<String> >  copyOfconfigWidget = new HashMap<String,ArrayList<String> >();
				
				copyOfconfigWidget.putAll(configWidget);
							
				int total = jqModuleMapper.getTotalQuantity(tableName,moduleId,configId);
				
				for(int j=0;j<pv.size();j++)
				{
					JQPropertyValue property = pv.get(j);

					ArrayList<String> pair = copyOfconfigWidget.remove(property.getName());
							
					if(pair != null)
					{
							
						List<String> values = JQUtils.covertToData(property.getValue());
								
						if(values.size()>0)
						{
							jqModuleMapper.addModuleData(tableName,Integer.parseInt(pair.get(0)),Integer.parseInt(pair.get(1)),total+1,0,values.get(0));
						}
					}				
					
				
				}
				
				for(Map.Entry<String,ArrayList<String> > entry: copyOfconfigWidget.entrySet())
				{
					List<String> values = JQUtils.covertToData(entry.getValue().get(2));
					
					if(values.size()>0)
					{
						jqModuleMapper.addModuleData(tableName,Integer.parseInt(entry.getValue().get(0)),Integer.parseInt(entry.getValue().get(1)),total+1,0,values.get(0));
					}
				
				}			
			
		
			}
	
		}
		return 0;
	}	
	public int addModuleData(int moduleId,int configId, List< Map<String,String> > data)
	{
		String tableName = JQUtils.getModuleDataTable(moduleId,configId);
		
		if(jqModuleMapper.existDataTable(tableName)==0)
		{
			jqModuleMapper.createDataTable(tableName);
		}
		
		
		
		HashMap< Integer, HashMap<String,ArrayList<String> > > cache = new HashMap<Integer, HashMap<String,ArrayList<String> > >();
		
		JQModuleConfig existModuleConfig = jqModuleMapper.findModuleConfigById(moduleId, configId);
		
		if(existModuleConfig != null)
		{
			JQConfig existConfig = existModuleConfig.getJQConfig();

			HashMap<String,ArrayList<String>> configWidget = cache.get(configId);
				
			if(configWidget == null)
			{
				configWidget = new HashMap<String,ArrayList<String> >();
					
				List<JQColumn> columns = existConfig.getProperties();
					
				System.out.println("columns:"+columns.size());
					
				for(int j=0;j<columns.size();j++)
				{
					List<JQWidget> widgets  = columns.get(j).getWidget();
						
					for(int m=0;m<widgets.size();m++)
					{
						JQWidget w = widgets.get(m);
						
						ArrayList<String> result = new ArrayList<String>();
						result.add(String.valueOf(columns.get(j).getId()));
						result.add(String.valueOf(w.getId()));
						List<String> wv = loadWidgetValue(w);
						result.add(wv.get(0));
						configWidget.put(w.getName(),result);						
						
						List<JQWidget> children = w.getChildren();
						if(children !=null)
						{	
							for(int n=0;n<children.size();n++)
							{
								//ArrayList<String> result = new ArrayList<String>();
								result.add(String.valueOf(columns.get(j).getId()));
								result.add(String.valueOf(children.get(n).getId()));
								List<String> cv = loadWidgetValue(children.get(n));
								result.add(cv.get(0));
								configWidget.put(children.get(n).getName(),result);
							}
						}
					}
						
				}
					
				cache.put(configId,configWidget);
			}

			
			for( int i=0; i<data.size();i++)
			{
				Map<String,String> row = data.get(i);
				
				String rowId= row.get("rowId");
				
				if(rowId ==null)
				{
					int total = jqModuleMapper.getTotalQuantity(tableName,moduleId,configId);
					rowId = String.valueOf(total+1);
				}
				
				String parentId = row.get("parentId");
				
				if(parentId==null)
				{
					parentId=""+0;
				}
				
				for(Map.Entry<String,ArrayList<String> > entry: configWidget.entrySet())
				{
					String value = row.get(entry.getKey());
					
					ArrayList<String> pair  = entry.getValue();
					if(value == null)
					{
						List<String> values = JQUtils.covertToData(entry.getValue().get(2));
					
						if(values.size()>0)
						{
							  jqModuleMapper.addModuleData(tableName,Integer.parseInt(entry.getValue().get(0)),
							  Integer.parseInt(entry.getValue().get(1)),Integer.parseInt(rowId),Integer.parseInt(parentId),values.get(0));
						}
					}
					else
					{
					
						List<String> values = JQUtils.covertToData(value);
								
						if(values.size()>0)
						{
							jqModuleMapper.addModuleData(tableName,Integer.parseInt(pair.get(0)),
										      Integer.parseInt(pair.get(1)),Integer.parseInt(rowId),
										      Integer.parseInt(parentId),values.get(0));
						}
					
					} 
				}
			}
			
	
		}
		return 0;
	}
	
	public int addModuleData(String module, List<JQModuleData> moduleData)
	{
		System.out.println("**************************addModuleData************************");


		
		HashMap< Integer, HashMap<String,ArrayList<String> > > cache = new HashMap<Integer, HashMap<String,ArrayList<String> > >();
		
		
		
		for(int i=0;i<moduleData.size();i++)
		{
		
			JQConfig config = moduleData.get(i).getJQConfig();
			
			JQModuleConfig existModuleConfig = jqModuleMapper.findModuleConfigByName(module, config.getRef());
			
			if(existModuleConfig != null)
			{
				JQConfig existConfig = existModuleConfig.getJQConfig();
				
				int moduleId = existModuleConfig.getModuleId();
		
				int configId = existConfig.getId();

				String tableName = JQUtils.getModuleDataTable(moduleId,configId);
				
				if(jqModuleMapper.existDataTable(tableName)==0)
				{
					jqModuleMapper.createDataTable(tableName);
				}	

				HashMap<String,ArrayList<String>> configWidget = cache.get(configId);
				
				if(configWidget == null)
				{
					configWidget = new HashMap<String,ArrayList<String> >();
					
					List<JQColumn> columns = existConfig.getProperties();
					
					System.out.println("columns:"+columns.size());
					
					for(int j=0;j<columns.size();j++)
					{
						List<JQWidget> widgets  = columns.get(j).getWidget();
						
						for(int m=0;m<widgets.size();m++)
						{
							JQWidget w = widgets.get(m);
							
							ArrayList<String> result = new ArrayList<String>();
							result.add(String.valueOf(columns.get(j).getId()));
							result.add(String.valueOf(w.getId()));
							List<String> wv = loadWidgetValue(w);
							result.add(wv.get(0));
							configWidget.put(w.getName(),result);						
							
							List<JQWidget> children = w.getChildren();
							if(children !=null)
							{	
								for(int n=0;n<children.size();n++)
								{
									//ArrayList<String> result = new ArrayList<String>();
									result.add(String.valueOf(columns.get(j).getId()));
									result.add(String.valueOf(children.get(n).getId()));
									List<String> cv = loadWidgetValue(children.get(n));					
									result.add(cv.get(0));
									configWidget.put(children.get(n).getName(),result);
								}
							}
						}
						
					}
					
					cache.put(configId,configWidget);
				}
				
				System.out.println("Map->"+ configWidget);
				
				
				HashMap<String,ArrayList<String> >  copyOfconfigWidget = new HashMap<String,ArrayList<String> >();
				
				copyOfconfigWidget.putAll(configWidget);
							
				int total = jqModuleMapper.getTotalQuantity(tableName,moduleId,configId);
				
				List<JQColumn> data = config.getProperties();				
				
				System.out.println("data"+data.size());
				
				for(int j=0;j<data.size();j++)
				{	
					
					
					List<JQWidget> widgets = data.get(j).getWidget();
					
					for(int m=0;m<widgets.size();m++)
					{
						JQWidget widget = widgets.get(m);
						
						ArrayList<String> pair = copyOfconfigWidget.remove(widget.getRef());
								
							if(pair != null)
							{
								
								List<String> values = loadWidgetValue(widget);
									
								if(values.size()>0)
								{
									jqModuleMapper.addModuleData(tableName,Integer.parseInt(pair.get(0)),Integer.parseInt(pair.get(1)),total+1,0,values.get(0));
								}
							}
						
							List<JQWidget> children = widget.getChildren();
						
							if(children !=null)
							{
							
								for(int n=0;n<children.size();n++)
								{
							
									JQWidget child = children.get(n);
							
									pair = copyOfconfigWidget.remove(child.getRef());
								
									if(pair != null)
									{
								
										List<String> values = loadWidgetValue(child);
									
										if(values.size()>0)
										{
											jqModuleMapper.addModuleData(tableName,Integer.parseInt(pair.get(0)),
												                     Integer.parseInt(pair.get(1)),total+1,0,values.get(0));
										}
								}	
							}
							
						}
						
						
						/*JQProperty property = widget.getProperty();						
						
						if(property == null || property.size()==0)
						{	
							ArrayList<String> pair = copyOfconfigWidget.remove(widget.getRef());
							
							if(pair != null)
							{
							
								List<String> values = JQUtils.covertToData(widget.getValue());
								
								if(values.size()>0)
								{
									jqModuleMapper.addModuleData(tableName,Integer.parseInt(pair.get(0)),Integer.parseInt(pair.get(1)),total+1,0,values.get(0));
								}
							}
						}
						else
						{
							
							for(int n=0;n<properties.size();n++)
							{
								ArrayList<String> pair = copyOfconfigWidget.remove(properties.get(n).getRef());
								
								System.out.println("M:"+properties.get(n).getRef());
								
								if(pair != null)
								{
									List<String> values = JQUtils.covertToData(properties.get(n).getValue());
									
									if(values.size()>0)
									{
										jqModuleMapper.addModuleData(tableName,
													      Integer.parseInt(pair.get(0)),
													      Integer.parseInt(pair.get(1)),
													      base+total+1,0,values.get(0));
									}
								}
							
							}
							
						}*/
					}			
				}
				
				for(Map.Entry<String,ArrayList<String> > entry: copyOfconfigWidget.entrySet())
				{
					List<String> values = JQUtils.covertToData(entry.getValue().get(2));
					
					if(values.size()>0)
					{
						jqModuleMapper.addModuleData(tableName,Integer.parseInt(entry.getValue().get(0)),Integer.parseInt(entry.getValue().get(1)),total+1,0,values.get(0));
					}
				
				}
				
					
			}
			else
			{
				System.out.println("DataSet is NOT correct and NO config could be found!!!");
			}
		}
		
		return 0;
	
	}
	
	
	List<String> loadWidgetValue(JQWidget widget)
	{

		List<String> result = new ArrayList<>();
		//if(true)
		//{
			String widgetValue = widget.getValue();
			if(widgetValue != null && !("".equals(widgetValue)))
			{
			
			
				switch(widgetValue)
				{
					case "{username}":
						User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
						
						String username=user.getUsername();
						
						result.add(username);
					break;
					
					case "{now}":
					
						result.add( (new Date()).toString());
									
					break;	
					
					default :
					
						result.add(widgetValue);
				}
			}		
		//}
		else
		
		{
		
			switch(widget.getDataSource())
			{
				case 0:
					int propertyId = widget.getPropertyId();
					
					if(propertyId >0)
					{
						JQProperty property = propertyService.findPropertyById(propertyId);
						
						String propertyValue =property.getValue();
						
						if(propertyValue !=null  && !("".equals(propertyValue)))
						{
							result.addAll(JQUtils.covertToData(propertyValue));
						}
						else
						{
							propertyService.loadPropertyOptions(property);
							
							List<JQPropertyOption> propertyOptions = property.getOptions();
							
							if(propertyOptions!= null)
							{						
								for(int i=0;i<propertyOptions.size();i++)
								{
									result.add(propertyOptions.get(i).getValue());
								}
							}
						}
						
					}
					break;
				case 1:
				
					break;
				case 2:
				
					break;
					
				case 100://count number of widgets in config
					
					break;
				case 101://count refrence of config
				
					break;	
					
				default:
						
						
						
						
				
			
			}
		}

		if(result.size()==0)
		{
			result.add("");
		}
		
		System.out.println("WidgetValue:" +widget.getName()+":"+result.get(0));
		
		return result;	
	
	}
	
	public void updateModuleData(int moduleId, int configId, int rowId, Map<String,String> data)
	{
		
		String tableName = JQUtils.getModuleDataTable(moduleId,configId);

		JQModuleConfig moduleConfig = jqModuleMapper.findModuleConfigById(moduleId,configId);
		
		JQConfig config = moduleConfig.getJQConfig();
		
		List<JQColumn> columns = config.getProperties();
		
		for(int i=0;i<columns.size();i++)
		{
			JQColumn col = columns.get(i);
			
			List<JQWidget> widgets = col.getWidget();
			
			for(int j=0;j<widgets.size();j++)
			{
				JQWidget widget = widgets.get(j);
				
				String value = data.get(widget.getName());
				
				if(value!=null)
				{
			
					jqModuleMapper.updateModuleData(tableName,rowId,col.getId(),widget.getId(),value);
				}
			
			}	
		}
		
	}
	
	public int updateModuleData(int  mid, List<JQModuleData> moduleData)
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
	
	

	public void deleteModuleData(int moduleId,int configId, int rowId)
	{
		String tableName = JQUtils.getModuleDataTable(moduleId,configId);

		jqModuleMapper.deleteModuleData(tableName,moduleId,configId,rowId);
		
		JQModuleConfig moduleModuleConfig = getModuleService();
						
		if(moduleModuleConfig.getModuleId() == moduleId && moduleModuleConfig.getConfigId()==configId)
		{
			deleteModule(rowId);
			
		}		
		JQModuleConfig configModuleConfig = getConfigService();	
			
		if(configModuleConfig.getModuleId() == moduleId  && configModuleConfig.getConfigId()==configId)
		{
			configService.deleteConfig(rowId);
		}		
		JQModuleConfig propertyModuleConfig = getPropertyService();
			
		if(propertyModuleConfig.getModuleId() == moduleId  && propertyModuleConfig.getConfigId()==configId)
		{
			propertyService.deleteProperty(rowId);
		}
			
		JQModuleConfig optionModuleConfig = getOptionService();
		if(optionModuleConfig.getModuleId() == moduleId  && optionModuleConfig.getConfigId()==configId)
		{
			//propertyService.deletePropertyOption(rowId);
		}
						
	
	}
	
	
	public List<JQModuleConfig> getModuleConfig(int mid)
	{
		List<JQModuleConfig> configs = jqModuleMapper.getModuleConfig(mid);
		
		for(int i=0;i< configs.size();i++)
		{
			JQModuleConfig c = configs.get(i);
			
			propertyService.loadPropertyByConfig(c.getJQConfig());

		}
		
		return configs;
	}
	
	
	public JQModuleConfig findModuleConfigById(int mid, int cid)
	{
		return jqModuleMapper.findModuleConfigById(mid,cid);
	}
	
	
	
	
	
	public int assignModuleConfig(int mid,List<JQModuleConfig> configs)
	{
		for(int i=0;i<configs.size();i++)
		{
			JQModuleConfig config = configs.get(i);
			
			//List<JQColumn> columns = config.getConfig().getProperties();
			
			
			//propertyService.createProperties(properties);
			
			//for(int j=0;j<columns.size();j++)
			//{
			//	JQColumn column = columns.get(j);
				
			//	JQProperty property = column.getProperty();
				
			//	propertyService.createProperty(property);
			
			assignModuleConfig(mid,config);
				
			//}
			
			
			
		}
		return 0;
	}
	
	
	public int assignModuleConfig(int moduleId,JQModuleConfig moduleConfig)
	{
		moduleConfig.setModuleId(moduleId);
		
		
		jqModuleMapper.createModuleConfig(moduleConfig);
		
		return moduleConfig.getId();
	}
	
	public int deleteModuleConfig(int moduleId,List<JQModuleConfig> configs)
	{
		for(int i=0;i<configs.size();i++)
		{
			deleteModuleConfig(moduleId,configs.get(i).getId());
		}	
		return 0;
	}
	
	
	public int deleteModuleConfig(int moduleId,int configId)
	{
		jqModuleMapper.deleteModuleConfig(moduleId,configId);
		
		return 0;
	}
	
	
	public List<Integer> queryRowIds(int moduleId,int configId, JQPropertyValue propertyValue, List<Integer> rowIds)
	{
		System.out.println("name="+propertyValue.getName()+":"+propertyValue.getValue());
		String tableName = JQUtils.getModuleDataTable(moduleId,configId);
		
		if(jqModuleMapper.existDataTable(tableName)>0)
		{
			return jqModuleMapper.queryRowIdsByPropertyValue(tableName,moduleId,configId,propertyValue,rowIds);
		}
		else
		{
			return null;
		}		
		
		
		
	
	}
	

	
	public List<JQModuleData> queryModuleData(JQModuleConfig moduleConfig)
	{
		
		
		//@todo
		
		int moduleId = moduleConfig.getModuleId();
		
		int configId = moduleConfig.getJQConfig().getId();
		
		String tableName = JQUtils.getModuleDataTable(moduleId,configId);
		
		if(jqModuleMapper.existDataTable(tableName)>0)
		{
	
			List<JQColumn> columns = moduleConfig.getJQConfig().getProperties();
			
			List<Integer> rowIds = new ArrayList<Integer>();
			
			for(int i=0;i<columns.size();i++)
			{
				JQColumn col = columns.get(i);
				
				List<JQWidget> widgets = col.getWidget();
				
				for(int j =0;j<widgets.size();j++)
				{
					JQWidget widget = widgets.get(j);
					
					int widgetId = widget.getId();
					
					String value = widget.getValue();
					
					if(value==null||"".equals(value))
					{
						continue;
					}
					
					rowIds = jqModuleMapper.queryRowIds(tableName,moduleId,configId,col.getId(),widget.getId(),value,rowIds);
						
					if(rowIds == null || rowIds.isEmpty())
					{
						break;
					}

					List<JQWidget> children = widget.getChildren();
					
					
					
					for(int k=0;k<children.size();k++)
					{
						JQWidget child =children.get(k);
						
						widgetId = child.getId();
						
						value = child.getValue();
						
						if(value ==null||"".equals(value))
						{
							continue;
						}			
						
						rowIds = jqModuleMapper.queryRowIds(tableName,moduleId,configId,col.getId(),widget.getId(),value,rowIds);
						
						if(rowIds == null || rowIds.isEmpty())
						{
							break;
						}
					
					}
					

					
				}
			
			}



			return queryModuleDataByRowIds(moduleId,configId,rowIds);
		}
		else
		{
			return null;
		}	
	
	}
	
	public List<JQModuleData> queryModuleDataByRowIds(int moduleId,int configId,List<Integer> rowIds)
	
	{
	
		List<JQModuleData> result = new ArrayList<JQModuleData>();
		
		if(rowIds !=null)
		{
			String tableName = JQUtils.getModuleDataTable(moduleId,configId);
		
			if(jqModuleMapper.existDataTable(tableName)>0)
			{
				for(int i=0;i<rowIds.size();i++)
				{
						
					JQModuleData data = jqModuleMapper.getModuleDataByRowId(tableName,moduleId,configId,rowIds.get(i));
					
					data.setModuleId(moduleId);
					data.setConfigId(configId);
					
				
					result.add(data);			
						
				}
			}
		}
		
		return result;
	}
	
	
	
	public List< Map<String,String> > readExcel(MultipartFile file)
	{
	
		String fileName = file.getOriginalFilename();
		if(!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$"))
		{
		 	return null;
		}
		
		List< Map<String,String> > dataList = new ArrayList<>();
		
		Workbook workbook = null;
		try{
		
			InputStream is= file.getInputStream();
			if(fileName.endsWith("xlsx"))
			{
				workbook= new XSSFWorkbook(is);
			}
			
			if(fileName.endsWith("xls"))
			{
				workbook = new HSSFWorkbook(is);
			}
			
			if(workbook !=null)
			{
				
	
			
				Sheet sheet = workbook.getSheetAt(0);
				
				boolean firstRow = true;
				
				HashMap<Integer, String> header = new HashMap<>();
				
				for(int i=sheet.getFirstRowNum();i<=sheet.getLastRowNum();i++)
				{
					Row row=sheet.getRow(i);
					
					
					
					if(firstRow)
					{
						for(int j=row.getFirstCellNum();j<=row.getLastCellNum();j++)
						{
							Cell cell = row.getCell(j);
							String cellValue = getCellValue(cell);
							header.put(j,cellValue);
						}
						firstRow = false;
					}
					else
					{
						try{
						
							if(row==null)
							{
								continue;
							}
							
							Map<String,String> widgets = new HashMap<String,String>();
							
							for(int j=row.getFirstCellNum();j<=row.getLastCellNum();j++)
							{
								Cell cell = row.getCell(j);
								String cellValue = getCellValue(cell);
								if(StringUtils.isNotBlank(cellValue) && StringUtils.isNotBlank(header.get(j)))
								{
									widgets.put(header.get(j),cellValue);
								}
							}
							dataList.add(widgets);

						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
					
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(workbook !=null)
			{
				try
				{
					workbook.close();
				}
				catch(Exception e)
				{
					   	e.printStackTrace();
				}
			}
		}
			
		return dataList;
		
	}
	
	
	
    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        
        return cell.toString().trim();
        
        /*if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                return HSSFDateUtil.getJavaDate(cell.getNumericCellValue()).toString();
            } else {
                return new BigDecimal(cell.getNumericCellValue()).toString();
            }
        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            return StringUtils.trimToEmpty(cell.getStringCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            return StringUtils.trimToEmpty(cell.getCellFormula());
        } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            return "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
            return "ERROR";
        } else {
            return cell.toString().trim();
        }*/

    }
    
    
    
    
    
    
    
    public void writeExcel(int moduleId, int configId,HttpServletResponse response)
    {
    	JQModuleConfig moduleConfig = getModuleConfigById(moduleId,configId);
    	
    	List<JQColumn> columns = moduleConfig.getJQConfig().getProperties();
    	
    	List<String> header = new ArrayList<>();
    	
    	for(int i=0 ;i<columns.size();i++)
    	{
    		JQColumn col = columns.get(i);
    		
    		List<JQWidget> widgets = col.getWidget();
    		
    		for(int j=0;j<widgets.size();j++)
    		{
    			JQWidget widget = widgets.get(j);
    			header.add(widget.getName());
    		}	
    	}
    	
    	
    	List<JQModuleData> moduleData = loadModuleData(moduleId,configId);//getModuleData(moduleId,configId,0);
    	
    	
    	if(CollectionUtils.isEmpty(moduleData)){
    		return;
		}
    	int columnSize = moduleData.get(0).getJQConfig().getProperties().size();
    	String[][] data = new String[moduleData.size()][columnSize];
    	
    	for(int i=0; i<moduleData.size();i++)
    	{

		    	List<JQColumn> dataColumns = moduleData.get(i).getJQConfig().getProperties(); 
		    	
		     	for(int j=0 ;j<dataColumns.size();j++)
		    	{
		    		JQColumn col = dataColumns.get(j);
		    		
		    		List<JQWidget> widgets = col.getWidget();
		    		
//		    		data[i] = new String[widgets.size()];
//		    		for(int k=0;k<widgets.size();k++)
//		    		{
//		    			JQWidget widget = widgets.get(k);
//		    		}
					data[i][j]= widgets.stream().map(JQWidget::getValue).collect(Collectors.joining(";"));
		    	}   	
    	}
 
 	   	
    
    	Workbook wb = JQUtils.getWorkbook("Sheet1",  header.toArray(new String[header.size()]),data);
        wb.getSheet("Sheet1").createFreezePane(0, 1, 0, 1);
        buildExcelDocument("JQ.xlsx",wb,response);
        buildExcelFile(".\\default.xlsx",wb);
    }



    private static void  buildExcelDocument(String fileName, Workbook wb,HttpServletResponse response){
        try {
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8"));
            response.flushBuffer();
            wb.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void  buildExcelFile(String path, Workbook wb){

        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        try {
            wb.write(new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public JQModuleConfig getModuleService()
    {
    	return findModuleConfigByName("菜单管理","菜单配置");
    }
    
    
    public JQModuleConfig getConfigService()
    {
    	return findModuleConfigByName("模板管理","模板配置");
    }
    
    
    public JQModuleConfig getPropertyService()
    {
    	return findModuleConfigByName("字典管理","字典配置");
    }
    
    public JQModuleConfig getOptionService()
    {
    	return findModuleConfigByName("数据项管理","数据项配置");    	
    }
    
    
    public JQModule toModule(Map<String,String> data)
    {
    
    	JQModuleConfig moduleConfig = getModuleService();
    	
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
 	
    	JQModule module = new JQModule();
    	
    	for(Map.Entry<String,String> entry:data.entrySet()){
    		switch(entry.getKey())
    		{
    			case "{module.name}":
    				module.setName(entry.getValue());
    				break;
    			case "{module.config}":
    				String strConfig = entry.getValue();
    							
    			   	JQConfig config = new JQConfig();
   		
   				config.setName(strConfig);
   	
   				JQModuleConfig mc = new JQModuleConfig();
   		
   				mc.setJQConfig(config);

		   		module.addConfig(mc);
    				break;
    			case "{module.URL}":
    				module.setPath(entry.getValue());
    				break;
     			case "{module.icon}":
    				module.setIcon(entry.getValue());
    				break;   		
     			case "{module.sortKey}":
    				module.setSortKey(entry.getValue());
    				break;
    			case "{module.id}":
    				module.setId(Integer.parseInt(entry.getValue()));
    				break;
    			case "{module.parentId}":
    				module.setParentId(Integer.parseInt(entry.getValue()));
    				break;
    				
    		}
    	
    	}
 	
   	/*String name = data.get("{}");
   	
   	if(name != null)
   	{
   		module.setName(name);
   	}
   	
   	String configName = data.get("模板编号");
   	if(configName != null)
   	{
    			   	JQConfig config = new JQConfig();
   		
   				config.setName(configName);
   	
   				JQModuleConfig moduleConfig = new JQModuleConfig();
   		
   				moduleConfig.setJQConfig(config);

		   		module.addConfig(moduleConfig);
   		
   	}   	
   	String icon = data.get("图标");
   	if(icon != null)
   	{
   		module.setIcon(icon);
   	}   	
   	String sortKey = data.get("排序");
   	if(sortKey != null)
   	{
   		module.setSortKey(sortKey);
   	}   	
   	String url = data.get("URL");
    	if(url != null)
   	{
   		
   	}  	
   	String status = data.get("可用性状态");
    	if(status != null)
   	{
   		module.setStatus(status);
   	}

   	String parentId = data.get("parentId");
    	if(parentId != null)
   	{
   		module.setParentId(Integer.parseInt(parentId));
   	} 
   	else
   	{
   		module.setParentId(0);
   	}  	

   	String id = data.get("id");
    	if(id != null)
   	{
   		module.setId(Integer.parseInt(id));
   	} 
   	else
   	{
   		module.setId(-1);
   	} 
   	*/
   	
   	return module;  	
   	

    
    }
    
    
/*    public JQConfig toConfig(Map<String,String> data)
    {
    
    	JQConfig config = new JQConfig();
    	
    	String name = data.get("name");
    	
    	if(name !=null)
    	{
    		config.setName(name);    	
    	}
    	
        String parentId = data.get("parentId");
    	if(parentId != null)
   	{
   		config.setParentId(Integer.parseInt(parentId));
   	} 
   	else
   	{
   		config.setParentId(0);
   	}  	

   	String id = data.get("id");
    	if(id != null)
   	{
   		config.setId(Integer.parseInt(id));
   	} 
   	else
   	{
   		config.setId(-1);
   	} 
   	
   	return config;
    
    }*/
    
    public List<Integer> findModuleIdByConfigId(int configId)
    {
    	return jqModuleMapper.findModuleIdByConfigId(configId);
    }
    

	public List<Map<String, String>> getModulePermissions(int moduleId) {
		return jqModuleMapper.getModulePermissions(moduleId);
	}
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	


