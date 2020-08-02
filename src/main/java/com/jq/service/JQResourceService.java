package com.jq.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jq.entity.*;
import com.jq.mapper.JQResourceMapper;
import com.jq.utils.JQBaseException;
import com.jq.utils.JQResponseCode;
import com.jq.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Transactional(rollbackFor = Exception.class)
public class JQResourceService{

    @Autowired
    private JQResourceMapper jqResourceMapper;

    @Autowired
    private JQDepartmentService departmentService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
		
    public List<JQUrl> getUrls()
    {
    	return jqResourceMapper.getUrls();
	
    }
    
    public int createUrl(JQUrl jqUrl)   
    {
	JQUrl url = findUrlByName(jqUrl.getName());
	
	if(url == null)
	{		
    		int id = jqResourceMapper.createUrl(jqUrl);    		
    		return jqUrl.getId();
    	}
    	else 
    	{
    		jqUrl.setId(jqUrl.getId());
    		
	    	return url.getId();
    	}
    }
    public int updateUrl(JQUrl jqUrl)
    {
    
    	jqResourceMapper.updateUrl(jqUrl);
    	
    	return 0;
    
    }
    protected JQUrl findUrlByName(String name)
    {
    	return jqResourceMapper.findUrlByName(name);
    }
    
    
    public PageInfo< JQRoleRes > getRoles(String roleName, Integer current, Integer pageSize)
    {
    	return PageHelper.startPage(current,pageSize).doSelectPageInfo(() -> jqResourceMapper.findAllRoles(roleName));
    }
    
    public boolean createUser(JQUser user)
    {
		validUserNameExist(user);
		user.setPassword(StringUtils.isNotBlank(user.getPassword()) ? passwordEncoder.encode(user.getPassword()) : passwordEncoder.encode("123456"));
		user.setStatus(user.getStatus() == null ? 1 : user.getStatus());
		int createNum = jqResourceMapper.createUser(user);
		if(createNum > 0){
			if(!CollectionUtils.isEmpty(user.getRoleIds())){
				user.getRoleIds().forEach(roleId ->{
					jqResourceMapper.assignRole(user.getId(),roleId);
				});
			}
		}
    	return true;
    }

	private void validUserNameExist(JQUser user) {
		JQUser existUser = jqResourceMapper.findUserByName(user.getUsername(), user.getId());
		if(existUser != null){
			throw new JQBaseException(JQResponseCode.NAME_DUPLICATE);
		}
	}


