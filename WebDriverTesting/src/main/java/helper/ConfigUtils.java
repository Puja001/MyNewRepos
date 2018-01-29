package helper;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


	public class ConfigUtils {
		
		static Properties prop;
		
		public static Properties loadProperties(String fileName){ 
		   prop = new Properties();
			try{
				
			prop.load(new FileInputStream(("user.dir")+"/resources" + '/'+ fileName));
			}catch(IOException e){
				e.printStackTrace();
			}
			return prop;
		}
		
		public static String getValue(String key){
			return prop.getProperty(key)  ;
			
			
		}
		}


	
	
	/*public class ConfigUtils {


		public static Properties loadProperties(String fileName) throws FileNotFoundException, IOException{

		Properties prop = new Properties();

		prop.load(new FileInputStream( System.getProperty("user.dir")+"resources/"+fileName));

		return prop;

		}*/



