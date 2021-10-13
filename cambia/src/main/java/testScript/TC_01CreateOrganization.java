package testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_01CreateOrganization {


	

	@Test
	public void createOrganizationTest() throws Throwable {
		WebDriverUtility wutil=new WebDriverUtility();

		FileUtility file=new FileUtility();
		String un = file.getPropertyKeyValue("username");
		String pwd = file.getPropertyKeyValue("password");
		String url = file.getPropertyKeyValue("url");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		wutil.waitUntilPageLoad(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();	
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		ExcelUtility ex=new ExcelUtility();
		String excelData1 = ex.getExceData("Sheet1", 1, 1);
		driver.findElement(By.name("accountname")).sendKeys(excelData1+JavaUtility.getRandomData());
		String excelData2 = ex.getExceData("Sheet1", 1, 2);
		driver.findElement(By.name("website")).sendKeys(excelData2);
		WebElement industry = driver.findElement(By.name("industry"));
		wutil.SelectOption(industry, 27);
		//Select s=new Select(industry);
		//s.selectByIndex(27);
		WebElement type = driver.findElement(By.name("accounttype"));
		wutil.SelectOption(type, 10);
		//Select s1=new Select(type);
		//s1.selectByIndex(10);
		WebElement rating = driver.findElement(By.name("rating"));
		Select s2=new Select(rating);
		driver.findElement(By.xpath("//input[@value='U']")).click();
		driver.findElement(By.name("bill_street")).sendKeys("Devasree");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='button'][1]")).click();
		Thread.sleep(2000);
		WebElement signout = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
		wutil.mouseOver(driver, signout);
	//Actions a= new Actions(driver);
			//a.moveToElement(signout).perform();
	driver.findElement(By.linkText("Sign Out")).click();
		//driver.close();
	}

}
