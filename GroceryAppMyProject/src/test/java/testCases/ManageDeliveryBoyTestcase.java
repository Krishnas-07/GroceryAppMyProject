package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.LoginPage;
import elementRepositary.ManageDeliveryBoy;
import utilities.ExcelReadUtils;

public class ManageDeliveryBoyTestcase extends BaseClass {
	LoginPage lp;
	ManageDeliveryBoy mdb;

	@Test(enabled = false)
	public void verifyTheHeadingTextOfEditDeliveryBoyPage() {
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");

		mdb = new ManageDeliveryBoy(driver);
		mdb.navigatetoManageDeliveryBoyTab();
		mdb.clickEditButton();
		String actual = mdb.editPageTile();
		String expected = "Enter Delivery Boy Informations";
		Assert.assertEquals(actual, expected, "Actual and expected result not matching");

	}

	@Test(enabled = false)
	public void verifyDeleteIconButton() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
		mdb = new ManageDeliveryBoy(driver);
		mdb.navigatetoManageDeliveryBoyTab();
		mdb.clickDeleteButton();
		mdb.alertmsgClick();
		String expected = "Alert!";
		String actual = mdb.getAlertMsgText();

		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);

	}
	@Test
	public void verifyUserCanAddNewDeliveryBoyDetails() {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
		mdb = new ManageDeliveryBoy(driver);
		mdb.navigatetoManageDeliveryBoyTab();
		mdb.clickNewButton();
		mdb.enterName();
		mdb.enterEmai();
		mdb.enterUsername();
		mdb.enterPassword();
		mdb.clickSave();
		boolean actual=mdb.checkNewlyAddedUser();
		boolean expected=true;
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);
	}
	

}
