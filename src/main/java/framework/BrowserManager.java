package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager {

    // creating ThreadLocal<WebDriver> for multithreading
    private static ThreadLocal<WebDriver> browser = new ThreadLocal<>();

    // getting browser
    public static WebDriver getBrowser() {
        return browser.get();
    }

    public static void openBrowser() {
        // way to driver
        System.setProperty("webdriver.chrome.driver", "./target/classes/chromedriver.exe");
        // creating ChromeDriver()
        browser.set(new ChromeDriver());
        // maximize window size
        browser.get().manage().window().maximize();
        // waiting for webelement
        browser.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    // closing browser
    public static void closeBrowser() {
        browser.get().quit();
    }
}
