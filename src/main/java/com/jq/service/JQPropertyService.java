package com.jq.service;

import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;

import java.util.List;

import com.jq.mapper.JQPropertyMapper;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

@Service
public class JQPropertyService
{
	@Autowired 
	JQPropertyMapper jqPropertyMapper;

	public List<JQProperty> getProperties()
	{
		List<JQProperty> properties = jqPropertyMapper.getProperties();
		
		
		return properties;
		
	}


}
