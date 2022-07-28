package pages;

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
	@FindBy(xpath = "//select[@id='currency']/option[position()=3]")
	private WebElement pound;

	@CacheLookup
	@FindBy(css = "[type='submit']")
	private WebElement processButton;

	@CacheLookup
	@FindBy(css = "[ng-click='showCust()']")
	private WebElement showCustomer;

	@CacheLookup
	@FindBy(xpath = "//div[@class='ng-scope']//tr[position()=6]")
	private WebElement newAccountInfo;

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

	public BankManagerLoginPage selectCurrencyType() {
		elementControl.setByVisibleText(currency, pound.getText());

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

	public String returnAccountInfo() {
		String acctInfo = newAccountInfo.getText();
		System.out.println(acctInfo);

		return acctInfo;
	}

	@Override
	protected String getRelativeUrl() {
		return null;
	}

}
