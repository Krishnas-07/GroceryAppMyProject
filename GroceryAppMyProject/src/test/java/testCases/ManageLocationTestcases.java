package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.LoginPage;
import elementRepositary.ManageLocation;

public class ManageLocationTestcases extends BaseClass {
	LoginPage lp;
	ManageLocation ml;

	@Test
	public void verifyTheSearchButtonProvidedInTheManageLocationTab() {
		lp = new LoginPage(driver);

		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		ml = new ManageLocation(driver);
		ml.clickManageLocationTab();
		ml.clickSearchButton();
		ml.selectCountry();
		ml.selectLocation();
		ml.clickSearchIcon();
		boolean actual = ml.checkLocation();

		boolean expected = true;
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);
	}
}
