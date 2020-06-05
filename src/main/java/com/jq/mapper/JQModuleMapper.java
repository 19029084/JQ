package com.jq.mapper;

import com.jq.entity.JQModule;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface JQModuleMapper{
	@Select("select * from Modules")
	List<JQModule> getModules();
	
}
