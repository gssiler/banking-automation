package pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class CustomerLoginPage extends PageObjectBase {

	public CustomerLoginPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
