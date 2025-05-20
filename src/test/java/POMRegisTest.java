import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class POMRegisTest {
    @Test
    public void registrasi() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationexercise.com/");

        HomePage home = new HomePage(driver);
        assertTrue(home.isHomePageVisible());
        home.clickSignupLogin();

        SignUpPage signup = new SignUpPage(driver);
        assertTrue(signup.isNewUserSignupVisible());
        signup.enterNameAndEmail("assifa", "assifa7@gmail.com");
        signup.clickSignupButton();

        AccountInfoPage info = new AccountInfoPage(driver);
        assertTrue(info.isEnterAccountInfoVisible());
        info.fillAccountInfo("assifa123", "1", "1", "2000");
        info.selectCheckboxes();
        info.fillAddress("assifa", "Nisa", "Paragon", "Yogyakarta", "Surakarta",
                "India", "Unitary State", "D.I Yogyakarta", "55811", "08123456789");
        info.clickCreateAccount();

        ConfirmPage confirm = new ConfirmPage(driver);
        assertTrue(confirm.isAccountCreatedVisible());

        confirm.clickContinueAfterCreate();
        assertTrue(confirm.isLoggedInAsVisible());
        confirm.clickDeleteAccount();
        assertTrue(confirm.isAccountDeletedVisible());
        confirm.clickContinueAfterDelete();

    }
}
