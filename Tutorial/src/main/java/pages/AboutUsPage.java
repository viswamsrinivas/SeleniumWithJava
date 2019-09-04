package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parent.BaseFunctions;

public class AboutUsPage extends BaseFunctions {

	  @FindBy(id="whatwedo")
	  WebElement whatWeDoColumn;
	  
	  public AboutUsPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public boolean checkAboutContentDisplayed()
	  {
		  return whatWeDoColumn.isDisplayed();
	  }
}
