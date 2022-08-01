package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class BankManagerLoginPage extends PageObjectBase{

	@CacheLookup
	@FindBy(css = "[ng-click='addCust()']")
	private WebElement addCustomer;

	@CacheLookup
	@FindBy(css = "[ng-model='fName']")
	private WebElement firstNameField;

	@CacheLookup
	@FindBy(css = "[ng-model='lName']")
	private WebElement lastNameField;

	@CacheLookup
	@FindBy(css = "[ng-model='postCd']")
	private WebElement zipCodeField;

	@CacheLookup
	@FindBy(css = "[type='submit']")
	private WebElement submitButton;

	@CacheLookup
	@FindBy(css = "[ng-click='openAccount()']")
	private WebElement openAcct;

	@CacheLookup
	@FindBy(css = "#userSelect")
	private WebElement selectCustomer;

	@CacheLookup
	@FindBy(css = "#currency")
	private WebElement currency;

	@CacheLookup
	@FindBy(css = "[type='submit']")
	private WebElement processButton;

	@CacheLookup
	@FindBy(css = "[ng-click='showCust()']")
	private WebElement showCustomer;

	@CacheLookup
	@FindBy(xpath = "//div[@class='ng-scope']//tr[position()=6]")
	private WebElement newAccountInfo;

	@CacheLookup
	@FindBy(css = "ng-click='home()'")
	private WebElement homeButton;

	@CacheLookup
	@FindBy(xpath = "//input[@ng-model='searchCustomer']")
	private WebElement searchCustomer;

	@CacheLookup
	@FindBy(xpath = "//tbody")
	private WebElement displaySearchResults;

	public BankManagerLoginPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public BankManagerLoginPage clickAddCustomerButton() {
		elementControl.clickElement(addCustomer);

		return this;
	}

	public BankManagerLoginPage enterFirstName(String firstName) {
		elementControl.setText(firstNameField, firstName);

		return this;
	}

	public BankManagerLoginPage enterLastName(String lastName) {
		elementControl.setText(lastNameField, lastName);

		return this;
	}

	public BankManagerLoginPage enterZipCode(String zipCode) {
		elementControl.setText(zipCodeField, zipCode);

		return this;
	}

	public BankManagerLoginPage submitNewAccount() {
		elementControl.clickElement(submitButton);

		return this;
	}

	public BankManagerLoginPage acceptAlert() {
		String alert = elementControl.getTextFromAlert();
		System.out.println(alert);
		elementControl.acceptAlert();

		return this;
	}

	public BankManagerLoginPage clickOpenAccountButton() {
		elementControl.clickElement(openAcct);

		return this;
	}

	public BankManagerLoginPage selectCustomerByFullName(String fullName) {
		elementControl.setByVisibleText(selectCustomer, fullName);

		return this;
	}

	public BankManagerLoginPage selectCurrencyType(String currencyType) {
		elementControl.setByVisibleText(currency, currencyType);

		return this;
	}

	public BankManagerLoginPage clickProcessButton() {
		elementControl.clickElement(processButton);

		return this;
	}

	public BankManagerLoginPage clickCustomersButton() {
		elementControl.clickElement(showCustomer);

		return this;
	}

	public String returnAccountInfo(String name) {

		int i;
		String acctInfo;

		if (name == "Hermoine Granger") {
			i = 1;
			acctInfo = getDriver().findElement(By.xpath("//div[@class='ng-scope']//tr[position()=" + i + "]")).getText();
			System.out.println(acctInfo);
		} else if (name == "Harry Potter") {
			i = 2;
			acctInfo = getDriver().findElement(By.xpath("//div[@class='ng-scope']//tr[position()=" + i + "]")).getText();
			System.out.println(acctInfo);
		}else if (name == "Ron Weasly") {
			i = 3;
			acctInfo = getDriver().findElement(By.xpath("//div[@class='ng-scope']//tr[position()=" + i + "]")).getText();
			System.out.println(acctInfo);
		}else if (name == "Albus Dumbledore") {
			i = 4;
			acctInfo = getDriver().findElement(By.xpath("//div[@class='ng-scope']//tr[position()=" + i + "]")).getText();
			System.out.println(acctInfo);
		}else if (name == "Neville Longbottom") {
			i = 5;
			acctInfo = getDriver().findElement(By.xpath("//div[@class='ng-scope']//tr[position()=" + i + "]")).getText();
			System.out.println(acctInfo);
		}else {
			i = 6;
			acctInfo = getDriver().findElement(By.xpath("//div[@class='ng-scope']//tr[position()=" + i + "]")).getText();
			System.out.println(acctInfo);
		}
		return acctInfo;
	}

	public BankManagerLoginPage deleteAccount(String name) {

		int i;

		if (name == "Hermoine Granger") {
			i = 1;
			WebElement position = getDriver().findElement(By.xpath("//tr[@class='ng-scope'][position()=" + i + "]//td/button"));
			position.click();
		} else if (name == "Harry Potter") {
			i = 2;
			WebElement position = getDriver().findElement(By.xpath("//tr[@class='ng-scope'][position()=" + i + "]//td/button"));
			position.click();
		}else if (name == "Ron Weasly") {
			i = 3;
			WebElement position = getDriver().findElement(By.xpath("//tr[@class='ng-scope'][position()=" + i + "]//td/button"));
			position.click();
		}else if (name == "Albus Dumbledore") {
			i = 4;
			WebElement position = getDriver().findElement(By.xpath("//tr[@class='ng-scope'][position()=" + i + "]//td/button"));
			position.click();
		}else if (name == "Neville Longbottom") {
			i = 5;
			WebElement position = getDriver().findElement(By.xpath("//tr[@class='ng-scope'][position()=" + i + "]//td/button"));
			position.click();
		}
		return this;
	}

	public HomePage clickHomeButton() {
		elementControl.clickElement(homeButton);

		return new HomePage(getDriver(), getRelativeUrl());
	}

	public BankManagerLoginPage searchCustomerName(String name) {
		elementControl.setText(searchCustomer, name);

		return this;
	}

	public String displaySearchResults() {
		String searchResults = displaySearchResults.getText();
		System.out.println(searchResults);

		return searchResults;

	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
