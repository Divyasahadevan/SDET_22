package com.crm.vtiger.GenericUtils;

import org.testng.ITestResult;
import org.testng.util.RetryAnalyzerCount;

public class RetryAnalyzer extends RetryAnalyzerCount {
 int count=0;
 int retrycount=3;
@Override
public boolean retryMethod(ITestResult result) {
	while(count <retrycount)
	{
	    count++;
		return true;
	
	}
	return false;
}
 
	
}
