package com.jq.vo;

import lombok.Data;

/**
 * @Description : 人员
 * @Create : 2020-07-28 15:42
 * @Author : xuhao
 */
@Data
public class JQUserRes {

    private int id;

    private String username;

    private String nickname;

    private String departmentName;

    private Integer roleNumber;

    private String roleNames;

    private String updateTime;

    private String updateBy;

    private Integer status;

}
