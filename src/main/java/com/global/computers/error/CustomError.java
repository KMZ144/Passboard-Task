package com.global.computers.error;


import java.util.Arrays;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomError extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		// TODO Auto-generated method stub
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
		errorAttributes.put("message", "error with server please try again later");
		errorAttributes.put("details", Arrays.asList(errorAttributes.get("message"),"this is custom error"));
		errorAttributes.remove("error");
		errorAttributes.remove("status");
		errorAttributes.remove("timestamp");
		errorAttributes.remove("path");
		return errorAttributes;
	}
	
	
	

}
