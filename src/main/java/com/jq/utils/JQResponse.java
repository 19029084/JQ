package com.jq.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class JQResponse implements Serializable {
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;
    
    //public JQResponse(Integer code,String msg,Object data)
    //{
    //	this.code = code;
    //	this.msg = msg;
    //	this.data = data;
    //}

}






