package testscript;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_69EditMultipleScenarioMassEdit {
	@Test
	public void AdvanceSearchTest() throws Throwable
	{
		WebDriverUtility wutil=new WebDriverUtility();

		FileUtility file=new FileUtility();
		String un = file.getPropertyKeyValue("username");
		String pwd = file.getPropertyKeyValue("password");
		String url = file.getPropertyKeyValue("url");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		wutil.waitUntilPageLoad(driver);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.id("33")).click();
		driver.findElement(By.id("34")).click();
		driver.findElement(By.xpath("(//input[@value='Mass Edit'])[1]")).click();
		ExcelUtility ex=new ExcelUtility();
		String opponame = ex.getExceData("Sheet1", 2, 2);
		driver.findElement(By.name("potentialname")).sendKeys(opponame);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
	}
}