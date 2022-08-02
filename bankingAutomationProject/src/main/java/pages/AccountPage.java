package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import framework.PageObjectBase;

public class AccountPage extends PageObjectBase{

	@CacheLookup
	@FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']//div/strong[position()=1]")
	private WebElement accountGreeting;

	@CacheLookup
	@FindBy(xpath = "//div[@ng-hide='noAccount'][position()=1]")
	private WebElement accountBalance;

	@CacheLookup
	@FindBy(xpath = "//button[@class='btn logout']")
	private WebElement logoutButton;

	@CacheLookup
	@FindBy(xpath = "//select")
	private WebElement selectAccount;

	@CacheLookup
	@FindBy(xpath = "//button[@ng-click='deposit()']")
	private WebElement depositOption;

	@CacheLookup
	@FindBy(xpath = "//select/option[position()=2]")
	private WebElement poundAccount;

	@CacheLookup
	@FindBy(xpath = "//div/input")
	private WebElement inputDepositAmomunt;

	@CacheLookup
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@CacheLookup
	@FindBy(xpath = "//div/span[@ng-show='message']")
	private WebElement transactionMessage;

	public AccountPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String accountGreeting() {
		String greeting = accountGreeting.getText();
		System.out.println(greeting);

		return greeting;
	}

	public AccountPage returnAccountBalance() {
		System.out.println(accountGreeting.getText() + " - (" + accountBalance.getText() + ")");

		return this;
	}

	public AccountPage selectAccount(int i) {
		new Select(selectAccount);
		WebElement account = getDriver().findElement(By.xpath("//option[position()=" + i + "]"));
		account.click();

		return this;
	}

	public CustomerLoginPage clickLogoutButton() {
		elementControl.clickElement(logoutButton);

		return new CustomerLoginPage(getDriver(), getRelativeUrl());
	}

	public AccountPage selectPoundAccount() {
		elementControl.clickElement(poundAccount);

		return this;
	}

	public AccountPage selectDepositOption() {
		elementControl.clickElement(depositOption);

		return this;
	}

	public AccountPage inputDeposit(String amount) {
		elementControl.setText(inputDepositAmomunt, amount);

		return this;
	}

	public AccountPage clickSubmitButton() {
		elementControl.clickElement(submitButton);

		return this;
	}

	public String retrieveTransactionMessage() {
		String actualMessage = transactionMessage.getText();

		return actualMessage;
	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
