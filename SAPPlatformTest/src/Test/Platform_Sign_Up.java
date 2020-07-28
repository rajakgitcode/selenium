package Test;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;
import PageObjects.ConfirmationPage;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import Utility.RetryTest;
import Utility.TestDataProvider;

/*
 * This Test class has a methods to interact with application to run the tests.
 */
@Listeners(Utility.ExtentTestNGITestListener.class)
public class Platform_Sign_Up extends TestBase {
	SoftAssert softAssert = new SoftAssert();

	// Reads SignUp Form data from the excel and perform the test based on it
	@Test(dataProvider = "data-provider-Test-Platform-SignUp", dataProviderClass = TestDataProvider.class, groups = {
			"functional" }, retryAnalyzer = RetryTest.class, description = "Test 1 - Testing Platform sign up with Excel Reader", enabled = true)
	public void test1_Platform_Sign_Up(String firstName, String lastName, String email, String password,
			String retypePasswd, String opAuth, String toutAuth) throws InterruptedException {
		System.out.println("*****Test Started - test_Platform_Sign_Up_With_Excel_Reader*****");

		HomePage homePage = new HomePage(driver);

		homePage.clickOnCookieOKButton(); // Click on OK button in cookie
		homePage.clickOnSignUpButton(); // Click SignUp button
		homePage.switchToIframe(); // Switch to Registration Form

		RegistrationPage registrationPage = new RegistrationPage(driver);

		registrationPage.enterFirstName(firstName); // Enter First Name
		Thread.sleep(300);
		registrationPage.enterLastName(lastName); // Enter Last Name
		Thread.sleep(300);
		registrationPage.enterMail(email); // Enter Email
		Thread.sleep(300);
		registrationPage.enterNewPassword(password); // Enter Password
		Thread.sleep(300);
		registrationPage.enterRetypePassword(retypePasswd); // ReEnter Password
		Thread.sleep(300);

		registrationPage.registerButton.sendKeys(Keys.DOWN); // Focus to Register button
		Thread.sleep(500);

		if (opAuth.equalsIgnoreCase("Yes")) {
			registrationPage.clickOnPDAccept(); // Click on PDAccept
		}

		if (toutAuth.equalsIgnoreCase("Yes")) {
			registrationPage.clickOnTouAccept(); // Click on ToutAccept
		}

		registrationPage.clickOnRegisterButton(); // Click on Register Button

		if (opAuth.equalsIgnoreCase("Yes") && toutAuth.equalsIgnoreCase("Yes")) {
			ConfirmationPage confirmationpage = new ConfirmationPage(driver); // View confirmation Page

			confirmationpage.verifySuccessMessage(); // Verify success message on confirmation
			confirmationpage.verifyConfirmationMailMessage(); // Verify mail text on confirmation
			confirmationpage.verifyActivationText(); // Verify activation text on confirmation
			confirmationpage.verifyLogoImage(); // Verify log image on confirmation
			confirmationpage.clickOnCloseButton(); // Click on close button to close confirmation window
		} else {
			if (opAuth.equalsIgnoreCase("No")) {
				registrationPage.verifyPDAcceptError(); // Verify PDAccept Error message
			}

			if (toutAuth.equalsIgnoreCase("No")) {
				registrationPage.verifyToutAcceptError(); // Verify ToutAccept Error message
			}
		}

		driver.switchTo().defaultContent();
		softAssert.assertAll();
	}

	// Verify the Label Name displayed on the SignUp page
	@Test(groups = {
			"Acceptance" }, retryAnalyzer = RetryTest.class, description = "Test 2 - Testing the Registration form label names/elements presents", enabled = true)
	public void test2_Registration_Form_LabelText() throws InterruptedException {
		System.out.println("*****Test Started - test_Registration_LabelText_Matching*****");

		HomePage homePage = new HomePage(driver);

		homePage.clickOnCookieOKButton();
		homePage.clickOnSignUpButton();
		Thread.sleep(500);
		homePage.switchToIframe();

		RegistrationPage registrationPage = new RegistrationPage(driver);

		// verifying the label names/elements presents in the registration form.
		registrationPage.verifyRegistrationTitle();
		registrationPage.verifyTellUsAboutYourselfTitle();
		registrationPage.verifyPasswordTitle();
		registrationPage.verifyTermsAndConditionsTitle();
		registrationPage.verifyFirstNameLabel();
		registrationPage.verifyLastNameLabel();
		registrationPage.verifyEmailLabel();
		registrationPage.verifyPasswordLabel();
		registrationPage.verifyRetypePasswordLabel();
		registrationPage.registerButton.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		registrationPage.verifyTermsLabel1();
		registrationPage.verifyTermsLabel2();
		registrationPage.verifyRequiredLabel();
		registrationPage.verifyLogoImage();
		registrationPage.clickOnCloseButton();

		driver.switchTo().defaultContent();
		softAssert.assertAll();

	}

	// Verify the Error Message displayed on the SignUp page
	@Test(groups = {
			"Negative" }, retryAnalyzer = RetryTest.class, description = "Test3 - Testing the Registration Form Error Messages", enabled = true)
	public void test3_registration_Form_Error_Messages() throws InterruptedException {
		System.out.println("*****Test Started - test_Registration_ErrorText_Matching*****");

		HomePage homePage = new HomePage(driver);

		homePage.clickOnCookieOKButton();
		homePage.clickOnSignUpButton();
		Thread.sleep(3000);
		homePage.switchToIframe();
		Thread.sleep(1000);

		RegistrationPage registrationPage = new RegistrationPage(driver);

		// registrationPage.registerButton.sendKeys(Keys.DOWN);
		// Thread.sleep(500);
		registrationPage.clickOnRegisterButton();
		Thread.sleep(2000);

		// verifying the label names/elements presents in the registration form.
		registrationPage.verifyFirstNameError();
		registrationPage.verifyLastNameError();
		registrationPage.verifyEmailError();
		registrationPage.verifyPasswordError();
		registrationPage.verifyReEnterPasswordError();
		registrationPage.verifyPDAcceptError();
		registrationPage.verifyToutAcceptError();
		registrationPage.clickOnCloseButton();

		driver.switchTo().defaultContent();
		softAssert.assertAll();

	}

}
