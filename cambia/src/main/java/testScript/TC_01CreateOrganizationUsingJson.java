package testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.FileUtility;

public class TC_01CreateOrganizationUsingJson {
	@Test
	public void createOrganizationTest() throws Throwable {
		 
		
		FileUtility file=new FileUtility();
		String un = file.getDataFromJson("username");
		String pwd = file.getDataFromJson("password");
		String url = file.getDataFromJson("url");
		WebDriver driver=new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();	
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("testyantra15");
		driver.findElement(By.name("website")).sendKeys("testyantra.com");
		
		WebElement industry = driver.findElement(By.name("industry"));
		Select s=new Select(industry);
		s.selectByIndex(27);
		WebElement type = driver.findElement(By.name("accounttype"));
		Select s1=new Select(type);
		s1.selectByIndex(10);
		WebElement rating = driver.findElement(By.name("rating"));
		Select s2=new Select(rating);
		 driver.findElement(By.xpath("//input[@value='U']")).click();
		 driver.findElement(By.name("bill_street")).sendKeys("Devasree");
		 driver.findElement(By.xpath("//input[@name='button'][1]")).click();
		/*WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions a= new Actions(driver);
			a.moveToElement(signout).perform();
	driver.findElement(By.xpath("//a[@text()='Sign Out']")).click();*/
	driver.close();
	}

}


