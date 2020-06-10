package com.jq.mapper;


import com.jq.entity.JQProperty;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface JQPropertyMapper
{
	@Select("select * from property")
	List<JQProperty> getProperties();


}
