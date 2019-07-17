/**
 * 
 */
package dataProvider;

import factory.ConfigurationFactory;
import factory.ExcelFactory;

/**
 * @author Lenovo
 *
 */
public class DataProvider {

	public static ConfigurationFactory getConfig(){
		
		ConfigurationFactory cf = new ConfigurationFactory();
		
		return cf;
		
	}
	
	public static ExcelFactory getExcel(){
		
		ExcelFactory excel = new ExcelFactory();
		
		return excel;
	}
	
}
