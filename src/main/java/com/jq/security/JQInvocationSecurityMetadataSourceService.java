package com.jq.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import com.jq.mapper.JQResourceMapper;
import com.jq.entity.JQPermission;


@Service
public class JQInvocationSecurityMetadataSourceService  implements
        FilterInvocationSecurityMetadataSource {

    @Autowired
    private JQResourceMapper  jqResourceMapper;

    private HashMap<String, Collection<ConfigAttribute>> map =null;

    public void loadResourceDefine(){
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<JQPermission> permissions = jqResourceMapper.findAllPermissions();
        for(JQPermission permission : permissions) {
            array = new ArrayList<>();
            cfg = new SecurityConfig("ROLE_"+permission.getName());
            array.add(cfg);
            map.put(permission.getUrl(), array);
        }

    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(map ==null) loadResourceDefine();
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        
        System.out.println("***********"+((FilterInvocation) object).getRequestUrl());
        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            System.out.println("resUrl:"+resUrl);
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)) {
            	System.out.println("MATCH!!!");
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
