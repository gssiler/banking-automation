package framework.seleniumWebDriver;

public class DriverManagerFactory {

	public static DriverManager getManager(String browserType) {

		if(browserType.equals(BrowserTypes.CHROME)) {
			return new ChromeDriverManager();
		}
		if(browserType.equals(BrowserTypes.EDGE)) {
			return new EdgeDriverManager();
		}

		throw new RuntimeException(browserType + " is not a supported browser.");
	}
}