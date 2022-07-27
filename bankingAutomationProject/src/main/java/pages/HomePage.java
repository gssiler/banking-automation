package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class HomePage extends PageObjectBase{
	
	@CacheLookup
	@FindBy(linkText = "Customer Login")
	private WebElement customerLoginBtn;
	
	@CacheLookup
	@FindBy(linkText = "Bank Manager Login")
	private WebElement bankManagerLoginBtn;

	public HomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public HomePage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}
	
	public CustomerLoginPage clickCustomerLoginButton() {
		elementControl.clickElement(customerLoginBtn);
		
		return new CustomerLoginPage (getDriver(), getBaseUrl());
	}

	@Override
	protected String getRelativeUrl() {
		return "/login";
	}

}
