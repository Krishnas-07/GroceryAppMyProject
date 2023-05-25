package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.LoginPage;
import elementRepositary.ManageExpense;
import utilities.ExcelReadUtils;

public class ManageExpenseTestcase extends BaseClass {
	LoginPage lp;
	ManageExpense me;

	@Test(enabled = false)
	public void verifyUserCanAddExpenseCategory() {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
		me = new ManageExpense(driver);
		me.clickManageExpense();
		me.clickExpeneseCategory();
		me.clickNewButton();
		me.enterTitle();
		me.clickSave();
		boolean actual = me.verifyAddElementPresence();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);

	}

	@Test(enabled = false)
	public void verifySearchButton() {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
		me = new ManageExpense(driver);
		me.clickManageExpense();
		me.listExpensePage();
		me.clickSearch();
		me.userSelection();
		me.clickSearchButton();
		boolean actual = me.checkSearchResult();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);

	}

	@Test(enabled = true,retryAnalyzer = RetryAnalyzer.class)

	public void verifyTheTextInShowDetailsButton() {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
		me = new ManageExpense(driver);
		me.clickManageExpense();
		me.listExpensePage();
		me.tableElement();
		me.clickShowDetails();
		String actual = me.text();
		String expected = "Expense Category : IceCreams\n"
				+ "Order Id : 6\n"
				+ "Purchase Id : 6\n"
				+ "Remarks : *****(5 stars)\n"
				+ "File : 1684678697_760ded3eeb5143a63222.jpg";
		Assert.assertEquals(actual, expected, Constants.errorMsgAssertion);
	}

}
