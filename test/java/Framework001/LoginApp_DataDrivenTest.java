package Framework001;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.signInPage_amazon;
import Pages.TestBase;

public class LoginApp_DataDrivenTest extends TestBase {

	public static final Logger log = Logger.getLogger(LoginApp_DataDrivenTest.class.getName());
		
	signInPage_amazon homepage ;
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
		homepage = new signInPage_amazon(driver);
	}
	
	@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords = getData("Login.xlsx","LoginDetails");
		return testRecords;
	}
	
	@Test(dataProvider="loginData")
	public void verifyLogin_DataDrivenTest(String emailAddress, String loginPassword, String runMode){
		homepage = new signInPage_amazon(driver);
	    if(runMode.equalsIgnoreCase("n")){
	    	throw new SkipException("user marked as no run");
	    }
		  try {
			log.info("==========>> Starting Login Test with Data Drivern <<===========");
			homepage.loginAccount_DataDrivenTest(emailAddress, loginPassword);  
			
		    log.info("==========>> Finished Test Login with Data Drivern <<===========");
			getScreenShot("verify Login Test using Data driven Test");
		} catch (Exception e) {
			getScreenShot("verify Login Test using Data Driven Test");
		}
		  
	}
	
}
