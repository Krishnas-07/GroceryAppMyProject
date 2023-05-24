package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.LoginPage;
import elementRepositary.ManageContent;
import utilities.ExcelReadUtils;

public class ManageContentTestcases extends BaseClass {
	LoginPage lp;
	ManageContent mc;

	@Test
	public void verifyImagesCanBeUploaded() throws AWTException, InterruptedException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
		mc = new ManageContent(driver);
		mc.navigateToManageContent();
		mc.navigateToManagePages();
		mc.editInTable();
		mc.insertPicture();
		mc.clickSubmit();
		String actual = mc.alertMsg();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);
	}

}
