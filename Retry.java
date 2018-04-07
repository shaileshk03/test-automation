package Listeners;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {

	public static final Logger log = Logger.getLogger(Retry.class);
	private int retryCount = 0;
	private int maxretryCount = 3;
	
	
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount < maxretryCount){
			retryCount++;
		return true;
		}
	return false;
	}

	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAILURE";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}
	
}
