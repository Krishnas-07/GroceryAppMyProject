package elementRepositary;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageContent {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageContent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//a[@class='nav-link']//p)[12]")
	WebElement manageContent;
	@FindBy(xpath = "(//a[@class='nav-link']//p)[13]")
	WebElement managePages;
	@FindBy(id = "main_img")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@name='update']")
	WebElement submitButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement alert;

	public void navigateToManageContent() {
		gu.clickTab(manageContent);
	}

	public void navigateToManagePages() {
		try {
			gu.sleepingTym();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		gu.clickTab(managePages);
	}

	public void editInTable() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "sample title");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (rowValue + 1)
				+ "]//td[5]//a[1]";
		WebElement editButton = driver.findElement(By.xpath(locator));
		gu.clickTab(editButton);

	}

	public void insertPicture() throws AWTException, InterruptedException {
		gu.uploadFile(driver, chooseFile,
				System.getProperty("user.dir") + "\\src\\main\\resources\\MyFiles\\pic2..jpg");
		gu.sleepingTym();
	}

	public void clickSubmit() {
		gu.pageScrollDown(driver, 0, 1000);
		try {
			gu.sleepingTym();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gu.clickTab(submitButton);
	}

	public String alertMsg() {
		return gu.getElementText(alert);
	}
}
