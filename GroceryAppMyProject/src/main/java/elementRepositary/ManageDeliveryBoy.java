package elementRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageDeliveryBoy {
	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public ManageDeliveryBoy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'])[1]")
	WebElement manageDeliveryButton;
	@FindBy(xpath = "//h3[@class='card-title']")
	WebElement editPageTitileTab;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible'] ")
	WebElement alertMsgText;

	public void navigatetoManageDeliveryBoyTab() {
		gu.clickTab(manageDeliveryButton);

	}

	public void clickEditButton() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Jerrell");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (rowValue + 1)
				+ "]//td[8]//a[1]";
		WebElement editIconActivate = driver.findElement(By.xpath(locator));
		gu.clickTab(editIconActivate);
	}

	public String editPageTile() {
		return gu.getElementText(editPageTitileTab);

	}

	public void clickDeleteButton() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "anjana");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (rowValue + 1)
				+ "]//td[8]//a[2]";
		WebElement deleteIconActivate = driver.findElement(By.xpath(locator));
	gu.clickTab(deleteIconActivate);
	
	}
	public void alertmsgClick() {
		gu.alertmsg(driver);
	}
	public String getAlertMsgText() {
	
	return gu.getElementText(alertMsgText);
	}
	

}
