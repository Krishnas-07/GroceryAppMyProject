package elementRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	WebElement userName;
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	@FindBy(linkText = "Home")
	WebElement homeButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signIn;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
WebElement alert;
	public void enterUsername(String name) {
		userName.sendKeys(name);
	}

	public void enterPassword(String name1) {
		password.sendKeys(name1);
	}

	public String signInButtonText() {

		return gu.getElementText(signIn);
	}

	public void clickSignIn() {
		signIn.click();

	}

	public String backgroundColourOfSignInButton() {
		return gu.generalStyleProprties(signIn, "background-color");

	}
	public String homeButtonText() {
		return gu.getElementText(homeButton);
	}
	
	public void performLogin(String name,String name1) {
	enterUsername(name);
	enterPassword(name1);
	clickSignIn();
}
	public String alertText() {
		return gu.getElementText(alert);
	}
}
