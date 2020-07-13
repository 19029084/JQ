package com.jq.mapper;


import com.jq.entity.JQUrl;
import com.jq.entity.JQRole;

import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQModuleConfig;

import com.jq.entity.JQUser;
import com.jq.entity.JQPermission;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface JQResourceMapper
{
	JQUser findUserByName(String name);
	
	int createUser(JQUser user);
	
	JQRole findRoleByName(String name);
	
	List<JQRole> findAllRoles();
	
	List<JQRole> findRolesByUserId(int userId);
	
	int createRole(JQRole role);
	
	int assignRole(int userId, int roleId);
	
	List<JQPermission> findAllPermissions();
	
	List<JQPermission> findPermissionsByUserId(int userId);
	
	JQPermission findPermissionByName(String name);
	
	int createPermission(JQPermission permission,int parentId);
	
	int assignPermission(int roleId, int permissonId);
	
	//List<JQProperty> getProperties();
	//int createProperty(JQProperty property);	
	//int updateProperty(JQProperty property);	
	//int deleteProperty(JQProperty property);
	//JQProperty findPropertyByName(String name);
	
	//List<JQProperty> getPropertyByConfig(JQModuleConfig config);

	
		
	//List<JQPropertyOption> getProperyOptions(String pid);
	//int addPropertyOption(String pid,JQPropertyOption option);
	//int updatePropertyOption(String pid,JQPropertyOption option);
	//int deletePropertyOption(String pid,JQPropertyOption option);
	
	List<JQUrl> getUrls();
	
	int createUrl(JQUrl jqUrl);
	
	JQUrl findUrlByName(String name);

}
