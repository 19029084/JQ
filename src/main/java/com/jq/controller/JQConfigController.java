package com.jq.controller;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQConfig;


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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.jq.entity.JQModuleTable;

import com.jq.utils.*;


@JQBaseResponse
@RestController
@Api(tags = "Config ")
@RequestMapping("/api/v1")

class JQConfigController
{

@Resource
JQConfigService m_service;

@GetMapping("/configs")
@ApiOperation("Get All Configs Information")
@ResponseBody
public Object getConfigs()
{

	List<JQConfig> configs = m_service.getConfigs();
	
	return configs;
}


@PostMapping("/configs")
@ApiOperation("Create Configs")
@ResponseBody
int createConfigs(@RequestBody List<JQConfig> configs)
{
	return m_service.createConfigs(configs);
}


@GetMapping("/configs/{cid:\\d+}")
@ApiOperation("Get one config Information")
@ResponseBody
public Object getConfig(@PathVariable String cid)
{
	
	JQConfig config = m_service.loadConfig(cid);
	
	return config;
}



/*
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

@DeleteMapping("/modules/{pid:\\d+}")
@ApiOperation("根据模块号删除其部分子模块")
@ResponseBody
int deleteModules(@RequestBody List<JQModule> modules,
                  @PathVariable String pid)
{
	return m_service.deleteModules(modules,pid);
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
                    @RequestBody List<JQModuleConfig> configs)
{

 return m_service.addModuleConfig(mid,configs);

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

@GetMapping("/modules/{mid:\\d+}/data")
@ApiOperation("Get Module Data by Module ID")
@ApiImplicitParam(name="mid",value="Module ID",defaultValue="0",required=true)
@ResponseBody

public Object getModuleData(@PathVariable String mid,
                            @RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			     @RequestParam(value="pageSize",defaultValue="10") Integer pageSize)
{
	
	List<JQModuleTable> data = m_service.getModuleData(mid,pageNum,pageSize);

	return data;
	

}

@PostMapping("/modules/{mid:\\d+}/data")
@ApiOperation("根据子模块号添加表格数据")
@ApiImplicitParam(name="mid",value="Module ID",defaultValue="0",required=true)
@ResponseBody
int addModuleData(@PathVariable String mid,
                  @RequestBody List<JQModuleData> moduleData)
{

 return m_service.addModuleData(mid,moduleData);

}

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

