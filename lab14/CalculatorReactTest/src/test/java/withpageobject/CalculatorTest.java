package withpageobject;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    private static CalculatorPage page;

    @Before
    public void createWebDriver() {
        // set path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "D:\\Sanjaya\\MSCS notes\\WAA - Rene de Jong\\chromedriver.exe");
        page = PageFactory.initElements(new ChromeDriver(), CalculatorPage.class);
        page.open("http://localhost:3000");
    }

    @AfterClass
    public static void closeWebDriver() {
        page.close();
    }

    @Test
    public void add() {
        page.getNum1().sendKeys("12");
        Select dropDown = new Select(page.webDriver.findElement(By.name("operator")));
        dropDown.selectByVisibleText("+");
        WebElement selection = dropDown.getFirstSelectedOption();
        selection.click();
        page.getNum2().sendKeys("12");
        page.clickCalculate();
        assertThat(page.getResult(), is("24"));
    }

    @Test
    public void sub() {
        page.getNum1().sendKeys("12");
        Select dropDown = new Select(page.webDriver.findElement(By.name("operator")));
        dropDown.selectByVisibleText("-");
        WebElement selection = dropDown.getFirstSelectedOption();
        selection.click();
        page.getNum2().sendKeys("12");
        page.clickCalculate();
        assertThat(page.getResult(), is("0"));
    }

    @Test
    public void mul() {
        page.getNum1().sendKeys("12");
        Select dropDown = new Select(page.webDriver.findElement(By.name("operator")));
        dropDown.selectByVisibleText("*");
        WebElement selection = dropDown.getFirstSelectedOption();
        selection.click();
        page.getNum2().sendKeys("12");
        page.clickCalculate();
        assertThat(page.getResult(), is("144"));
    }

    @Test
    public void div() {
        page.getNum1().sendKeys("12");
        Select dropDown = new Select(page.webDriver.findElement(By.name("operator")));
        dropDown.selectByVisibleText("/");
        WebElement selection = dropDown.getFirstSelectedOption();
        selection.click();
        page.getNum2().sendKeys("12");
        page.clickCalculate();
        assertThat(page.getResult(), is("1"));
    }
}
