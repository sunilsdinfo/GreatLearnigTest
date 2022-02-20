/* Class Created from Sunil S Daivajna on 16/02/2022
 * */

package GreatLearning.DemoTest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import GreatLearning.DemoTest.Utilities.Utilities;

public class Registration_Page extends Utilities {

	/* Page Objects */

	public static WebDriver driver;
	public static String REGISTRATION_HEADER = "registrationheader";
	public static String USER_MOBIKENUMBER = "usermobilenumber";
	public static String USER_NAME = "username";
	public static String USER_EMIAL = "useremail";
	public static String USER_CITY = "usercity";
	public static String USER_EXPERIANCE_DROPDOWN = "experiance";
	public static String NEXT_BUTTONSTEP1 = "nextbuttonstep1";
	public static String USER_ORG = "userorganisation";
	public static String USER_FROMMONTH_DROPDOWN = "userfrommonth";
	public static String USER_FROMYEAR_DROPDOWN = "userfromyear";
	public static String USER_TOYEAR_DROPDOWN = "usertoyear";
	public static String USER_TOMONTH_DROPDOWN = "usertomonth";
	public static String USER_DESIGNATION = "userdesignation";
	public static String USER_INDUSTRY = "userindustry";
	public static String USER_YEAROFEXPERIANCE = "useryearofexperiance";
	public static String USER_NATION = "usernation";
	public static String NEXT_BUTTONSTEP2 = "nextbuttonstep2";
	public static String USER_LANGUAGE = "userpgmlanguage";
	public static String USER_COUNTRYDROPDOWN = "countrydropdown";
	public static String countryname = "xpath==//span[text()='Replace']";
	public static String pgmlanguage = "userpgmlanguage";
	public static String USER_DEGREE = "userdegree";
	public static String USER_SPECIALISATION = "userspecialisation";
	public static String USER_COLLEGE = "userscollege";
	public static String USER_GRADYEAR = "usersgraduationyear";
	public static String USERNEXTBUTTON3 = "nextbuttonstep3";
	public static String USERLINKEDPF = "userlinkedinpf";
	public static String USERNEXTBUTTON4 = "nextbuttonstep4";
	public static String USER_STATEMENT = "userstatement";
	public static String USER_SUBMIT = "submitapp";
	public static String USER_PERCENTAGE = "userspercentage";
	public static String USER_ACCEPTANCE = "useracceptance";
	public static String SUCCESS_SUBMISSIONTEXT = "successsubmission";

	/*
	 * Function Name: clickingOnCountryDropdown 
	 * Function Desciption: function to click on CountryDropdown
	 *  Input Parameter = Driver
	 */
	public static void clickingOnCountryDropdown(WebDriver driver) {

		getWebElement(getObjectID(USER_COUNTRYDROPDOWN), driver).click();

	};

	/*
	 * Function Name: selectingCountryFromDropDown 
	 * Function Desciption: function to click on CountryDropdown
	 *  Input Parameter = Driver and text
	 */
	public static void selectingCountryFromDropDown(WebDriver driver, String text) {

		fnScrollIntoView(countryname.replace("Replace", text), driver);
		getWebElement(countryname.replace("Replace", text), driver).click();
	};

	/*
	 * Function Name: selecting dropdown value 
	 *Function  Desciption: function to select dropdown value
	 * experiance Input Parameter = experiance and Driver, locator
	 */
	public static void selectingDropDownValue(String exp, WebDriver driver, String loc) {

		Select sel = new Select(getWebElement(getObjectID(loc), driver));
		sel.selectByValue(exp);
	};

	/*
	 * Function Name: clickingonNext
	 * Function Desciption: function to click next
	 * Input Parameter = Driver, locator
	 */
	public static void clickingonNext(WebDriver driver, String loc) {

		fnWaitForVisibilityOfElement(getObjectID(loc), driver);
		getWebElement(getObjectID(loc), driver).click();

	};

	/*
	 * Function Name: selecting_ProgrammingLanguage 
     * Function Desciption: function to select language 
	 *Input  Parameter = Driver, language
	 */
	public static void selecting_ProgrammingLanguage(WebDriver driver, String language) throws InterruptedException {

		Thread.sleep(200);
		getWebElement(getObjectID(pgmlanguage), driver).click();
	};

	/*
	 * Function Name: enteringValue Function 
	 * Desciption: function to send value
	 * Input Parameter = locator and Driver, name
	 */
	public static void enteringValue(WebDriver driver, String locator, String name) {

		fnWaitForVisibilityOfElement(getObjectID(locator), driver);
		getWebElement(getObjectID(locator), driver).sendKeys(name);

	};

	/*
	 * Function Name: gettingText Function
	 *  Desciption: function to get Text 
	 * Parameter = locator and Driver
	 */
	public static String gettingText(WebDriver driver, String locator) {

		fnWaitForVisibilityOfElement(getObjectID(locator), driver);
		fnWaitForVisibilityOfElement(getObjectID(locator), driver);
		return getWebElement(getObjectID(locator), driver).getText();

	};

	/*
	 * Function Name: isElementDisplayed Function 
	 * Desciption: function to verify
	 * element display Input Parameter = locator and Driver
	 */
	public static boolean isElementDisplayed(WebDriver driver, String locator) {

		fnWaitForVisibilityOfElement(getObjectID(locator), driver);
		return getWebElement(getObjectID(locator), driver).isDisplayed();

	};

}
