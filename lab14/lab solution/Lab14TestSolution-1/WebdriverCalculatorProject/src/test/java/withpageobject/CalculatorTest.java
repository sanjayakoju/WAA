package withpageobject;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
	private static CalculatorPage calcpage;
	private static ResultPage resultpage;
	@Before
	public void createWebDriver() {
		// set path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "C:\\waa\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    calcpage = new CalculatorPage(driver);
		calcpage.open();
	  }

	  @AfterClass
	  public static void closeTheBrowser() {
		  calcpage.close();
		  if (resultpage != null)
			  resultpage.close();

	  }

	  @Test
	  public void oneAndOne() {
		  calcpage.enterNumbers("1", "1");
		  resultpage = calcpage.clickAdd();
		  resultpage.checkResult("2");
	  }

	@Test
	public void oneMinusOne() {
		calcpage.enterNumbers("1", "1");
		resultpage = calcpage.clickSubtract();
		resultpage.checkResult("0");
	}

	@Test
	public void oneTimesTwo() {
		calcpage.enterNumbers("1", "2");
		resultpage = calcpage.clickMultiply();
		resultpage.checkResult("2");
	}




}