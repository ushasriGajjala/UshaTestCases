package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MAddCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MAddCategoryTest {
	private WebDriver driver;
	private String adminURL;
	private MAddCategoryPOM mAddCategoryPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		mAddCategoryPOM = new MAddCategoryPOM(driver); 
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
		driver.quit();
	}
	@Test
	public void addCategoryTest() {
		mAddCategoryPOM.sendUserName("admin");
		mAddCategoryPOM.sendPassword("admin@123");
		mAddCategoryPOM.clickLoginBtn(); 
		
		//mAddCategoryPOM.clickmenuBtn();
		mAddCategoryPOM.clickcatalog();
		mAddCategoryPOM.clickcategories();
		
		mAddCategoryPOM.checkcategoryName();
		mAddCategoryPOM.checksortOrder();
		mAddCategoryPOM.checkaction();
		
		mAddCategoryPOM.clickaddNew();
		mAddCategoryPOM.checkaddCategory();
		
		mAddCategoryPOM.sendcategoryNameTextbox("Blazers(3-5)");
		mAddCategoryPOM.senddescriptionTextbox("Blazers for students");
		mAddCategoryPOM.sendmetaTagDescriptionTextbox("Blazers for primary class student");
		mAddCategoryPOM.sendmetaTagTitleTextbox("BLZ 03");
		mAddCategoryPOM.clicksaveIconButton();
		mAddCategoryPOM.checksuccessMsg();
		
		screenShot.captureScreenShot("mAddCategoryTest");
	}
}
