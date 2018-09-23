package com.ui.auto.pages;

import org.openqa.selenium.WebDriver;

import com.ui.auto.uiautomation.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private static String URL = "";
	
	/*Locators*/
	private static String locatorUserName = "css=#mat-input-0";
	private static String locatorPassword = "css=#mat-input-1";
	private static String locatorLoginButton = "css=.login-form-item.login-btn>span.mat-button-wrapper";
	private static String locatorErrorMessage = "css=.error-message-container.alert .err-msg"; 
			

	public void openLoginPage() {
		openURL(URL);
	}
	
	public void enterUserName(String userName) {
		enterText(locatorUserName, userName);
	}

	public void enterPassword(String password) {
		enterText(locatorPassword, password);
	}
	
	public void clickLoginButton() {
		clickElement(locatorLoginButton);
	}
	
	public String getErrroMessage() {
		waitUntilElementVisible(locatorErrorMessage, 30);
		return getElementText(locatorErrorMessage);
	}
	

}
