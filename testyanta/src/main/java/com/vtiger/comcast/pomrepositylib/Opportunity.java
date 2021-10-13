package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class Opportunity extends WebDriverUtility{
	public Opportunity(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement createOppoImg;
	public WebElement getCreateOppoImg() {
		return createOppoImg;
	}
	
	@FindBy(linkText="Create Filter")
	private WebElement createFilterLink;
	@FindBy(name="viewName")
	private WebElement viewNameLink;
	
	public WebElement getViewNameLink() {
		return viewNameLink;
	}
	
	@FindBy(xpath=".//input[contains(@title, 'Save')]")
	private WebElement saveBtnoppo;
	@FindBy(linkText="Edit")
	private WebElement oppoEditBtn;
	
	@FindBy(linkText="Delete")
	private WebElement oppoDeleteBtn;
	
	public WebElement getOppoEditBtn() {
		return oppoEditBtn;
	}

	public WebElement getOppoDeleteBtn() {
		return oppoDeleteBtn;
	}

	public WebElement getSaveBtnoppo() {
		return saveBtnoppo;
	}

	public WebElement getCreateFilterLink() {
		return createFilterLink;
	}
	
	//WebDriver driver;
	public void fliter(String oppoName) {
		getCreateFilterLink().click();
		getViewNameLink().sendKeys(oppoName);
		getSaveBtnoppo().click(); 
		getOppoEditBtn().click();
		getSaveBtnoppo().click();
		getOppoDeleteBtn().click();
	}
}
