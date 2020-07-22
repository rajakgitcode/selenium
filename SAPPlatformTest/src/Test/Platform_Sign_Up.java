package Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.ConfirmationPage;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;

public class Platform_Sign_Up extends TestBase {
	SoftAssert softAssert = new SoftAssert();

	@Test()
	public void testSignUp() throws InterruptedException {
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		;
		homepage.clickOnCookieOKButton();
		homepage.clickOnSignUpButton();
		homepage.switchToIframe();
		RegistrationPage registartionPage = new RegistrationPage(driver);
		registartionPage.enterFirstName("AAAA1");
		Thread.sleep(300);
		registartionPage.enterLastName("BBBB1");
		Thread.sleep(300);
		registartionPage.enterMail("AAAA1@yahoo.com");
		Thread.sleep(300);
		registartionPage.enterNewPassword("123@Qwert");
		Thread.sleep(300);
		registartionPage.enterRetypePassword("123@Qwert");
		Thread.sleep(500);
		registartionPage.clickOnPDAccept();
		registartionPage.clickOnTouAccept();
		registartionPage.clickOnRegisterButton();
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		confirmationpage.verifySuccessMessage();
		System.out.println(confirmationpage.getSuccessMessage());
		confirmationpage.verifyConfirmationMailMessage();
		System.out.println(confirmationpage.getConfirmationMail());
		softAssert.assertAll();

	}

}
