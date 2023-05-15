package elementRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class PushNotification {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public PushNotification(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "Push Notifications")
	WebElement pushNotifyTab;
	@FindBy(id = "title")
	WebElement titleValue;
	@FindBy(id = "description")
	WebElement descriptionValue;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;

	public void navigateToPushNotificationTab() {
		gu.clickTab(pushNotifyTab);
	}

	public void enterTitle() {
		gu.addText(titleValue, "Welcome to Application");
	}

	public void enterDescription() {
		gu.addText(descriptionValue, "pls enter ur puchase item");
	}

	public void clickSubmit() {
		gu.clickTab(submitButton);
	}

	public String alertText() {
		return gu.getElementText(alertmsg);
	}
}
