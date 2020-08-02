package com.jq.controller;


//import com.jq.service.JQUserService;


import com.jq.entity.JQPermission;
import com.jq.entity.JQRole;
import com.jq.entity.JQUser;
import com.jq.service.JQResourceService;
import com.jq.utils.JQBaseResponse;
import com.jq.vo.JQPasswordResetReq;
import com.jq.vo.JQRoleReq;
import com.jq.vo.JQRoleRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@JQBaseResponse
@RestController
@Api(tags = "User Management API")
@RequestMapping("/api/v1")
class JQUserController {
//@Resource
//JQUserService m_service;

    @Resource
    JQResourceService m_resourceService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {

        OAuth2AccessToken token = null;
        MultiValueMap<String, Object> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.set("username", username);
        paramsMap.set("password", password);
        paramsMap.set("grant_type", "password");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("webapp", "JQApp"));
        token = restTemplate.postForObject("http://localhost:" + port + "/oauth/token", paramsMap, OAuth2AccessToken.class);

        return token;
    }


    @PostMapping(value = "/logout")
    public Object logout() {

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

    @PostMapping(value = "/user")
    public Object createUser(@RequestBody JQUser user) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userDetails != null){
            user.setUpdateBy(userDetails.getUsername());
        }
        return m_resourceService.createUser(user);
    }

    @GetMapping(value = "/user/passwordReset")
    @ApiOperation("重置密码")
    public Object passwordReset(@RequestParam("id") Integer id) {
        return m_resourceService.passwordReset(id);
    }

    @PostMapping(value = "/user/passwordUpdate")
    @ApiOperation("修改密码")
    public Object passwordUpdate(@RequestBody JQPasswordResetReq resetReq) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return m_resourceService.passwordUpdate(resetReq, userDetails.getUsername());
    }

    @GetMapping(value = "/user")
    public Object getUsers(@RequestParam(required = false) String userName, @RequestParam(required = false) String nickName, @RequestParam Integer current, @RequestParam Integer pageSize) {
        return m_resourceService.getUser(userName, nickName, current, pageSize);
    }

    @GetMapping(value = "/user/updateStatus")
    public Object updateUserStatus(@RequestParam("id") Integer id) {
        return m_resourceService.updateUserStatus(id);
    }

    @DeleteMapping("/user/{id:\\d+}")
    public boolean deleteUser(@PathVariable("id") int id) {
        return m_resourceService.deleteUser(id);
    }

    @GetMapping("/user/updateInit/{id:\\d+}")
    public Map<String, Object> updateInitUser(@PathVariable("id") int id) {
        return m_resourceService.updateInitUser(id);
    }

    @GetMapping("/user/addInit")
    public Map<String, Object> addInitUser() {
        return m_resourceService.addInitUser();
    }

    @PutMapping("/user")
    public boolean updateUser(@RequestBody JQUser user)
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userDetails != null){
            user.setUpdateBy(userDetails.getUsername());
        }
        return m_resourceService.updateUser(user);
    }

    @GetMapping(value = "/url")
    public Object getUrls() {

        return m_resourceService.getUrls();
    }


    @GetMapping(value = "/role")
    public Object getRoles(@RequestParam(required = false) String roleName, @RequestParam Integer current, @RequestParam Integer pageSize) {
        return m_resourceService.getRoles(roleName, current, pageSize);
    }


    @PostMapping(value = "/role")
    public Object createRole(@RequestBody JQRoleReq role) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userDetails != null){
            role.setUpdateBy(userDetails.getUsername());
        }
        return m_resourceService.createRoleVo(role);
    }

    @GetMapping("/role/updateInit/{id:\\d+}")
    public JQRoleRes updateInit(@PathVariable("id") int id) {
        return m_resourceService.updateInit(id);
    }

    @PutMapping("/role")
    public boolean updateRole(@RequestBody JQRoleReq role)
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userDetails != null){
            role.setUpdateBy(userDetails.getUsername());
        }
        return m_resourceService.updateJRole(role);
    }

    @DeleteMapping("/role/{id:\\d+}")
    public boolean deleteRole(@PathVariable("id") int id) {
        return m_resourceService.deleteRole(id);
    }


    @PostMapping(value = "/{uid:\\d+}/role")
    public Object assignRole(@PathVariable int uid,
                             @RequestBody List<JQRole> roles) {

        return m_resourceService.assignRole(uid, roles);
    }


    @GetMapping(value = "/permission")
    public Object getPermissions() {
        return m_resourceService.getPermissionTree();
    }


    @PostMapping(value = "/permission")
    public Object createPermission(@RequestBody List<JQPermission> permissions) {

        return m_resourceService.createPermission(permissions, 0);
    }


    @PostMapping(value = "/permission/{parentId:\\d+}")
    public Object createPermission(@RequestBody List<JQPermission> permissions,
                                   @PathVariable int parentId) {

        return m_resourceService.createPermission(permissions, parentId);
    }

    @PostMapping(value = "/role/{roleId:\\d+}/permission")
    public Object assignPermission(@PathVariable int roleId,
                                   @RequestBody List<JQPermission> permissions) {

        return m_resourceService.assignPermission(roleId, permissions);
    }


}
