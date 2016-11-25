package com.adyen;

import com.adyen.enums.Environment;
import org.junit.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTest {

	
	protected static Map<String,String> configurations;
	
	/**
	 * Load configuration values
	 */
	@BeforeClass
	public static void setUp() {
		try {
			File file = new File("src/test/java/com/adyen/config/test.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			configurations = new HashMap<String, String>();
			
			Enumeration<Object> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				configurations.put(key, value);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Client createClientFromConfigurations()
	{
		Client client = new Client(
				configurations.get("username"),
				configurations.get("password"),
				Environment.TEST,
				"My Test Application"
		);
		return client;
	}
	
	public String getMerchantAccount()
	{
		return configurations.get("merchantAccount");
	}

}
