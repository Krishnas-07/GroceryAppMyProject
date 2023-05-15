package elementRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class Settings {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait ew=new ExplicitWait();

	public Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='active highlight nav-link'])[1]")
	WebElement settingTab;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/menu-management'])[1]")
	WebElement manageMenu;

	public void navigateToSetting() {
		gu.clickTab(settingTab);
	}

	public void selectManageMenu() {
		gu.clickTab(manageMenu);
	}

	public void pageWaiting() {
		gu.pageScrollDown(driver, 1000, 2000);

	}
	public void waitForObject() {
		ew.waitForElementTOBeClickables(driver, "Settings");
	}
}
