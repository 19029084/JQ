package com.jq.service;

import com.jq.entity.JQModule;
import com.jq.mapper.JQModuleMapper;
import com.jq.dao.IJQModuleDAO;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

@Service
public class JQModuleService
{
	//@Resource
	//IJQModuleDAO moduleDAO;

	@Autowired
	JQModuleMapper jqModuleMapper;

	public List<JQModule> getModules()
	{
		return jqModuleMapper.getModules();
	}	

}
