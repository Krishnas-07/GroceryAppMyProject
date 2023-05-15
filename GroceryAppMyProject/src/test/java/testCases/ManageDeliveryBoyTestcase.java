package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

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

	@Test(enabled = true)
	public void verifyDeleteIconButton() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0), ExcelReadUtils.read(1, 1));
		mdb = new ManageDeliveryBoy(driver);
		mdb.navigatetoManageDeliveryBoyTab();
		mdb.clickDeleteButton();
		mdb.alertmsgClick();
		String expected = "×\n" + "Alert!\n" + "Delivery Boy Informations Deleted Successfully";
		String actual = mdb.getAlertMsgText();

		Assert.assertEquals(actual, expected, "Actual and expected result not matching");

	}

}
