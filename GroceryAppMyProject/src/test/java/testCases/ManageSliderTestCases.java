package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepositary.LoginPage;
import elementRepositary.ManageSlider;
import utilities.ExcelReadUtils;

public class ManageSliderTestCases extends BaseClass{
	LoginPage lp;
	ManageSlider ms;
	
  @Test(retryAnalyzer = RetryAnalyzer.class,enabled=true)
  public void verifyTheAlertTextAfterUploadingNewpictureWithLargerSize() throws IOException, AWTException, InterruptedException {
	  lp=new LoginPage(driver);
	  lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
	  ms=new ManageSlider(driver);
	  ms.navigateToMnagaeSliderTab();
	  ms.editTable();
	  ms.insertPic();
	  ms.clickUpdate();
	 String actual= ms.getAlertText();
	System.out.println(actual);
	 String expected="Image is too large of a file.";
	 Assert.assertEquals(actual, expected,Constants.errorMsgAssertion );
  }
  @Test(retryAnalyzer = RetryAnalyzer.class)
  public void verifyTheUserCanAddNewSlider() {
	  lp=new LoginPage(driver);
	  lp.performLogin(ExcelReadUtils.read("Sheet1",1, 0), ExcelReadUtils.read("Sheet1",1, 1));
	  ms=new ManageSlider(driver);
	  ms.navigateToMnagaeSliderTab();
	  ms.clickNewButton();
	  ms.insertImage();
	  ms.provideLink();
	  ms.clickSave();
	  ms.navigateToMnagaeSliderTab();
	  boolean actual=ms.checkNewlyAddedLink();
	  boolean expected=true;
	  Assert.assertEquals(actual,expected, Constants.errorMsgAssertion);
	  
	 
  }
}
