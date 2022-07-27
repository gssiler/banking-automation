import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.xyzBankingTestBase;
import pages.CustomerLoginPage;
import pages.HomePage;

public class BankingTests extends xyzBankingTestBase{
	@Test
	public void canLogIntoCustomerAccount() {

		String name = "Ron Weasly";
		String expectedGreeting = "Welcome " + name + " !!";

		String actualGreeting = new HomePage(getDriver(), getBaseUrl())
				.navigate()
				.clickCustomerLoginButton()
				.selectAccount(name)
				.clickLogin()
				.accountGreeting();

		assertEquals(expectedGreeting, actualGreeting, "Expected greeting does not match the actual greeting.");


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
			.selectCustomerAccount(i++)
			.clickLogin()
			.returnAccountBalance()
			.clickLogoutButton();
			++actualAccounts;
		}

		assertEquals(expectedAccounts, actualAccounts, "Number of expected account balances [5] were not returned.");
	}



}
