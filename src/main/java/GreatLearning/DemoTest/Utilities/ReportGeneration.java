/* Class Created from Sunil S Daivajna on 19/02/2022
 * */

package GreatLearning.DemoTest.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGeneration {
	
	ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;
    
    protected ExtentReports extent;
	public WebDriver driver;
   
    
    @BeforeTest
    @Parameters({ "Browser" })
    public void startReport( String browser) throws IOException {
    	
    	// initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Extent-Reports/extenttestReport"+new Date()+".html");
        
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", browser);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
       
     }
    
    public void getdriver(WebDriver driver) {
    	this.driver=driver;
    }
    
    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
        	String dest = System.getProperty("user.dir")+File.separator+"Extent-Reports"+File.separator+"screenshots"+File.separator+result.getName()+new Date()+".png";
        	Screenshot.captureScreenshot(result.getName(), driver, dest);
        	
        	
        	test.log(Status.FAIL, "Snapshot: " + test.addScreenCaptureFromPath(dest));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterTest
    public void tearDown() {
    	//to write or update test information to reporter
        extent.flush();
        
    }
    
    @AfterSuite
	public void driverclose() throws InterruptedException {
		driver.close();

	}
}
