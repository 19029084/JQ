package com.jq.controller;

import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;
import com.jq.service.JQPropertyService;


import java.util.List;


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
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.*;

import com.jq.utils.*;

@JQBaseResponse
@RestController
@Api(tags = "Property Management API")
@RequestMapping("/api/v1")
public class JQPropertyController
{

	@Resource
	JQPropertyService m_service;

	@GetMapping("/properties")
	@ApiOperation("获取所有字段信息")
	@ResponseBody
	List<JQProperty> getProperties()
	{
	
		return m_service.getProperties();

	}



	@PostMapping("/properties")
	@ApiOperation("创建新的字段")
	@ResponseBody
	int createProperties(@RequestBody List<JQProperty> properties)
	{
	
		return m_service.createProperties(properties);

	}
	
	
	@PutMapping("/properties")
	@ApiOperation("更新字段内容")
	@ResponseBody
	int updateProperties(@RequestBody List<JQProperty> properties)
	{
	
		return m_service.updateProperties(properties);

	}
	
	
	@DeleteMapping("/properties")
	@ApiOperation("删除字段")
	@ResponseBody
	int deleteProperties(@RequestBody List<JQProperty> properties)
	{
	
		return m_service.deleteProperties(properties);

	}







	@GetMapping("/properties/{propertyId:\\d+}")
	@ApiOperation("获取某字段的选项值")
	@ResponseBody
	List<JQPropertyOption> getPropertyOptions(@PathVariable String propertyId)
	{
	
		return m_service.getPropertyOptions(propertyId);

	}
	
	@PostMapping("/properties/{propertyId:\\d+}")
	@ApiOperation("添加某字段的选项值")
	@ResponseBody
	int addPropertyOptions(@PathVariable String propertyId,
	                       @RequestBody List<JQPropertyOption> propertyOptions)
	{
	
		return m_service.addPropertyOptions(propertyId,propertyOptions);

	}
	
	@PutMapping("/properties/{propertyId:\\d+}")
	@ApiOperation("更新某字段的选项值")
	@ResponseBody
	int updatePropertyOptions(@PathVariable String propertyId,
	                          @RequestBody List<JQPropertyOption> propertyOptions)
	{
	
		return m_service.updatePropertyOptions(propertyId,propertyOptions);

	}
	
	
	@DeleteMapping("/properties/{propertyId:\\d+}")
	@ApiOperation("删除某字段的选项值")
	@ResponseBody
	int deletePropertyOptions(@PathVariable String propertyId, 
	                          @RequestBody List<JQPropertyOption> propertyOptions)
	{
	
		return m_service.deletePropertyOptions(propertyId,propertyOptions);

	}




}

