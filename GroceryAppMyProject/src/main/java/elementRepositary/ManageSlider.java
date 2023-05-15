package elementRepositary;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSlider {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManageSlider(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider'])[1]")
	WebElement manageSliderTab;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath="//button[@type='submit']")
	WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	
	
public void navigateToMnagaeSliderTab() {
	gu.clickTab(manageSliderTab);
}
public void editTable() {
	int rawImage=gu.clickdynamicTable(driver, "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]", "https");
	String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(rawImage+1)+"]//td[4]//a[1]";
	WebElement editButton=driver.findElement(By.xpath(locator));
	gu.clickTab(editButton);
}
public void insertPic() throws AWTException {
	gu.uploadFile(driver, chooseFile,System.getProperty("user.dir") +"\\src\\main\\resources\\MyFiles\\pic1.JPG");
}
public void clickUpdate() {
	gu.clickTab(updateButton);
}
public String getAlertText() {
	return gu.getElementText(alertText);
}
}
