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

	public AccountPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String accountGreeting() {
		String actualGreeting = accountGreeting.getText();
		System.out.println(actualGreeting);
		return actualGreeting;

	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
