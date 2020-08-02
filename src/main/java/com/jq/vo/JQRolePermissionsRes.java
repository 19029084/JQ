package com.jq.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description : 角色权限
 * @Create : 2020-07-28 15:42
 * @Author : xuhao
 */
@Data
public class JQRolePermissionsRes {

    private int roleId;

    private String roleName;

    private List<JQPermissionTreeVo> permissionTree;
}
