package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class AccountPage extends PageObjectBase{

	@CacheLookup
	@FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']//div/strong[position()=1]")
	private WebElement accountGreeting;

	@CacheLookup
	@FindBy(xpath = "//strong[@class='ng-binding'][position()=2]")
	private WebElement accountBalance;

	@CacheLookup
	@FindBy(xpath = "//button[@class='btn logout']")
	private WebElement logoutButton;

	public AccountPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String accountGreeting() {
		String greeting = accountGreeting.getText();
		System.out.println(greeting);

		return greeting;

	}

	public AccountPage returnAccountBalance() {
		String balance = accountBalance.getText();
		System.out.println(balance);

		return this;
	}

	public CustomerLoginPage clickLogoutButton() {
		elementControl.clickElement(logoutButton);

		return new CustomerLoginPage(getDriver(), getRelativeUrl());
	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
