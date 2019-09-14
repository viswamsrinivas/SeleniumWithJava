package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parent.BaseFunctions;

public class TalksPage extends BaseFunctions {

	  
	  public TalksPage(WebDriver driver) {
		  PageFactory.initElements(driver, TalksPage.class);
		  System.out.println("driver=" + driver); 
	  }
	  
	  public TalksPage()
	  {
		  
	  }
	  
	  public boolean checkTalksPageContentDisplayed(String heading)
	  {
		  List<WebElement> projects = driver.findElements(By.className(".talk-card"));
		  return (driver.getPageSource().contains(heading) && !projects.isEmpty());
	  }
}
