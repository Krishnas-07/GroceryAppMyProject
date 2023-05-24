package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.LoginPage;
import elementRepositary.ManageUser;
import utilities.ExcelReadUtils;

public class ManageUserTestcases extends BaseClass {
	LoginPage lp;
	ManageUser mu;

	@Test(enabled = true)
	public void verifyStatusOfUserInManageUserTable() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
		mu = new ManageUser(driver);
		mu.navigateToManageUserTab();
		mu.verifyStatusOfUserInManageUserTab();
		String actual = mu.alertText();
		// System.out.println(actual);
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "Not matching actual and expected result");

	}

	@Test(enabled = true)
	public void verifyDeleteIconInManageUserTable() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
		mu = new ManageUser(driver);
		mu.navigateToManageUserTab();
		mu.clickDeleteIcon();
		mu.verifyAlert();
		mu.deleteResult();
		String actual = mu.serachResult();
		String expected = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);
	}

	@Test(enabled = true)
	public void verifyPassword() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
		mu = new ManageUser(driver);
		mu.navigateToManageUserTab();
		Thread.sleep(2000);
		String actual = mu.viewPassword();
		String expected = "Password : Qwerty@123";
		Assert.assertEquals(actual, expected, "Not matching actual and expected result");
	}

}
