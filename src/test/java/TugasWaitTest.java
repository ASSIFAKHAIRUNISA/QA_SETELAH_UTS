import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TugasWaitTest {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
    }

    // implicit: itu kayak misal aku bikin durasi 10 detik. nah itu tuh nanti dia akan delay selama 10 detik baru menjalankan aksi selanjutnya
    // explicit: itu kayak ada conditional atau patokan. jadi misal aku kasih durasi 10 detik dalam mencari elemen A. nah kalo udah ketemu elemen A itu baru menjalankan eksekusi selanjutnya
    // thread.sleep: itu kayak misal aksi A kemudian nunggu dulu durasinya misal 5 detik, baru nanti jalanin aksi B.
    @Test
    public void testCase1() throws InterruptedException {
        driver.findElement(By.id("add_btn")).click();

        // Gunakan sleep untuk menunggu input muncul
        Thread.sleep(3000); // delay 3 detik

        WebElement row2Input = driver.findElement(By.cssSelector("input.input-field"));
        assertTrue(row2Input.isDisplayed());
    }

    @Test
    public void testCase3() {
        driver.findElement(By.id("edit_btn")).click();

        // Explicit wait sampai input bisa diklik
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputField = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("input.input-field"))
        );

        inputField.clear();
        inputField.sendKeys("Uji Explicit");
        assertEquals("Uji Explicit", inputField.getAttribute("value"));
    }


    @Test
    public void testCase4() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement instructions = driver.findElement(By.id("instructions"));
        driver.findElement(By.id("add_btn")).click();

        // Tunggu hingga elemen instruksi tidak lagi terlihat atau tidak ada
        wait.until(ExpectedConditions.stalenessOf(instructions));

        // Coba interaksi dengan elemen instruksi akan gagal jika tidak ditangani (StaleElementReferenceException)
        try {
            instructions.getText(); // Ini akan menyebabkan StaleElementReferenceException jika tidak ditangani
            fail("Expected StaleElementReferenceException not thrown");
        } catch (StaleElementReferenceException e) {
            // Expected behavior
        }
    }


    @Test
    public void testCase5() {
        driver.findElement(By.id("add_btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // Tunggu input kedua muncul (padahal munculnya butuh 5 detik)
        WebElement secondInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input2")));

        Assertions.assertTrue(secondInput.isDisplayed(), "Second input tidak muncul");
    }
}
