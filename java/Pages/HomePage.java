package Pages;

import java.awt.Image;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

	static WebDriver driver;

	public final String Hello_SignIn = "Hello. Sign in";

	public final String MENS_TSHIRTS = "men's tshirt'";
	public final String SAREES = "Sarees";

	private int invalidImageCount;

	// Locator for Registration
	@FindBy(xpath = "html/body/div[1]/header/div/div[3]/div[2]/div/a[1]/span[2]")
	public WebElement YourOrderLink;

	@FindBy(xpath = "html/body/div[1]/header/div/div[1]/div[4]/div[6]/div[1]/div/a")
	public WebElement NewCustomer_Starthere;

	@FindBy(xpath = "//input[@id='ap_customer_name']")
	public WebElement CreateAccount_yourName;

	@FindBy(xpath = "//input[@id='ap_phone_number']")
	public WebElement CreateAccount_Mobile;

	@FindBy(xpath = "//input[@id='ap_email']")
	public WebElement CreateAccount_EmailAddress;

	@FindBy(xpath = "//input[@id='ap_password']")
	public WebElement CreateAccount_password;

	@FindBy(xpath = "//input[@id='continue']")
	public WebElement CreateAccount_Continuebnt;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Get All links and HTTP Response
	public static void getAllLinks() throws InterruptedException {
		List<WebElement> AllLinklist = driver.findElements(By.tagName("a"));
		for (int i = 0; i < AllLinklist.size(); i++) {
			WebElement ele = AllLinklist.get(i);
			String url = ele.getAttribute("href");
			verifyLinkActive(url);
		}
	}

	// verify Http response For Web Links
	public static void verifyLinkActive(String linkurl) {
		try {

			URL url = new URL(linkurl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url
					.openConnection();
			httpUrlConnection.setConnectTimeout(3000);
			httpUrlConnection.connect();

			if (httpUrlConnection.getResponseCode() == 200) {
				System.out.println(linkurl + "-"
						+ httpUrlConnection.getResponseMessage());
			}
			if (httpUrlConnection.getResponseCode() == httpUrlConnection.HTTP_NOT_FOUND) {
				System.out.println(linkurl + "-"
						+ httpUrlConnection.getResponseMessage() + "-"
						+ httpUrlConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {
		}
	}

	// Mouse Hover and Click
	public static void HoverAndClick(WebDriver driver,
			WebElement elementToHover, WebElement elementToClick)
			throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(elementToHover).click(elementToClick).build()
				.perform();
		Thread.sleep(1000);
	}

	// Registration New User
	public void verifyNewUser_Registration(String yourName, String Mobile,
			String EmailAddress, String password) {
		this.CreateAccount_yourName.sendKeys(yourName);
		log.info("Entered user name and the object is :"
				+ this.CreateAccount_yourName.toString());
		this.CreateAccount_Mobile.sendKeys(Mobile);
		log.info("Entered Mobile number and the object is:"
				+ this.CreateAccount_Mobile.toString());
		this.CreateAccount_EmailAddress.sendKeys(EmailAddress);
		log.info("Entered Email address and object is:"
				+ this.CreateAccount_EmailAddress.toString());
		this.CreateAccount_password.sendKeys(password);
		log.info("Entered password and object is: "
				+ this.CreateAccount_password.toString());
		this.CreateAccount_Continuebnt.click();
		log.info("Clicked on continue button and object is:"
				+ this.CreateAccount_Continuebnt);
	}

	@FindBy(xpath = "//i[@class='a-icon a-icon-next-rounded']")
	protected WebElement imgSlider;

	@FindBy(xpath = "//img[@alt='Personal Care Products']")
	public static WebElement prd_personalCare;

	// verify image present on UI
	public boolean isImagePresent() {
		if (prd_personalCare.isDisplayed()) {
			log.info("Image displayed on User Interface"
					+ prd_personalCare.toString());
			prd_personalCare.click();
			log.info("Element found and clicked");
			return true;
		}
		log.info("Element not found");
		return false;
	}

	// verify Http response of images available on Home page
	public void validateInvalid_Image() {
		try {
			invalidImageCount = 0;
			List<WebElement> imageList = driver.findElements(By.tagName("img"));
			log.info("Total numbers of images are " + imageList.size());
			for (int i = 0; i < imageList.size(); i++) {
				log.info(imageList.get(i));
				String linkURL = imageList.get(i).getAttribute("src");
				log.info(" " + imageList.get(i).getText());
				URL url = new URL(linkURL);
				HttpURLConnection http = (HttpURLConnection) url
						.openConnection();
				http.setConnectTimeout(10000);
				http.setReadTimeout(20000);
				int statusCode = http.getResponseCode();
				if (statusCode == 404 || statusCode == 500) {
					invalidImageCount = invalidImageCount + 1;
					System.out.println(linkURL + "and its Status codes is:"
							+ statusCode);
				}
			}
			log.info("total number of broken images are: " + invalidImageCount);

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Error" + e.getMessage());
		}
	}

	// Extract text of an image and read it.
	public void Extract_ImageText() throws IOException {
		String imgUrl = driver.findElement(By.xpath("")).getAttribute("src");
		log.info("Image source path : \n" + imgUrl);

		try {
			URL url = new URL(imgUrl);
			Image image = ImageIO.read(url);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void clickOnProducts_HomePage(String data) {
		String locator = "//*[@alt='" + data + "']";
		driver.findElement(By.xpath(locator)).click();
	}

	@FindBy(xpath = ".//*[contains(text(),'Facebook')]")
	private WebElement facebook_lnk;

	@FindBy(xpath = ".//*[@class='_3oba' and contains(text(),'See more of Amazon India on Facebook')]")
	private WebElement facebookMsg;

	public void clickOnFacebookLink() {
		facebook_lnk.click();
		log.info("clicked on facebook link object is" + facebook_lnk.toString());
	}

	public boolean veifyFacebookMessage() {
		try {
			facebookMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