	public int createRole(List<JQRole> roles)
    {
    	for(int i=0;i<roles.size();i++)
    	{
    		JQRole role  = roles.get(i);

    		JQRole existRole = jqResourceMapper.findRoleByName(role.getName(), role.getId());

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


	public boolean createRoleVo(JQRoleReq role)
	{
		//验证名称重复
		validateNameExist(role);
		jqResourceMapper.createRoleVo(role);
		if(!CollectionUtils.isEmpty(role.getPermissionIds())){
			role.getPermissionIds().forEach(permissionId -> {
				jqResourceMapper.assignPermission(role.getId(), permissionId);
			});
		}
		return true;
	}

	private void validateNameExist(JQRoleReq role) {
		JQRole existRole = jqResourceMapper.findRoleByName(role.getName(), role.getId());
		if(existRole != null){
			throw new JQBaseException(JQResponseCode.NAME_DUPLICATE);
		}
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

    public JQPermission findPermissionById(int id){
		return jqResourceMapper.findPermissionById(id);
	}

	public JQPermission findPermissionByName(String name){
		return jqResourceMapper.findPermissionByName(name);
	}
    
     public List<JQPermission> getPermissions()
    {
	return jqResourceMapper.findAllPermissions();
    
    }

	public List<JQPermissionTreeVo> getPermissionTree()
	{
		List<JQPermissionTreeVo> result = new ArrayList<>();
		//获取所有权限
		List<JQPermission> permissions = jqResourceMapper.findAllPermissions();
		//封装
		if(CollectionUtils.isEmpty(permissions)){
			return result;
		}
		List<JQPermission> roots = permissions.stream().filter(jqPermission -> 0 == jqPermission.getParentid()).collect(Collectors.toList());
		if(CollectionUtils.isEmpty(roots)){
			return result;
		}
		List<JQPermissionTreeVo> treeVos = new ArrayList<>(roots.size());
		transferToTreeVo(roots, permissions, treeVos);
		return treeVos;
	}



	private void transferToTreeVo(List<JQPermission> roots, List<JQPermission> permissions, List<JQPermissionTreeVo> treeVos) {
		roots.forEach(jqPermission -> {
			JQPermissionTreeVo treeVo = new JQPermissionTreeVo();
			BeanUtils.copyProperties(jqPermission, treeVo);
			//children
			List<JQPermission> childrens = permissions.stream().filter(permission -> jqPermission.getId() == permission.getParentid()).collect(Collectors.toList());
			if(!CollectionUtils.isEmpty(childrens)){
				List<JQPermissionTreeVo> childrenTrees = new ArrayList<>(childrens.size());
				transferToTreeVo(childrens, permissions, childrenTrees);
				treeVo.setChildren(childrenTrees);
			}else{
				treeVo.setChildren(new ArrayList<>());
			}
			treeVos.add(treeVo);
		});
	}

	public int createPermission(List<JQPermission> permissions, int parentId)
    {
    	for(int i=0;i<permissions.size();i++)
    	{
    		JQPermission permission = permissions.get(i);
    		
    		JQPermission existPermission = jqResourceMapper.findPermissionByName(permission.getName());
    		
    		if(existPermission == null)
    		{
				String urlId = null;

				if(permission.getUrl() != null)
				{
					urlId = String.valueOf(createUrl(new JQUrl(permission.getUrl())));
				}
				permission.setUrl(urlId);
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

    public int createPerssion (JQPermission JQPermission ,int parentId ){
		return jqResourceMapper.createPermission(JQPermission,parentId);

	}


    public boolean deleteRole(int id) {
        int delete = jqResourceMapper.deleteRole(id);
        if(delete > 0){
            jqResourceMapper.deleteRolePermission(id);
        }
        return true;
    }

	public boolean updateJRole(JQRoleReq role) {
    	//验证名称重复
		validateNameExist(role);
		jqResourceMapper.updateRole(role);
		//sys_role_permission
		jqResourceMapper.deleteRolePermission(role.getId());
		if(!CollectionUtils.isEmpty(role.getPermissionIds())){
			role.getPermissionIds().forEach(permissionId -> {
				jqResourceMapper.assignPermission(role.getId(), permissionId);
			});
		}
		return true;
	}

	public JQRoleRes updateInit(int id) {
		JQRoleRes result = jqResourceMapper.findRoleById(id);
		//role_permission
		List<JQRolePermission> rolePermissionList = jqResourceMapper.findRolePermissionByRoleId(id);
		if(!CollectionUtils.isEmpty(rolePermissionList)){
			List<Integer> permissionIds = rolePermissionList.stream().map(JQRolePermission::getPermissionId).collect(Collectors.toList());
			result.setPermissionIds(permissionIds);
		}
		return result;
	}

	public PageInfo<JQUserRes> getUser(String userName, String nickName, Integer current, Integer pageSize) {
		PageInfo<JQUserRes> pageInfo = PageHelper.startPage(current, pageSize).doSelectPageInfo(() -> jqResourceMapper.findUsersBySearch(userName, nickName));
		if(!CollectionUtils.isEmpty(pageInfo.getList())){
			//user_role
			pageInfo.getList().forEach(jqUserRes -> {
				List<JQRole> roleList = jqResourceMapper.findRolesByUserId(jqUserRes.getId());
				if(CollectionUtils.isEmpty(roleList)){
					jqUserRes.setRoleNumber(0);
					jqUserRes.setRoleNames("");
				}else{
					jqUserRes.setRoleNumber(roleList.size());
					jqUserRes.setRoleNames(roleList.stream().map(JQRole::getName).collect(Collectors.joining(";")));
				}
			});
		}
		return pageInfo;
	}

	public boolean deleteUser(int id) {
		int delete = jqResourceMapper.deleteUser(id);
		if(delete > 0){
			jqResourceMapper.deleteUserRole(id);
		}
		return true;
	}

	public boolean updateUser(JQUser user) {
		//验证名称重复
		validUserNameExist(user);
		user.setStatus(user.getStatus() == null ? 1 : user.getStatus());
		jqResourceMapper.updateUser(user);
		//sys_role_permission
		jqResourceMapper.deleteUserRole(user.getId());
		if(!CollectionUtils.isEmpty(user.getRoleIds())){
			user.getRoleIds().forEach(roleId -> {
				jqResourceMapper.assignRole(user.getId(), roleId);
			});
		}
		return true;
	}

	public Map<String, Object> updateInitUser(int id) {
		Map<String, Object> result = new HashMap<>();
		JQUser user = jqResourceMapper.findUserById(id);
		if(user != null){
			//user_role
			List<JQRole> roleList = jqResourceMapper.findRolesByUserId(id);
			if(CollectionUtils.isEmpty(roleList)){
				user.setRoleIds(new ArrayList<>());
			}else{
				user.setRoleIds(roleList.stream().map(JQRole::getId).collect(Collectors.toList()));
			}
		}
		result.put("detail", user);
		result.put("departmentList", departmentService.selectJQDepartmentList(null,"0"));
		//角色权限列表
		result.put("permissionList", getRolePermissions());
		return result;
	}

	public List<JQRolePermissionsRes> getRolePermissions(){
		List<JQRolePermissionsRes> result = new ArrayList<>();
		//所有角色
		List<JQRoleRes> roleResList = jqResourceMapper.findAllRoles(null);
		if(CollectionUtils.isEmpty(roleResList)){
			return result;
		}
		roleResList.forEach(jqRoleRes -> {
			JQRolePermissionsRes rolePermissionsRes = new JQRolePermissionsRes();
			rolePermissionsRes.setRoleId(jqRoleRes.getId());
			rolePermissionsRes.setRoleName(jqRoleRes.getName());
			//获取角色权限
			List<JQPermission> permissions = jqResourceMapper.findPermissionByRoleId(jqRoleRes.getId());
			if(!CollectionUtils.isEmpty(permissions)){
				List<JQPermission> roots = permissions.stream().filter(jqPermission -> 0 == jqPermission.getParentid()).collect(Collectors.toList());
				List<JQPermissionTreeVo> treeVos = new ArrayList<>(roots.size());
				transferToTreeVo(roots, permissions, treeVos);
				rolePermissionsRes.setPermissionTree(treeVos);
			}else{
				rolePermissionsRes.setPermissionTree(new ArrayList<>());
			}
			result.add(rolePermissionsRes);
		});
		return result;
	}

	public boolean passwordUpdate(JQPasswordResetReq resetReq, String userName) {
    	//根据username查询
		JQUser user = jqResourceMapper.findUserByName(userName, null);
		if(user == null){
			return false;
		}
		//验证密码是否正确
		if(passwordEncoder.matches(resetReq.getPassword(),user.getPassword())){
			jqResourceMapper.updateUserPassword(user.getId(), passwordEncoder.encode(resetReq.getNewPassword()));
			return true;
		}
		return false;
	}

	public Map<String, Object> addInitUser() {
		Map<String, Object> result = new HashMap<>();
		result.put("departmentList", departmentService.selectJQDepartmentList(null,"0"));
		//角色权限列表
		result.put("permissionList", getRolePermissions());
		return result;
	}

	public boolean passwordReset(Integer id) {
		JQUser user = jqResourceMapper.findUserById(id);
		if(user == null){
			return false;
		}
		//重置密码
		jqResourceMapper.updateUserPassword(id, passwordEncoder.encode("123456"));
		return true;
	}

	public JQUser updateUserStatus(Integer id) {
		JQUser user = jqResourceMapper.findUserById(id);
		if(user == null){
			throw new JQBaseException(JQResponseCode.RESOURCES_NOT_EXIST);
		}
		//修改status
		Integer status = user.getStatus() == 1 ? 0 : 1;
		user.setStatus(status);
		jqResourceMapper.updateUserStatus(id, status);
		return user;
	}
}
