package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RemoveCartPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RemoveCartTest {
	private WebDriver driver;
	private String baseUrl;
	private RemoveCartPOM removeCartPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		removeCartPOM= new RemoveCartPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	/*@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		removeCartPOM = new RemoveCartPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}*/
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	@Test
	public void viewCart() throws InterruptedException {
		removeCartPOM.clickMyAccountBtn();
		removeCartPOM.clickLoginBtn();
		removeCartPOM.sendEmail("bathini.ushasrireddy@gmail.com");
		removeCartPOM.sendPassword("Usha@123");
		removeCartPOM.clickSubmitBtn();
		removeCartPOM.clickUniformStore();
		removeCartPOM.clickShopUniforms(); 
		removeCartPOM.clickYellowTShirt();
		removeCartPOM.selectChestSize();
		removeCartPOM.clickAddToCart();
		Assert.assertEquals("Success: You have added REGULAR T-SHIRTS (YELLOW) to your shopping cart!",removeCartPOM.successText());
		removeCartPOM.clickCart();
		removeCartPOM.removeCart();
		screenShot.captureScreenShot("RemoveCartTest");

		}
}
