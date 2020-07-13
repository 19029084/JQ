package com.jq.controller;


//import com.jq.service.JQUserService;


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

import javax.annotation.*;

import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Value;


import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import java.util.Map;

import com.jq.utils.*;


import com.jq.service.*;

import java.util.List;
import com.jq.entity.JQUser;
import com.jq.entity.JQRole;

import com.jq.entity.JQPermission;

@JQBaseResponse
@RestController
@Api(tags = "User Management API")
@RequestMapping("/api/v1")

class JQUserController
{
//@Resource
//JQUserService m_service;

@Resource 
JQResourceService m_resourceService;

	@Value("${server.port}")
	private String port;

@GetMapping(value="/login")
public Object login(@RequestParam("username") String username,
		    @RequestParam("password") String password)
{

	OAuth2AccessToken token = null;
	MultiValueMap<String,Object> paramsMap=new LinkedMultiValueMap<>();
        paramsMap.set("username",username);
        paramsMap.set("password",password);
        paramsMap.set("grant_type","password");
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("webapp","JQApp"));
        token=restTemplate.postForObject("http://localhost:"+port+"/oauth/token",paramsMap,OAuth2AccessToken.class);

        return token;
}


@PostMapping(value="/logout")
public Object logout()
{

	//OAuth2AccessToken token = null;
	//MultiValueMap<String,Object> paramsMap=new LinkedMultiValueMap<>();
        //paramsMap.set("username",username);
        //paramsMap.set("password",password);
        //paramsMap.set("grant_type","password");
        //RestTemplate restTemplate=new RestTemplate();
        //restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("webapp","JQApp"));
        //token=restTemplate.postForObject("http://localhost:"+port+"/oauth/token",paramsMap,OAuth2AccessToken.class);

        return 0;
}

@PostMapping(value="/user")
public Object createUser(@RequestBody List<JQUser> users)
{
	
	return m_resourceService.createUser(users);
}

@GetMapping(value="/url")
public Object getUrls()
{

	return m_resourceService.getUrls();
}


@GetMapping(value="/role")
public Object getRoles()
{
	return m_resourceService.getRoles();
}


@PostMapping(value="/role")
public Object createRole(@RequestBody List<JQRole> roles)
{

	return m_resourceService.createRole(roles);
}


@PostMapping(value="/{uid:\\d+}/role")
public Object assignRole(@PathVariable int uid,
		         @RequestBody List<JQRole> roles)
{

	return m_resourceService.assignRole(uid,roles);
}


@GetMapping(value="/permission")
public Object getPermissions()
{
	return m_resourceService.getPermissions();
}


@PostMapping(value="/permission")
public Object createPermission(@RequestBody List<JQPermission> permissions)
{

	return m_resourceService.createPermission(permissions,0);
}


@PostMapping(value="/permission/{parentId:\\d+}")
public Object createPermission(@RequestBody List<JQPermission> permissions,
				@PathVariable int parentId)
{

	return m_resourceService.createPermission(permissions,parentId);
}

@PostMapping(value="/role/{roleId:\\d+}/permission")
public Object assignPermission(@PathVariable int roleId,
		         @RequestBody List<JQPermission> permissions)
{

	return m_resourceService.assignPermission(roleId,permissions);
}


}
