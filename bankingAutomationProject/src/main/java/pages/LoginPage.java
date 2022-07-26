package pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class LoginPage extends PageObjectBase{

	public LoginPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@Override
	protected String getRelativeUrl() {
		return "login";
	}

}
