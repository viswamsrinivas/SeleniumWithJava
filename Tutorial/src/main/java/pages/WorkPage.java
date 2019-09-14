package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parent.BaseFunctions;

public class WorkPage extends BaseFunctions {

	  
	  public WorkPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public WorkPage() {
		 
	  }
	  
	  public boolean checkWorkPageContentDisplayed(String heading)
	  {
		  List<WebElement> projects = driver.findElements(By.className(".project-card"));
		  return (driver.getPageSource().contains(heading) && !projects.isEmpty());
	  }
}
