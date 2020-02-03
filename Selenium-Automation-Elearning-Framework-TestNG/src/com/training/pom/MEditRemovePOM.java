package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MEditRemovePOM {
	private WebDriver driver; 
	public Actions act;
		public MEditRemovePOM(WebDriver driver) {
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
		
		@FindBy(xpath="//tr[1]//td[4]//a[1]")
		private WebElement editIcon;
		@FindBy(xpath="//h3[@class='panel-title']")
		private WebElement editCategory;
		
		
		@FindBy(xpath="//tr[3]//td[1]//input[1]")
		private WebElement checkBox;
		@FindBy(xpath="//button[@class='btn btn-danger']")
		private WebElement deleteIcon;
		
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
		
		public void clickeditIcon() {
			this.editIcon.click();
		}
		public void checkeditCategory() {
			Assert.assertEquals("Edit Category",this.editCategory.getText());
		}
		
		public void clickcheckBox() {
			this.checkBox.click();
		}
		public void clickdeleteIcon() {
			this.deleteIcon.click();
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		public void checksuccessMsg() {
			Assert.assertEquals("Success: You have modified categories!",this.successMsg.getText().replaceAll("×"," ").replace('\n',' ').trim());
		}

}
