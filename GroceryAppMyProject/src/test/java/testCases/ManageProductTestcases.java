package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepositary.LoginPage;
import elementRepositary.ManageProduct;

public class ManageProductTestcases extends BaseClass {
	LoginPage lp;
	ManageProduct mp;

	@Test(enabled = false)
	public void verifyTheEditButtonInListProductsTableInManageProductTab() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		mp = new ManageProduct(driver);
		mp.clickManageProductTab();
		mp.clickEditTab();
		mp.selectCategory();
		boolean actual = mp.selectionCheck();
		boolean expected = true;
		Assert.assertEquals(actual, expected, "There is no dropdown to select");
	}

	@Test(enabled = true)
	public void verifyUpdateButtonisEnabled() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		mp = new ManageProduct(driver);
		mp.clickManageProductTab();
		mp.clickEditTab();
		mp.editProductType();
		mp.editPriceType();
		mp.addWeightUnit();
		mp.addWeightValue();
		mp.addPrice();
		mp.addMRP();
		mp.addStockAvaialability();
		mp.addMaximumQuantity();
		mp.selectSubCategory();
		//mp.clickUpdateButton();
		boolean actual1 = mp.enableCheck();
		boolean expected1 = true;
		Assert.assertEquals(actual1, expected1, "Category feild is not abled to select");

	}
}
