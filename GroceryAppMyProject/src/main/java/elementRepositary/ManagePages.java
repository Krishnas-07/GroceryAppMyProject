package elementRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManagePages {
	GeneralUtilities gu=new GeneralUtilities();
	WebDriver driver;

	public ManagePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement search;

	public String verifyTextOfSearchButtonInManageExpenseTab() {
		return gu.getElementText(search);
	}

}
