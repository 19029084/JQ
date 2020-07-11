package com.jq.security;

//import com.jq.security.repository.JQUserRepository;
import com.jq.entity.JQAccount;
import com.jq.entity.JQUser;
import com.jq.entity.JQRole;
import com.jq.entity.JQPermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.stereotype.Service;


import com.jq.mapper.JQResourceMapper;

import java.util.List;
import java.util.ArrayList;






@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private JQResourceMapper jqResourceMapper;
    //@Autowired
    //private JQUserRepository jqUserRepository;
    
    

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        JQUser user=jqResourceMapper.findUserByName(s);
        //JQUser user= jqUserRepository.findByUsernameCaseInsensitive(s);
        if(user==null){
            throw new UsernameNotFoundException("帐号不存在！");
        }else{
        
        	List<JQPermission> permissions = jqResourceMapper.findPermissionsByUserId(user.getId());
        	
        	List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        	
        	for(JQPermission permission: permissions)
        	{
        		if(permission !=null && permission.getCode()!=null)
        		{
        			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getCode());
        			grantedAuthorities.add(grantedAuthority);
        		}
        	}
        	return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
        

            //return new JQAccount(user);
        }
    }
}

