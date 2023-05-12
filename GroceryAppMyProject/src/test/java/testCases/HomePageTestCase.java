package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepositary.HomePage;
import elementRepositary.LoginPage;

public class HomePageTestCase extends BaseClass {
	LoginPage lp;
	HomePage hp;

	@Test(groups={"Critical"})
	public void verifyBackgroundColourOfMangeExpenseTabInHomePage() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		hp = new HomePage(driver);

		String actual = hp.verifyBackgroundColourOfManageExpenseTab();

		String expected = "rgba(0, 0, 0, 0.1)";
		Assert.assertEquals(actual, expected, "Not matching actual and expected results");
	}

	@Test(groups={"High"})
	public void verifyTextOfManageExpenseTabInHomePage() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		hp = new HomePage(driver);
		String actual = hp.verifyTextOfManagePagesTab();
		String expected = "More info";
		Assert.assertEquals(actual, expected, "Actual and Expected result not matching");
	}

}
