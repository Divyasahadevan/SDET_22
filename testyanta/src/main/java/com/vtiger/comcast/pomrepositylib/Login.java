package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public Login(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginBtn;
	public WebElement getUserNameEdt() {
		return userNameEdt;}
	public WebElement getUserpasswordEdt() {
		return userPasswordEdt;
		
	}
	public WebElement getLoginBtn() {
		return loginBtn;
		
	}
	
		public void loginToApp( String userName,String password) {
		
			userNameEdt.sendKeys(userName);
			userPasswordEdt.sendKeys(password);
			loginBtn.click();
			
			
		}
	
	}
	
	
	

