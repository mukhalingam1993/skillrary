package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains all reusable methods to perform operations on 
 * properties file @author user
 * 
 */
public class PropertiesFileUtility {
	private Properties property;
	/**
	 * This method is used to initialize properties file
	 * @param filepath
	 */
	public void propertyFileInialization(String filePath) {
			FileInputStream fis=null;
			try 
			{
				fis=new FileInputStream(filePath);
				
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
			property= new Properties();
			
			try 
			{
				property.load(fis);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
	public String featchproperties(String key) {
		
		return property.getProperty(key);
	}
	}


