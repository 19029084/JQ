package com.jq.entity;

import lombok.Data;

import java.util.List;

@Data
public class JQUser {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String deptCode;
    private String deptName;
    private Integer status;
    private String updateBy;
    private List<Integer> roleIds;
//    protected List<JQRole> roles;
}
