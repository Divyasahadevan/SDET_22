package testScript;

import java.util.Iterator;
import java.util.Set;
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
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_02CreateContact {


	@Test
	public void createContactTest() throws Throwable
	{
		FileUtility file=new FileUtility();
		String un = file.getDataFromJson("username");
		String pwd = file.getDataFromJson("password");
		String url = file.getDataFromJson("url");
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement firstname = driver.findElement(By.name("salutationtype"));

		Select s=new Select(firstname);
		s.selectByValue("Mrs.");
		ExcelUtility ex=new ExcelUtility();
		String excelData1 = ex.getExceData("Sheet1", 3, 2);
		driver.findElement(By.name("firstname")).sendKeys(excelData1);
		String excelData2 = ex.getExceData("Sheet1", 3, 1);
		driver.findElement(By.name("lastname")).sendKeys(excelData2);
		driver.findElement(By.xpath("//img[@alt='Select'][1]")).click();
		String pwh = driver.getWindowHandle();

		Set<String> allwh = driver.getWindowHandles();
		int count=allwh.size();
		Iterator<String >it=allwh.iterator(); 
		while(it.hasNext())
		{
			String id=it.next();
			if(!pwh.equals(id))
			{
				WebDriver windowhandle = driver.switchTo().window(id);
				windowhandle.getTitle();
				driver.findElement(By.linkText("testyantra")).click();
			}
		}
		driver.switchTo().window(pwh);
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a= new Actions(driver);
		a.moveToElement(signout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();


	}
}
