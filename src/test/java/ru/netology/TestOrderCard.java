package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestOrderCard {
    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

        @Test
        void Test () {
            driver.get("http://localhost:9999");
            driver.findElement(By.cssSelector("[type=\"text\"]")).sendKeys("Иван Петров");
            driver.findElement(By.cssSelector("[type=\"tel\"]")).sendKeys("+79998887766");
            driver.findElement(By.className("checkbox__box")).click();
            driver.findElement(By.className("button__content")).click();

            String actual = driver.findElement(By.className("paragraph")).getText().trim();
            String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";

            Assertions.assertEquals(expected, actual);
        }

    }
