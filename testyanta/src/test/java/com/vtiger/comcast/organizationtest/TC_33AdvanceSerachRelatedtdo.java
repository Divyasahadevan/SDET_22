package com.vtiger.comcast.organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.CreateNewOpportunity;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.Opportunity;
import com.vtiger.comcast.pomrepositylib.OpportunityInfo;

public class TC_33AdvanceSerachRelatedtdo {
@Test
	public void AdvanceSearchRelatedtodoTest() throws Throwable {
			
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
			String oppoName = elib.getExceData("Sheet1", 1, 1);
			switch(BROWSER)
			{
				case "Chrome":
					driver=new ChromeDriver();
					break;
				case "firefox":
					driver=new FirefoxDriver();
					break;
			}
			
			driver.manage().window().maximize();
			
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
			hp.getOpportunitiesLink().click();

			Thread.sleep(2000);
			hp.getAdvancedsearchLink().click();
			hp.select();
			wlib.acceptAlert(driver);
			
			OpportunityInfo oinfo= new OpportunityInfo(driver);
			wlib.waitforElementVisibility(driver, oinfo.getSuccessMsgInAdvanceSearchpage());
			String actSucMsg =oinfo.getSuccessMsgInAdvanceSearchpage().getText();
			if(actSucMsg.contains("Opportunity Name Option cannot be empty")) {
				System.out.println("Opportunity Name Option cannot be empty popup displayed-pass");
			}
			else {
				System.out.println("Opportunity Name Option cannot be empty popup displayed-fail");
			}
			
			hp.logout();
			//op.fliter(oppoName);
			
			//wlib.acceptAlert(driver);
			
			//Close the driver
			driver.quit();
	}
}