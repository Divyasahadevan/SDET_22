package com.vtiger.comcast.pomrepositylib;

import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class CreateNewOpportunity extends WebDriverUtility {
	public CreateNewOpportunity(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(name="potentialname")
	private WebElement oppoNameEdt;

	@FindBy(id="related_to_type")
	private WebElement relatedto;


	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement relatedtoSelect;


	@FindBy(name="sales_stage")
	private WebElement  salestage;

	@FindBy(xpath=".//input[contains(@title, 'Save')]")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	@FindBy(linkText="testyantra testyantra")
	private WebElement ContactLink;
	
	@FindBy(name="sales_stage")
	private WebElement salesStageDrop;

	public WebElement getSalesStageDrop() {
		return salesStageDrop;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public void createOppo(String OppoName) {
		oppoNameEdt.sendKeys(OppoName);

	}

	public WebElement getRelatedtoSelect() {
		return relatedtoSelect;
	}
	
	public void selectRelatedTo(WebDriver d) throws Throwable {
 		SelectOption(relatedto, 1);	
		SelectOption(salesStageDrop, 0);
		
		getRelatedtoSelect().click();
	    
		String parentWindow = switchTowindow(d, "Contacts&action");
		getContactLink().click();
	  
		d.switchTo().window(parentWindow);
		getSaveBtn().click();
	}
	
	public String popupMSg(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		String popupMsg = driver.switchTo().alert().getText();
		return popupMsg;
	}
	
	public String popupMSgRelatedTo(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		String popupMsgRelated = driver.switchTo().alert().getText();
		return popupMsgRelated;
	}
	
	/*public void getdate() {
	 Date d= new Date();
	 String currentdate= d.toString();
	int month= d.getMonth()+1;
	int date= d.getDate();h
	 String year= d.split(" ")[5];
	 String actdate=year+"-"+month+"-"+date;
	}*/
}
