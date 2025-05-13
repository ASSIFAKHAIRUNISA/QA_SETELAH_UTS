import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitStrategyTest {

    @Test
    public void testImplicitWait(){
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void loginFailed()
    {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement button = driver.findElement(By.name("login-button"));
        button.submit();

        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement error_msg = driver.findElement (By.cssSelector("h3[data-test='error']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(error_msg));

        System.out.println(error_msg.getText());
    }
}
