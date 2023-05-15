package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepositary.LoginPage;
import elementRepositary.ManageCategory;

public class ManageCategoryTestcases extends BaseClass {
	LoginPage lp;
	ManageCategory mc;

	@Test
	public void verifyDeleteButtonInTheCategoryTable() {
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		mc = new ManageCategory(driver);
		mc.navigatetoManageCategoryTab();
		mc.selectCategory();
		mc.activeButton();
		String actual = mc.alertText();
		// System.out.println(actual);
		String expected = "Category Status Changed Successfully";
		Assert.assertEquals(actual, expected, "Actual and Expected result not matching");

	}
}
