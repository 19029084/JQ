package com.jq.utils;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;

import com.jq.entity.JQColumn;

import com.jq.entity.JQConfig;



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

import java.util.Stack;


public class JQUtils
{

	public final String MODULES = "modules";
	public final String MODULE = "module";

	public final String CONFIG="config";
	public final String DATA="data";
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
	
	public void LoadData() throws SAXException,DocumentException
	{
		System.out.println("Load Data....");
		SAXReader saxReader = new SAXReader();
		
		Document doc = saxReader.read(getClassPath("data.xml"));
		
		Element rootElement = doc.getRootElement();
		
		LoadData(rootElement);
	
	}
	
	public InputStream getClassPath(String xmlPath)
	{
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(xmlPath);
		
		
		
		return resourceAsStream;
	
	
	}
	
	public void LoadData(Element rootElement)
	{
		
		System.out.println("DATA-----");
		
		System.out.println(rootElement.getName());
		
		//List<JQModule> modules = null;
		
		//Stack<JQModule> moduleStack = new Stack<JQModule>();
		
		//Stack<Element> elements = new Stack<Element>();
		
		//elements.push(rootElement)
		
		//while(!elements.empty())
		
		{
			Element e = rootElement;//elements.peek();
			
			if(MODULES.equalsIgnoreCase(e.getName()))
			{
				modules = new ArrayList<JQModule>();	
				moduleStack = new Stack<JQModule>();	
				configStack = new Stack<JQConfig>();	
		
			}
			else if(MODULE.equalsIgnoreCase(rootElement.getName())) 
			{
				JQModule module = new JQModule();
			
				moduleStack.push(module);
			
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
					
			}
		
			else if(CONFIG.equalsIgnoreCase(rootElement.getName()))
			{
		
				JQConfig config = new JQConfig();
				
				configStack.push(config);
			
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
		
			}
			else if (DATA.equalsIgnoreCase(rootElement.getName()))
			{
				/*JQModuleData data = new JQModuleData();
				
				configStack.push(data);
				
				List<Attribute> attributes = rootElement.attributes();
				
				for(Attribute attribute: attributes)
				{
					switch(attribute.getName())
					{
						case "ref":
							int configId=Integer.parseInt(attribute.getText());
							data.setConfigId(configId);					
							break;				
						default:
					
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}*/				
				
				
			}
			else if(PROPERTY.equalsIgnoreCase(rootElement.getName()))
			{
				JQColumn column = new JQColumn();
				
				JQProperty property = new JQProperty();
				
				column.setProperty(property);
			
				JQConfig config = configStack.peek();
				
				System.out.println("Config: "+config);
				List<Attribute> attributes = rootElement.attributes();
				for(Attribute attribute: attributes)
				{
					System.out.println("Attribute:");
		
					System.out.println(attribute.getName()+":"+attribute.getText());
				
					switch(attribute.getName())
					{
						case "name":
							property.setName(attribute.getText());					
							break;
							
						case "value":
							property.setValue(attribute.getText());
							break;
							
						case "ref":
							property.setReference(attribute.getText());
							break;
							
						case "type":
							property.getPropertyType().setType(attribute.getText());						
							break;
						case "order":
							column.setSortKey(Integer.parseInt(attribute.getText()));
										
						default:
						
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}
				
				config.push(column);
		
			}
			else if(OPTION.equalsIgnoreCase(rootElement.getName()))
			{
				JQPropertyOption option = new JQPropertyOption();
				
				JQConfig config = configStack.peek();
				
				config.peek().getProperty().addOption(option);
			
				List<Attribute> attributes = rootElement.attributes();
				for(Attribute attribute: attributes)
				{
					System.out.println("Attribute:");
		
					System.out.println(attribute.getName()+":"+attribute.getText());
				
					switch(attribute.getName())
					{
						case "value":
							option.setValue(attribute.getText());					
							break;
		
						default:
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}
				
							
			
		
			}
	
		
			Iterator<Element> elementIterator = rootElement.elementIterator();
		
			while(elementIterator.hasNext())
			{
				Element next = elementIterator.next();
				LoadData(next);		
			}
		
			if(CONFIG.equalsIgnoreCase(rootElement.getName()))
			{
				JQModule module = moduleStack.peek();
				
				JQConfig config = configStack.pop();
				
				JQModuleConfig moduleConfig = new JQModuleConfig();
				
				moduleConfig.setJQConfig(config);
								
				module.addConfig(moduleConfig);
			}	
			
			
			if(DATA.equalsIgnoreCase(rootElement.getName()))
			{
				JQModule module= moduleStack.peek();
				
				//module.addData((JQModuleData)configStack.pop());
				
			}
		
			if(MODULE.equalsIgnoreCase(rootElement.getName()))
			{
				JQModule module = moduleStack.pop();
			
				if(moduleStack.empty())
				{
					modules.add(module);
				}
				else
				{
					System.out.println("sub module:"+module.getName());
					moduleStack.peek().addSubModule(module);
					
				}	
		
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
	
	
	


}
