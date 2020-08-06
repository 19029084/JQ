package com.jq.service;

import com.jq.entity.JQModule;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import javax.annotation.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

import com.jq.entity.*;


@Service
public class JQAdminService{

@Resource 
JQModuleService moduleService;

@Resource 
JQConfigService configService;

@Resource 
JQPropertyService propertyService;


	public void resetData()
	{
		com.jq.utils.JQUtils utils = new com.jq.utils.JQUtils();
		try{
		
			System.out.println("Begin");
			
			utils.LoadData();
			
			List<JQModule> modules = utils.getModules();
			
			moduleService.createModules(modules,0);
			
			//modules = moduleService.getModules();
			
			List< Map<String,String> > moduleData = new ArrayList< >();
			List< Map<String,String> > configData = new ArrayList< >();
			
			
			
			JQModuleConfig moduleModuleConfig = moduleService.getModuleService();//moduleService.findModuleConfigByName("菜单管理","菜单配置");			
			JQModuleConfig configModuleConfig = moduleService.getConfigService();//moduleService.findModuleConfigByName("模板管理","模板配置");			
			JQModuleConfig propertyModuleConfig = moduleService.getPropertyService();//moduleService.findModuleConfigByName("字典管理","字典配置");
			JQModuleConfig optionModuleConfig = moduleService.getOptionService();//moduleService.findModuleConfigByName("数据项管理","数据项配置");
			
			for(int i=0;i<modules.size();i++)
			{
				JQModule module = modules.get(i);


			
				ModuleToWidget(module,moduleData,0);
				
				List<JQModuleConfig> moduleConfigs = module.getModuleConfigs();
				
				System.out.println("module:"+module.getName());
				if(moduleConfigs!=null)
				{
					for(int j=0;j<moduleConfigs.size();j++)
					{
						JQConfig config = moduleConfigs.get(j).getJQConfig();

						//ConfigToWidget(config,configData);
					}	
				
				}
				
				
				
			
			}
			
			
			
			moduleService.addModuleData(moduleModuleConfig.getModuleId(),moduleModuleConfig.getConfigId(),moduleData);
			
			//moduleService.addModuleData(configModuleConfig.getModuleId(),configModuleConfig.getConfigId(),configData);
			configService.refresh(configModuleConfig.getModuleId(),configModuleConfig.getConfigId());
			
			
			List<JQProperty> properties = propertyService.loadProperties();
			
			List< Map<String,String> > propertyData = new ArrayList<>();
			
			for(int i=0;i<properties.size();i++)
			{
				PropertyToWidget(properties.get(i),propertyData);
			
			}
			
			moduleService.addModuleData(propertyModuleConfig.getModuleId(),propertyModuleConfig.getConfigId(),propertyData);
			
			
			
			
			List<JQPropertyOption> options = propertyService.loadPropertyOptions();
			
			List< Map<String,String> > optionData = new ArrayList< >();
			
			for(int i=0;i<options.size();i++)
			{
				OptionToWidget(options.get(i),optionData);
				
				List<JQPropertyOption> subOptions = options.get(i).getChildren();
				
				for(int j=0;j<subOptions.size();j++)
				{
					OptionToWidget(subOptions.get(i),optionData);
				}
			
			}
			
			moduleService.addModuleData(optionModuleConfig.getModuleId(),optionModuleConfig.getConfigId(),optionData);
			
			
			
			 
			
			
			
			
			
			System.out.println("END");
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
	
	
	protected void ModuleToWidget(JQModule module, List< Map<String,String> > data,int parentId)
	{
				Map<String,String> row = new HashMap<>();
				
				row.put("序号",""+module.getId());
				row.put("菜单名称",module.getName());
				
				List<JQModuleConfig> moduleConfigs = module.getModuleConfigs();
				
				if(moduleConfigs!=null &&moduleConfigs.size()>0)
				{
					row.put("模板编号",moduleConfigs.get(0).getJQConfig().getName());
				}
				row.put("URL",module.getPath());
				row.put("parentId",""+parentId);
				row.put("rowId",""+module.getId());
				
				/*List<JQWidget> widgets = new ArrayList<>();
				
				JQWidget w3 = new JQWidget();
				
				w3.setName("序号");
				w3.setValue(""+module.getId());
				
				widgets.add(w3);
				
				JQWidget w1 = new JQWidget();				
				w1.setName("菜单名称");
				w1.setValue(module.getName());
				widgets.add(w1);
				
				JQWidget w2 = new JQWidget();
				w2.setName("URL");
				w2.setValue(module.getPath());
				widgets.add(w2);
				
				JQWidget w4 = new JQWidget();
				w2.setName("parentId");
				w2.setValue(module.getPath());
				widgets.add(w4);*/
					
				data.add(row);
				
				List<JQModule> children = module.getChildren();
				if(children != null)
				{
					for(int j=0;j<children.size();j++)
					{
						ModuleToWidget(children.get(j),data,module.getId());
						
					}
					
				}	
	
	}
	
	
	
		
	protected void ConfigToWidget(JQConfig config, List< Map<String,String> > data)
	{

				Map<String,String> row = new HashMap<>();
				
				
				row.put("模板编号",""+config.getId());
				row.put("模板标题",config.getName());
				

				row.put("rowId",""+config.getId());


				data.add(row);	
				
				
	
	}
	
	
	protected void PropertyToWidget(JQProperty property, List< Map<String,String> > data)
	{

				Map<String,String> row = new HashMap<>();
				row.put("字典名称",property.getName());
				row.put("数据值数量",""+property.getId());
				row.put("引用数量",""+property.getId());
				//row.put("parentId",""+config.getParentId());
				row.put("rowId",""+property.getId());
				row.put("parentId","0");

				data.add(row);	
				
				
	
	}
	
	
	
	protected void OptionToWidget(JQPropertyOption option, List< Map<String,String> > data)
	{


				Map<String,String> row = new HashMap<>();
				row.put("数据项名称",option.getValue());
				//row.put("parentId",""+config.getParentId());
				row.put("rowId",""+option.getId());
				row.put("parentId",""+option.getParentId());

				data.add(row);	
				
				
	
	}
		
		
		
}
