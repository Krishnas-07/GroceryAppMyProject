package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepositary.LoginPage;
import elementRepositary.PushNotification;
import utilities.ExcelReadUtils;

public class PushNotifyTestCases extends BaseClass {

	LoginPage lp;
	PushNotification pn;

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verify() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0), ExcelReadUtils.read(1, 1));
		pn = new PushNotification(driver);
		pn.navigateToPushNotificationTab();
		pn.enterTitle();
		pn.enterDescription();
		pn.clickSubmit();
		String actual = pn.alertText();

		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "Actual and expected result not matching");
	}
}
