package dsAlgo_Utilities;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {
	private static final Properties properties = new Properties();
	private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);

	public ConfigReader() {
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
			if (input == null) {
				throw new FileNotFoundException("config.properties file not found");
			}
			properties.load(input);
			logger.info("Config properties loaded");
		} catch (Exception e) {
			logger.info("Exception in configrReader "+e);
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return properties.getProperty("url");
	}

	public String getUsername() {
		return properties.getProperty("username");
	}

	public String getPassword() {
		return properties.getProperty("password");
	}
	public String getBrowser() {
		return properties.getProperty("browser");
	}
	public String getHomeUrl() {
		return properties.getProperty("Homeurl");
	}
	
	public String getLoginUrl() {
		return properties.getProperty("Loginurl");
	}
	
	public String getRetry() {
		return properties.getProperty("maxRetryCount");
	}
}

