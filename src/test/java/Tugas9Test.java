import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class Tugas9Test {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void testHover() {
        driver.findElement(By.linkText("Hovers")).click();

        WebElement image = driver.findElements(By.cssSelector(".figure")).get(0); // Gambar pertama
        Actions action = new Actions(driver);
        action.moveToElement(image).perform();

        WebElement image2 = driver.findElements(By.cssSelector(".figure")).get(1); // Gambar kedua
        Actions action2 = new Actions(driver);
        action2.moveToElement(image2).perform();

        WebElement image3 = driver.findElements(By.cssSelector(".figure")).get(2); // Gambar ketiga
        Actions action3 = new Actions(driver);
        action3.moveToElement(image3).perform();
    }

    @Test
    public void testDragAndDrop() {
        driver.findElement(By.linkText("Drag and Drop")).click();

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        Actions action = new Actions(driver);
        action.dragAndDrop(columnA, columnB).perform();
    }

    @Test
    public void testKeyPress() {
        driver.findElement(By.linkText("Key Presses")).click();

        WebElement inputField = driver.findElement(By.id("target"));
        inputField.sendKeys(Keys.SHIFT);

        WebElement result = driver.findElement(By.id("result"));
        assertEquals("You entered: SHIFT", result.getText());
    }
}
