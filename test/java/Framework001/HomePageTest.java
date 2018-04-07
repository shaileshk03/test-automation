package Framework001;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.TestBase;

public class HomePageTest extends TestBase {

	HomePage page;

	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

	public void getHomepage_LinksAndVerify() throws InterruptedException {
		page = new HomePage(driver);

	}

	public void NewUser_RegistrationTest() throws InterruptedException {
		page = new HomePage(driver);
		HomePage.HoverAndClick(driver, page.YourOrderLink,
				page.NewCustomer_Starthere);
		page.verifyNewUser_Registration("Alex", "736998888", "Alex@gmail.com",
				"test@123");
	}

	public void checkHomePage_LinkResponse() throws InterruptedException {
		page = new HomePage(driver);
		page.getAllLinks();
		page.verifyLinkActive("http://www.amazon.in");
	}

	public void imageTest() {
		page = new HomePage(driver);
		page.validateInvalid_Image();

	}

	@Test
	public void verifyProducts() {
		page = new HomePage(driver);
		page.clickOnProducts_HomePage(page.SAREES);

	}

}
