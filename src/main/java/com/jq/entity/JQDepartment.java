package com.jq.entity;


import java.util.Date;
import java.util.List;

/**
 * 部门管理对象 sys_department
 *
 * @author jan
 * @date 2020-07-28
 */

public class JQDepartment
{
    /** 主键 */
    private Long id;


    /** 部门名称 */
    private String deptName;

    /** 父类id */
    private Long parentid;


    private String updateBy;

    private Date UpdateTime;

    private List<JQDepartment> childrenList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }


    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    public List<JQDepartment> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<JQDepartment> childrenList) {
        this.childrenList = childrenList;
    }
}
