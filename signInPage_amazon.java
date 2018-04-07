package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class signInPage_amazon extends TestBase {

	WebDriver driver;
	
	@FindBy(xpath="//span[contains(text(),'Hello. Sign in')]")
	public WebElement Hello_Singin_Link;
	
	
	@FindBy(xpath="//input[@id='ap_email']")
	public WebElement Login_Email;
	
	@FindBy(xpath="//input[@id='continue']")
	public WebElement Login_Continuebtn;
	
	@FindBy(xpath="//input[@id='ap_password']")
	public WebElement Login_Password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	public WebElement Login_Submitbtn;
	
    // Required Xpath here 
	@FindBy(xpath="")
	public WebElement Logout_btn; 
	
	
	public signInPage_amazon(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginAccount_DataDrivenTest(String emailAddress, String loginPassword){
		 Hello_Singin_Link.click();
		 Login_Email.sendKeys(emailAddress);
		 Login_Continuebtn.click();
		 Login_Password.sendKeys(loginPassword);
		 Login_Submitbtn.click();
	}
	
	public boolean verifyLogoutDisplay(){
		try {
		    Logout_btn.isDisplayed();
		} catch (Exception e) {
			return true;
		 }
		return false;	
	  }
	
	
	public void clickLogout(){
		Logout_btn.click();
	}
	
	
	
	
}

