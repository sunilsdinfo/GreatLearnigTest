package GreatLearning.DemoTest.Utilities;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilities {
	
	 public static WebDriver driver=null;
	 public WebElement element=null;
	 
	 /* Method to get Driver */
    @Parameters({ "Browser" })
	public  static WebDriver getDriver(String browser) {
		
			if(driver==null)
			{	
				if("firefox".equalsIgnoreCase(browser))
				{
					 /* Getting firefox driver from webdriver manager */
					  WebDriverManager.firefoxdriver().setup();
					  driver = new FirefoxDriver();
					 
				}
				else if("chrome".equalsIgnoreCase(browser))
				{
					
					/* Getting chrome driver from webdriver manager */
					  
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				if("ie".equalsIgnoreCase(browser))
				{
					 /* Getting firefox driver from webdriver manager */
					  WebDriverManager.iedriver().setup();
					  driver = new InternetExplorerDriver();
					 
				}
				
			}		
			return driver;
		}

	   /*
	    * Method to get object ids from config.properties 
	    */
		public static String getObjectID(String a)
		{	
			
			ResourceBundle resourceBundle = ResourceBundle.getBundle(
					"Resources/config",Locale.getDefault());
					return resourceBundle.getString(a);
		}
	 
	 @BeforeSuite
	 public void launchApplication(String url)
	 {
			driver.manage().window().maximize();
			//driver.get(getObjectID("URL"));
		 
	 };
	 @AfterSuite
	 public void closedriver()
	 {
		 driver.close();
		 
	 };
	
	 /* Finding Element by ID  */
		
		public WebElement getElementByID(String str) {
			
			 element = driver.findElement(By.id(getObjectID(str)));
			 return element;

		}
		
	 /* Finding Element by partial link text */
			 
  public WebElement getElementByLinkText(String str) {
	
			element = driver.findElement(By.id(getObjectID(str)));
			return element;
       } 
		
		/* Finding Element by Xpath */
		 
   public WebElement getElementByXpath( String str) {
			
	    element =driver.findElement(By.xpath(getObjectID(str)));
		return element;

		}
		/* Finding Element by CssSelector */
	public WebElement getElementByCssSelector(String str) {
			
			 element =driver.findElement(By.cssSelector(getObjectID(str)));
				
			    return element;

		}
		/* Finding Element by name  */
		
	public WebElement getElementByName( String str) {
			
			 element =driver.findElement(By.cssSelector(getObjectID(str)));
				
			    return element;
        }
		

}
