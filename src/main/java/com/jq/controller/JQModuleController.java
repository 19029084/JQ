package com.jq.controller;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQModuleData;


import com.jq.service.JQModuleService;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;




import javax.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

class JQModuleController
{

@Resource
JQModuleService m_service;

@GetMapping("/modules")
@ResponseBody
List<JQModule> getModules()
{

 return m_service.getModules("0");

}

@GetMapping("/modules/{pid:\\d+}")
@ResponseBody
List<JQModule> getSubModules(@PathVariable String pid)
{

 return m_service.getModules(pid);

}

@GetMapping("/modules/{mid:\\d+}/config")
@ResponseBody
List<JQModuleConfig> getModuleConfig(@PathVariable String mid)
{

 return m_service.getModuleConfig(mid);

}

@GetMapping("/modules/{mid:\\d+}/data")
@ResponseBody
List<JQModuleData> getModuleData(@PathVariable String mid)
{

 return m_service.getModuleData(mid);

}











}

