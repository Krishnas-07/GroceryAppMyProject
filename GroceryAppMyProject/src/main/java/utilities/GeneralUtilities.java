package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String generalStyleProprties(WebElement element, String propertytype) {
		String property = element.getCssValue(propertytype);
		return property;
	}

	public void clickTab(WebElement element) {
		element.click();
	}

	public void addText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void selectFromDropDown(WebElement element, int dropdown) {
		Select obj = new Select(element);
		obj.selectByIndex(dropdown);
	}

	public boolean checkSelection(WebElement element) {
		boolean check = element.isSelected();
		return check;
	}

	public boolean enabledOrNot(WebElement element) {
		boolean value = element.isEnabled();
		return value;
	}

	public int clickdynamicTable(WebDriver driver, String columnValue, String compareName) {
		List<WebElement> firstColumnElement = driver.findElements(By.xpath(columnValue));
		int value = 0;
		for (int i = 0; i < firstColumnElement.size(); i++) {
			if (firstColumnElement.get(i).getText().equals(compareName)) {
				value = i;
				break;
			}
		}
		return value;

	}

	public void pageScrollDown(WebDriver driver, int horizontalScroll, int verticalScroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;// interface to trigger javascript
		js.executeScript("window.scrollBy("+horizontalScroll+","+verticalScroll+")", "");
	}

	public void alertmsg(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void uploadFile(WebDriver driver, WebElement string, String location) throws AWTException {
		Robot robot = new Robot();
		Actions action = new Actions(driver);
		action.moveToElement(string).click().perform();
		// copy path to your system clipboard
		StringSelection ss = new StringSelection(location);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
