package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {
	
		public CreateNewContact(WebDriver driver) {
			 PageFactory.initElements(driver, this);
			 
		 }
		@FindBy(name="lastname")
		private WebElement contactNameEdt;
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		public void createOrg(String contactName) {
			contactNameEdt.sendKeys(contactName);
			saveBtn.click();
	

		}
}
