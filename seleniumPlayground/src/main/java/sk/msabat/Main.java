package sk.msabat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        WebDriverManager.chromedriver()
                .driverVersion("109.0.5414.74")
                .setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://tabas32.github.io/web_sabat/");

        var locator = By.cssSelector("div.about h2");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        System.out.println(element.getText().equals("Software engineer in testing"));

        driver.quit();
    }
}