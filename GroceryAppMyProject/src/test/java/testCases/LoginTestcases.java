package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.LoginPage;
import utilities.ExcelReadUtils;

public class LoginTestcases extends BaseClass {
	LoginPage lp;

	@Test(enabled = true)
	public void verifySignInButtonisClickable() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelReadUtils.read("Sheet1",1, 0));
		lp.enterPassword(ExcelReadUtils.read("Sheet1",1, 1));
		lp.clickSignIn();
		String expected = "Home";
		String actual = lp.homeButtonText();
		Assert.assertEquals(actual, expected, "Not matching actual and expected result");
	}

	@Test(enabled = false)
	public void verifyTextOfSignInButtonInLoginPage() {
		lp = new LoginPage(driver);
		String actual = lp.signInButtonText();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, "Not matching actual and expected Result");

	}

	@Test(enabled = false)
	public void verifyBackgroundColourOfSignInButton() {
		lp = new LoginPage(driver);
		String actual = lp.backgroundColourOfSignInButton();
		String expected = Constants.loginButtonBackGroundColour;
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);

	}

	@Test(enabled = false, dataProvider = "loginSucess", dataProviderClass = DataProviderTestcase.class)
	public void verifyTheAlertMessageforWrongUserDetails(String name, String name1) {
		lp = new LoginPage(driver);
		lp.performLogin(name, name1);
		String actual=lp.alertText();
		System.out.println(actual);
		String expected="×\n"
				+ "Alert!\n"
				+ "Invalid Username/Password";
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);
		

	}

}
