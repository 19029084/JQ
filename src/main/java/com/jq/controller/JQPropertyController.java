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

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.jq.api.JQPropertyBase;
import com.jq.api.JQPropertyOptionBase;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



@JQBaseResponse
@RestController
@Api(tags = "字典管理模块")
@RequestMapping("/api/v2")
public class JQPropertyController
{

	@Resource
	JQPropertyService m_service;

	@GetMapping("/properties")
	@ApiOperation("获取所有字段信息")
	@ResponseBody
	Object getProperties( @RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			       @RequestParam(value="pageSize",defaultValue="10") Integer pageSize)
	{
	
		PageHelper.startPage(pageNum,pageSize);
		
		List<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>>();
		
		List<JQProperty> properties= m_service.loadProperties();
		
		for(int i=0;i<properties.size();i++)
		{
			HashMap<String, Object> output = new HashMap<String,Object>();
		
			JQProperty property = properties.get(i);
			
			m_service.loadPropertyOptions(property);
						
			property.toBase(output,true);
			
			result.add(output);
		
		}
		
		PageInfo< HashMap<String,Object> > pageInfo= new PageInfo<>(result);
		
		return pageInfo;
	}



	@PostMapping("/properties")
	@ApiOperation("创建新的字段")
	@ResponseBody
	Object createProperties(@RequestBody List<JQPropertyBase> properties)
	{
		List<Integer> ids =new ArrayList<Integer>();
		for(int i=0;i<properties.size();i++)
		{
			JQProperty property = new JQProperty(properties.get(i));
		
			ids.add(m_service.createProperty(property));
		
		}
		
		return ids;
	}
	
	
	@PutMapping("/properties")
	@ApiOperation("更新字段内容")
	@ResponseBody
	int updateProperties(@RequestBody List<JQProperty> properties)
	{
	
		return m_service.updateProperties(properties);

	}
	
	
	@DeleteMapping("/properties/{propertyId:\\d+}")
	@ApiOperation("删除字典")
	@ResponseBody
	public void deleteProperties(@PathVariable int propertyId)
	{
	
		m_service.deleteProperty(propertyId);

	}







	@GetMapping("/properties/{propertyId:\\d+}")
	@ApiOperation("获取某字段的选项值")
	@ResponseBody
	List<JQPropertyOption> getPropertyOptions(@PathVariable int propertyId)
	{

		return m_service.getPropertyOptions(propertyId);

	}
	
	@PostMapping("/properties/{propertyId:\\d+}")
	@ApiOperation("添加某字段的选项值")
	@ResponseBody
	int addPropertyOptions(@PathVariable int propertyId,
	                       @RequestBody List<JQPropertyOption> propertyOptions)
	{
	
		return m_service.assignPropertyOptions(propertyId,propertyOptions);

	}
	
	@PutMapping("/properties/{propertyId:\\d+}/options/{optionId:\\d+}")
	@ApiOperation("更新某字段的选项值")
	@ResponseBody
	int updatePropertyOptions(@PathVariable int propertyId,@PathVariable int optionId,
	                          @RequestBody List<JQPropertyOption> propertyOptions)
	{
		
		
		return m_service.updatePropertyOptions(propertyId,propertyOptions);

	}
	
	
	@DeleteMapping("/properties/{propertyId:\\d+}/options")
	@ApiOperation("删除某字段的选项值")
	@ResponseBody
	Object deletePropertyOptions(@PathVariable int propertyId, 
	                          @RequestBody List<Integer> ids)
	{
	
		m_service.deletePropertyOptionByIds(propertyId,ids);
		
		return 0;

	}

}

