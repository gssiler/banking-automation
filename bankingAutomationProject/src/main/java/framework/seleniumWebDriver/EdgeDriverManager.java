package framework.seleniumWebDriver;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		System.setProperty("webdriver.edge.driver", "target/test-classes/webDrivers/msedgedriver");
		this.setDriver(new EdgeDriver());
	}
}