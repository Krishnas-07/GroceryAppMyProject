package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import elementRepositary.LoginPage;
import elementRepositary.Settings;
import utilities.ExcelReadUtils;

public class SettingTestCases extends BaseClass{
	LoginPage lp;
	Settings s;
  @Test
  public void verifyManageMenuInSettingsTab() throws IOException {
	  lp=new LoginPage(driver);
	  lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
	  
	  s=new Settings(driver);
	  s.pageWaiting();
	  s.navigateToSetting();
	  s.selectManageMenu();
	  s.waitForObject();
		  
  }
}
