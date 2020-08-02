package com.jq.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.jq.entity.JQObject;

import java.util.List;

@NoArgsConstructor
@Data
public class JQPropertyOptionBase extends JQObject
{

	protected String value;
	
	protected String code;
	
	protected String sortKey;
	
	protected List<JQPropertyOptionBase> children;
	
	

}
