package elementRepositary;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadUtils;
import utilities.GeneralUtilities;

public class ManageSlider {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider'])[1]")
	WebElement manageSliderTab;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//li")
	WebElement alertText;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id="link")
	WebElement insertLink;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;

	public void navigateToMnagaeSliderTab() {
		gu.clickTab(manageSliderTab);
	}

	public void editTable() {
		int rawImage = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]", "https:\\grocery.com");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (rawImage + 1)
				+ "]//td[4]//a[1]";
		WebElement editButton = driver.findElement(By.xpath(locator));
		gu.clickTab(editButton);
	}

	public void insertPic() throws AWTException, InterruptedException {
		gu.uploadFile(driver, chooseFile, System.getProperty("user.dir") + "\\src\\main\\resources\\MyFiles\\pic1.JPG");
		gu.sleepingTym();
	}

	public void clickUpdate() {
		gu.pageScrollDown(driver, 0, 800);
		gu.clickTab(updateButton);
	}

	public String getAlertText() {
		return gu.getElementText(alertText);

	}

	public void clickNewButton() {
		gu.clickTab(newButton);
	}

	public void insertImage() {
		try {
			gu.uploadFile(driver, chooseFile,
					System.getProperty("user.dir") + "\\src\\main\\resources\\MyFiles\\pic2..jpg");
		} catch (AWTException e) {
			e.printStackTrace();
		}
		try {
			gu.sleepingTym();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void provideLink() {
		gu.addText(insertLink, ExcelReadUtils.read("ManageContent", 1, 0));
		try {
			gu.sleepingTym();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	public void clickSave() {
		gu.clickTab(saveButton);
	}
	public boolean checkNewlyAddedLink() {
		List<WebElement>checkLink=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]"));
		boolean check=false;
		for(WebElement checkNewLink : checkLink) {
			if(checkNewLink.getText().contains("http link")) {
				check=true;
				break;
			}}return check;
			
			
			}
		
		
		
	
}
