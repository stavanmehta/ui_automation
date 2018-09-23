package com.ui.auto.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage
 *
 */
public class BasePage {
	protected WebDriver driver;
	protected int timeout;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public BasePage(WebDriver driver, int timeout) {
		this.driver = driver;
		this.timeout = timeout;
	}

	/**
	 * @param driver
	 * @param locator
	 * @return WebElement
	 * 
	 *         Wait until given element is visible and return WebElement. If element
	 *         is not visible in 30 seconds, it returns null
	 */
	protected WebElement waitUntilElementVisible(String locator, int timeout) {

		String[] ls = locator.split("=");
		WebElement webElement = null;
		try {
			switch (ls[0]) {
			case "id":
				webElement = new WebDriverWait(this.driver, timeout)
						.until(ExpectedConditions.visibilityOfElementLocated(By.id(ls[1])));
				break;
			case "css":
				webElement = new WebDriverWait(this.driver, timeout)
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ls[1])));
				break;
			case "className":
				webElement = new WebDriverWait(this.driver, timeout)
						.until(ExpectedConditions.visibilityOfElementLocated(By.className(ls[1])));
				break;
			}
		} catch (TimeoutException timeoutException) {
			return null;
		} catch (NoSuchElementException noSuchElementException) {
			return null;
		}
		return webElement;
	}

	/**
	 * @param driver
	 * @param locator
	 * @return WebElement
	 * 
	 *         Wait until given element is clickable and return WebElement.
	 */
	protected WebElement waitUntilElementIsClickable(String locator, int timeout) {

		String[] ls = locator.split("=");
		WebElement webElement = null;
		try {
			switch (ls[0]) {
			case "id":
				webElement = new WebDriverWait(this.driver, timeout)
						.until(ExpectedConditions.elementToBeClickable(By.id(ls[1])));
				break;
			case "css":
				webElement = new WebDriverWait(this.driver, timeout)
						.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ls[1])));
				break;
			case "className":
				webElement = new WebDriverWait(this.driver, timeout)
						.until(ExpectedConditions.elementToBeClickable(By.className(ls[1])));
				break;
			}
		} catch (TimeoutException timeoutException) {
			return null;
		} catch (NoSuchElementException noSuchElementException) {
			return null;
		}
		return webElement;
	}

	/**
	 * @param driver
	 * @param locator
	 * @return WebElement
	 * 
	 *         Find webElemnet based on locator type and locator value. Return null
	 *         if WebElement not found for given locator
	 */
	protected WebElement getElement(String locator) {
		return waitUntilElementVisible(locator, 0);
	}

	protected void clickElement(String locator) {
		getElement(locator).click();
	}

	protected void enterText(String locator, String keysToSend) {
		getElement(locator).sendKeys(keysToSend);
	}

	protected Select getSelectElement(String locator) {
		return new Select(getElement(locator));
	}

	protected String getElementText(String locator) {
		return getElement(locator).getText();
	}

	protected String getPageTitle() {
		return this.driver.getTitle();
	}
	
	protected void deselectAll(String locator) {
		getSelectElement(locator).deselectAll();
	}

	protected void selectValue(String locator, String value) {
		getSelectElement(locator).selectByValue(value);
	}

	protected void goToPage(String url) {
		this.driver.navigate().to(url);
	}

	protected void openURL(String url) {
		this.driver.get(url);
	}

	protected void closeBrowser() {
		this.driver.close();
	}
}
