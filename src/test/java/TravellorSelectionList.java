import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TravellorSelectionList {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

        // Close login popup if it appears
        driver.findElement(By.tagName("body")).click();
    }

    @Test
    public void selectTravellers() throws InterruptedException {

        // Open the "Travellers & Class" dropdown
        WebElement travellerBox = driver.findElement(By.xpath("(contains(@class,'lbl_input appendBottom5'))"));       
        travellerBox.click();
        Thread.sleep(1000);

        // Increase Adults from 1 to 2
        WebElement adultIncrement = driver.findElement(By.xpath("//p[text()='Adults']/following-sibling::div//span[@data-testid='adult-increment']"));
        adultIncrement.click();

        // Increase Children to 1
        WebElement childIncrement = driver.findElement(By.xpath("//p[text()='Children']/following-sibling::div//span[@data-testid='child-increment']"));
        childIncrement.click();
        
        // Increase Infants to 1
        WebElement infantIncrement = driver.findElement(By.xpath("//p[text()='Infants']/following-sibling::div//span[@data-testid='infant-increment']"));
        infantIncrement.click();

        // Click Apply button
        WebElement applyButton = driver.findElement(By.xpath("//button[text()='APPLY']"));
        applyButton.click();

        // Validate the updated traveller summary
        WebElement travellerSummary = driver.findElement(By.xpath("//label[contains(text(),'Travellers & Class')]/following-sibling::p"));
        String summaryText = travellerSummary.getText();
        System.out.println("Traveller Summary: " + summaryText);

        Assert.assertTrue(summaryText.contains("2 Adults"));
        Assert.assertTrue(summaryText.contains("1 Child"));
        Assert.assertTrue(summaryText.contains("1 Infant"));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
