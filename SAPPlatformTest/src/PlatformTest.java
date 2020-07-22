import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlatformTest {

	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = null;

		try {
			System.setProperty("webdriver.chrome.driver", "/Users/rajak/Documents/Selenium/chromedriver");
			System.setProperty("webdriver.gecko.driver", "/Users/rajak/Documents/Selenium/geckodriver");

			// WebDriver driver = new ChromeDriver();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			// Home Page
			driver.get("https://cai.tools.sap/");

			// Click on Cookie button
			WebElement cookieOKButton = new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'OK')]")));
			cookieOKButton.click();

			// Click on Signup buton
			WebElement signUpButton = new WebDriverWait(driver, 10).until(
					ExpectedConditions.elementToBeClickable(By.cssSelector(".sap-btn-action > div:nth-child(1)")));
			signUpButton.click();

			// Switch to Iframe
			WebElement iframe1 = new WebDriverWait(driver, 20).until(ExpectedConditions
					.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/iframe[1]")));
			driver.switchTo().frame(0);

			// Prints Forms Title
			System.out.println(
					driver.findElement(By.xpath("/html/body/main/div/div/form/div[2]/fieldset[1]/h2")).getText());

			// Enters Form Data
			driver.findElement(By.xpath("//*[@id=\"firstName\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("P1236");
			driver.findElement(By.xpath("//*[@id=\"lastName\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("P1236");
			driver.findElement(By.xpath("//*[@id=\"mail\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"mail\"]")).sendKeys("P1236@yahoo.com");
			driver.findElement(By.xpath("//*[@id=\"newPasswordInput\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"newPasswordInput\"]")).sendKeys("123@Qwert");
			driver.findElement(By.xpath("//*[@id=\"retypeNewPasswordInput\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"retypeNewPasswordInput\"]")).sendKeys("123@Qwert");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"pdAccept\"]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"touAccept\"]")).click();
			Thread.sleep(5000);
			// Click on Register button
			WebElement registerButton = new WebDriverWait(driver, 30).until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sapStoreRegisterFormSubmit\"]")));
			registerButton.click();

			// Wait for Confirmatino message
			WebElement successMessage = new WebDriverWait(driver, 20)
					.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div/h1")));

			// Print confirmation message
			System.out.println(driver.findElement(By.xpath("/html/body/main/div/div/h1")).getText());
			System.out.println(driver.findElement(By.xpath("/html/body/main/div/div/div[2]")).getText());

			driver.switchTo().defaultContent();

			driver.close();
			driver.quit();
		} catch (Exception e) {
			System.out.println(e);
			driver.close();
			driver.quit();
		}
	}

}
