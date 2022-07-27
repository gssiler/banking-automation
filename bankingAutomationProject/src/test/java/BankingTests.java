import org.testng.annotations.Test;

import foundation.xyzBankingTestBase;
import pages.LoginPage;

public class BankingTests extends xyzBankingTestBase{
	@Test
	public void canLogInToAccount() {

		new LoginPage(getDriver(), getBaseUrl())
		.navigate()

	}
}
