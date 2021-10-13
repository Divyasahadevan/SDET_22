package com.vtiger.comcast.organizationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.CreateNewOpportunity;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.Opportunity;

public class AdvanceSearchlogout {
	
	public static void main(String[] args) throws Throwable {
		
		//create objects
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib= new FileUtility();
		JavaUtility jlib= new JavaUtility();
		WebDriverUtility wlib= new WebDriverUtility();
		WebDriver driver=null;
		
		//read common data
		String BROWSER = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		// read test data
		String oppoName = elib.getExceData("opportunity", 1, 1);
		if(BROWSER.equals("Chrome")) {
			driver=new ChromeDriver();}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();}
		else  {
			driver=new ChromeDriver();}
		
		//step 2:login to application
		driver.get(URL);
		Login lp= new Login(driver);
				lp.loginToApp(USERNAME, PASSWORD);
		//navigate to opportunity
				Home hp= new Home(driver);
				hp.getOpportunitiesLink().click();
		// navigate to create opportunity page
				 Opportunity op= new Opportunity(driver);
				 op.getCreateOppoImg().click();
		// create new opportunity
				 CreateNewOpportunity cnoppo= new CreateNewOpportunity(driver);
				 cnoppo.createOppo(oppoName);
				 cnoppo.selectRelatedTo(driver);
	}
}
