package feature;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import parent.BaseFunctions;

public class SmokeTest extends BaseFunctions{
	
	HomePage homePage;
	
	public SmokeTest() throws IOException{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homePage = new HomePage(driver);
	}
	
	@Test
	public void verifyWebsiteIsLive() {
		driver.get(properties.getProperty("startupURL"));
		Assert.assertTrue(homePage.checkSiteDisplayedToUser());
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}
