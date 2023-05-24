package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.LoginPage;
import elementRepositary.ManageCategory;
import utilities.ExcelReadUtils;

public class ManageCategoryTestcases extends BaseClass {
	LoginPage lp;
	ManageCategory mc;

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyDeleteButtonInTheCategoryTable() {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1", 1, 0),ExcelReadUtils.read("Sheet1", 1, 0));
		mc = new ManageCategory(driver);
		mc.navigatetoManageCategoryTab();
		mc.selectCategory();
		mc.activeButton();
		String actual = mc.alertText();
		// System.out.println(actual);
		String expected = Constants.manageTabExpectedResult;
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);

	}
}
