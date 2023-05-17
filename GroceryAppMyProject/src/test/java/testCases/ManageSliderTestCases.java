package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.LoginPage;
import elementRepositary.ManageSlider;
import utilities.ExcelReadUtils;

public class ManageSliderTestCases extends BaseClass{
	LoginPage lp;
	ManageSlider ms;
	
  @Test
  public void verifyTheAlertTextAfterUploadingNewpicture() throws IOException, AWTException {
	  lp=new LoginPage(driver);
	  lp.performLogin(ExcelReadUtils.read(1, 0), ExcelReadUtils.read(1, 1));
	  ms=new ManageSlider(driver);
	  ms.navigateToMnagaeSliderTab();
	  ms.editTable();
	  ms.insertPic();
	  ms.clickUpdate();
	 String actual= ms.getAlertText();
	
	 String expected="Alert!";
	 Assert.assertEquals(actual, expected,Constants.errorMsgAssertion );
  }
}
