package elementRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Manage Pages")
	WebElement manageExpenseTab;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'])[2]")
	WebElement manageExpenseArrow;

	public void navigateToManageExpenseTab() {
		gu.clickTab(manageExpenseArrow);
	}

	public String verifyBackgroundColourOfManageExpenseTab() {
		return gu.generalStyleProprties(manageExpenseArrow, "background-color");
	}
	public String verifyTextOfManagePagesTab() {
		 String text=gu.getElementText(manageExpenseArrow);
		return gu.getElementText(manageExpenseArrow);
	}

}
