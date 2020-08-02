package com.jq.controller;

import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;
import com.jq.service.JQPropertyService;


import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.*;

import com.jq.utils.*;

import java.util.UUID;

import javax.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import java.io.File;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.util.unit.DataSize;


@JQBaseResponse
@RestController
@Api(tags = "Resource Management API")
@RequestMapping("/api/v1")
public class JQResourceController
{

	//@Resource
	//JQResourcervice m_service;

	
	
	
	 @Bean
   	 MultipartConfigElement multipartConfigElement() {
        	MultipartConfigFactory factory = new MultipartConfigFactory();
        	factory.setLocation(JQUtils.getImagePath());
        	//factory.setMaxFileSize(DataSize.ofBytes(512*1024L));         
         	//factory.setMaxRequestSize(DataSize.ofBytes(512*1024*1024L));
        	return factory.createMultipartConfig();
    	}

	@PostMapping("/upload")
	@ApiOperation("上传文件")
	@ResponseBody
	public String fileUpload(@RequestParam("file") MultipartFile imageFile)
	{
		
		if (imageFile.isEmpty()) {
		    return null;
		}
		String filename = imageFile.getOriginalFilename();
		
		String ext= null;
		if(filename.contains(".")){
		    ext = filename.substring(filename.lastIndexOf("."));
		}else{
		    ext = "";
		}
		
		
		Date date = new Date();
        	
          	DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
 
           	String nfileName = df.format(date)+File.separator;

		String uuid =  UUID.randomUUID().toString().replaceAll("-", "");
        	
        	nfileName += uuid + ext;
        	

        	File targetFile = new File(JQUtils.getImagePath()+nfileName);
        	if (!targetFile.exists()) {
            		targetFile.mkdirs();
        	} else {
            		targetFile.delete();
        	}
		
		
		try {
		    imageFile.transferTo(targetFile);
		} catch (IllegalStateException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}

		String accessUrl =  JQUtils.getImageUrl(nfileName);
		//logger.debug("上传文件成功 URL：" + nfileName);
		return accessUrl;

	}
	
	
	
	


}

