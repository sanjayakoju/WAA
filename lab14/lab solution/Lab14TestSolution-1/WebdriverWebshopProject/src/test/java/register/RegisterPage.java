package register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	protected WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gender-male")
	private WebElement gendermale;
	@FindBy(id = "FirstName")
	private WebElement firstName;
	@FindBy(id = "LastName")
	private WebElement lastName;
	@FindBy(name = "DateOfBirthDay")
	private WebElement selectDay;
	@FindBy(name = "DateOfBirthMonth")
	private WebElement selectMonth;
	@FindBy(name = "DateOfBirthYear")
	private WebElement selectYear;
	@FindBy(id = "Email")
	private WebElement email;
	@FindBy(id = "Company")
	private WebElement company;
	@FindBy(id = "Password")
	private WebElement password;
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPassword;
	@FindBy(id = "register-button")
	private WebElement registerButton;

	public void open() {
		driver.get ("http://demo.nopcommerce.com/register");
	}

	public void clickMale() {
		gendermale.click();
	}

	public void enterName(String firstName, String lastName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);

		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}

	public void enterCompany(String company) {
		this.company.clear();
		this.company.sendKeys(company);
	}

	public void enterUniqueEmail() {
		this.email.clear();
		this.email.sendKeys(createUniqueEmail());
	}

	private String createUniqueEmail() {
		String email = "@gmail.com";
		String name = "frank" + createRandomNumber();
		return name + email;
	}

	private int createRandomNumber() {
		return (int) (Math.random() * 5000 + 1);
	}

	public void enterDateOfBirth(String day, String month, String year) {
		new Select(selectDay).selectByVisibleText(day);
		new Select(selectMonth).selectByVisibleText(month);
		new Select(selectYear).selectByVisibleText(year);
	}

	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);

		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(password);
	}

	public RegistrationResultPage clickRegisterButton() {
		registerButton.click();
		return new RegistrationResultPage(driver);
	}
}
