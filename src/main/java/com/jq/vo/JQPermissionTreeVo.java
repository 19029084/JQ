package com.jq.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description : 权限树形结构
 * @Create : 2020-07-27 22:14
 * @Author : xuhao
 */
@Data
public class JQPermissionTreeVo {

    private int id;

    private String name;

    private String urlId;

    private List<JQPermissionTreeVo> children;
}
