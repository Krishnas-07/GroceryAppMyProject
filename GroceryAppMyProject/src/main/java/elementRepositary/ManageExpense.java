package elementRepositary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageExpense {

	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageExpense(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(partialLinkText = "Manage Expense")
	WebElement manageExpenseTab;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category'])[1]")
	WebElement expenseCategory;
	@FindBy(xpath = "(//a[@class='btn btn-rounded btn-danger'])[1]")
	WebElement newButtonElement;
	@FindBy(id = "name")
	WebElement titleName;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement saveButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']")
	WebElement manageExpense;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement addSearch;
	@FindBy(id = "um")
	WebElement user;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButton;
	@FindBy(xpath="(//div[@class='action-buttons'])[2]")
	WebElement showDetails;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[4]//td")
	WebElement showDetailsText;

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

	public boolean verifyAddElementPresence() {
		List<WebElement> checkPresence = driver.findElements(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
		boolean check = false;
		for (WebElement checkEachValue : checkPresence) {
			if (checkEachValue.getText().contains("choclates")) {
				check = true;
				break;
			}
		}
		return check;

	}

	public void listExpensePage() {
		gu.clickTab(manageExpense);
	}

	public void clickSearch() {
		gu.clickTab(addSearch);
	}

	public void userSelection() {
		gu.selectFromDropDown(user, 3);
	}

	public void clickSearchButton() {
		gu.clickTab(searchButton);
	}

	public boolean checkSearchResult() {
		List<WebElement> checkSearch = driver.findElements(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
		boolean check = false;
		for (WebElement checkEachRow : checkSearch) {
			if (checkEachRow.getText().contains("NewFruit (Admin2-AD)")) {
				check = true;
				break;
			}
		}
		return check;
	}
	public void tableElement() {
		int rowNumber=gu.clickdynamicTable(driver, "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "NewFruit001 (Admin-AD)");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(rowNumber+1)+"]//td[1]";
		WebElement arrowButton=driver.findElement(By.xpath(locator));
		 gu.clickTab(arrowButton);
		
	}
	public void clickShowDetails() {
		gu.clickTab(showDetails);
	}
	public String text() {
		return gu.getElementText(showDetailsText);
	}

}
