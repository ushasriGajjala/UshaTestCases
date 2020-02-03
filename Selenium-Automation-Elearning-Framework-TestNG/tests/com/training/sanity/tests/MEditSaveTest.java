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
import com.training.pom.MEditSavePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MEditSaveTest {
	private WebDriver driver;
	private String adminURL;
	private MEditSavePOM mEditSavePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		mEditSavePOM = new MEditSavePOM(driver); 
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
	public void editSaveTest() {
		mEditSavePOM.sendUserName("admin");
		mEditSavePOM.sendPassword("admin@123");
		mEditSavePOM.clickLoginBtn(); 
		
		//mAddCategoryPOM.clickmenuBtn();
		mEditSavePOM.clickcatalog();
		mEditSavePOM.clickcategories();
		
		mEditSavePOM.checkcategoryName();
		mEditSavePOM.checksortOrder();
		mEditSavePOM.checkaction();
		
		mEditSavePOM.clickeditIcon();
		mEditSavePOM.checkeditCategory();
		
		mEditSavePOM.sendmetaTagDescriptionTextbox("Uniform for students");
		mEditSavePOM.sendmetaTagTitleTextbox("BLZ 05");
		mEditSavePOM.clicksaveIconButton();
		mEditSavePOM.checksuccessMsg();
		
		screenShot.captureScreenShot("mEditSaveTest");
	}
}
