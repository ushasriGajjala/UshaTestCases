package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MAddCategoryPOM {
private WebDriver driver; 
public Actions act;
	public MAddCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement userName; 
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//i[@class='fa fa-indent fa-lg']")
	private WebElement menuBtn; 
	
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement catalog; 
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement categories; 
	
	@FindBy(xpath="//form[1]//table[1]//tr[1]//td[2]/a")
	private WebElement categoryName;
	@FindBy(xpath="//a[contains(text(),'Sort Order')]")
	private WebElement sortOrder;
	@FindBy(xpath="//td[contains(text(),'Action')]")
	private WebElement action;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addNew;
	@FindBy(xpath="//h3[@class='panel-title']")
	private WebElement addCategory;
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement categoryNameTextbox;
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement descriptionTextbox;
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metaTagTitleTextbox;
	@FindBy(xpath="//textarea[@id='input-meta-description1']")
	private WebElement metaTagDescriptionTextbox;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement saveIcon;
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMsg;
	
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

	public void clickcatalog() {
		this.catalog.click();
	}
	public void clickcategories() {
		this.categories.click();
	}
	
	public void checkcategoryName() {
		Assert.assertEquals("Category Name",this.categoryName.getText());
	}
	public void checksortOrder() {
		Assert.assertEquals("Sort Order",this.sortOrder.getText());
	}
	public void checkaction() {
		Assert.assertEquals("Action",this.action.getText());
	}
	
	public void clickaddNew() {
		this.addNew.click();
	}
	public void checkaddCategory() {
		Assert.assertEquals("Add Category",this.addCategory.getText());
		System.out.println(this.addCategory.getText());
	}
	public void sendcategoryNameTextbox(String categoryNameTextbox) {
		this.categoryNameTextbox.clear();
		this.categoryNameTextbox.sendKeys(categoryNameTextbox);
	}
	
	public void senddescriptionTextbox(String descriptionTextbox) {
		this.descriptionTextbox.clear(); 
		this.descriptionTextbox.sendKeys(descriptionTextbox); 
	}
	public void sendmetaTagTitleTextbox(String metaTagTitleTextbox) {
		this.metaTagTitleTextbox.clear();
		this.metaTagTitleTextbox.sendKeys(metaTagTitleTextbox);
	}
	
	public void sendmetaTagDescriptionTextbox(String metaTagDescriptionTextbox) {
		this.metaTagDescriptionTextbox.clear(); 
		this.metaTagDescriptionTextbox.sendKeys(metaTagDescriptionTextbox); 
	}
	public void clicksaveIconButton() {
		this.saveIcon.click();
	}
	public void checksuccessMsg() {
		Assert.assertEquals("Success: You have modified categories!",this.successMsg.getText().replaceAll("×"," ").replace('\n',' ').trim());
	}
}
