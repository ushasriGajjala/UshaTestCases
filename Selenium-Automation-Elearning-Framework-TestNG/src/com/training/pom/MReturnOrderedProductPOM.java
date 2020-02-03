package com.training.pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MReturnOrderedProductPOM {
private WebDriver driver; 
	public String thanksMessage;
	public MReturnOrderedProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement userProfile; 
	
	@FindBy(linkText="Login")
	private WebElement loginBtn; 
	
	@FindBy(name="email")
	private WebElement email; 
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitBtn; 
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']")
	private WebElement myAccountDropdown; 
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']//a[contains(text(),'My Account')]")
	private WebElement myAccount; 
	
	@FindBy(linkText="Order History")
	private WebElement orderHistory;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']//a[contains(text(),'Transactions')]")
	private WebElement transactions;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']//a[contains(text(),'Downloads')]")
	private WebElement downloads;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']//a[contains(text(),'Logout')]")
	private WebElement logout;
	
	@FindBy(xpath="//td[contains(text(),'Order ID')]")
	private WebElement orderID;
	
	@FindBy(xpath="//td[contains(text(),'Customer')]")
	private WebElement customer;
	
	@FindBy(xpath="//td[contains(text(),'No. of Products')]")
	private WebElement NoofProducts;
	
	@FindBy(xpath="//td[contains(text(),'Status')]")
	private WebElement status;
	
	@FindBy(xpath="//td[contains(text(),'Total')]")
	private WebElement total;
	
	@FindBy(xpath="//td[contains(text(),'Date Added')]")
	private WebElement dateAdded;
	
	@FindBy(xpath="//i[@class='fa fa-eye']")
	private WebElement viewIcon;
	
	@FindBy(xpath="//h2[contains(text(),'Order Information')]")
	private WebElement orderDetails;
	
	@FindBy(xpath="//tr[1]//td[6]//a[2]//i[1]")
	private WebElement returnicon;
	
	@FindBy(xpath="//h1[contains(text(),'Product Returns')]")
	private WebElement productReturns;
	@FindBy(xpath="//legend[contains(text(),'Order Information')]")
	private WebElement orderInformation;
	@FindBy(xpath="//legend[contains(text(),'Product Information')]")
	private WebElement productInformation;
	
	@FindBy(xpath="//div[3]/label/input[@name='return_reason_id']")
	private WebElement validReasonbutton;
	
	@FindBy(xpath="//div[@class='col-sm-10']/label[1]/input[1]")
	private WebElement productOpened;
	
	@FindBy(xpath="//div[3]/label/input[@name='return_reason_id']")
	private WebElement faultyDetails;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement termsCheckBox;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement submitButton;
	
	@FindBy(xpath="//p[contains(text(),'Thank you for submitting your return request. Your')]")
	private WebElement thanksMessage1;
	
	@FindBy(xpath="//p[contains(text(),'You will be notified via e-mail as to the status o')]")
	private WebElement thanksMessage2;
	
	public void clickUserProfileBtn() {
		this.userProfile.click(); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickSubmitBtn() {
		this.submitBtn.click(); 
	}
	
	public void clickMyAccount() {
		this.myAccount.isDisplayed();
	}
	public void clickTransactions() {
		this.transactions.isDisplayed();
	}
	public void clickDownloads() {
		this.downloads.isDisplayed();
	}
	public void clickLogout() {
		this.logout.isDisplayed();
	}
	public void clickOrderHistory() {
		this.orderHistory.isDisplayed();
		this.orderHistory.click();
	}
	
	public void orderIDdisplayed() {
		this.orderID.isDisplayed();
	}
	public void customerDisplayed() {
		this.customer.isDisplayed();
	}
	public void NoofProductsDisplayed() {
		this.NoofProducts.isDisplayed();
	}
	public void statusDisplayed() {
		this.status.isDisplayed();
	}
	public void totalDisplayed() {
		this.total.isDisplayed();
	}
	public void dateAddedDisplayed() {
		this.dateAdded.isDisplayed();
	}
	
	public void clickViewIcon() {
		this.viewIcon.click(); 
	}
	public void orderDetailsDisplayed() {
		this.orderDetails.click(); 
	}
	
	public void ClickmyAccountDropdown() {
		this.myAccountDropdown.click();
	}

	public void Clickreturnicon() {
		this.returnicon.click();
	}
	public void productReturnsDisplayed() {
		this.productReturns.isDisplayed();
		Assert.assertEquals(productReturns.getText(),"PRODUCT RETURNS");
	}
	public void orderInformationDisplayed() {
		this.orderInformation.isDisplayed();
		Assert.assertEquals(orderInformation.getText(),"Order Information");
	}
	public void productInformationDisplayed() {
		this.productInformation.isDisplayed();
		Assert.assertEquals(productInformation.getText(),"Product Information");
	}
	
	public void ClickvalidReasonbutton() {
		this.validReasonbutton.click();
	}
	
	public void ClickproductOpenedbutton() {
		this.productOpened.click();
	}
	
	public void EnterfaultyDetails() {
		this.faultyDetails.sendKeys("Incorrect Item");
	}

	public void ClicksubmitButton() {
		this.submitButton.click();  
	}
	
	public void ClicktermsCheckBox() {
		this.termsCheckBox.click();  
	}
	
	public void CheckThanksMessage() {
		thanksMessage=this.thanksMessage1.getText()+this.thanksMessage2.getText();
		Assert.assertEquals("Thank you for submitting your return request. Your request has been sent to the relevant department for processing.You will be notified via e-mail as to the status of your request.",thanksMessage);
	}
}
