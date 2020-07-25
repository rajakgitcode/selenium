package Test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import PageObjects.ConfirmationPage;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import Utility.ExcelUtil;
import Utility.ExtentTestNGITestListener;

@Listeners(Utility.ExtentTestNGITestListener.class)
public class Platform_Sign_Up extends TestBase 
{
	SoftAssert softAssert = new SoftAssert();

	@Test(groups = {"functional"}, description = "testing Platform sign up", enabled = false)
	public void test_Platform_Sign_Up() throws InterruptedException 
	{
		System.out.println("****Test Started - test_Platform_Sign_Up****");
		
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		
		homepage.clickOnCookieOKButton(); //Click on Cookie button.
		homepage.clickOnSignUpButton(); //Clicks on Sign up button.
		homepage.switchToIframe(); //Switch to registartion page.
		
		RegistrationPage registartionPage = new RegistrationPage(driver);
		
		registartionPage.enterFirstName("AAAA4");
		Thread.sleep(300);
		registartionPage.enterLastName("BBBB4");
		Thread.sleep(300);
		registartionPage.enterMail("AAAA4@yahoo.com");
		Thread.sleep(300);
		registartionPage.enterNewPassword("123@Qwert");
		Thread.sleep(300);
		registartionPage.enterRetypePassword("123@Qwert");
		Thread.sleep(500);
		registartionPage.registerButton.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		registartionPage.clickOnPDAccept(); //verify selecting PDAccept
		registartionPage.clickOnTouAccept(); //verify selecting ToutAccept
		registartionPage.clickOnRegisterButton(); //click on Register Button
		
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		
		confirmationpage.verifySuccessMessage(); //verify confirmation message
		confirmationpage.verifyConfirmationMailMessage(); //verify confirmation mail text
		confirmationpage.verifyActivationText(); //verify confirmation activatin text
		confirmationpage.verifyLogoImage(); //verify logo image on confirmation page.
		confirmationpage.clickOnCloseButton(); //verify close button click
		softAssert.assertAll();
		
	}
	
	@DataProvider(name = "data-provider-Test-Platform-SignUp")
	public Object[][] dpMethod()
	{
		//non-static reference
		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("/Users/rajak/git/repository/SAPPlatformTest/src/resources/", "TestData.xlsx", "Sheet1");
		return excel.readExcelTestData("/Users/rajak/git/repository/SAPPlatformTest/src/resources/", "TestData.xlsx", "Sheet1");
		
		
		//return ExcelUtil.readExcelTestData("/Users/rajak/git/repository/SAPPlatformTest/src/resources/", "TestData.xlsx", "Sheet1");
	}
	
	@Test(dataProvider = "data-provider-Test-Platform-SignUp", groups = {"functional"}, description = "testing Platform sign up with Excel Reader", enabled = false)
	public void test_Platform_Sign_Up_With_Excel_Reader(String firstName, String lastName, String email, String password, String retypePasswd, String opAuth, String toutAuth) throws InterruptedException 
	{
		System.out.println("*****Test Started - test_Platform_Sign_Up_With_Excel_Reader*****");
		
		
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		
		homepage.clickOnCookieOKButton();
		homepage.clickOnSignUpButton();
		homepage.switchToIframe();
			
		RegistrationPage registartionPage = new RegistrationPage(driver);
		
		registartionPage.enterFirstName(firstName);
		Thread.sleep(300);
		registartionPage.enterLastName(lastName);
		Thread.sleep(300);
		registartionPage.enterMail(email);
		Thread.sleep(300);
		registartionPage.enterNewPassword(password);
		Thread.sleep(300);
		registartionPage.enterRetypePassword(retypePasswd);
		Thread.sleep(500);
			
		registartionPage.registerButton.sendKeys(Keys.DOWN);
		
		Thread.sleep(500);
		registartionPage.clickOnPDAccept();
		registartionPage.clickOnTouAccept();
		registartionPage.clickOnRegisterButton();
			
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
			
		confirmationpage.verifySuccessMessage();
		confirmationpage.verifyConfirmationMailMessage();
		confirmationpage.verifyActivationText();
		confirmationpage.verifyLogoImage();
		confirmationpage.clickOnCloseButton();
		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}
	
	@Test(groups = {"Acceptance"}, description = "testing the Registration form label names/elements presents", enabled = true)
	public void test_Registration_LabelText_Matching()
	{
		System.out.println("*****Test Started - test_Registration_LabelText_Matching*****");
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.clickOnCookieOKButton();
		homePage.clickOnSignUpButton();
		homePage.switchToIframe();
		
		RegistrationPage registartionPage = new RegistrationPage(driver);
		
		//verifying the label names/elements presents in the registration form.
		registartionPage.verifyRegistrationTitle();
		registartionPage.verifyTellUsAboutYourselfTitle();
		registartionPage.verifyPasswordTitle();
		registartionPage.verifyTermsAndConditionsTitle();
		registartionPage.verifyFirstNameLabel();
		registartionPage.verifyLastNameLabel();
		registartionPage.verifyEmailLabel();
		registartionPage.verifyPasswordLabel();
		registartionPage.verifyRetypePasswordLabel();
		registartionPage.registerButton.sendKeys(Keys.DOWN);
		registartionPage.verifyTermsLabel1();
		registartionPage.verifyTermsLabel2();
		registartionPage.verifyRequiredLabel();
		registartionPage.verifyLogoImage();
		registartionPage.clickOnCloseButton();
		softAssert.assertAll();
		
	}
	
	@Test(groups = {"Negative"}, description = "testing the Registration form Error Messages", enabled = false)
	public void test_Registartion_Error_Messages()
	{
		System.out.println("*****Test Started - test_Registartion_Error_Messages*****");
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.clickOnCookieOKButton();
		homePage.clickOnSignUpButton();
		homePage.switchToIframe();
		
		
		RegistrationPage registartionPage = new RegistrationPage(driver);
		
		//registartionPage.registerButton.sendKeys(Keys.DOWN);
		
		//Verify Error Messages displayed
		registartionPage.clickOnRegisterButton();
		registartionPage.verifyFirstNameError();
		registartionPage.verifyLastNameError();
		registartionPage.verifyEmailError();
		registartionPage.verifyPasswordError();
		registartionPage.verifyReEnterPasswordError();
		registartionPage.verifyPDAcceptError();
		registartionPage.verifyToutAcceptError();
		softAssert.assertAll();
	}

}
