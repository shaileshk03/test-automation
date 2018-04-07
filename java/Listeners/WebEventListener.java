package Listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;




import com.relevantcodes.extentreports.LogStatus;

import Pages.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public static final Logger log = Logger.getLogger(WebEventListener.class);
	
	@Override
	public void beforeAlertAccept(WebDriver driver) {
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		log("Before Navigating to :" + url + "'");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		log("Navigated to :" + url + "'");
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		log("Navigating back to previous page");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		log("Navigated back to previous page");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		log("Navigating forward to next page");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		log("Navigated forward to next page");
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		log("Navigating to Refresh");
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		log("Navigated to Refresh");
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log("Trying to find element by :" + by.toString());
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log("Trying to find element By :" + by.toString());
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		log("Found element By :" + element.toString());
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		log("Clicked on :" + element.toString());
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver,
			CharSequence[] keysToSend) {
		log( "Value of the :" + element.toString() + " before any changes made");
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver,
			CharSequence[] keysToSend) {
		log("Element value changed to : " + element.toString() +"'");
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
	  log(" Exception occured " + throwable );
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
		test.log(LogStatus.INFO, data);
	}

}
