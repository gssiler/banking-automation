import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

import foundation.xyzBankingTestBase;
import pages.AccountPage;
import pages.CustomerLoginPage;
import pages.HomePage;

public class BankingTests extends xyzBankingTestBase {
	@Test
	public void canLogIntoCustomerAccount() {

		String name = "Ron Weasly";
		String expectedGreeting = "Welcome " + name + " !!";

		String actualGreeting = new HomePage(getDriver(), getBaseUrl()).navigate().clickCustomerLoginButton()
				.selectAccount(name).clickLogin().accountGreeting();

		assertEquals(expectedGreeting, actualGreeting, "The expected greeting does not match the actual greeting.");

	}

	@Test
	public void canReturnAllAccountBalances() {

		int actualAccounts = 0;
		int expectedAccounts = 5;

		new HomePage(getDriver(), getBaseUrl())
		.navigate()
		.clickCustomerLoginButton();

		int i = 1;
		while (i < 6) {
			new CustomerLoginPage(getDriver(), getBaseUrl())
			.selectCustomer(i++)
			.clickLogin();

			int a = 1;
			while (a < 4) {

				new AccountPage(getDriver(), getBaseUrl())
				.returnAccountBalance();

				if (a < 3) {

					new AccountPage(getDriver(), getBaseUrl())
					.selectAccount(++a);
				}

				else {

					new AccountPage(getDriver(), getBaseUrl())
					.clickLogoutButton();
					++a;
					++actualAccounts;
				}
			}
		}

		assertEquals(expectedAccounts, actualAccounts,
				"The number of expected account balances [5] were not returned.");
	}

	@Test
	public void canCreateNewCustomerAccountForRupees() {

		String firstName = "Draco";
		String lastName = "Malfoy";
		String zipCode = "41357";
		String fullName = "Draco Malfoy";
		String currencyType = "Rupee";

		String customerAccount = new HomePage(getDriver(), getBaseUrl()).navigate().clickBankManagerLoginButton()
				.clickAddCustomerButton().enterFirstName(firstName).enterLastName(lastName).enterZipCode(zipCode)
				.submitNewAccount().acceptAlert().clickOpenAccountButton().selectCustomerByFullName(fullName)
				.selectCurrencyType(currencyType).clickProcessButton().acceptAlert().clickCustomersButton()
				.returnAccountInfo(fullName);

		assertNotEquals(customerAccount, null,
				"The new customers account information should be displayed. Please try again.");

	}

	@Test
	public void canDeleteAccount() {

		String name = "Harry Potter";
		String expectedSearchResults = "";

		String actualSearchResults = new HomePage(getDriver(), getBaseUrl()).navigate().clickBankManagerLoginButton()
				.clickCustomersButton().deleteAccount(name).searchCustomerName(name).displaySearchResults();

		assertEquals(actualSearchResults, expectedSearchResults, "An account populated that should not exist.");

	}

}
