package com.crm.vtiger.GenericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/*
	 * author@divya
	 */
	/**
	 * *this method wait for 20sec for page loading
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * this method wait for the element to be visible
	 * @param driver
	 * @param element
	 */

	public void waitforElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method wait for the element to be clicked
	 * @param element
	 * @throws throwable
	 */
	public void waitAndClick(WebElement element)throws InterruptedException{
		int count=0;
		while(count<40) {
			try {
				element.click();
				break;
			}

			catch(Throwable e){
				Thread.sleep(1000);
				count++;

			}

		}

	}
	/**
	 * this method enables user to handle dropdown using visible text
	 * @param element
	 * @param optiom
	 */
	public void SelectOption(WebElement element,String option) {
		Select select= new Select (element);
		select.selectByVisibleText(option);
	} 
	/**
	 * this methods enables user to handle dropdownusing index
	 * @param element
	 * @param index
	 */
	public void SelectOption(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);

	}
	/**
	 * this method will perform mouse over action
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();

	}
	/**
	 * this method helps to right click operation
	 * @param driver
	 * @param element
	 * 
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * switch from one window to another
	 */
	public void switchTowindow(WebDriver driver,String partialWinTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String>it=window.iterator();
		while(it.hasNext())
		{
			String winId=it.next();
			String title=driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle)) {
				break;
			}
		}
	}
	/**
	 * Accept  alert
	 * @param driver
	 */




	public void acceptAlert (WebDriver driver)
	{
		driver.switchTo().alert().accept();

	}
	/**
	 * this method used for scrolling action in a web page
	 * @param driver
	 * @param element
	 */
	public void srollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}

	public void switchFrane(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchFrane(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchFrane(WebDriver driver,String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	public String takeScreenShot (WebDriver driver , String screenshotName)throws Throwable{
		String screenshotpath="./screenshot/"+screenshotName+JavaUtility.getCurrentDDate()+".PNG";
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(screenshotpath);
		Files.copy(src, dest);
		return screenshotpath;

	}
	public void pressEnterKey() throws Throwable{
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);	
	}



}