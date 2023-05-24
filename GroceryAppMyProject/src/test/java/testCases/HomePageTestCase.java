package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.HomePage;
import elementRepositary.LoginPage;
import utilities.ExcelReadUtils;

public class HomePageTestCase extends BaseClass {
	LoginPage lp;
	HomePage hp;

	@Test(groups={"Critical"})
	public void verifyBackgroundColourOfMangeExpenseTabInHomePage() {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelReadUtils.read("Sheet1", 1, 0));
		lp.enterPassword(ExcelReadUtils.read("Sheet1", 1, 1));
		lp.clickSignIn();
		hp = new HomePage(driver);

		String actual = hp.verifyBackgroundColourOfManageExpenseTab();

		String expected = Constants.backgroundColour;
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);
	}

	@Test(groups={"High"})
	public void verifyTextOfManageExpenseTabInHomePage() {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelReadUtils.read("Sheet1", 1, 0));
		lp.enterPassword(ExcelReadUtils.read("Sheet1", 1, 1));
		lp.clickSignIn();
		hp = new HomePage(driver);
		String actual = hp.verifyTextOfManagePagesTab();
		String expected = Constants.HomePageExpectedResult;
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);
	}

}
