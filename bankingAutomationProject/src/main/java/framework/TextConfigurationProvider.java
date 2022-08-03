package framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class TextConfigurationProvider implements ConfigurationProvider {

	public HashMap<String, String> get(String fileName) {
		InputStream inputStream = null;
		Properties properties = new Properties();

		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

			if (inputStream == null) {
				throw new RuntimeException(fileName + " was not found in the Resources folder.");
			}

			try {
				properties.load(inputStream);
			} catch (Exception e) {
				throw new RuntimeException("Error reading config file " + fileName);
			}
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				throw new RuntimeException("Error closing config file " + fileName);
			}
		}

		HashMap<String, String> propertyValuesByKey = new HashMap<String, String>();

		for (String key : properties.stringPropertyNames()) {
			String value = properties.getProperty(key);
			propertyValuesByKey.put(key, value);
		}

		return propertyValuesByKey;
	}
}