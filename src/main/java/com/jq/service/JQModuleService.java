package com.jq.service;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQModuleConfig;



import com.jq.mapper.JQModuleMapper;


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

	public List<JQModule> getModules(String pid)
	{
		return jqModuleMapper.getModules(pid);
	}	


	public List<JQModuleData> getModuleData(String mid)
	{
		return jqModuleMapper.getModuleData(mid);
	}
	
	public List<JQModuleConfig> getModuleConfig(String mid)
	{
		return jqModuleMapper.getModuleConfig(mid);
	}

}
