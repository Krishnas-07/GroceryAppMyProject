package elementRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageExpense {
WebDriver driver;
GeneralUtilities gu=new GeneralUtilities();
public  ManageExpense(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(xpath="//a[@class='nav-link active']")
WebElement manageExpenseTab;
@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category'])[1]")
WebElement expenseCategory;
}
