package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.PasswordMismatchPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PasswordMisMatchTest {
	private WebDriver driver;
	private String baseUrl;
	private PasswordMismatchPOM passwordMismatchPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		passwordMismatchPOM = new PasswordMismatchPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	/*@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		passwordMismatchPOM = new PasswordMismatchPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}*/
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void PasswordMismatch() {
		passwordMismatchPOM.clickMyAccountBtn();
		passwordMismatchPOM.clickLoginBtn();
		passwordMismatchPOM.sendEmail("bathini.ushasrireddy@gmail.com");
		passwordMismatchPOM.sendPassword("Usha@123");
		passwordMismatchPOM.clickSubmitBtn();
		passwordMismatchPOM.ClickChangePassword();
		passwordMismatchPOM.sendPassword("Usha@123");
		passwordMismatchPOM.confirmPassword("Usha@505");
		passwordMismatchPOM.clickSubmitBtn();
		Assert.assertEquals("Password confirmation does not match password!",passwordMismatchPOM.PasswordDoesnotMatch());
		screenShot.captureScreenShot("passwordMismatchTest");
	}
}
