package vtigerTests;

import static org.testng.Assert.fail;

import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.vtiger.comcast.pomrepositylib.CreateNewOpportunity;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Opportunity;
@Listeners(com.crm.vtiger.GenericUtils.ListnerImpltn.class)
public class CreateFilter extends BaseClass {
	
	@Test
	public void createFilterTest() throws Throwable {
		
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
		op.fliter(oppoName);
		String actSucMsg = cnoppo.popupMSg(driver);
		//Assert.fail();
		
		wlib.acceptAlert(driver);
	

		//validation
		//Assert.assertTrue(actSucMsg.contains("Are You Sure You want to Delete?"));
	}
}
