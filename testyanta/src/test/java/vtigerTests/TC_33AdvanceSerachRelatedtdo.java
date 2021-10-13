package vtigerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.vtiger.comcast.organizationtest.CreateOpportunityTest;
import com.vtiger.comcast.pomrepositylib.CreateNewOpportunity;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.Opportunity;
import com.vtiger.comcast.pomrepositylib.OpportunityInfo;

public class TC_33AdvanceSerachRelatedtdo extends BaseClass {
	
	@Test(groups= {"smoketest"})
	public void AdvanceSearchRelatedtodoTest() throws Throwable {
			
			// read the test data from excel
			String oppoName = elib.getExceData("Sheet1", 1, 1);
			System.out.println(oppoName);

			//click on opportunity link
			Home hp= new Home(driver);
			hp.getOpportunitiesLink().click();


			// click on create opportunity image
			Opportunity op= new Opportunity(driver);
			op.getCreateOppoImg().click();
			//enter mandatory fields
			CreateNewOpportunity cnoppo= new CreateNewOpportunity(driver);
			cnoppo.createOppo(oppoName);
			cnoppo.selectRelatedTo(driver);
			hp.getOpportunitiesLink().click();

			Thread.sleep(2000);
			hp.getAdvancedsearchLink().click();
			hp.select();
			String popupMsg = cnoppo.popupMSgRelatedTo(driver);
			Assert.assertTrue(popupMsg.contains("Related To Option cannot be empty"));
			
			wlib.acceptAlert(driver);
			
			OpportunityInfo oinfo= new OpportunityInfo(driver);
			wlib.waitforElementVisibility(driver, oinfo.getSuccessMsgInAdvanceSearchpage());
			String actSucMsg =oinfo.getSuccessMsgInAdvanceSearchpage().getText();
			
			Assert.assertTrue(actSucMsg.contains("Advanced Search"));
	}
}