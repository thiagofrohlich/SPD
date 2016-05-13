package br.com.spd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class PropertiesUtilImpl implements PropertiesUtil {
	
	private Properties properties;
	
	public PropertiesUtilImpl() throws IOException {
		InputStream inputStream = null;
		try {
			properties = new Properties();
			String propertiesFileName = "msg.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
			
			if(inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException("Properties file '" + propertiesFileName + "' not found.");
			}
			
		} catch(Exception e) {
			throw e;
		} finally {
			if(inputStream != null) {
				inputStream.close();
			}
		}
		
	}

	@Override
	public String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}
	
}
