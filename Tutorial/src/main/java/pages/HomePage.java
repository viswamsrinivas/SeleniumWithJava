package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parent.BaseFunctions;

public class HomePage extends BaseFunctions{
	
  @FindBy(css="a>img[src*=logo][title='Tarka Labs']")
  WebElement logo;
		
  public HomePage(WebDriver driver){
	  PageFactory.initElements(driver, this);
	  
  }
  
  public boolean checkSiteDisplayedToUser()
  {
	  return logo.isDisplayed();
  }

}
