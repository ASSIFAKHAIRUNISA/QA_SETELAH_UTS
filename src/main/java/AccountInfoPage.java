import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInfoPage {
    WebDriver driver;

    public AccountInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    By header = By.xpath("//b[text()='Enter Account Information']");
    By genderMale = By.id("id_gender1");
    By password = By.id("password");
    By days = By.id("days");
    By months = By.id("months");
    By years = By.id("years");
    By newsletter = By.id("newsletter");
    By optin = By.id("optin");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By company = By.id("company");
    By address1 = By.id("address1");
    By address2 = By.id("address2");
    By country = By.id("country");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobileNumber = By.id("mobile_number");
    By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    public boolean isEnterAccountInfoVisible() {
        return driver.findElement(header).isDisplayed();
    }

    public void fillAccountInfo(String pass, String day, String month, String year) {
        driver.findElement(genderMale).click();
        driver.findElement(password).sendKeys(pass);
        new Select(driver.findElement(days)).selectByValue(day);
        new Select(driver.findElement(months)).selectByValue(month);
        new Select(driver.findElement(years)).selectByValue(year);
    }

    public void selectCheckboxes() {
        driver.findElement(newsletter).click();
        driver.findElement(optin).click();
    }

    public void fillAddress(String fname, String lname, String comp, String addr1, String addr2,
                            String ctry, String st, String cty, String zip, String phone) {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(company).sendKeys(comp);
        driver.findElement(address1).sendKeys(addr1);
        driver.findElement(address2).sendKeys(addr2);
        driver.findElement(country).sendKeys(ctry);
        driver.findElement(state).sendKeys(st);
        driver.findElement(city).sendKeys(cty);
        driver.findElement(zipcode).sendKeys(zip);
        driver.findElement(mobileNumber).sendKeys(phone);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }
}
