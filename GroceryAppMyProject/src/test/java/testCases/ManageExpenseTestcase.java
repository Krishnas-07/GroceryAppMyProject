package testCases;

import org.testng.annotations.Test;

import elementRepositary.LoginPage;
import elementRepositary.ManageExpense;

public class ManageExpenseTestcase extends BaseClass{
	LoginPage lp;
	ManageExpense me;
	
  @Test
  public void verifyUserCanAddExpenseCategory() {
	  lp = new LoginPage(driver);
	  lp.performLogin("admin", "admin");
	  me=new ManageExpense(driver);
	  me.clickManageExpense();
	  me.clickExpeneseCategory();
	  me.clickNewButton();
	  me.enterTitle();
	  me.clickSave();
	  
	  

	  
	  
  }
}
