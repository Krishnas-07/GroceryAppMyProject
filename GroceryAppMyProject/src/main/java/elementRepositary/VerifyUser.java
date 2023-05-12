package elementRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class VerifyUser {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public VerifyUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/verify-users'])[1]")
	WebElement verifyUserTab;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;
	@FindBy(linkText = "Search")
	WebElement searchButton;
	@FindBy(id = "un")
	WebElement name;
	@FindBy(xpath = "(//button[@name='Search'])")
	WebElement serachName;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//center")
	WebElement searchResult;

	public void navigateToVerifyUser() {
		gu.clickTab(verifyUserTab);
	}

	public void selectingUser() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Tester");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (rowValue + 1)
				+ "]//td[5]//a[1]";
		WebElement statusButton = driver.findElement(By.xpath(locator));
		gu.clickTab(statusButton);
	}

	public String alertMsgText() {
		return gu.getElementText(alertMsg);
	}

	public void clickSearhButton() {
		gu.clickTab(searchButton);
	}

	public void enterName() {
		gu.addText(name, "Tester");
	}

	public void clickSearchName() {
		gu.clickTab(serachName);
	}

	public String showSearchResult() {
		return gu.getElementText(searchResult);
	}
}
