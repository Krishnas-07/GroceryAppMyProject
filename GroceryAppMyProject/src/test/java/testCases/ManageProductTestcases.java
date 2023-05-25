package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.LoginPage;
import elementRepositary.ManageProduct;
import utilities.ExcelReadUtils;

public class ManageProductTestcases extends BaseClass {
	LoginPage lp;
	ManageProduct mp;

	@Test(enabled = false)
	public void verifyTheEditButtonInListProductsTableInManageProductTab() {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelReadUtils.read("Sheet1", 1, 0));
		lp.enterPassword(ExcelReadUtils.read("Sheet1", 1, 1));
		lp.clickSignIn();
		mp = new ManageProduct(driver);
		mp.clickManageProductTab();
		mp.clickEditTab();
		mp.selectCategory();
		boolean actual = mp.selectionCheck();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constants.manageProduct);
	}

	@Test(enabled = true)
	public void verifyUpdateButtonisEnabled() {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1", 1, 0),ExcelReadUtils.read("Sheet1", 1, 1));
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
		Assert.assertEquals(actual1, expected1, Constants.manageProductUpdateButton);

	}
}
