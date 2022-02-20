/* Class Created from Sunil S Daivajna on 15/02/2022
 * */

package GreatLearning.DemoTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import GreatLearning.DemoTest.PageObject.Registration_Page;
import GreatLearning.DemoTest.Utilities.ReportGeneration;
import GreatLearning.DemoTest.Utilities.Utilities;


public class Registration extends ReportGeneration {
	
	public WebDriver driver;
	
    @Test(priority = 0)
	@Parameters({ "Browser" })
	public void LaunchingApplication(String Browser) throws InterruptedException {

		test = extent.createTest("LaunchingApplication");
		driver = Utilities.getDriver(Browser);
		getdriver(driver);
		driver.get(Utilities.getTestData("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(Registration_Page.isElementDisplayed(driver, Registration_Page.REGISTRATION_HEADER),
				"Registration Page not Displayed");
		test.log(Status.PASS, "Test Passed");
	}

	@Test(priority = 1)
	public void verifyingBasicInformationPageAndEnteringData() throws InterruptedException {

		test = extent.createTest("verifyingBasicInformationPageAndEnteringData");
        Registration_Page.enteringValue(driver, Registration_Page.USER_MOBIKENUMBER,
				Registration_Page.getTestData("userphonenumber"));
		Registration_Page.enteringValue(driver, Registration_Page.USER_NAME, Registration_Page.getTestData("username"));
		Registration_Page.enteringValue(driver, Registration_Page.USER_EMIAL,
				Registration_Page.getTestData("useremail"));
		Registration_Page.enteringValue(driver, Registration_Page.USER_CITY, Registration_Page.getTestData("usercity"));
		Registration_Page.clickingOnCountryDropdown(driver);
		Registration_Page.selectingCountryFromDropDown(driver, Registration_Page.getTestData("usercountry"));
		Registration_Page.selectingDropDownValue(Registration_Page.getTestData("userexperiance"), driver,
				Registration_Page.USER_EXPERIANCE_DROPDOWN);
		Assert.assertTrue(Registration_Page.isElementDisplayed(driver, Registration_Page.USER_EXPERIANCE_DROPDOWN),
				"Experiance dropdown not Displayed");
		Registration_Page.clickingonNext(driver, Registration_Page.NEXT_BUTTONSTEP1);
		test.log(Status.PASS, "Test Passed");

	}

	@Test(priority = 2)
	public void verifyingProfessionalDetailsPageAndEnteringData() throws InterruptedException {

		test = extent.createTest("verifyingProfessionalDetailsPageAndEnteringData");
		Registration_Page.enteringValue(driver, Registration_Page.USER_ORG,
				Registration_Page.getTestData("userorganisation"));
		Registration_Page.selectingDropDownValue(Registration_Page.getTestData("frommonth"), driver,
				Registration_Page.USER_FROMMONTH_DROPDOWN);
		Registration_Page.selectingDropDownValue(Registration_Page.getTestData("fromyear"), driver,
				Registration_Page.USER_FROMYEAR_DROPDOWN);
		Registration_Page.selectingDropDownValue(Registration_Page.getTestData("toyear"), driver,
				Registration_Page.USER_TOYEAR_DROPDOWN);
		Registration_Page.selectingDropDownValue(Registration_Page.getTestData("tomonth"), driver,
				Registration_Page.USER_TOMONTH_DROPDOWN);
		Registration_Page.enteringValue(driver, Registration_Page.USER_DESIGNATION,
				Registration_Page.getTestData("userdesignation"));
		Registration_Page.selectingDropDownValue(Registration_Page.getTestData("userindustry"), driver,
				Registration_Page.USER_INDUSTRY);
		Assert.assertTrue(Registration_Page.isElementDisplayed(driver, Registration_Page.USER_INDUSTRY),
				"user industry not Displayed");
		Registration_Page.fnScrollIntoView(Registration_Page.getObjectID(Registration_Page.NEXT_BUTTONSTEP2), driver);
		test.log(Status.PASS, "Test Passed");

	}

	@Test(priority = 3)
	public void verifyingUerProgrammingExperiancePageAndEnteringData() throws InterruptedException {
		test = extent.createTest("verifyingUerProgrammingExperiancePageAndEnteringData");
		Registration_Page.selectingDropDownValue(Registration_Page.getTestData("yearofexperiance"), driver,
				Registration_Page.USER_YEAROFEXPERIANCE);
		Thread.sleep(500);
		Assert.assertTrue(Registration_Page.isElementDisplayed(driver, Registration_Page.USER_YEAROFEXPERIANCE),
				"Year of Experiance dropdown not Displayed");
		Registration_Page.selecting_ProgrammingLanguage(driver, Registration_Page.getTestData("pgogramlanguage"));
		Thread.sleep(400);
		Registration_Page.fnScrollIntoView(Registration_Page.getObjectID(Registration_Page.NEXT_BUTTONSTEP2), driver);
		Registration_Page.clickingonNext(driver, Registration_Page.NEXT_BUTTONSTEP2);
		test.log(Status.PASS, "Test Passed");
	}

	@Test(priority = 3)
	public void verifyingUserEducationPageAndEnteringData() throws InterruptedException {

		test = extent.createTest("verifyingUserEducationPageAndEnteringData");
		Registration_Page.selectingDropDownValue(Registration_Page.getTestData("education"), driver,
				Registration_Page.USER_DEGREE);
		Registration_Page.enteringValue(driver, Registration_Page.USER_SPECIALISATION,
				Registration_Page.getTestData("specialisation"));
		Registration_Page.enteringValue(driver, Registration_Page.USER_COLLEGE,
				Registration_Page.getTestData("college"));
		Registration_Page.selectingDropDownValue(Registration_Page.getTestData("graduationyear"), driver,
				Registration_Page.USER_GRADYEAR);
		Assert.assertTrue(Registration_Page.isElementDisplayed(driver, Registration_Page.USER_GRADYEAR),
				"user graduation year dropdown not Displayed");
		Registration_Page.enteringValue(driver, Registration_Page.USER_PERCENTAGE,
				Registration_Page.getTestData("userpercentage"));
		Registration_Page.clickingonNext(driver, Registration_Page.USERNEXTBUTTON3);
		test.log(Status.PASS, "Test Passed");
	}

	@Test(priority = 4)
	public void verifyingLinkedinProfileEnterTextAndEnteringData() throws InterruptedException {

		test = extent.createTest("verifyingLinkedinProfileEnterTextAndEnteringData");
		Registration_Page.enteringValue(driver, Registration_Page.USERLINKEDPF,
				Registration_Page.getTestData("userlinkedinurl"));
		Registration_Page.clickingonNext(driver, Registration_Page.USERNEXTBUTTON4);
		test.log(Status.PASS, "Test Passed");

	}

	@Test(priority = 5)
	public void verifyingLFinalSubmission() throws InterruptedException {

		test = extent.createTest("verifyingLFinalSubmission");
		Thread.sleep(500);
		Registration_Page.enteringValue(driver, Registration_Page.USER_STATEMENT,
				Registration_Page.getTestData("userstatement"));
		Registration_Page.clickingonNext(driver, Registration_Page.USER_ACCEPTANCE);
		Registration_Page.clickingonNext(driver, Registration_Page.USER_SUBMIT);
		String textgot = Registration_Page.gettingText(driver, Registration_Page.SUCCESS_SUBMISSIONTEXT);
		Assert.assertEquals(textgot, Registration_Page.getTestData("successsubmissiontext"));
		test.log(Status.PASS, "Test Passed");
	}
};
