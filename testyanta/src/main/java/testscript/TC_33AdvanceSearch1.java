package testscript;

import java.text.*;
import java.time.*;
import java.lang.*;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class TC_33AdvanceSearch1 {
	
	WebDriver driver;
	
	@BeforeSuite
	public void Initialize()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void AdvanceSearchTest() throws Throwable
	{
		FileUtility file=new FileUtility();
		String un = file.getPropertyKeyValue("username");
		String pwd = file.getPropertyKeyValue("password");
		String url = file.getPropertyKeyValue("url");
		
		ExcelUtility ex=new ExcelUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		 
		driver.get(url);
		wutil.waitUntilPageLoad(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		
		String opportunityname = ex.getExceData("Opportunitydata", 1, 1);
		driver.findElement(By.name("potentialname")).sendKeys(opportunityname);
		WebElement relatedto = driver.findElement(By.id("related_to_type"));
		wutil.SelectOption(relatedto, 1);
		driver.findElement(By.xpath("//input[@value='U']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//form[@name='EditView']//img[@src='themes/softed/images/btnL3Calendar.gif']")).click();
		
		Thread.sleep(2000);
		
		LocalDate dt = LocalDate.now();
		LocalDate reqDate = LocalDate.of(2018, 01, 01);
		// find out how many years to go back
		int cYear = dt.getYear() - reqDate.getYear();
		// find out how many months to go back. 
		// Sometimes, we may have to go forward.
		int cMonth = dt.getMonthValue() - reqDate.getMonthValue();
		String mXpath = ".//div[@class='calendar'][1]/table//tr[@class='headrow']/td"; 
				
		if(cMonth > 0)
		{
			// when the month to select is lower than current month.
			mXpath = mXpath + "[2]";
		}
		else
		{
			// When month to select is greater than current month
			mXpath = mXpath + "[4]";
			cMonth *= -1;
		}
		
		for(int i = 0; i < cYear; i++)
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//div[@class='calendar'][1]/table//tr[@class='headrow']/td[1]")).click();
		}
		
		for(int j = 0; j < cMonth; j++)
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath(mXpath)).click();
		}
		
		Thread.sleep(2000);
		String xpathForDay = ".//div[@class='calendar']/table//tr[@class='daysrow']/td[@class='day' and text()='"+ reqDate.getDayOfMonth() +"']";
		driver.findElement(By.xpath(xpathForDay)).click();
		
		
		
		driver.findElement(By.xpath("//input[@value='U']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();;
		String pwh = driver.getWindowHandle();
		Set<String> allwh = driver.getWindowHandles();
		int count = allwh.size();
		Iterator<String>it = allwh.iterator(); 
		
		String id;
		while(it.hasNext())
		{
			id = it.next();
			if(!pwh.equals(id))
			{
				WebDriver windowhandle = driver.switchTo().window(id);
				windowhandle.getTitle();
				driver.findElement(By.linkText("testyantra testyantra")).click();
			}
		}
		
		driver.switchTo().window(pwh);
		//what this do?^^^^
		
		WebElement salestage = driver.findElement(By.name("sales_stage"));
		wutil.SelectOption(salestage, 0);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.linkText("Go to Advanced Search")).click();
		WebElement option = driver.findElement(By.id("fcol0"));
		wutil.SelectOption(option, 14);
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
	}
	
	@AfterSuite
	public void Finalize()
	{
		//driver.close();
		//driver.quit();
	}
}