package com.jq.entity;

import lombok.Data;

/**
 * @Description : 角色权限
 * @Create : 2020-07-27 23:26
 * @Author : xuhao
 */
@Data
public class JQRolePermission {

    private int id;

    private int roleId;

    private int permissionId;
}
