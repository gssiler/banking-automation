package framework.seleniumWebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

	private static final String DRIVER_FILE_PATH = "target/test-classes/webdrivers/chromedriver";

	@Override
	public void createDriver() {

		ChromeOptions options = buildOptions();
		ChromeDriver driver = new ChromeDriver(options);

		this.setDriver(driver);
	}

	private ChromeOptions buildOptions() {
		System.setProperty("webdriver.chrome.driver", DRIVER_FILE_PATH);

		ChromeOptions options = new ChromeOptions();

		return options;
	}
}