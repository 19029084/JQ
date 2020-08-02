package com.jq.controller;


import com.jq.entity.*;
import com.jq.service.JQWidgetService;
import com.jq.utils.JQBaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


@JQBaseResponse
@RestController
@Api(tags = "Widget Management API")
@RequestMapping("/api/v1")

class JQWidgetController
{

@Resource
JQWidgetService w_service;

@GetMapping("/widgets")
@ApiOperation("Get All widget Information")
@ResponseBody
public List<JQWidget> getWidgets()
{

 return w_service.getWidgets();

}



@GetMapping("/widgets/{name:\\d+}")
@ApiOperation("Get widget Information by name")
@ApiImplicitParam(name="name",value="Widget name",required=true)
@ResponseBody
JQWidget getWidgetByName(@PathVariable String name)
{

 return w_service.getWidgetByName(name);

}




}

