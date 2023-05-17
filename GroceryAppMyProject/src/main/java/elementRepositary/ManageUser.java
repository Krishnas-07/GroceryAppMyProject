package elementRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageUser {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user'])[1]")
	WebElement manageUserTab;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;
	@FindBy(xpath = "(//div[@class='col-xs-12 col-sm-12'])[5]")
	WebElement secretPassword;
	@FindBy(xpath = "(//a[@class='green bigger-140 show-details-btn'])[5]")
	WebElement showDetailsButton;

	public void navigateToManageUserTab() {
		gu.clickTab(manageUserTab);
	}

	public void verifyStatusOfUserInManageUserTab() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Anandhu Prakash");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (rowValue + 1)
				+ "]//td[5]//a";
		WebElement statusButtonActivation = driver.findElement(By.xpath(locator));
		gu.clickTab(statusButtonActivation);

	}

	public String alertText() {
		return gu.getElementText(alertMsg);
	}

	public void clickDeleteIcon() {
		int readRowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[6]", "CIJIN SJ");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (readRowValue + 1)
				+ "]//td[6]//a[2]";
		WebElement deleteIcon = driver.findElement(By.xpath(locator));
		gu.clickTab(deleteIcon);

	}

	public void verifyAlert() {
		gu.alertmsg(driver);
	}

	public String viewPassword() throws InterruptedException {
		int passwordView = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Anandhu Prakash");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (passwordView + 1)
				+ "]//td[3]";
		WebElement password = driver.findElement(By.xpath(locator));

	gu.clickTab(password);
		
		gu.clickTab(showDetailsButton);
		//String text=gu.getElementText(secretPassword);
		return gu.getElementText(secretPassword);

	}

}
