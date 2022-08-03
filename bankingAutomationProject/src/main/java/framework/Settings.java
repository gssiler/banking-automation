package framework;

import java.util.HashMap;

public class Settings {

	private final String CONFIG_FILE_NAME = "config.properties";
	private final String BROWSER_TYPE = "browserType";
	private final String IMPLICIT_WAIT_SECS = "implicitWaitSecs";

	private ConfigurationProvider provider;

	private HashMap<String, String> map;

	public Settings(ConfigurationProvider provider) {
		this.provider = provider;
		this.map = this.provider.get(CONFIG_FILE_NAME);
	}

	public String getBrowserType() {
		return this.map.get(BROWSER_TYPE);
	}

	public int getImplicitWaitSecs() {
		String value = this.map.get(IMPLICIT_WAIT_SECS);

		return Integer.parseInt(value);
	}
}