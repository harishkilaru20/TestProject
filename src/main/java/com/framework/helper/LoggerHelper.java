/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 */
package com.framework.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
	
	private static boolean root = false;
	
	public static Logger getLogger(Class<?> clas) {
		if(root)
			return Logger.getLogger(clas);
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/resources/configfile/log4j.properties");
		root = true;
		return Logger.getLogger(clas);
	}
	
	

}
