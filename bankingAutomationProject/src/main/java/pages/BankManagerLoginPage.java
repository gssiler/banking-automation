package pages;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class BankManagerLoginPage extends PageObjectBase{

	public BankManagerLoginPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
