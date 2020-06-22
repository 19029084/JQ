package com.jq.utils;

import com.jq.entity.JQModule;
import com.jq.entity.JQModuleConfig;
import com.jq.entity.JQModuleData;
import com.jq.entity.JQProperty;
import com.jq.entity.JQPropertyOption;



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
				configStack = new Stack<JQModuleConfig>();	
		
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
						default:
						
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}
					
			}
		
			else if(CONFIG.equalsIgnoreCase(rootElement.getName()))
			{
		
				JQModuleConfig config = new JQModuleConfig();
				
				configStack.push(config);
			
				List<Attribute> attributes = rootElement.attributes();
				for(Attribute attribute: attributes)
				{
					switch(attribute.getName())
					{
						case "id":
							int configId=Integer.parseInt(attribute.getText());
							config.setConfigId(configId);					
							break;				
						default:
					
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}
		
			}
			else if (DATA.equalsIgnoreCase(rootElement.getName()))
			{
				JQModuleData data = new JQModuleData();
				
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
				}				
				
				
			}
			else if(PROPERTY.equalsIgnoreCase(rootElement.getName()))
			{
				JQProperty property = new JQProperty();
			
				JQModuleConfig config = configStack.peek();
				
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
						default:
						
							System.out.println("UNKNOW ATTRIBUTE:"+attribute.getName());
					}
				}
				
				config.push(property);
		
			}
			else if(OPTION.equalsIgnoreCase(rootElement.getName()))
			{
				JQPropertyOption option = new JQPropertyOption();
				
				JQModuleConfig config = configStack.peek();
				
				
				System.out.println("Config:"+config.getConfigId());
				
				config.peek().addOption(option);
			
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
				
				module.addConfig(configStack.pop());
			}	
			
			
			if(DATA.equalsIgnoreCase(rootElement.getName()))
			{
				JQModule module= moduleStack.peek();
				
				module.addData((JQModuleData)configStack.pop());
				
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
	
	private Stack<JQModuleConfig> configStack;
	
	
	


}
