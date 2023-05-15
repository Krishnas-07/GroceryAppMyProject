package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {

	public void captureScreenshotFailures(WebDriver driver, String image) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);// screenshot will store in temporary path
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// date time capture using
																							// java
		File reportPath = new File(System.getProperty("user.dir") + "//ScreenshotUtils");

		if (!reportPath.exists()) {
			reportPath.mkdir();// makedirectory
		}

		File finalDestination = new File(
				System.getProperty("user.dir") + "\\ScreenshotImages\\" + image + timeStamp + ".png");// creating
		// a
		// location for
		// screenshot
		FileHandler.copy(screenShot, finalDestination);// to save in our system file
	}

}
