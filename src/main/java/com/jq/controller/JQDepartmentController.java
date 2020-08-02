package com.jq.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jq.entity.JQDepartment;
import com.jq.utils.JQBaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jq.service.JQDepartmentService;

/**
 * 部门管理Controller
 * 
 * @author jan
 * @date 2020-07-28
 */
@JQBaseResponse
@RestController
@Api(tags = "Department Management API")
@RequestMapping("/api/v1")
public class JQDepartmentController
{


    @Autowired
    private JQDepartmentService jqDepartmentService;



    /**
     * 查询部门管理列表
     */
    @GetMapping("/department")
    @ApiOperation("获取部门列表")
    @ResponseBody
    public Object getDepartlist(@RequestParam(name = "deptName",required = false) String deptName)
    {
        return jqDepartmentService.selectJQDepartmentList(deptName,"0");

    }


    /**
     * 新增保存部门管理
     */

    @PostMapping("/department")
    @ApiOperation("新增部门")
    @ResponseBody
    public int addSave(@RequestBody JQDepartment jqDepartment)
    {
        return jqDepartmentService.insertJQDepartment(jqDepartment);
    }

    /**
     * 查找某一部门信息
     */
    @GetMapping("/department/{id:\\d+}")
    @ApiOperation("查找某部门信息")
    public JQDepartment selectDeptById(@PathVariable("id") Long id)
    {
        return jqDepartmentService.selectJQDepartmentById(id);
    }

    /**
     * 修改保存部门管理
     */

    @PutMapping("/department")
    @ApiOperation("修改部门信息")
    @ResponseBody
    public int updateDept(@RequestBody JQDepartment jqDepartment)
    {

        return jqDepartmentService.updateJQDepartment(jqDepartment);
    }

    /**
     * 删除部门管理
     */

    @DeleteMapping( "/department/{id:\\d+}")
    @ApiOperation("删除部门信息")
    @ResponseBody
    public int remove(@PathVariable("id") Long id)
    {
        return jqDepartmentService.deleteJQDepartmentById(id);
    }
}
