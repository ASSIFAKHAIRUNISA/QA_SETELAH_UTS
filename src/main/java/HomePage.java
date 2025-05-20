import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By signupLoginBtn = By.linkText("Signup / Login");

    public boolean isHomePageVisible() {
        return driver.getTitle().contains("Automation Exercise");
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginBtn).click();
    }
}
