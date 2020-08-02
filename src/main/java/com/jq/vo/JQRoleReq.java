package com.jq.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description :
 * @Create : 2020-07-27 23:12
 * @Author : xuhao
 */
@Data
public class JQRoleReq {

    private int id;

    private String name;

    private String remark;

    private String updateBy;

    private List<Integer> permissionIds;
}
