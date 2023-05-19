package withpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.assertThat;

public class ResultPage {
	protected WebDriver driver;

	public ResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "result")
	private WebElement resultText;

	public void close() {
		driver.close();
	}

	public void checkResult(String expected) {
		assertThat(resultText.getText(), is(expected));

	}


}
