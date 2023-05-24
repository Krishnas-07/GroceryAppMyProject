package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderTestcase {

  @DataProvider(name = "loginSucess")
  public Object[][] succesfull(){
	return new Object[][] {{"admin1","admin2"},{"hello","hello2"}};
	  
  }
  
}
