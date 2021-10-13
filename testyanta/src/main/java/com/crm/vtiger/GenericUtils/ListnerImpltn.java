package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

public class ListnerImpltn implements ITestListener {
  
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		Date date= new Date();
	String currentdate = date.toString().replace(" ", "_").replace(":", "_");
		
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./screenshot/"+testName+currentdate+".png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}



}
