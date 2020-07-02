package com.jq.service;

import com.jq.entity.JQModule;

import java.util.List;
import javax.annotation.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;


import com.jq.entity.JQUrl;
import com.jq.entity.JQRole;



import com.jq.mapper.JQResourceMapper;


@Service
public class JQResourceService{

    @Autowired
    private JQResourceMapper jqResourceMapper;
		
    public List<JQUrl> getUrls()
    {
    	return jqResourceMapper.getUrls();
	
    }
    
    public int createUrl(JQUrl jqUrl)   
    {
    
    	int id = jqResourceMapper.createUrl(jqUrl);
    	
    	JQUrl url = findUrlByName(jqUrl.getUrl());
    	
    	return url.getId();
    }
    
    protected JQUrl findUrlByName(String name)
    {
    	return jqResourceMapper.findUrlByName(name);
    }
    
    
    public List<JQRole> getRoles()
    {
    	return jqResourceMapper.getRoles();
	
    }
    
			
		
}
