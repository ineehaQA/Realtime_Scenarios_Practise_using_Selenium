import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class GoogleAutoSuggest {

    public static void main(String[] args) throws InterruptedException {
        
        // Setup ChromeDriver (Make sure chromedriver is in your PATH or set its path here)
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Step 1: Open Google
        driver.get("https://www.google.com");

        // Step 2: Type "selenium" into the search bar
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");

        // Step 3: Wait and capture all suggestions
        Thread.sleep(2000); // Use WebDriverWait for better practice in real frameworks

        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='wM6W7d']/span"));

        System.out.println("Auto-suggestions:");
        boolean found = false;
        for (WebElement suggestion : suggestions) {
            String text = suggestion.getText();
            System.out.println(text);

            // Step 4: Select "selenium rich foods" if present
            if (text.equalsIgnoreCase("selenium rich foods")) {
                suggestion.click();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\"selenium rich foods\" not found in suggestions.");
        }

        // Optional wait to view result page
        Thread.sleep(3000);
        driver.quit();
    }
}

