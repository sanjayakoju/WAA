package withoutpageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
	private WebDriver driver;

	@Before
	public void createWebDriver() {
		// set path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "D:\\Sanjaya\\MSCS notes\\WAA - Rene de Jong\\chromedriver.exe");
		// create chrome instance
		driver = new ChromeDriver();
	}

	@After
	public void closeWebDriver() {
		driver.close();
	}

	@Test
	public void oneAndFour() {
		driver.navigate().to("http://www.rekenmachine-calculator.nl/");

		WebElement button = driver.findElement(By.name("one"));
		button.click();
		button = driver.findElement(By.name("add"));
		button.click();
		button = driver.findElement(By.name("four"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("1+4"));
		button = driver.findElement(By.name("equal"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("5"));
	}

	@Test
	public void subtract() {
		driver.navigate().to("http://www.rekenmachine-calculator.nl/");

		WebElement button = driver.findElement(By.name("eight"));
		button.click();
		button = driver.findElement(By.name("sub"));
		button.click();
		button = driver.findElement(By.name("two"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("8-2"));
		button = driver.findElement(By.name("equal"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("6"));
	}

	@Test
	public void buttonThree() {
		driver.navigate().to("http://www.rekenmachine-calculator.nl/");

		WebElement button = driver.findElement(By.cssSelector("#table6 > tbody > tr:nth-child(3) > td > div > font:nth-child(5) > input[type=button]"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("3"));
	}
}