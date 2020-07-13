package com.jq.service;

import com.jq.entity.JQModule;

import java.util.List;
import javax.annotation.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;


import com.jq.entity.JQUrl;
import com.jq.entity.JQRole;

import com.jq.entity.JQPermission;

import com.jq.entity.JQUser;

import org.springframework.security.crypto.password.PasswordEncoder;



import com.jq.mapper.JQResourceMapper;


@Service
public class JQResourceService{

    @Autowired
    private JQResourceMapper jqResourceMapper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
		
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
    	return jqResourceMapper.findAllRoles();
	
    }
    
    public int createUser(List<JQUser> users)
    {
    	for(int i=0;i<users.size();i++)
    	{
    		JQUser user  = users.get(i);
    		
    		JQUser existUser = jqResourceMapper.findUserByName(user.getUsername());
    		
    		if(existUser == null)
    		{
    		
    			user.setPassword(passwordEncoder.encode(user.getPassword()));
    		
    			jqResourceMapper.createUser(user);
    		}
    		else
    		{
    			user.setId(existUser.getId());
    		}
    		
    		System.out.println("user---: "+user.getId());
    		
    		if(user.getRoles()!=null)
    		{
    			List<JQRole> roles = user.getRoles();
    			createRole(roles);
    			assignRole(user.getId(),roles);
    		}
    		
    	}
    	
    	return 0;
    
    
    }
    
    
    
    
    public int createRole(List<JQRole> roles)
    {
    	for(int i=0;i<roles.size();i++)
    	{
    		JQRole role  = roles.get(i);
    		
    		JQRole existRole = jqResourceMapper.findRoleByName(role.getName());
    		
    		if(existRole == null)
    		{
    			jqResourceMapper.createRole(role);
    		}
    		else
    		{
    			role.setId(existRole.getId());
    		}
    		
    		System.out.println("role---: "+role.getId());
    		
    		List<JQPermission> permissions = role.getPermissions();
    		
    		
    		if(permissions != null)
    		{
    		
    			createPermission(permissions,0);
    		
    		}
    		
    	}
    	
    	return 0;
    
    
    }
    
    public int assignRole(int userId, List<JQRole> roles)
    {
    	createRole(roles);
    	
    	for(int i=0;i<roles.size();i++)
    	{
    		jqResourceMapper.assignRole(userId,roles.get(i).getId());
    	}
    	return 0;
    
    }
    
     public List<JQPermission> getPermissions()
    {
	return jqResourceMapper.findAllPermissions();
    
    }   
    
    public int createPermission(List<JQPermission> permissions, int parentId)
    {
    	for(int i=0;i<permissions.size();i++)
    	{
    		JQPermission permission = permissions.get(i);
    		
    		JQPermission existPermission = jqResourceMapper.findPermissionByName(permission.getName());
    		
    		if(existPermission == null)
    		{
    			jqResourceMapper.createPermission(permission,parentId);
    		}
    		else
    		{
    			permission.setId(existPermission.getId());
    		}
    		
    	
    	}
    	
    	return 0;
    
    }
    
    
    public int assignPermission(int roleId, List<JQPermission> permissions)
    {

    	for(int i=0;i<permissions.size();i++)
    	{
    		jqResourceMapper.assignPermission(roleId,permissions.get(i).getId());
    	}
    	return 0;
    
    }
			
		
}
