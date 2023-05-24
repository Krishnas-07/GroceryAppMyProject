package elementRepositary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadUtils;
import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageDeliveryBoy {
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait ew = new ExplicitWait();
	WebDriver driver;

	public ManageDeliveryBoy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'])[1]")
	WebElement manageDeliveryButton;
	@FindBy(xpath = "//h3[@class='card-title']")
	WebElement editPageTitileTab;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement alertMsgText;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']//i")
	WebElement newButton;
	@FindBy(id = "name")
	WebElement name;
	@FindBy(id = "email")
	WebElement email;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement passWord;
	@FindBy(xpath = "//div[@class='card-footer']//button")
	WebElement saveButton;
	

	public void navigatetoManageDeliveryBoyTab() {
		gu.clickTab(manageDeliveryButton);

	}

	public void clickEditButton() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Mr. Alberta Moen");
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
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]",
				"Alvera Hilpert");
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

	public void clickNewButton() {
		gu.clickTab(newButton);
	}

	public void enterName() {
		gu.addText(name, ExcelReadUtils.read("DeliveryBoy", 1, 0));
	}

	public void enterEmai() {
		gu.addText(email, ExcelReadUtils.read("DeliveryBoy", 1, 1));
	}

	public void enterUsername() {
		gu.addText(userName, ExcelReadUtils.read("DeliveryBoy", 1, 4));
	}

	public void enterPassword() {
		gu.addText(passWord, ExcelReadUtils.read("DeliveryBoy", 1, 5));
	}

	public void clickSave() {
		gu.pageScrollDown(driver, 0, 2000);
		try {
			gu.sleepingTym();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gu.clickTab(saveButton);
	}
	public boolean checkNewlyAddedUser() {
		List<WebElement>checkname=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
		boolean check=false;
		for(WebElement checkRowValue: checkname) {
			if(checkRowValue.getText().contains("Krishnan")) {
				check=true;
				break;
			}} return check;
			
		}
				
	}
	

