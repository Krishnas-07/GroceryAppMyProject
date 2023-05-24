package elementRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageCategory {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(linkText = "Manage Category")
	WebElement manageCategory;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[1]")
	WebElement category;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement alertmsg;

	public void navigatetoManageCategoryTab() {
		gu.clickTab(manageCategory);
	}

	public void selectCategory() {
		gu.clickTab(category);
	}

	public void activeButton() {
		int value = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Heavy duty Dress");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (value + 1)
				+ "]//td[3]";
		WebElement activateButton = driver.findElement(By.xpath(locator));
		gu.clickTab(activateButton);
	}

	public String alertText() {

		return gu.getElementText(alertmsg);
	}

}
