package uiTesting.UiTest_HardCoded;

import uiTesting.UiTest_HardCoded.pageObjectModel.flightSelectionPage;
import uiTesting.UiTest_HardCoded.pageObjectModel.homePage;
import uiTesting.UiTest_HardCoded.pageObjectModel.itineraryPage;
import uiTesting.UiTest_HardCoded.pageObjectModel.loginPage;
import uiTesting.UiTest_HardCoded.utilities.generalFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases
{
    WebDriver driver;
    public static String browser="Chrome";
    String name="https://www.cleartrip.com/flights";

@BeforeTest
    public void beforeTest() throws InterruptedException {
    switch (browser) {
        case "Chrome" -> {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
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
    driver.get(name);
    driver.manage().window().maximize();
    Thread.sleep(2000);
}
@Test
public void homePageTest()throws InterruptedException{
    homePage.closeAds(driver);
    homePage.selectBusinessCls(driver);
    homePage.departureAirport(driver);
    homePage.arrivalAirports(driver);
    homePage.dateSelector(driver);
    homePage.submitBtn(driver);
}
//
//@Test(priority = 0)
//public void closingAds() throws InterruptedException {
//    homePage1.closeAds(driver);
//}
//@Test(priority = 1)
//public void ticketClass() throws InterruptedException {
//    homePage1.selectBusinessCls(driver);
//}
//@Test(priority = 2)
//public void testDeparture() throws InterruptedException {
//    homePage1.departureAirport(driver);
//}
//@Test(priority = 3)
//public void testArrival() throws InterruptedException {
//    homePage1.arrivalAirports(driver);
//}
//@Test(priority = 4)
//public void testDate() throws InterruptedException {
//    homePage1.dateSelector(driver);
//}
//@Test(priority = 5)
//public void testSubmit(){
//    homePage1.submitBtn(driver);
//}

    @Test(priority = 1)
    public void flightSelectionPageTest() throws InterruptedException {
    //flightSelectionPage.nonstopCheckbox(driver);
    flightSelectionPage.bookBtn(driver);
    }
//@Test(priority = 6)
//public void testCheckbox() throws InterruptedException {
//    flightSelectionPage.nonstopCheckbox(driver);
//}
//@Test(priority = 7)
//public void testBookBtn() throws InterruptedException {
//    flightSelectionPage.bookBtn(driver);
//}
@Test(priority = 2)
public void testHandleWindow() throws InterruptedException {
    generalFunctions.handleWindow(driver);
}
@Test(priority = 3)
public void itineraryPageTest()throws InterruptedException
{
    itineraryPage.couponCode(driver);
    generalFunctions.scrollDown(driver);
    itineraryPage.continueBtn(driver);
    itineraryPage.enterMobile(driver);
    itineraryPage.enterEmail(driver);
    itineraryPage.continue1Btn(driver);

}
//@Test(priority = 10)
//public void enterDetails() throws InterruptedException {
//    generalFunctions.scrollDown(driver);
//    ItineraryPage.continueBtn(driver);
//    ItineraryPage.enterMobile(driver);
//    ItineraryPage.enterEmail(driver);
//    ItineraryPage.continue1Btn(driver);
//}
@Test(priority = 4)
public void loginTest() throws InterruptedException {
    loginPage.login(driver);
}
@AfterTest
    public void afterTest()
{
    driver.close();
    driver.quit();
}

}
