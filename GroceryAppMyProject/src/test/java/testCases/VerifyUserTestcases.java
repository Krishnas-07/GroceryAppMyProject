package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.LoginPage;
import elementRepositary.VerifyUser;
import utilities.ExcelReadUtils;

public class VerifyUserTestcases extends BaseClass {
	LoginPage lp;
	VerifyUser vu;

	@Test
	public void verifyTheSearchTabInVerifyUserTab() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
		vu = new VerifyUser(driver);
		vu.navigateToVerifyUser();
		// vu.selectingUser();
		// String actual = vu.alertMsgText();
		// System.out.println(actual);
		vu.clickSearhButton();
		vu.enterName();
		vu.clickSearchName();
		String actual = vu.showSearchResult();

		String expected = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);

	}
}
