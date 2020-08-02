package com.jq.entity;


import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import lombok.Data;


@Data
//@Entity
//@Table(name = "sys_role", schema = "JQ", catalog = "")
public class JQRole
{
	private int id;

	private String name;

	private String remark;
	//@Basic
        //@Column(name = "name")
        //public String getName() {
        //    return name;
        //}
        //public void setName(String name) {
        //    this.name = name;
        //}

        //@Basic
        //@Column(name = "name_cn")
        //public String getNameCN() {
        //    return nameCN;
        //}
        //public void setNameCN(String name_cn) {
        //    this.nameCN = name_cn;
        //}

	//@JsonBackReference
	//@ManyToMany(mappedBy ="roles")
	//private List<JQUser> users;

	//@ManyToMany
	//@JoinTable(
	//	name= "sys_permission",
	//	joinColumns=@JoinColumn(name="permission_id"),
	//	inverseJoinColumns=@JoinColumn(name="role_id")
	//	)
	private List<JQPermission> permissions;

}
