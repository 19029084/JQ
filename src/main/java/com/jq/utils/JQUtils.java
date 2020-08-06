package com.jq.utils;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;

import com.jq.entity.JQColumn;

import com.jq.entity.JQConfig;
import com.jq.entity.JQWidget;


import java.io.InputStream;

import org.dom4j.io.SAXReader;
import org.dom4j.Document;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.DocumentException;
import org.xml.sax.SAXException;

import java.util.List;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;

import java.util.Stack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.jq.entity.JQObject;

import java.util.Date;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;


import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;

import org.springframework.web.multipart.MultipartFile;


public class JQUtils
{

	public final String MODULES = "modules";
	public final String MODULE = "module";

	public final String CONFIG="config";
	public final String DATA="data";
	public final String WIDGET="widget";
	public final String PROPERTY="property";
	public final String OPTION ="option";
	

	public static void  main(String args[]) throws SAXException,DocumentException
		
	{	
		System.out.println("Load Data");
		
		JQUtils utils = new JQUtils();
		
		utils.LoadData();
	}
	
	
	public JQUtils()
	{
		
	
	
	}
	
	public static void ConfigToWidget(JQConfig config, List< Map<String,String> > data)
	{

				Map<String,String> row = new HashMap<>();
				
				
				row.put("模板编号",""+config.getId());
				row.put("模板标题",config.getName());

				row.put("rowId",""+config.getId());


				data.add(row);	
				
				
	
	}
	
	public static String getModuleDataTable(int moduleId, int configId)
	{
		
		//return "Module_"+moduleId+"_Config_"+configId+"_Data";
		return "ModuleData";	
	}
	
	public static List<String> covertToData(String key)
	{
		List<String> data = new ArrayList<String>();
		
		switch(key)
		{
			case "{username}":
				User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				
				String username=user.getUsername();
				
				data.add(username);
			break;
			
			case "{now}":
			
				data.add( (new Date()).toString());
							
			break;	
			
			default :
			
				data.add(key);
		
		
		}
		
		return data;
		
	}
	
	public static String getImagePath()
	{
		String path = System.getProperty("user.dir")+File.separator+"images"+File.separator;
		
		return path;
	}
	
	public static String getImageUrl(String filename)
	{
		return "/images/"+filename;
	
	}
	
	
	public static XSSFWorkbook getWorkbook(String sheetname, String [] title, String [][]content)
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet(sheetname);
		
		XSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		
		XSSFRow titleRow = sheet.createRow(0);
		
		for(int i=0;i<title.length;i++)
		{
			XSSFCell cell = titleRow.createCell(i);
			
			cell.setCellValue(title[i]);
			
			cell.setCellStyle(style);
		}
		
		for(int i=0;i<content.length;i++)
		{
			XSSFRow row = sheet.createRow(i+1);
			
			for(int j=0;j<content[i].length;j++)
			{
				XSSFCell cell = row.createCell(j);
				
				cell.setCellValue(content[i][j]);
				
				cell.setCellStyle(style);
			
			}
		}
		
