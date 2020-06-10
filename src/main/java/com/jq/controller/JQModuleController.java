package com.jq.controller;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQModuleData;


import com.jq.service.JQModuleService;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


import javax.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Module Management API")
@RequestMapping("/api/v1")

class JQModuleController
{

@Resource
JQModuleService m_service;

@GetMapping("/modules")
@ApiOperation("Get All Modules Information")
@ResponseBody
List<JQModule> getModules()
{

 return m_service.getModules("0");

}


@PostMapping("/modules")
@ApiOperation("Create Modules")
@ResponseBody
int createModules(@RequestBody List<JQModule> modules)
{
	return m_service.createModules(modules,"0");
}

@DeleteMapping("/modules")
int deleteModules(@RequestBody List<JQModule> modules)
{
return 0;
}

@PutMapping("/modules")
int updateModules(@RequestBody List<JQModule> modules)
{
return 0;

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
int createModules(@RequestBody List<JQModule> modules,@PathVariable String pid)
{
	return m_service.createModules(modules,pid);
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

@GetMapping("/modules/{mid:\\d+}/data")
@ApiOperation("Get Module Data by Module ID")
@ApiImplicitParam(name="mid",value="Module ID",defaultValue="0",required=true)
@ResponseBody
List<JQModuleData> getModuleData(@PathVariable String mid)
{

 return m_service.getModuleData(mid);

}











}

