/* Class Created from Sunil S Daivajna on 15/02/2022
 * */

package GreatLearning.DemoTest.Utilities;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilities {
	
	 public static WebDriver driver=null;
	 public static WebElement element=null;
	 public static List<WebElement> elements = null;
	 static Logger log  =Logger.getLogger("devpinoyLogger");	
	 
	 
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
					"config",Locale.getDefault());
					return resourceBundle.getString(a);
		}
		
		
		/*
	     * Fetch webelement for a provided string locator
	     *
	     * @param locator driver
	     * @return WebElement
	     */
	    public static WebElement getWebElement(String locator, WebDriver driver) {

	        int start = locator.indexOf("==");
	        String identifier = locator.substring(0, start).toLowerCase();
	        String attrValue = locator.substring(start + 2);
	        

	        
	        try {
	            if (identifier.equalsIgnoreCase("id")) {
	                element = driver.findElement(By.id(attrValue));
	            } else if (identifier.equalsIgnoreCase("name")) {
	                element = driver.findElement(By.name(attrValue));
	            } else if (identifier.equalsIgnoreCase("xpath")) {
	                element = driver.findElement(By.xpath(attrValue));
	            } else if (identifier.equalsIgnoreCase("css")) {
	                element = driver.findElement(By.cssSelector(attrValue));
	            } else if (identifier.equalsIgnoreCase("link")) {
	                element = driver.findElement(By.linkText(attrValue));
	            } else if (identifier.equalsIgnoreCase("partiallink")) {
	                element = driver.findElement(By.partialLinkText(attrValue));
	            } else if (identifier.equalsIgnoreCase("tagname")) {
	                element = driver.findElement(By.tagName(attrValue));
	            } else if (identifier.equalsIgnoreCase("classname")) {
	                element = driver.findElement(By.className(attrValue));
	            } else {
	               
	            }
	        } catch (NoSuchElementException e) {
	        	e.printStackTrace();
	            log.error("No Element  found: " + e);
	            log.info("Please verify if the xpath is in format of <xpath==>");
	            Assert.fail("FAIL: Element  <" + locator + ">", e);
	        } catch (ElementNotVisibleException notvisible) {
	            log.error("Element not visible ");
	            return null;
	        }
	        return element;
	    }	
		
	    /*
	     * Fetch list of webelement for a string locator
	     *
	     * @param locator and driver
	     * @return
	     */
	    public static List<WebElement> getWebElements(String locator,WebDriver driver) {

	        int start = locator.indexOf("==");
	        String identifier = locator.substring(0, start).toLowerCase();
	        String attrValue = locator.substring(start + 2);
	        log.info("attrValue: " + attrValue);

	        try {
	            if (identifier.equalsIgnoreCase("id")) {
	                elements = driver.findElements(By.id(attrValue));
	            } else if (identifier.equalsIgnoreCase("name")) {
	                elements = driver.findElements(By.name(attrValue));
	            } else if (identifier.equalsIgnoreCase("xpath")) {
	                elements = driver.findElements(By.xpath(attrValue));
	            } else if (identifier.equalsIgnoreCase("css")) {
	                elements = driver.findElements(By.cssSelector(attrValue));
	            } else if (identifier.equalsIgnoreCase("link")) {
	                elements = driver.findElements(By.linkText(attrValue));
	            } else if (identifier.equalsIgnoreCase("partiallink")) {
	                elements = driver.findElements(By.partialLinkText(attrValue));
	            } else if (identifier.equalsIgnoreCase("tagname")) {
	                elements = driver.findElements(By.tagName(attrValue));
	            } else if (identifier.equalsIgnoreCase("classname")) {
	                elements = driver.findElements(By.className(attrValue));
	            } else {
	                log.error("No such object exists ");
	            }
	        } catch (NoSuchElementException e) {
	        	e.printStackTrace();
	            log.error("No Element  found: " + e);
	            log.info("Please verify if the xpath is in format of <xpath==>");
	            Assert.fail("FAIL: Element  <" + locator + ">", e);
	        } catch (ElementNotVisibleException notvisible) {
	            log.error("Element not visible ");
	            return null;
	        }
	        return elements;
	    }
		
	
	 
	 /*
	     * scroll to a view
	     *
	     * @param locator to scroll element into view
	     */
	    public static void fnScrollIntoView(String locator, WebDriver driver) {
	       
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", getWebElement(locator,driver));
	    }
	
	    /* Check for WaitForVisibilityOfElement
	     * @param locator
	     */
	   
		public static void fnWaitForVisibilityOfElement(String locator,WebDriver driver) {
	    	
	    	FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20)).ignoring(StaleElementReferenceException.class);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(getWebBy(locator,driver)));
	    } 
		
	    /*
	     * returns object type for a string locator
	     *
	     * @param locator
	     * @return
	     */
	    public static By getWebBy(String locator,WebDriver driver) {
	        int start = locator.indexOf("==");
	        String identifier = locator.substring(0, start).toLowerCase();
	        String attrValue = locator.substring(start + 2);
	        
	        By by = null;

	        try {
	            if (identifier.equalsIgnoreCase("id")) {
	                by = By.id(attrValue);
	            } else if (identifier.equalsIgnoreCase("name")) {
	                by = By.name(attrValue);
	            } else if (identifier.equalsIgnoreCase("xpath")) {
	                by = By.xpath(attrValue);
	            } else if (identifier.equalsIgnoreCase("css")) {
	                by = By.cssSelector(attrValue);
	            } else if (identifier.equalsIgnoreCase("link")) {
	                by = By.linkText(attrValue);
	            } else if (identifier.equalsIgnoreCase("partiallink")) {
	                by = By.partialLinkText(attrValue);
	            } else if (identifier.equalsIgnoreCase("tagname")) {
	                by = By.tagName(attrValue);
	            } else if (identifier.equalsIgnoreCase("classname")) {
	                by = By.className(attrValue);
	            } else {
	                log.error("No such object exists ");
	            }
	        } catch (Exception e) {
	            log.error(" Exception " + e);
	            log.info("Please verify if the xpath is in format of <xpath==>");
	            Assert.fail("FAIL: Element  <" + locator + ">", e);
	        }
	        return by;

	    }
	    
	    /*
		    * Method to get test data from configTestData.properties 
		    */
			public static String getTestData(String a)
			{	
				
				ResourceBundle resourceBundle = ResourceBundle.getBundle(
						"testdata",Locale.getDefault());
						return resourceBundle.getString(a);
			}

}
