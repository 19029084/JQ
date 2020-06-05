package com.jq.controller;

import com.jq.entity.JQModule;
//import com.jq.entity.JQUser;

import com.jq.service.JQModuleService;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;




import javax.annotation.*;

import java.util.List;

@RestController

class JQModuleController
{

@Resource
JQModuleService m_service;

@RequestMapping("/api/v1/modules")
@ResponseBody
List<JQModule> getModules()
{

 return m_service.getModules();

}


}

