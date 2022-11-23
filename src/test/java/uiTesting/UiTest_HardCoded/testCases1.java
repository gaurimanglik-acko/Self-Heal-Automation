package uiTesting.UiTest_HardCoded;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import uiTesting.Ackathon.homePage1;

public class testCases1 {
    WebDriver driver;
    WebDriver delegate;

    SelfHealingDriver selfHealingDriver;
    public static String browser="Chrome";
    String name="https://www.google.com/";

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        switch (browser) {
            case "Chrome" -> {

                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
                delegate = new ChromeDriver();
//create Self-healing driver
                selfHealingDriver = SelfHealingDriver.create(delegate);
            }
            case "Firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "Safari" -> {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            default -> throw new IllegalStateException("Unexpected value: " + browser);
        }

        selfHealingDriver.get(name);
        selfHealingDriver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @Test
    public void launchWebsite() throws InterruptedException {
        homePage1.clickOnTextBox(selfHealingDriver);
    }
}
