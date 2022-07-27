import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.xyzBankingTestBase;
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
}
