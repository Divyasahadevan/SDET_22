package testscript_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class AutomationToolKit extends WebDriverUtility {
	@Test
	public void AutomationToolsQATest() throws Throwable {
		WebDriver driver=new ChromeDriver();
		maximizeWindow(driver);
		waitUntilPageLoad(driver);
		driver.get("https://demoqa.com/tool-tips");
		WebElement tooltips = driver.findElement(By.id("toolTipButton"));
		mouseOver(driver, tooltips);
		String message = driver.findElement(By.xpath("//div[@class='tooltip-inner']")).getText();
		Thread.sleep(1000);
		System.out.println(message);
		driver.findElement(By.id("toolTipTextField")).sendKeys(message);
		driver.close();
		
	}

}
