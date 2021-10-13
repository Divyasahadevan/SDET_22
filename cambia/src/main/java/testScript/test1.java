package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class test1 {
	static {
		System.setProperty("webdriver.chrome.driver", "./cambia/chromedriver1.exe");
	}
	
	@Test
	public void createOrganizationTest() {
		 
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();	
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("testyantra7");
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
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions a= new Actions(driver);
			a.moveToElement(signout).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	driver.close();
	}

}