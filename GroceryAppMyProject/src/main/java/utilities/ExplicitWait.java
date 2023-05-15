package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	public void waitForElementTOBeClickables(WebDriver driver, String type) {
		WebDriverWait waitForNextPage = new WebDriverWait(driver, Duration.ofMillis(5000));
		waitForNextPage.until(ExpectedConditions.elementToBeClickable(By.xpath(type)));

	}

}
