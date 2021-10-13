package testscript;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_34advanceSearch {
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
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		ExcelUtility ex=new ExcelUtility();
		String opportunityname = ex.getExceData("Sheet1", 1, 1);
		driver.findElement(By.name("potentialname")).sendKeys(opportunityname);
		WebElement relatedto = driver.findElement(By.id("related_to_type"));
		wutil.SelectOption(relatedto, 1);
		driver.findElement(By.xpath("//input[@value='U']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();;
		String pwh = driver.getWindowHandle();
		Set<String> allwh = driver.getWindowHandles();
		int count = allwh.size();
		for(String wh:allwh) {
			driver.switchTo().window(wh);
			if(!pwh.equals(wh))
			{
				driver.findElement(By.linkText("testyantra testyantra")).click();
			}
		}
		driver.switchTo().window(pwh);
		driver.findElement(By.id("jscal_trigger_closingdate")).click();;
		//driver.findElement(By.xpath("(//td[contains(@class,'day')])[2]")).click();
		WebElement salestage = driver.findElement(By.name("sales_stage"));
		wutil.SelectOption(salestage, 0);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		driver.findElement(By.linkText("Opportunities")).click();

		driver.findElement(By.linkText("Go to Advanced Search")).click();
		WebElement option = driver.findElement(By.id("fcol0"));
		wutil.SelectOption(option, 14);
		WebElement option1 = driver.findElement(By.id("fop0"));
		wutil.SelectOption(option1, 1);
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
		
	}}