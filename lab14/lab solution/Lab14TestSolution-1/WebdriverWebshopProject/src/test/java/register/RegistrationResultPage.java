package register;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationResultPage {
	protected WebDriver driver;

	public RegistrationResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/form/div/div[2]/div[1]")
//	@FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div > div > form > div > div.page-body > div.result")
	@FindBy(css = "div.result")
    private WebElement registrationResult;

    public String getRegistrationResult(){
        return registrationResult.getText();
    }

	public void checkThatResultPageShowsTheText(String result) {
		assertThat(getRegistrationResult(), is(result));
		
	}


}
