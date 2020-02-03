package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MAdminInvalidLoginPOM {
private WebDriver driver; 
	
	public MAdminInvalidLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement userName; 
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement alertMessage;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public void checkErrorMessage() {
		Assert.assertEquals("No match for Username and/or Password.", this.alertMessage.getText().replaceAll("×"," ").replace('\n',' ').trim());
	}
}
