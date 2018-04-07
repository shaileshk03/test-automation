package Framework001;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.signInPage_amazon;
import Pages.TestBase;


public class verifyLogin extends TestBase{
   
	signInPage_amazon homepage;
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

    @Test
	public void test(){
		homepage = new signInPage_amazon(driver);
		
	}



}
