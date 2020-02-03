package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MAdminInvalidLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MAdminInvalidloginTest {
	private WebDriver driver;
	private String adminURL;
	private MAdminInvalidLoginPOM mAdminInvalidLoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		mAdminInvalidLoginPOM = new MAdminInvalidLoginPOM(driver); 
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminURL);
	}

	/*@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminLoginPOM = new AdminLoginPOM(driver); 
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminURL);
	}*/
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void MAdminInvalidLoginTest() {
		mAdminInvalidLoginPOM.sendUserName("admin");
		mAdminInvalidLoginPOM.sendPassword("admin@");
		mAdminInvalidLoginPOM.clickLoginBtn(); 
		mAdminInvalidLoginPOM.checkErrorMessage();
		
		screenShot.captureScreenShot("MAdminInvalidLoginTest");
	}
}
