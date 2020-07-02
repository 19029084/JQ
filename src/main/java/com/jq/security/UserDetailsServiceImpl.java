package com.jq.security;

import com.jq.security.repository.JQUserRepository;
import com.jq.entity.JQAccount;
import com.jq.entity.JQUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    //@Autowired
    //private UserMapper userMapper;
    @Autowired
    private JQUserRepository jqUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //User user=userMapper.selectByUsername(s);
        JQUser user= jqUserRepository.findByUsernameCaseInsensitive(s);
        if(user==null){
            throw new UsernameNotFoundException("帐号不存在！");
        }else{
            return new JQAccount(user);
        }
    }
}

