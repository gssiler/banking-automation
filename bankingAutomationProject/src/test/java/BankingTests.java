import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.xyzBankingTestBase;
import pages.HomePage;

public class BankingTests extends xyzBankingTestBase{
	@Test
	public void canLogIntoCustomerAccount() {

		String expectedAlert = "Welcome Harry Potter !!";
		//WebElement ronWeasly;

		String actualGreeting = new HomePage(getDriver(), getBaseUrl())
				.navigate()
				.clickCustomerLoginButton()
				.selectAccount("Harry Potter")
				.clickLogin()
				.accountGreeting();

		assertEquals(expectedAlert, actualGreeting, "Expected greeting does not match the actual greeting.");


	}
}
