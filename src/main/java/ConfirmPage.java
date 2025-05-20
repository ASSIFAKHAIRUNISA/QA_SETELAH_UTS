import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPage {
    WebDriver driver;

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    By accountCreatedText = By.xpath("//*[contains(text(),'Account Created!')]");
    By continueButton = By.cssSelector("a.btn.btn-primary");

    By loggedInAs = By.xpath("//*[contains(text(),'Logged in as')]");
    By deleteAccountLink = By.xpath("//a[contains(text(), 'Delete Account')]");
    By accountDeletedText = By.xpath("//*[contains(text(),'Account Deleted!')]");
    By finalContinueBtn = By.xpath("//a[text()='Continue']");

    public boolean isAccountCreatedVisible() {
        return driver.findElement(accountCreatedText).isDisplayed();
    }

    public void clickContinueAfterCreate() {
        driver.findElement(continueButton).click();
    }

    public boolean isLoggedInAsVisible() {
        return driver.findElement(loggedInAs).isDisplayed();
    }

    public void clickDeleteAccount() {
        driver.findElement(deleteAccountLink).click();
    }

    public boolean isAccountDeletedVisible() {
        return driver.findElement(accountDeletedText).isDisplayed();
    }

    public void clickContinueAfterDelete() {
        driver.findElement(finalContinueBtn).click();
    }
}
