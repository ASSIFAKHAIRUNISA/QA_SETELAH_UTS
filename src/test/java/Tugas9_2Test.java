import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

public class Tugas9_2Test {

    @Test
    public void registrasi() {
        // Launch browser
        WebDriver driver = new ChromeDriver();
        // Navigate to URL
        driver.get("http://automationexercise.com/");

        // Verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        assertTrue("Home page is not visible successfully", actualTitle.contains(expectedTitle));


        // Click on 'Signup / Login' button
        WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
        signupLoginBtn.click();

        // Verify 'New User Signup!' is visible
        WebElement newUserSignupText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        assertTrue("'New User Signup!' is not visible", newUserSignupText.isDisplayed());

        //Enter name and email address
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("assifa");

        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("assifa6@gmail.com");

        WebElement button = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        button.click();

        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement accountInfoHeader = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        assertTrue("'ENTER ACCOUNT INFORMATION' is not visible", accountInfoHeader.isDisplayed());

        //Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender1")).click(); // Title: Mr.
        driver.findElement(By.id("password")).sendKeys("assifa123");

        Select days = new Select(driver.findElement(By.id("days")));
        days.selectByValue("1");
        Select months = new Select(driver.findElement(By.id("months")));
        months.selectByValue("1");
        Select years = new Select(driver.findElement(By.id("years")));
        years.selectByValue("2000");

        //Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        // Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.id("first_name"));
        firstName.sendKeys("assifa");

        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.sendKeys("Nisa");

        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys("Paragon");

        WebElement address1 = driver.findElement(By.id("address1"));
        address1.sendKeys("Yogyakarta");

        WebElement address2 = driver.findElement(By.id("address2"));
        address2.sendKeys("Surakarta");

        WebElement country = driver.findElement(By.id("country"));
        country.sendKeys("India");

        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Unitary State");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("D.I Yogyakarta");

        WebElement zipcode = driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("55811");

        WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
        mobileNumber.sendKeys("08123456789");

        //Click 'Create Account button'
        WebElement createAccount = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccount.click();

        //Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedText = driver.findElement(By.xpath("//*[contains(text(),'Account Created!')]"));
        assertTrue("'ACCOUNT CREATED!' is not visible", accountCreatedText.isDisplayed());

        //Click 'Continue' button
        WebElement cntn = driver.findElement(By.cssSelector("a.btn.btn-primary"));
        cntn.click();

        //Verify that 'Logged in as username' is visible
        WebElement loggedInAs = driver.findElement(By.xpath("//*[contains(text(),'Logged in as')]"));
        assertTrue("'Logged in as username' is not visible", loggedInAs.isDisplayed());

        //Click 'Delete Account' button
        WebElement deleteAccount = driver.findElement(By.xpath("//a[contains(text(), 'Delete Account')]"));
        deleteAccount.click();

        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedText = driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]"));
        assertTrue("'ACCOUNT DELETED!' is not visible", accountDeletedText.isDisplayed());
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

    }

}
