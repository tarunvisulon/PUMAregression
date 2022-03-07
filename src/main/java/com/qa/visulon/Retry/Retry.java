package com.qa.visulon.Retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int retryCount=0;
	private int maxretryCount=3;
	
	
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount<maxretryCount)
		{
			retryCount++;
			return true;
		}
		
		return false;
	}

}
