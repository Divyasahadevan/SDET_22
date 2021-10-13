package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfo {
	
	 public OpportunityInfo  (WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }

	 @FindBy(xpath="//span[@class='dvHeaderText']")
	 private WebElement succesfullMsg;

	public WebElement getSuccesfullMsg() {
		return succesfullMsg;
		
	}
	
	@FindBy(xpath="//table//b[text()='Advanced Search']")
	private WebElement successMsgInAdvanceSearchpage;

	public WebElement getSuccessMsgInAdvanceSearchpage() {
		return successMsgInAdvanceSearchpage;
	}
	
	@FindBy(linkText="vtiger")
	private WebElement HomePageVtiger;

	public WebElement getHomePageVtiger() {
		return HomePageVtiger;
	}
	

}

	 

