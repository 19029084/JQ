package com.jq.service;

import com.jq.entity.JQModule;

import java.util.List;
import javax.annotation.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;


@Service
public class JQAdminService{

@Resource 
JQModuleService moduleService;


	public void Initialize()
	{
		com.jq.utils.JQUtils utils = new com.jq.utils.JQUtils();
		try{
		
			System.out.println("Begin");
			
			utils.LoadData();
			
			List<JQModule> modules = utils.getModules();
			
			moduleService.createModules(modules,"0");
	
			System.out.println("END");
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
		
		
		
}
