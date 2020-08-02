package com.jq.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description : 角色res vo
 * @Create : 2020-07-28 15:42
 * @Author : xuhao
 */
@Data
public class JQRoleRes {
    private int id;

    private String name;

    private String remark;

    private String updateBy;

    private String updateTime;

    private List<Integer> permissionIds;
}
