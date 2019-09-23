package com.egp.qa.helper.resource;

import org.apache.log4j.Logger;

import com.egp.qa.helper.logger.LoggerHelper;



public class ResourceHelper {
	
	private static Logger log = LoggerHelper.getLogger(ResourceHelper.class);
	
	public static String getResourcePath(String path) {
		String basePath = System.getProperty("user.dir");
		System.out.println("Inside ResourceHelper class basepath+path -->> "+basePath +""+ path);
		//log.info("Inside ResourceHelper class basepath+path -->> "+basePath +""+ path);
		return basePath +"/"+ path;
	}
	
	/*public static void main(String[] args) {
		String path = ResourceHelper.getResourcePath("/src/main/resources/configfile/log4j.properties");
		System.out.println(path);
	}*/
}
