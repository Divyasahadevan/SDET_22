package com.crm.vtiger.GenericUtils;

import org.apache.poi.ss.formula.functions.LogicalFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.vtiger.GenericUtils.DataBaseUtility;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;

public class BaseClass {
	
	public DataBaseUtility dLib= new DataBaseUtility();
	public ExcelUtility elib= new ExcelUtility();
	public FileUtility flib= new FileUtility();
	public JavaUtility jlib= new JavaUtility();
	public WebDriverUtility wlib= new WebDriverUtility();
	public WebDriver  driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"smoketest", "regression"})
	public void connectDB() throws Throwable {
		//dLib.connectDB();
		System.out.println("============DB Connection successfull==============");

	}
	@Parameters(value= {"browser"})
	@BeforeClass(groups= {"smoketest","regression"})
	public void launchBrowser(@Optional("Chrome") String BROWSER) throws Throwable {
		//read data from property file
		//String BROWSER = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		System.out.println("===============browser launch successfull===============");
		wlib.maximizeWindow(driver);
		wlib.waitUntilPageLoad(driver);
		driver.get(URL);
		sdriver=driver;
	}
	
	@BeforeMethod(groups= {"smoketest"})
	public void loginToApp() throws Throwable
	{
		// read data from property file
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		//login to app
		Login lp= new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("==================login successfull=====================");
	}
	
	@AfterMethod(groups= {"smoketest"})
	public void logoutOfApp() {
		//sign out of home page
		Home hp= new Home(driver);
		hp.logout();
		System.out.println("======================sign out successfull===============");
		
	}
	
	@AfterClass(groups= {"smoketest"})
	public void closeBrowser() {
		driver.close();
		System.out.println("=================browser closed successfully============");
	}
	@AfterSuite(groups= {"smoketest"})
	public void closedDb() {
		//dLib.closeDb();
		System.out.println("======================DB connetion closed successfully==========");
	}
}
