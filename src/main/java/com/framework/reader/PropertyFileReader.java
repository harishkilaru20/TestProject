
package com.framework.reader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
public class PropertyFileReader {
	
	public Properties prop;
	public FileInputStream file;
	public FileOutputStream fileOut;
	public String path;
		 public PropertyFileReader(String path) {
			
			try {
			       this.path=path;
			 	   prop = new Properties();

			}
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	 	 public String readingData(String key) throws IOException{
			  file = new FileInputStream(path);
			  prop.load(file);
	 		  String out=prop.getProperty(key);
	 		  return out;
		 
		  }
		 
		  public void writeData(String key,String data) throws IOException{
			  file = new FileInputStream(path);
			  fileOut = new FileOutputStream(path);
	   
		      // set the value to key
		      prop.setProperty(key, data);
		    
		      // save properties
		       prop.store(fileOut, null);
		    
		    
		   }
	
		 @Test
		public void test() throws IOException{
			
		PropertyFileReader prop1 =  new PropertyFileReader(System.getProperty("user.dir")+"/src/main/resources/configfile/Environment.properties");
		prop1.readingData("QA");
		
		}
	
	
	
	
	
}
