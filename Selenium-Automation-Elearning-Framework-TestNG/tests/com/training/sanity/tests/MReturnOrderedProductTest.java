package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MReturnOrderedProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MReturnOrderedProductTest {
	private WebDriver driver;
	private String baseUrl;
	private MReturnOrderedProductPOM mReturnOrderedProductPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		mReturnOrderedProductPOM = new MReturnOrderedProductPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void returnOrderedProduct() {
		mReturnOrderedProductPOM.clickUserProfileBtn();
		mReturnOrderedProductPOM.clickLoginBtn();
		mReturnOrderedProductPOM.sendEmail("bathini.ushasrireddy@gmail.com");
		mReturnOrderedProductPOM.sendPassword("Usha@123");
		mReturnOrderedProductPOM.clickSubmitBtn();
		mReturnOrderedProductPOM.clickUserProfileBtn();
		mReturnOrderedProductPOM.ClickmyAccountDropdown();
		
		mReturnOrderedProductPOM.clickMyAccount();
		mReturnOrderedProductPOM.clickTransactions();
		mReturnOrderedProductPOM.clickDownloads();
		mReturnOrderedProductPOM.clickLogout();
		mReturnOrderedProductPOM.clickOrderHistory();
		
		mReturnOrderedProductPOM.orderIDdisplayed();
		mReturnOrderedProductPOM.customerDisplayed();
		mReturnOrderedProductPOM.NoofProductsDisplayed();
		mReturnOrderedProductPOM.statusDisplayed();
		mReturnOrderedProductPOM.totalDisplayed();
		mReturnOrderedProductPOM.dateAddedDisplayed();
		
		mReturnOrderedProductPOM.clickViewIcon();
		mReturnOrderedProductPOM.orderDetailsDisplayed();
		
		mReturnOrderedProductPOM.Clickreturnicon();
		mReturnOrderedProductPOM.productReturnsDisplayed();
		mReturnOrderedProductPOM.productInformationDisplayed();
		mReturnOrderedProductPOM.orderInformationDisplayed();
		
		mReturnOrderedProductPOM.ClickvalidReasonbutton();
		mReturnOrderedProductPOM.ClickproductOpenedbutton();
		mReturnOrderedProductPOM.EnterfaultyDetails();
		mReturnOrderedProductPOM.ClicktermsCheckBox();
		mReturnOrderedProductPOM.ClicksubmitButton();
		mReturnOrderedProductPOM.CheckThanksMessage();
		
		screenShot.captureScreenShot("MReturnOrderedProductTest");
	}
}
