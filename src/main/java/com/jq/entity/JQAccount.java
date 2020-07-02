package com.jq.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
public class JQAccount extends JQUser implements UserDetails {
    private String username;

    private String password;

    private String nickname;

    private boolean locked;

    private boolean expire;

    //private List<JQRole> roles;

    public JQAccount(JQUser user){
        username=user.getUsername();
        password=user.getPassword();
        //nickname=user.getNickname();
        //locked=user.getLocked();
        //expire=user.getExpire();
        //roles=user.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list=new ArrayList<>();
        Set<JQRole> roles = getRoles();
        if(roles != null)
        {
        for(JQRole role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
        }
        return list;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !expire;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


