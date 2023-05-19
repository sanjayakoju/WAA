package register;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.*;

public class RegistrationTest {
	private static RegisterPage registrationPage;
	private static WebDriver driver;

	@BeforeClass
	public static void openTheBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\waa\\chromedriver.exe");
		// create chrome instance
		driver = new ChromeDriver();
		registrationPage = new RegisterPage(driver);		
	}

	@AfterClass
	public static void closeTheBrowser() {
		driver.close();
	}

	@Test
	public void signUp() {
		registrationPage.open();
		registrationPage.enterName("Frank", "Brown");
		registrationPage.enterUniqueEmail();
		registrationPage.enterDateOfBirth("3", "May", "1998");
		registrationPage.enterPassword("yoyoyo");

		RegistrationResultPage resultPage = registrationPage.clickRegisterButton();
		resultPage.checkThatResultPageShowsTheText("Your registration completed");
		
	}
	
	@Test
	public void signUp2() {
		registrationPage.open();
		registrationPage.enterName("Frankie", "Johnson");
		registrationPage.enterUniqueEmail();
		registrationPage.enterDateOfBirth("8", "June", "1998");
		registrationPage.enterPassword("password");

		RegistrationResultPage resultPage = registrationPage.clickRegisterButton();
		resultPage.checkThatResultPageShowsTheText("Your registration completed");

	}
	
}