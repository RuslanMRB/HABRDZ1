package org.example.habrdz;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void roscomnadzor() {

        WebElement searchButton = driver.findElement(By.cssSelector("a[data-test-id='search-button']"));
        searchButton.click();

        WebElement dokuments = driver.findElement(By.cssSelector("a[href='/ru/docs/docs/transparency/']"));
        dokuments.click();

        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Роскомнадзор')]")).isDisplayed(), "Роскомнадзор не найден");


    }


    @Test
    public void language() {

        WebElement nastroiki = driver.findElement(By.cssSelector(".tm-header-user-menu__toggle"));
        nastroiki.click();


        WebElement english = driver.findElement(By.xpath("//*[@id='uiEnglish']/.."));
        english.click();

        WebElement podtvezdenie = driver.findElement(By.cssSelector(".btn_large"));
        podtvezdenie.click();


        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'PopSci')]")).isDisplayed(), "PopSci не найден");


    }


}
