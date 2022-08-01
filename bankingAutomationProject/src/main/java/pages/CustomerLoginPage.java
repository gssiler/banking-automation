package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import framework.PageObjectBase;

public class CustomerLoginPage extends PageObjectBase {

	@CacheLookup
	@FindBy(css = "#userSelect")
	private WebElement selectUser;

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

	public CustomerLoginPage selectCustomer(int i) {

		new Select(selectUser);
		WebElement user = getDriver().findElement(By.cssSelector("[value = '" + i + "']"));
		user.click();

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
