package testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.CreateNewOpportunity;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.Opportunity;

public class TC_31 {

	public static void main(String args[]) throws Throwable {
		String oppoNmae="testyantra";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.waitUntilPageLoad(driver);
		FileUtility file=new FileUtility();
		String url = file.getPropertyKeyValue("url");
		driver.get(url);
		Login lg= new Login(driver);
		lg.loginToApp("admin", "admin");
		Home home=new Home(driver);
		home.getOpportunitiesLink().click();;
		Opportunity oppo=new Opportunity(driver);
		oppo.getCreateOppoImg().click();
		CreateNewOpportunity newoppo=new CreateNewOpportunity(driver);
		newoppo.createOppo("testyantra");
		//newoppo.getRelatedto();
		newoppo.getRelatedtoSelect();
		
		
		
		
		
		home.logout();
	}
	
}