		return workbook;
		
	
	}
	

	
	
	public void LoadData() throws SAXException,DocumentException
	{
		System.out.println("Load Data....");
		SAXReader saxReader = new SAXReader();
		
		Document doc = saxReader.read(getClassPath("data.xml"));
		
		Element rootElement = doc.getRootElement();
		
		LoadData(rootElement, null);
	
	}
	
	public InputStream getClassPath(String xmlPath)
	{
		InputStream resourceAsStream = null;
		
		try{
			String path = System.getProperty("user.dir")+File.separator+"config"+File.separator;
			
			resourceAsStream = new FileInputStream(new File(path+xmlPath));
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
				
			resourceAsStream = getClass().getClassLoader().getResourceAsStream(xmlPath);				
		
		} 
		finally
		{
			return resourceAsStream;
		}
	}
	
	public void LoadData(Element rootElement, JQObject parent)
	{
		
		System.out.println("DATA-----");
		
		System.out.println(rootElement.getName());
		
		JQObject current = null;
		
		{
			Element e = rootElement;//elements.peek();
			
			if(MODULES.equalsIgnoreCase(e.getName()))
			{
				modules = new ArrayList<JQModule>();	
				
				configWidget = new TreeMap<Integer, ArrayList<JQWidget>>();

				orders = new HashMap<Integer,Integer>();
		
			}
			else if(MODULE.equalsIgnoreCase(rootElement.getName())) 
			{
				JQModule module = new JQModule();
			
				current = module;
			
				List<Attribute> attributes = rootElement.attributes();
			
				for(Attribute attribute: attributes)
				{
					System.out.println("Attribute:");
			
					System.out.println(attribute.getName()+":"+attribute.getText());
				
					switch(attribute.getName())
					{
						case "name":
							module.setName(attribute.getText());					
							break;
						case "path":
							module.setPath(attribute.getText());
							break;				
						default:
						
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}
				
				if(parent == null)
				{
					module.setSortKey(String.valueOf(modules.size()+1));
					modules.add(module);
				}

				if(parent instanceof JQModule)
				{
					((JQModule)parent).addChildren(module);
				}

					
			}
		
			else if(CONFIG.equalsIgnoreCase(rootElement.getName()))
			{
		
				JQConfig config = new JQConfig();
				
				current = config;
				
				//configStack.push(config);
				
				JQModuleConfig moduleConfig = new JQModuleConfig();
				
				moduleConfig.setJQConfig(config);
				
				
			
				List<Attribute> attributes = rootElement.attributes();
				for(Attribute attribute: attributes)
				{
					switch(attribute.getName())
					{
						case "name":
							//int configId=Integer.parseInt(attribute.getText());
							//config.setConfigId(configId);
							config.setName(attribute.getText());					
							break;	
						case "title":
							//int configId=Integer.parseInt(attribute.getText());
							//config.setConfigId(configId);					
							break;			
						default:
					
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}
				
				if(parent instanceof JQModule)
				{
					((JQModule)parent).addConfig(moduleConfig);
				}
				
				if(parent instanceof JQConfig)
				{

					for(Map.Entry<Integer,ArrayList<JQWidget>> entry: configWidget.entrySet())
					{
						JQColumn column = new JQColumn();
						column.setSortKey(entry.getKey());
						column.setWidget(entry.getValue());
						((JQConfig)parent).push(column);
					}
					
					configWidget.clear();
					
					((JQConfig)parent).addChildren(config);
				
				}
				
 				nWidget=0;
 				orders.clear();
				
				
		
			}
			else if (DATA.equalsIgnoreCase(rootElement.getName()))
			{
				
				JQConfig config = new JQConfig();
				
				current = config;
				
				JQModuleData moduleData = new JQModuleData();
				
				moduleData.setJQConfig(config);
				
				List<Attribute> attributes = rootElement.attributes();
				
				for(Attribute attribute: attributes)
				{
					switch(attribute.getName())
					{
						case "ref":
							config.setRef(attribute.getText());					
							break;				
						default:
					
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}
				
				if(parent instanceof JQModule)
				{
					((JQModule)parent).addData(moduleData);
				}				
				
				
			}
			else if(WIDGET.equalsIgnoreCase(rootElement.getName()))
			{
				nWidget++;
				
				JQWidget widget = new JQWidget();
				
				current = widget;

				boolean hasOrder =false;
				
				List<Attribute> attributes = rootElement.attributes();
				for(Attribute attribute: attributes)
				{
		
					System.out.println(attribute.getName()+":"+attribute.getText());
				
					switch(attribute.getName())
					{
						case "name":
							widget.setName(attribute.getText());					
							break;							
						case "value":
							widget.setValue(attribute.getText());
							break;							
						case "ref":							
							widget.setRef(attribute.getText());
							break;							
						case "type":
							widget.setType(attribute.getText());						
							break;
						case "order":
							hasOrder = true;
							Integer key = Integer.parseInt(attribute.getText());
							
							if(orders.get(key)!=null)
							{
								key = orders.get(key);
							}
							else
							{
								orders.put(key,nWidget);
								key =nWidget;
							}
							
							
							ArrayList<JQWidget> widgets = configWidget.get(key);
							if(widgets == null)
							{
								widgets = new ArrayList<JQWidget>();
					
								configWidget.put(key,widgets);				
							}
				
							widgets.add(widget);
							//widget.setSortKey(key);
							
							break;
						case "source":
							switch(attribute.getText())
							{	
								case "property":
									widget.setDataSource(0);
									break;
								case "widget":
									widget.setDataSource(1);
									break;								
								case "config":
									widget.setDataSource(2);
									break;							
								default: 
									System.out.println("UNKNOWN SOURCE:"+attribute.getText());
							}						
							break;
						case "visible":
							switch(attribute.getText())
							{
								case "true":
									widget.setVisible(true);
									break;
								case "false":
									widget.setVisible(false);
									break;
							}
						
										
	 						default:
						
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}
				
				if(!hasOrder)
				{
							ArrayList<JQWidget> widgets = configWidget.get(nWidget);
							if(widgets == null)
							{
								widgets = new ArrayList<JQWidget>();
					
								configWidget.put(nWidget,widgets);				
							}
				
							widgets.add(widget);
				}
				
				
				
				

			}
			
			else if(PROPERTY.equalsIgnoreCase(rootElement.getName()))
			{
			
				JQProperty property = new JQProperty();
				
				current = property;
				
				List<Attribute> attributes = rootElement.attributes();
				for(Attribute attribute: attributes)
				{
				
					switch(attribute.getName())
					{
						case "name":
							property.setName(attribute.getText());					
							break;
						case "ref":
							property.setRef(attribute.getText());					
							break;	
						case "value":
							property.setValue(attribute.getText());
							break;
						case "type":
							property.setType(attribute.getText());
							break;
						default:
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}
				
				if(parent instanceof JQWidget)
				{
					((JQWidget)parent).setProperty(property);
				}				
				
			
			}
			
			else if(OPTION.equalsIgnoreCase(rootElement.getName()))
			{
				JQPropertyOption option = new JQPropertyOption();
				
				current = option;
				
				//JQConfig config = configStack.peek();

				//config.peek().getWidget().addOption(option);
			
				List<Attribute> attributes = rootElement.attributes();
				for(Attribute attribute: attributes)
				{
			
					switch(attribute.getName())
					{
						case "value":
							option.setValue(attribute.getText());					
							break;
		
						default:
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}
				
				
				System.out.println(option.getValue()+"option:"+rootElement.getText());
				
				if(option.getValue() == null||"".equals(option.getValue()))
				{
									
					option.setValue(rootElement.getText());
					System.out.println(option.getValue());
				}
				
				if(parent instanceof JQProperty)
				{
					JQProperty property = (JQProperty)parent;
					
					property.addOption(option);
				
				}
				else if(parent instanceof JQPropertyOption)
				{
					System.out.println(((JQPropertyOption) parent).getValue()+"child:"+option.getValue());
					((JQPropertyOption) parent).addChildren(option);
					
				}	
			}
	
		
			Iterator<Element> elementIterator = rootElement.elementIterator();
		
			while(elementIterator.hasNext())
			{
				Element next = elementIterator.next();
				LoadData(next,current);		
			}
		
			if(CONFIG.equalsIgnoreCase(rootElement.getName()))
			{
				//JQModule module = moduleStack.peek();
				
				//JQConfig config = configStack.pop();
				
				for(Map.Entry<Integer,ArrayList<JQWidget>> entry: configWidget.entrySet())
				{
					JQColumn column = new JQColumn();
					column.setSortKey(entry.getKey());
					column.setWidget(entry.getValue());
					((JQConfig)current).push(column);
				}
				
				configWidget.clear();
				
				//JQModuleConfig moduleConfig = new JQModuleConfig();
				
				//moduleConfig.setJQConfig(config);
								
				//module.addConfig(moduleConfig);
			}	
			
			
			if(DATA.equalsIgnoreCase(rootElement.getName()))
			{
				for(Map.Entry<Integer,ArrayList<JQWidget>> entry: configWidget.entrySet())
				{
					JQColumn column = new JQColumn();
					column.setSortKey(entry.getKey());
					column.setWidget(entry.getValue());
					((JQConfig)current).push(column);
				}
				
				configWidget.clear();
				
			}
		
			if(MODULE.equalsIgnoreCase(rootElement.getName()))
			{

		
			}
			

	
	
	
		}
	}
	
	public List<JQModule> getModules()
	{
		return modules;
	}
	
	
	private List<JQModule> modules;
	private Stack<JQModule> moduleStack;
	
	private List<JQConfig> configs;
	
	private Stack<JQConfig> configStack;
	
	private TreeMap<Integer,ArrayList<JQWidget>> configWidget; 
	
	private List<JQWidget> widgets;
	
	private HashMap<Integer,Integer> orders;
	
	private int nWidget;
	
	
	


}
