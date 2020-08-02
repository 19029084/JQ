package com.jq.controller;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQConfig;
import com.jq.entity.JQWidget;
import com.jq.entity.JQColumn;
import com.jq.entity.JQCriteria;

import com.jq.entity.JQProperty;



import com.jq.service.JQModuleService;
import com.jq.service.JQConfigService;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


import javax.annotation.*;

import java.util.List;

import java.util.Map;
import java.util.HashMap;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.jq.entity.JQModuleTable;

import com.jq.utils.*;

import java.util.ArrayList;

import com.jq.entity.JQPropertyValue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import com.jq.api.JQModuleBase;
import com.jq.api.JQConfigBase;


import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

import org.springframework.web.multipart.MultipartFile;

@JQBaseResponse
@RestController
@Api(tags = "菜单管理模块")
@RequestMapping("/api/v2")

class JQModuleController
{

@Resource
JQModuleService m_service;

@Resource
JQConfigService m_config;


@GetMapping("/modules")
@ApiOperation("获取父菜单")
@ResponseBody
public Object getModules()
{
	List<JQModule> modules = m_service.getModules(0);
	
	List< Map<String,String>> result = new ArrayList< Map<String,String> >();
	
	for(int i=0;i<modules.size();i++)
	{
		Map<String,String> output = new HashMap<String,String>();
		
		modules.get(i).toBase(output);		
		
		List<JQModuleConfig> configs = m_service.getModuleConfig(modules.get(i).getId());
		
		if(configs != null && configs.size()>0)
		{
			configs.get(0).toBase(output);
			
			if(output.get("moduleUrl")==null|| "".equals(output.get("moduleUrl")))
			{
				output.put("moduleUrl","/p/"+modules.get(i).getId()+"/"+configs.get(0).getId());
			}
		}
  	
		result.add(output);	
	
	}

	return result;

}

@PostMapping("/modules")
@ApiOperation("创建父菜单")
@ResponseBody
List<Integer> createModules(@RequestBody List<JQModuleBase> modules,@RequestBody(required=false) List<JQConfigBase> configs)
{

	List<Integer> ids = new ArrayList<Integer>();
	for(int i=0;i<modules.size();i++)
	{
		JQModule module = new JQModule(modules.get(i));
		
		int id = m_service.createModule(module,0);
		
		if(configs !=null && configs.size()==modules.size())
		{
			JQModuleConfig moduleConfig= new JQModuleConfig();
		
			moduleConfig.setModuleId(id);
		
			moduleConfig.setConfigId(configs.get(i).getId());
		
			m_service.assignModuleConfig(id,moduleConfig);
		}
		ids.add(id);
	}
	
	return ids;
}


@GetMapping("/modules/{moduleId:\\d+}/submodules")
@ApiOperation("获取子菜单")
@ResponseBody
public Object getModules(@PathVariable int moduleId)
{
	List<JQModule> modules = m_service.getModules(moduleId);
	
	List< Map<String,String>> result = new ArrayList< Map<String,String> >();
	
	for(int i=0;i<modules.size();i++)
	{
		Map<String,String> output = new HashMap<String,String>();
		
		modules.get(i).toBase(output);		
		
		List<JQModuleConfig> configs = m_service.getModuleConfig(modules.get(i).getId());
		
		if(configs != null && configs.size()>0)
		{
			configs.get(0).toBase(output);
		}
  	
		result.add(output);	
	
	}

	return result;

}

@PostMapping("/modules/{moduleId:\\d+}/submodules")
@ApiOperation("创建子菜单")
@ResponseBody
List<Integer> createModules(@PathVariable int moduleId,@RequestBody List<JQModuleBase> modules,@RequestBody(required=false) List<JQConfigBase> configs)
{
	List<Integer> ids = new ArrayList<Integer>(); 
	for(int i=0;i<modules.size();i++)
	{
		JQModule module = new JQModule(modules.get(i));
		
		int id = m_service.createModule(module,moduleId);
		

		if(configs !=null && configs.size()==modules.size())
		{
			JQModuleConfig moduleConfig= new JQModuleConfig();
		
			moduleConfig.setModuleId(id);
		
			moduleConfig.setConfigId(configs.get(i).getId());
		
			m_service.assignModuleConfig(id,moduleConfig);
		}		
		
		ids.add(id);
	}
	
	return ids;
}


@GetMapping("/modules/{moduleId:\\d+}/configs")
@ApiOperation("获取菜单配置")
@ResponseBody
public Object getModuleConfigs(@PathVariable int moduleId)
{
	List< Map<String,String>> result = new ArrayList< Map<String,String> >();

  	List<JQModuleConfig> configs = m_service.getModuleConfig(moduleId);
  	
	for(int i=0;i<configs.size();i++)
	{
		Map<String,String> output = new HashMap<String,String>();
		
		configs.get(i).toBase(output);
		
		result.add(output);
	}

	return configs;

}


@PostMapping("/modules/{moduleId:\\d+}/configs")
@ApiOperation("连接菜单与配置")
@ResponseBody
List<Integer> assignModuleConfigs(@PathVariable int moduleId,@RequestBody List<JQConfigBase> configs)
{
	List<Integer> ids = new ArrayList<Integer>(); 
	
	for(int i=0;i<configs.size();i++)
	{
	
		JQConfig config = new JQConfig(configs.get(i));
		
		m_config.createConfig(config);
		
		JQModuleConfig moduleConfig = new JQModuleConfig();
		
		moduleConfig.setJQConfig(config);
		
		ids.add(m_service.assignModuleConfig(moduleId,moduleConfig));
	}

	
	return ids;
}




@PostMapping("/modules/{moduleId:\\d+}/configs/{configId:\\d+}/insert")
@ApiOperation("根据模块和配置添加表格数据")
@ApiImplicitParams({
	@ApiImplicitParam(name="moduleId",value="Module ID",defaultValue="0",required=true),
	@ApiImplicitParam(name="configId",value="Config ID",defaultValue="0",required=true),
	//@ApiImplicitParam(name="propertyValue",value="多行数据",required=true)
})
@ResponseBody
public Object addModuleData(@PathVariable int moduleId,@PathVariable int configId, @RequestBody  List< Map<String,String> > propertyValue)
{


	JQModuleConfig moduleModuleConfig = m_service.getModuleService();
	JQModuleConfig configModuleConfig = m_service.getConfigService();		
	JQModuleConfig propertyModuleConfig = m_service.getPropertyService();
	JQModuleConfig optionModuleConfig =  m_service.getOptionService();
	
	if(moduleId == moduleModuleConfig.getModuleId() && configId == moduleModuleConfig.getConfigId())
	{	
	
		for(int i=0;i<propertyValue.size();i++)
		{
			 
			 
			Map<String,String> row = propertyValue.get(i);
 			 
 			JQModule module = m_service.toModule(row);
			 	
			List<JQModule> modules = new ArrayList<>();
			 
			modules.add(module);
			 			 
			m_service.createModules(modules,module.getParentId());
			 	
			row.put("rowId",""+module.getId());
			row.put("parentId",""+module.getParentId());
		}
		
	}			

	
	if(moduleId == configModuleConfig.getModuleId() && configId == configModuleConfig.getConfigId())
	{
	
	}
	
	
		
	if(moduleId == propertyModuleConfig.getModuleId() && configId == propertyModuleConfig.getConfigId())
	{
	
	}
	
	
		
	if(moduleId == optionModuleConfig.getModuleId() && configId == optionModuleConfig.getConfigId())
	{
	
	}
	
	

	return m_service.addModuleData(moduleId,configId,propertyValue);
}


@PostMapping("/modules/{moduleId:\\d+}/configs/{configId:\\d+}/query")
@ApiOperation("根据模块和配置检索表格数据")
@ApiImplicitParams({
	@ApiImplicitParam(name="moduleId",value="Module ID",defaultValue="0",required=true),
	@ApiImplicitParam(name="configId",value="Config ID",defaultValue="0",required=true),
	//@ApiImplicitParam(name="criteria",value="检索条件，[{\"name\":\"序号\",\"value\":\"1\"}]",required=false),
	@ApiImplicitParam(name="pageNum",value="Page Number",defaultValue="1",required=true),
	@ApiImplicitParam(name="pageSize",value="Page Size",defaultValue="10",required=true)

})
@ResponseBody

public Object getModuleData(@PathVariable int moduleId,@PathVariable int configId, @RequestBody(required=false) List<JQPropertyValue> criteria,
                            @RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			     @RequestParam(value="pageSize",defaultValue="10") Integer pageSize)
{
	
	
	int nWidget=0;
	
	JQModuleConfig moduleConfig = m_service.findModuleConfigById(moduleId,configId);
	
	if(moduleConfig!=null)
	{
		JQConfig config = moduleConfig.getJQConfig();

		List<JQColumn> columns = config.getProperties();
						
		for(int j=0;j<columns.size();j++)
		{
			List<JQWidget> widgets  = columns.get(j).getWidget();
			
			nWidget+= widgets.size();
		}
	}
	
	List<JQModuleData> data = null;
	
	if(criteria != null && criteria.size()>0)
	{
		//ObjectMapper mapper = new ObjectMapper();
		
		List<Integer> rowIds = null;
			
		try{
			
			List<JQPropertyValue> propertyValues = criteria;//mapper.readValue(query,new TypeReference<List<JQPropertyValue>>(){});
			
			for(int i=0;i<propertyValues.size();i++)
			{
				rowIds = m_service.queryRowIds(moduleId,configId,propertyValues.get(i),rowIds);
				
				if(rowIds==null || rowIds.isEmpty())
				{
		 			break;
		 		}
			}
	
			

		   }
		   catch(Exception e)
		   {
		   
		   	e.printStackTrace();
		   
		   }
		   finally
		   {
		   
		   	PageHelper.startPage(pageNum,pageSize*nWidget);
			
			data = m_service.queryModuleDataByRowIds(moduleId,configId,rowIds);
			
			PageInfo< JQModuleData > pageInfo= new PageInfo<>(data);

		   	return pageInfo;
		   }
	}	
	else
	{
		PageHelper.startPage(pageNum,pageSize*nWidget);
		
		data = m_service.getModuleData(moduleId,configId);
		
		PageInfo< JQModuleData > pageInfo= new PageInfo<>(data);
		
		return pageInfo;
		
	}
	
	

	
	
	
/*	
	//临时解决方案
	
	List< List< List< Map<Integer, List<JQPropertyValue>>> > > result = new ArrayList< List< List< Map<Integer, List<JQPropertyValue>>> > >();
	
	if(data != null)
	{	
		for(int i=0;i<data.size();i++)
		{
			JQModuleData d = data.get(i);
			
			List<JQColumn> columns = d.getJQConfig().getProperties();
		               
			List< List< Map<Integer, List<JQPropertyValue>>> > row = new ArrayList< List< Map<Integer, List<JQPropertyValue>>> >();
		       	
		       result.add(row);        
					
			for(int j=0;j<columns.size();j++)
			{
				
				List<JQWidget> widgets = columns.get(j).getWidget();
					
				List< Map<Integer, List<JQPropertyValue>>> l = new ArrayList<Map<Integer, List<JQPropertyValue>>>();
					
				row.add(l);
					
				for(int m=0;m<widgets.size();m++)
				{
					JQWidget widget = widgets.get(m);
						
					List<JQProperty> properties = widget.getProperties();
						
					Map<Integer, List<JQPropertyValue>> widgetProperties = new HashMap<Integer, List<JQPropertyValue> >();
						
					List<JQPropertyValue> values = new ArrayList<JQPropertyValue>();
						
						
					widgetProperties.put(widget.getId(),values);
						
					l.add(widgetProperties);
						
					for(int n=0;n<properties.size();n++)
					{
						JQPropertyValue pv = properties.get(n).toBase();
							
						values.add(pv);
					}
					
				}
					
			}
			
			
		}
		
	}
*/	

		
	

}



@PostMapping("/modules/{moduleId:\\d+}/configs/{configId:\\d+}/data/{rowId:\\d+}/update")
@ApiOperation("根据模块和配置检索表格数据")
@ApiImplicitParams({
	@ApiImplicitParam(name="moduleId",value="Module ID",defaultValue="0",required=true),
	@ApiImplicitParam(name="configId",value="Config ID",defaultValue="0",required=true),
	//@ApiImplicitParam(name="criteria",value="检索条件，[{\"name\":\"序号\",\"value\":\"1\"}]",required=false),
	@ApiImplicitParam(name="pageNum",value="Page Number",defaultValue="1",required=true),
	@ApiImplicitParam(name="pageSize",value="Page Size",defaultValue="10",required=true)

})
@ResponseBody

public Object updateModuleData(@PathVariable int moduleId,@PathVariable int configId, @PathVariable int rowId,@RequestBody Map<String,String> data,
                            @RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			     @RequestParam(value="pageSize",defaultValue="10") Integer pageSize)
{
	

	return null;
}



@PostMapping("/modules/{moduleId:\\d+}/modify")
@ApiOperation("修改菜单的基本信息")
@ApiImplicitParams({
	@ApiImplicitParam(name="moduleId",value="菜单主键",defaultValue="0",required=true),
	//@ApiImplicitParam(name="base",value="菜单的基本信息",required=true),
	@ApiImplicitParam(name="parentId",value="父菜单主键，用于移动菜单",required=false),
})
@ResponseBody
int updateModules(@PathVariable int moduleId,@RequestBody JQModuleBase base, @RequestParam(required=false,defaultValue="-1") int parentId)
{
	//List<JQModule> modules = new ArrayList<JQModule>();
	
	System.out.println("*****"+base);
	
	JQModule module = m_service.findModuleById(moduleId);
	
	if(base.getName()!=null)
	{
		module.setName(base.getName());
	}

	if(base.getIcon()!=null)
	{
		module.setIcon(base.getIcon());
	}
	
	if(base.getUrl()!=null)
	{
		module.setPath(base.getUrl());
	}
	
	if(base.getSortKey()!=null)
	{
		module.setSortKey(base.getSortKey());
	}
	
	if(base.getStatus()!=null)
	{
		module.setStatus(base.getStatus());
	}
	
	if(parentId >0 && parentId!=module.getParentId())
	{
		module.setParentId(parentId);
	}

	m_service.updateModule(module);
	
	return 0;

}


@DeleteMapping("/modules/{moduleId:\\d+}")
@ApiOperation("删除菜单")
@ResponseBody
int deleteModules(@PathVariable int moduleId)
{
	return m_service.deleteModule(moduleId);
}


@GetMapping("/modules/{moduleId:\\d+}/configs/{configId:\\d+}/data/export")
@ApiOperation("导出数据")
@ResponseBody
public void exportData(@PathVariable int moduleId,@PathVariable int configId,HttpServletResponse response) throws ParseException
{

        m_service.writeExcel(moduleId,configId,response);

}

@PostMapping("/modules/{moduleId:\\d+}/configs/{configId:\\d+}/data/import")
@ApiOperation("导入数据")
@ResponseBody
public void importData(@PathVariable int moduleId,@PathVariable int configId,MultipartFile file) throws ParseException
{
	//List< List<JQWidget> > data = m_service.readExcel(file);
	
	//m_service.addModuleData(moduleId,configId,data,0);	
	
}


@DeleteMapping("/modules/{moduleId:\\d+}/configs/{configId:\\d+}/data/{rowId:\\d+}/delete")
@ApiOperation("根据ID删除数据")
@ResponseBody
public void deleteModules(@PathVariable int moduleId,@PathVariable int configId,@PathVariable int rowId)
{
	m_service.deleteModuleData(moduleId,configId,rowId);
	
	
}

/*

@GetMapping("/modules")
@ApiOperation("Get All Modules Information")
@ResponseBody
public Object getModules()
{
	//PageHelper.startPage(pageNum,pageSize);
	List<JQModule> modules = m_service.getModules("0");
	for(int i=0;i<modules.size();i++)
	{
		List<JQModule> subModules =  m_service.getModules(String.valueOf(modules.get(i).getId()));
		
		modules.get(i).setChildren(subModules);
	
	}
	
	
	//PageInfo<JQModule> pageInfo= new PageInfo<>(modules);

 return modules;

}


@PostMapping("/modules")
@ApiOperation("Create Modules")
@ResponseBody
int createModules(@RequestBody List<String> modules)
{
	return m_service.createModules(modules,"0");
}

@PutMapping("/modules")
@ApiOperation("Update Modules' name and path")
@ResponseBody
int updateModules(@RequestBody List<JQModule> modules)
{
	return m_service.updateModules(modules,"0");

}

@DeleteMapping("/modules")
@ApiOperation("Delete Modules")
@ResponseBody
int deleteModules(@RequestBody List<JQModule> modules)
{
	return m_service.deleteModules(modules,"0");
}



@GetMapping("/modules/{pid:\\d+}")
@ApiOperation("Get Submodule Information by Parent ID")
@ApiImplicitParam(name="pid",value="Parent ID",defaultValue="0",required=true)
@ResponseBody
List<JQModule> getSubModules(@PathVariable String pid)
{

 return m_service.getModules(pid);

}



@PostMapping("/modules/{pid:\\d+}")
@ApiOperation("Create Submodule by Parent ID")
@ResponseBody
int createModules(@RequestBody List<JQModule> modules,
                  @PathVariable String pid)
{
	return m_service.createModules(modules,pid);
}


@PutMapping("/modules/{pid:\\d+}")
@ApiOperation("Update Modules' name and path")
@ResponseBody
int updateModules(@RequestBody List<JQModule> modules,
                  @PathVariable String pid)
{
	return m_service.updateModules(modules,pid);

}







@GetMapping("/modules/{mid:\\d+}/config")
@ApiOperation("Get Module Configuration by Module ID")
//@ApiImplicitParams({...})
@ApiImplicitParam(name="mid",value="Module ID",defaultValue="0",required=true)
@ResponseBody
List<JQModuleConfig> getModuleConfig(@PathVariable String mid)
{

 return m_service.getModuleConfig(mid);

}


@PostMapping("/modules/{mid:\\d+}/config")
@ApiOperation("根据子模块号添加表格配置")
//@ApiImplicitParams({...})
@ApiImplicitParam(name="mid",value="Module ID",defaultValue="0",required=true)
@ResponseBody
int addModuleConfig(@PathVariable String mid,
                    @RequestBody List<JQConfig> configs)
{
	List<JQModuleConfig> moduleConfigs = new ArrayList<JQModuleConfig>();
	for(int i=0;i<configs.size();i++)
	{
		moduleConfigs.add(new JQModuleConfig(configs.get(i)));
	}

 	return m_service.addModuleConfig(mid,moduleConfigs);

}


@DeleteMapping("/modules/{mid:\\d+}/config")
@ApiOperation("根据子模块号删除表格配置")
//@ApiImplicitParams({...})
@ApiImplicitParam(name="mid",value="Module ID",defaultValue="0",required=true)
@ResponseBody
int deleteModuleConfig(@PathVariable String mid,
                       @RequestBody List<JQModuleConfig> configs)
{

 return m_service.deleteModuleConfig(mid,configs);

}

*/







//@PostMapping("/Query/ModuleData")
//@ApiOperation("Query Module Data by Module Config")
//@ApiImplicitParam(name="mid",value="Module ID",defaultValue="0",required=true)
//@ResponseBody

//public Object queryModuleData(@RequestBody JQModuleConfig moduleConfig,
//                            @RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
//			     @RequestParam(value="pageSize",defaultValue="10") Integer pageSize)
//{
//	int nWidget=0;
	

//	JQConfig config = moduleConfig.getJQConfig();

//	List<JQColumn> columns = config.getProperties();
						
//	for(int j=0;j<columns.size();j++)
//	{
//		List<JQWidget> widgets  = columns.get(j).getWidget();
			
//		nWidget+= widgets.size();
//	}

//	PageHelper.startPage(pageNum,pageSize*nWidget);
	
//	List<JQModuleData> data = m_service.queryModuleData(moduleConfig);
	
//	PageInfo<JQModuleData> pageInfo= new PageInfo<>(data);
	
//	return pageInfo;
	

//}


//@PostMapping("/modules/{mid:\\d+}/data")
//@ApiOperation("根据子模块号添加表格数据")
//@ApiImplicitParam(name="mid",value="Module ID",defaultValue="0",required=true)
//@ResponseBody
//int addModuleData(@PathVariable String mid,
//                  @RequestBody List<JQModuleData> moduleData)
//{

// return m_service.addModuleData(mid,moduleData);

//}
/*
@PutMapping("/modules/{mid:\\d+}/data")
@ApiOperation("根据子模块号修改表格数据")
@ApiImplicitParam(name="mid",value="Module ID",defaultValue="0",required=true)
@ResponseBody
int updateModuleData(@PathVariable String mid,
                     @RequestBody List<JQModuleData> moduleData)
{

 return m_service.updateModuleData(mid,moduleData);

}

@DeleteMapping("/modules/{mid:\\d+}/data")
@ApiOperation("根据子模块号删除表格数据")
@ApiImplicitParam(name="mid",value="Module ID",defaultValue="0",required=true)
@ResponseBody
int deleteModuleData(@PathVariable String mid,
                     @RequestBody List<JQModuleData> moduleData)
{

 return m_service.deleteModuleData(mid,moduleData);

}
*/









}

