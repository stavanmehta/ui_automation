package com.ui.auto.uiautomation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ui.auto.pages.LoginPage;

public class LoginPageTest {
	
	LoginPage loginPage;
	
  @Test(dataProvider = "validLogins", priority = 2)
  public void validLoginTest(String userName, String password) {
	  loginPage.openLoginPage();
	  loginPage.enterUserName(userName);
	  loginPage.enterPassword(password);
	  loginPage.clickLoginButton();
  }

  @Test(dataProvider = "inValidLogins", priority = 1)
  public void inValidLoginTest(String userName, String password, String expectedErrorMessage) {
	  loginPage.openLoginPage();
	  loginPage.enterUserName(userName);
	  loginPage.enterPassword(password);
	  loginPage.clickLoginButton();
	  String errorMessage = loginPage.getErrroMessage();
	  Assert.assertEquals(errorMessage, expectedErrorMessage);
  }
  
  
  
  @BeforeSuite
  public void beforeSuite() {
	  WebDriver driver = UIDriver.getFirefoxDriver();
	  loginPage = new LoginPage(driver);
  }

  @AfterSuite
  public void afterSuite() {
	  loginPage.closeBrowser();
  }

  
  @DataProvider
  public Object[][] validLogins() {
    return new Object[][] {
      new Object[] { "", "" }
//      new Object[] { "", "b" },
    };
  }
  
  @DataProvider
  public Object[][] inValidLogins() {
	    return new Object[][] {
	      new Object[] { "", "invalidPassword", "Username and Password do not match for teacher" }
	    };
	  }
}
