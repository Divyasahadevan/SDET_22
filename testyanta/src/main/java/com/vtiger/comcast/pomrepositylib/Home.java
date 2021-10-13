package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class Home extends WebDriverUtility {
	WebDriver driver;
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	@FindBy(linkText="products")
	private WebElement productLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	//@FindBy(linkText="Opportunities")
	@FindBy(xpath=".//table//a[contains(text(),'Opportunities')]")
	private WebElement OpportunitiesLink;
	
	@FindBy(linkText="Go to Advanced Search")
	private WebElement AdvancedsearchLink;
	
	public WebElement getAdvancedsearchLink() {
		return AdvancedsearchLink;
		
	}
	@FindBy(id="fcol0")
	private WebElement optionDropdwn;
	@FindBy(xpath="(//input[@value=' Search Now '])[2]")
	private WebElement searchnowBtn;
	@FindBy(id="fop0")
	private WebElement searchoptionDropdwn;
	
	public WebElement getSearchoptionDropdwn() {
		return searchoptionDropdwn;
	}
	public WebElement getSearchnowBtn() {
		return searchnowBtn;
	}
	public WebElement getOptionDropdwn() {
		return optionDropdwn;
	}
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	public WebElement getOrgLink() {
		return organizationLink;
	}
	public WebElement getProductLink() {
		return  productLink;
	}
	public WebElement getOpportunitiesLink() {
		return  OpportunitiesLink;
	}
	

	

	public WebElement getadminstratorImg() {
		return  adminstratorImg;
	}

	public WebElement getsignOutLink() {
		return  signOutLink;
	}
 
	public void select() {
	SelectOption(optionDropdwn, 14);
	searchnowBtn.click();
	}
 
	public void selectWithOptionequals() {
		SelectOption(optionDropdwn, 14);
		SelectOption(searchoptionDropdwn, 1);
		searchnowBtn.click();
	}
	public void selectWithOptionnotequals() {
		SelectOption(optionDropdwn, 14);
		SelectOption(searchoptionDropdwn, 2);
		searchnowBtn.click();
	}
 
 
	public void logout() {
		//Actions act=new Actions(driver);
		//act.moveToElement(adminstratorImg).perform();
		mouseOver(driver, adminstratorImg);
		signOutLink.click();
	}

}
