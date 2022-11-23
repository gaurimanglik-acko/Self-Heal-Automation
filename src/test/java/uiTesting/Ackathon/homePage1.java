package uiTesting.Ackathon;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage1 {
//    public static Object clickOnTextBox;
    @FindBy(xpath = "//input[@name='q']")
    private static WebElement textBox;

    public static void clickOnTextBox(SelfHealingDriver driver) throws InterruptedException {
//        textBox.click();
        Thread.sleep(1000);
        WebElement text=driver.findElement(By.xpath("//input[@name='q']"));
        text.click();
        text.sendKeys("facebook");
    }
}
