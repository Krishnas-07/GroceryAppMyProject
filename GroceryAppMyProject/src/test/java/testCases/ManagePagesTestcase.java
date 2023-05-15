package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.HomePage;
import elementRepositary.LoginPage;
import elementRepositary.ManagePages;

public class ManagePagesTestcase extends BaseClass{
	LoginPage lp;
	HomePage hp;
	ManagePages mp;
	
  @Test
  public void verifyTextOfSearchButtonInManageExpenseTabinManagePageTab() {
	  lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		hp = new HomePage(driver);
		hp.navigateToManageExpenseTab();
		mp=new ManagePages(driver);
		String actual=mp.verifyTextOfSearchButtonInManageExpenseTab();
		String expected="Search";
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);
  }
}
