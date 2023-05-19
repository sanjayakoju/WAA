package withpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
	protected WebDriver driver;

	public CalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first")
	private WebElement firstField;
	@FindBy(id = "second")
	private WebElement secondField;
	@FindBy(id = "add")
	private WebElement addButton;
	@FindBy(id = "subtract")
	private WebElement subtractButton;
	@FindBy(id = "multiply")
	private WebElement multiplyButton;


	public void open() {
		driver.get ("http://localhost:3000");
	}

	public void close() {
		driver.close();
	}

	public void enterNumbers(String first, String second) {
		firstField.clear();
		firstField.sendKeys(first);

		secondField.clear();
		secondField.sendKeys(second);
	}

	public ResultPage clickAdd() {
		addButton.click();
		return new ResultPage(driver);
	}

	public ResultPage clickSubtract() {
		subtractButton.click();
		return new ResultPage(driver);
	}

	public ResultPage clickMultiply() {
		multiplyButton.click();
		return new ResultPage(driver);
	}



}
