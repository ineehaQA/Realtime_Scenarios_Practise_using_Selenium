import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyingsortingformultipleitemsonMyntra {
	
@Test
public void verifySortingLowToHigh() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.myntra.com/tshirts?rawQuery=tshirts");

    // Click on "Sort by: Price - Low to High"
    WebElement sortDropdown = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
    sortDropdown.click();
    WebElement lowToHigh = driver.findElement(By.xpath("//label[text()='Price: Low to High']"));
    lowToHigh.click();
    Thread.sleep(3000); // wait for sorting to apply

    List<Integer> allPrices = new ArrayList<>();

    // Loop for first 5 pages/items by scrolling down
    for (int i = 0; i < 5; i++) {
        // Extract price elements
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='product-discountedPrice' or @class='product-price']"));

        for (WebElement e : priceElements) {
            String priceText = e.getText().replaceAll("[^0-9]", ""); // remove currency symbols
            if (!priceText.isEmpty()) {
                allPrices.add(Integer.parseInt(priceText));
            }
        }

        // Scroll to bottom to load more items (lazy loading)
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(3000); // allow time to load more items
    }

    driver.quit();

    // Create a copy of original list and sort it
    List<Integer> sortedPrices = new ArrayList<>(allPrices);
    Collections.sort(sortedPrices);

    // Assertion to verify if sorting is correct
    Assert.assertEquals(allPrices, sortedPrices, "Prices are not sorted in ascending order!");
}
}
