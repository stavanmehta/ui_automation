package com.ui.auto.uiautomation;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UIDriver {

	public static WebDriver getFirefoxDriver() {
		Path path = FileSystems.getDefault().getPath("src/main/resources/geckodriver");
        System.setProperty("webdriver.gecko.driver",path.toString());
		return new FirefoxDriver();
	}
}
