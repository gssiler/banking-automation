package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class CustomerLoginPage extends PageObjectBase {

	@CacheLookup
	@FindBy(css = "#userSelect")
	private WebElement selectUser;

	@CacheLookup
	@FindBy(linkText = "Ron Weasly")
	private String ronWeasly;

	@CacheLookup
	@FindBy(css = "[type='submit']")
	private WebElement loginButton;

	public CustomerLoginPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public CustomerLoginPage selectAccount(String name) {
		elementControl.setByVisibleText(selectUser, name);

		return this;
	}

	public AccountPage clickLogin() {
		elementControl.clickElement(loginButton);

		return new AccountPage(getDriver(), getBaseUrl());
	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
