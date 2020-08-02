package com.jq.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jq.entity.JQDepartment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.jq.mapper.JQDepartmentMapper;
/**
 * 部门管理Service业务层处理
 * 
 * @author jan
 * @date 2020-07-28
 */
@Service
public class JQDepartmentService
{
    @Autowired
    private JQDepartmentMapper jqDepartmentMapper;

    /**
     * 查询部门管理
     * 
     * @param id 部门管理ID
     * @return 部门管理
     */
    
    public JQDepartment selectJQDepartmentById(Long id)
    {
        return jqDepartmentMapper.selectJQDepartmentById(id);
    }

    /**
     * 查询部门管理列表
     * 
     * @param
     * @return 部门管理
     */
  
    public List<Map<String ,Object>> selectJQDepartmentList(String deptName , String parentId)
    {
        List<Map<String ,Object>> list=new ArrayList<>();
        if(StringUtils.isNotEmpty(deptName)){
            List<JQDepartment> dlist=jqDepartmentMapper.selectJQDepartmentByName(deptName);

            if(dlist.size()>0&&dlist!=null){
               List<Long> ids = new ArrayList<>();
               getids(dlist,ids);

             list=  getDeptTreeDate(null,null,ids);
//               list=jqDepartmentMapper.selectJQDepartmentList(null,null,ids);
//                for(Map<String,Object> map:list){
//
//                    List<Map<String ,Object>> jqDepartment=jqDepartmentMapper.selectJQDepartmentList(null,map.get("id").toString(),null);
//                    map.put("childrenList",jqDepartment);
//
//                }
            }
            return list;
        }

            list=getDeptTreeDate(null,parentId,null);
//           list = jqDepartmentMapper.selectJQDepartmentList(deptName,parentId,null);
//        for(Map<String,Object> map:list){
//
//            List<Map<String ,Object>> jqDepartment=selectJQDepartmentList(deptName,map.get("id").toString());
//            map.put("childrenList",jqDepartment);
//
//        }
        return list;
    }


    private void getids( List<JQDepartment> dlist,List<Long> ids){
        if(dlist.size()>0&&dlist!=null){
            for(JQDepartment jd : dlist){
                if(jd.getParentid()==0){
                    ids.add(jd.getId());
                }else{
                    JQDepartment pjq=jqDepartmentMapper.selectJQDepartmentById(jd.getParentid());
                    getpids(pjq,ids);
                }

            }
        }
    }

    private void getpids( JQDepartment dlist,List<Long> ids){
        if(dlist!=null){

                if(dlist.getParentid()==0){
                    ids.add(dlist.getId());
                }else{
                    JQDepartment pjq=jqDepartmentMapper.selectJQDepartmentById(dlist.getParentid());
                    getpids(pjq,ids);
                }


        }
    }

    private List<Map<String,Object>> getDeptTreeDate(String deptName,String parentId,List<Long> ids){
        List<Map<String,Object>> list =jqDepartmentMapper.selectJQDepartmentList(deptName,parentId,ids);

        for(Map<String,Object> map:list){

            List<Map<String ,Object>> jqDepartment=getDeptTreeDate(deptName,map.get("id").toString(),null);
            map.put("childrenList",jqDepartment);

        }
        return list;
    }

    /**
     * 新增部门管理
     * 
     * @param jqDepartment 部门管理
     * @return 结果
     */
   
    public int insertJQDepartment(JQDepartment jqDepartment)
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        jqDepartment.setUpdateBy(userDetails.getUsername());
        return jqDepartmentMapper.insertJQDepartment(jqDepartment);
    }

    /**
     * 修改部门管理
     * 
     * @param jqDepartment 部门管理
     * @return 结果
     */
 
    public int updateJQDepartment(JQDepartment jqDepartment)
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        jqDepartment.setUpdateBy(userDetails.getUsername());
        return jqDepartmentMapper.updateJQDepartment(jqDepartment);
    }

  

    /**
     * 删除部门管理信息
     * 
     * @param id 部门管理ID
     * @return 结果
     */
    public int deleteJQDepartmentById(Long id)
    {
        return jqDepartmentMapper.deleteJQDepartmentById(id);
    }

    /**
     * 校验部门名称是否唯一
     *
     * @param
     * @return 结果
     */
    public String checkDeptNameUnique(JQDepartment jqDepartment)
    {
        Long deptId = jqDepartment.getId()==null ? -1L : jqDepartment.getId();
        JQDepartment info = jqDepartmentMapper.checkDeptNameUnique(jqDepartment.getDeptName(), jqDepartment.getParentid());
        if (info!= null && info.getId().longValue() != deptId.longValue())
        {
            return "1";
        }
        return "0";
    }

    /**
     * 通过parentId查找部门
     * @param parentId
     * @return
     */
    public List<JQDepartment> selectJQDepartmentByPId(Long parentId)
    {
        return jqDepartmentMapper.selectJQDepartmentByPId(parentId);
    }

}
