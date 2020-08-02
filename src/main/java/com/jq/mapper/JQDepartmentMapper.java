package com.jq.mapper;

import com.jq.entity.JQDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;

/**
 * 部门管理Mapper接口
 * 
 * @author jan
 * @date 2020-07-27
 */

@Mapper
public interface JQDepartmentMapper
{
    /**
     * 查询部门管理
     * 
     * @param id 部门管理ID
     * @return 部门管理
     */
    public JQDepartment selectJQDepartmentById(Long id);

    /**
     * 通过parentId查找部门
     * @param parentId
     * @return
     */
    public List<JQDepartment> selectJQDepartmentByPId(Long parentId);
    public List<JQDepartment> selectJQDepartmentByName(String deptName);
    public List<Map<String, Object>> selectJQDepartmentListByIds(List<Long> ids);

    /**
     * 查询部门管理列表
     * 
     * @param
     * @return 部门管理集合
     */
    public List<Map<String, Object>> selectJQDepartmentList(@Param("deptName") String deptName , @Param("parentId") String parentId,@Param("ids") List<Long> ids);

    /**
     * 新增部门管理
     * 
     * @param jqDepartment 部门管理
     * @return 结果
     */
    public int insertJQDepartment(JQDepartment jqDepartment);

    /**
     * 修改部门管理
     * 
     * @param jqDepartment   部门管理
     * @return 结果
     */
    public int updateJQDepartment(JQDepartment jqDepartment);

    /**
     * 删除部门管理
     * 
     * @param id 部门管理ID
     * @return 结果
     */
    public int deleteJQDepartmentById(Long id);

    /**
     * 校验部门名称是否唯一
     *
     * @param
     * @return 结果
     */
    public JQDepartment checkDeptNameUnique(String deptName,Long  parentId);

}
