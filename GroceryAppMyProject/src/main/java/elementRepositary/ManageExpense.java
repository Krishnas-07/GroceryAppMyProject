package elementRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;



public class ManageExpense {

GeneralUtilities gu=new GeneralUtilities();
WebDriver driver;
public  ManageExpense(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(partialLinkText = "Manage Expense")
WebElement manageExpenseTab;
@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category'])[1]")
WebElement expenseCategory;
@FindBy(xpath="(//a[@class='btn btn-rounded btn-danger'])[1]")
WebElement newButtonElement;
@FindBy(id="name")
WebElement titleName;
@FindBy(xpath="//i[@class='fa fa-save']")
WebElement saveButton;
public void clickManageExpense() {
	gu.clickTab(manageExpenseTab);
}
public void clickExpeneseCategory() {
	gu.clickTab(expenseCategory);
}
public void clickNewButton() {
	gu.clickTab(newButtonElement);
}
public void enterTitle() {
	gu.addText(titleName, "choclates");
}
public void clickSave() {
	gu.clickTab(saveButton);
}
public  void verificationInTable() {
	int row=gu.clickdynamicTable(driver, "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "choclates");
 String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(row+1)+"]//td[1]";
}

}
