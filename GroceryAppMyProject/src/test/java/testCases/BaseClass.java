package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import utilities.ScreenshotUtils;

public class BaseClass {
	WebDriver driver;
	ScreenshotUtils sc;
	public static Properties prop;

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//Properties//Config.properties");
		prop.load(ip);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browser) throws IOException {

		if (browser.equals("chrome")) {
			testBasic();
			// driver = new ChromeDriver();

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\KPS\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
		} else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\KPS\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();// run time polymorphism
		}
		driver.get(prop.getProperty("BaseURL"));// --> login page

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

	}

	@AfterMethod(enabled = false, alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {

		if (itestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenshotUtils();
			sc.captureScreenshotFailures(driver, itestResult.getName());

		} // for capturing screenshot if program fails

		driver.close();
	}
}
