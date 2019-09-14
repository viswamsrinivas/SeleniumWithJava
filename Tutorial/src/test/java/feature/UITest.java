package feature;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AboutUsPage;
import pages.BlogsPage;
import pages.ContactUsPage;
import pages.HomePage;
import pages.TalksPage;
import pages.WorkPage;
import parent.BaseFunctions;

public class UITest extends BaseFunctions {

	HomePage homePage;
	AboutUsPage aboutUsPage;
	WorkPage workPage;
	TalksPage talksPage;
	ContactUsPage contactUsPage;
	BlogsPage blogsPage;
	
	public UITest() throws IOException{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homePage = new HomePage(driver);
		aboutUsPage = new AboutUsPage(driver);
		workPage = new WorkPage(driver);
		talksPage = new TalksPage(driver);
		contactUsPage = new ContactUsPage(driver);
		blogsPage = new BlogsPage(driver);
	}
	
	@Test
	public void verifyAboutUsPage() 
	{
		driver.get(properties.getProperty("startupURL"));
		homePage.clickAboutButton();
		Assert.assertTrue(aboutUsPage.checkAboutContentDisplayed());
	}
	
	@Test
	public void verifyWorkPage() 
	{
		driver.get(properties.getProperty("startupURL"));
		homePage.clickWorkButton();
		Assert.assertTrue(workPage.checkWorkPageContentDisplayed(properties.getProperty("workPageContent")));
	}
	
	@Test
	public void verifyTalksPage() 
	{
		driver.get(properties.getProperty("startupURL"));
		homePage.clickTalksButton();
		Assert.assertTrue(talksPage.checkTalksPageContentDisplayed(properties.getProperty("talksPageContent")));
	}
	
	@Test
	public void verifyContactUsPage() 
	{
		driver.get(properties.getProperty("startupURL"));
		homePage.clickContactUsButton();
		Assert.assertTrue(contactUsPage.checkContactUsPageContentDisplayed());
	}
	
	@Test
	public void verifyBlogPage() 
	{
		driver.get(properties.getProperty("startupURL"));
		homePage.clickBlogstButton();
		Assert.assertTrue(blogsPage.checkBlogsPageContentDisplayed(properties.getProperty("blogPageURL")));
	}
	
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}
