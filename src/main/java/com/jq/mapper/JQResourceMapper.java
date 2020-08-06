package com.jq.mapper;


import com.jq.entity.*;
import com.jq.vo.JQRoleReq;
import com.jq.vo.JQRoleRes;
import com.jq.vo.JQUserRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface JQResourceMapper
{
	JQUser findUserByName(String name, Integer id);
	
	int createUser(JQUser user);
	
	JQRole findRoleByName(String name, Integer id);
	
	List<JQRoleRes> findAllRoles(String name);
	
	List<JQRole> findRolesByUserId(int userId);
	
	int createRole(JQRole role);

	int createRoleVo(JQRoleReq role);
	
	int assignRole(int userId, int roleId);
	
	List<JQPermission> findAllPermissions();
	
	List<JQPermission> findPermissionsByUserId(int userId);
	
	JQPermission findPermissionByName(String name);

	List<JQPermission> findPermissionByRoleId(int roleId);

	JQPermission findPermissionById(int id);
	
	int createPermission(JQPermission permission,int parentId);

	//int createPermissionM(@Param("permission") JQPermission permission,@Param("parentId") int parentId);
	//	int createPermissionM(@Param("int") int id,@Param("name") String name,@Param("url") String url,@Param("parentId") int parentId);

	int assignPermission(int roleId, int permissionId);
	
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
	
	List<JQUrl> findUrlByName(String name);
	int updateUrl(JQUrl url);

    int deleteRole(int id);

    int deleteRolePermission(int id);

	int updateRole(JQRoleReq role);

	JQRoleRes findRoleById(int id);

	List<JQRolePermission> findRolePermissionByRoleId(int id);

	List<JQUserRes> findUsersBySearch(String userName, String nickName);

	int deleteUser(int id);

	int deleteUserRole(int id);

	JQUser findUserById(int id);

	int updateUser(JQUser user);

	int updateUserPassword(int id, String password);

	int updateUserStatus(int id, Integer status);
}
