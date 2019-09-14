package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parent.BaseFunctions;

public class BlogsPage extends BaseFunctions {

	  
	  public BlogsPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public BlogsPage() {
	  }
	  
	  public boolean checkBlogsPageContentDisplayed(String heading)
	  {
		  List<WebElement> projects = driver.findElements(By.className(".postItem"));
		  return (driver.getTitle().contentEquals(heading) && !projects.isEmpty());
	  }
}
