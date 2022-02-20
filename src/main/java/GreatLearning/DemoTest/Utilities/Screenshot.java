/* Class Created from Sunil S Daivajna on 19/02/2022
 * */

package GreatLearning.DemoTest.Utilities;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
	
	public static void captureScreenshot(String filename,WebDriver driver,String fileWithPath ) throws IOException
	
	{
		TakesScreenshot scrShot = (TakesScreenshot)driver;
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
	}

}
