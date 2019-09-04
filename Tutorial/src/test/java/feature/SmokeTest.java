package feature;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AboutUsPage;
import pages.HomePage;
import parent.BaseFunctions;

public class SmokeTest extends BaseFunctions{
	
	HomePage homePage;
	AboutUsPage aboutUsPage;
	
	public SmokeTest() throws IOException{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homePage = new HomePage(driver);
		aboutUsPage = new AboutUsPage(driver);
	}
	
	@Test
	public void verifyWebsiteIsLive()
	{
		driver.get(properties.getProperty("startupURL"));
		Assert.assertTrue(homePage.checkSiteDisplayedToUser());
	}
	
	@Test
	public void verifyAboutUsSession() 
	{
		driver.get(properties.getProperty("startupURL"));
		homePage.clickAboutButton();
		Assert.assertTrue(aboutUsPage.checkAboutContentDisplayed());
	}
	
	@Test
	public void checkForBrokenLinks()
	{
		driver.get(properties.getProperty("startupURL"));
		HttpURLConnection con = null;
		int responseCode;
		int brokenLinkCount =0;
		List<WebElement> links = driver.findElements(By.xpath("//header[@class='mobile-hide']//a"));
		System.out.println(links.size());
		for(Integer i=1;i<links.size();i++)
		{
			 driver.findElement(By.xpath("(//header[@class='mobile-hide']//a)["+i.toString()+"]")).click();
                   
				 try {
		                con = (HttpURLConnection)(new URL(driver.getCurrentUrl()).openConnection());	               
		                con.connect();		                
		                responseCode = con.getResponseCode();		                
		                if(responseCode >= 400)
		                {
		                	System.out.println(responseCode);
		                    System.out.println(driver.getCurrentUrl());
		                    brokenLinkCount ++ ;
		                }
				     }
				 catch (Exception e)
				        {
		                e.printStackTrace();
		                }
				driver.navigate().to(properties.getProperty("startupURL"));
	     }
		Assert.assertEquals(brokenLinkCount, 0,"There are broken links in the page");
	}
	
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}
