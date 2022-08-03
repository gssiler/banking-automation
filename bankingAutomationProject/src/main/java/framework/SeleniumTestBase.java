package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.seleniumWebDriver.DriverManager;
import framework.seleniumWebDriver.DriverManagerFactory;

public abstract class SeleniumTestBase {
	private WebDriver driver;
	private Settings settings;
	private String baseUrl;

	protected SeleniumTestBase(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@BeforeMethod
	public void setup() {
		this.settings = new Settings(new TextConfigurationProvider());
		createDriver();
		setTestContext();
	}

	private void setTestContext() {
		TestContext.setAttribute(TestContextAttributes.WEB_DRIVER, getDriver());
		TestContext.setAttribute(TestContextAttributes.SETTINGS, this.settings);
		TestContext.setAttribute(TestContextAttributes.BASE_URL, this.baseUrl);
	}

	@AfterMethod
	public void cleanup(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE)
		{
			return;
		}

		if(this.driver != null) {
			this.driver.quit();
		}
	}

	protected String getBaseUrl() {
		return this.baseUrl;
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	private void createDriver() {
		String browserType = this.settings.getBrowserType();
		DriverManager manager = DriverManagerFactory.getManager(browserType);
		manager.createDriver();
		this.driver = manager.getDriver();

		int implicitWaitSecs = this.settings.getImplicitWaitSecs();
		this.driver.manage().timeouts().implicitlyWait(implicitWaitSecs, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
	}
}