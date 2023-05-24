package elementRepositary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocation {
	GeneralUtilities gu = new GeneralUtilities();;
	WebDriver driver;

	public ManageLocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location'])[1]")
	WebElement manageLocationTab;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement searchButton;
	@FindBy(id = "country_id")
	WebElement countryname;

	@FindBy(id = "location")
	WebElement location;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchIcon;

	public void clickManageLocationTab() {

		gu.clickTab(manageLocationTab);

	}

	public void clickSearchButton() {
		gu.clickTab(searchButton);
	}

	public void selectCountry() {
		gu.selectFromDropDown(countryname, 1);
	}

	public void selectLocation() {
		gu.addText(location, "garden street");
	}

	public void clickSearchIcon() {
		gu.clickTab(searchIcon);
	}

	public boolean checkLocation() {
		List<WebElement> checkPresence = driver.findElements(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
		boolean check = false;
		for (WebElement checkEachValue : checkPresence) {
			if (checkEachValue.getText().contains("garden street")) {
				check = true;
				break;
			}
		}
		return check;
	}

}
