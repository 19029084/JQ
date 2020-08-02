package com.jq.entity;

import com.jq.entity.JQPropertyOption;
import com.jq.entity.JQPropertyType;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

import com.jq.api.JQPropertyBase;

import lombok.Data;

@Data
public class JQProperty extends JQObject
{

	public JQProperty()
	{
		propertyType = new JQPropertyType();
		propertyType.setType("text");
		base = new JQPropertyBase();
	}
	
	public JQProperty(JQPropertyBase base)
	{
		propertyType = new JQPropertyType();
		propertyType.setType("text");	
		
		this.base=base;			
	}

	public void setId(int id)
	{
		this.base.setId(id);
	}


	public int getId()
	{
		return base.getId();
	}


	public void setName(String name)
	{
		this.base.setName(name);
	}


	public String getName()
	{
		return base.getName();
	}
	
	public String getValue()
	{
		return base.getValue()==null?"":base.getValue();		
	}
	
	public void setValue(String value)
	{
		this.base.setValue(value);		
	}
	public void setType(String type)
	{
		propertyType.setType(type);
	}
	public String getType()
	{
		return propertyType.getType();
	}	
	public void setPropertyType(JQPropertyType propertyType)
	{
		this.propertyType = propertyType;
	}

	public JQPropertyType getPropertyType()
	{
		return this.propertyType;
	}	
	
	
	public void setRef(String ref)
	{
		this.ref=ref;
	}
	
	public String getRef()
	{
		return this.ref;
	}
	
	public void addOption(JQPropertyOption option)
	{
		
		if(options==null)
		{
			options = new ArrayList<JQPropertyOption>();
		}
	
		options.add(option);
	}	

	public void setOptions(List<JQPropertyOption> options)
	{
		this.options = options;
	}
	
	public List<JQPropertyOption> getOptions()
	{
		return options;
	}	
	
	//public JQPropertyValue toBase()
	//{
	//	JQPropertyValue pv = new JQPropertyValue();
	//	pv.setName(name);
	//	pv.setValue(value);
		
	//	return pv;
		
	//}
	
	protected int findReference()
	{
		return 0;
	}

	public String getDescription()
	{
		return base.getDescription();
	}
	
	
	public String getStatus()
	{
		return base.getStatus();
	}
	
	
	public String getCode()
	{
		return base.getCode();
	}
	
	
		public String getSortKey()
	{
		return base.getSortKey();
	}
	
	
	
	public void toBase(Map<String,Object> output, boolean explore)
	{
		output.put("name",base.getName());
		output.put("value",base.getValue());
		output.put("type",getType());
		output.put("code",base.getCode());
		output.put("sortKey",base.getSortKey());		
		output.put("status",base.getStatus());
		output.put("description",base.getDescription());
		output.put("numOfReference",findReference());
		
		if(explore)
		{
			List< Map<String,Object> > optionList = new ArrayList< Map<String,Object> >();
			List<JQPropertyOption> options = getOptions();
			if(options != null)
			{
				for(int i=0;i<options.size();i++)
				{
					Map<String,Object> optionMap = new HashMap<String,Object>();
					
					JQPropertyOption op = options.get(i);
					
					op.toBase(optionMap,explore);
					
					optionList.add(optionMap);
				}
			}
			output.put("numOfOption",optionList.size());
			output.put("options",optionList);
		}
	
	}
	
/*	public String getSortKey()
	{
		return this.sortKey;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getStatus()
	{
		return status;
	}
*/	
	private JQPropertyType propertyType;
	
	private String ref;

	private List<JQPropertyOption> options;
	
	private JQPropertyBase base;
	
	
	
	
	

	



}
