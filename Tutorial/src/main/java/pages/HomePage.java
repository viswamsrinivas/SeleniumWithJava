package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parent.BaseFunctions;

public class HomePage extends BaseFunctions{
	
  @FindBy(css="a>img[src*=logo][title='Tarka Labs']")
  WebElement logo;
  
  @FindBy(css=".mobile-hide a[href='/about']")
  WebElement aboutButton;
  
  @FindBy(css=".mobile-hide a[href='/works']")
  WebElement workButton;
  
  @FindBy(css=".mobile-hide a[href='/talks']")
  WebElement talksButton;
  
  @FindBy(css=".mobile-hide a[href*='medium']")
  WebElement blogsButton;
  
  @FindBy(css=".mobile-hide a[href='/#contact-us']")
  WebElement contactUsButton;
  
  TalksPage talksPage;
		
  public HomePage(WebDriver driver){
	  PageFactory.initElements(driver, this);
	  
  }
  
  public boolean checkSiteDisplayedToUser()
  {
	  return logo.isDisplayed();
  }
  
  public void clickAboutButton() 
  {
	aboutButton.click();  
  }
 
  public void clickWorkButton() 
  {
	workButton.click();  
  }
  
  public TalksPage clickTalksButton() 
  {
	talksButton.click();
	return talksPage;
  }
  
  public void clickBlogstButton() 
  {
	blogsButton.click();  
  }
  
  public void clickContactUsButton() 
  {
	contactUsButton.click();  
  }

}
