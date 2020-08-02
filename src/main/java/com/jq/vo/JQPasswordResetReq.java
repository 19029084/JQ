package com.jq.vo;

import lombok.Data;

/**
 * @Description : 修改密码
 * @Create : 2020-07-28 22:48
 * @Author : xuhao
 */

@Data
public class JQPasswordResetReq {

    private String password;

    private String newPassword;
}
