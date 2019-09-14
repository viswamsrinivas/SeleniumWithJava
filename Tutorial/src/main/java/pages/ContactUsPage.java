package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parent.BaseFunctions;

public class ContactUsPage extends BaseFunctions {

	@FindBy(css="form")
	  WebElement form;
	  
	  public ContactUsPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public ContactUsPage()
	  {
		  
	  }
	  
	  public boolean checkContactUsPageContentDisplayed()
	  {
		  return form.isDisplayed();
	  }
}
