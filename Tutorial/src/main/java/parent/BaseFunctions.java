package parent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseFunctions {
	
	public static WebDriver driver;
	public static Properties properties;
	
	public BaseFunctions() {
		
		try {
			properties = new Properties();
			FileInputStream inputStream;
			inputStream = new FileInputStream("/Users/Srinivas/eclipse-workspace/Tutorial/src/main/java/configurations/config.properties");
			properties.load(inputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void initialize() {
		System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe"); //set your Chrome driver's location
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(18, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
