import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
	
public class checkingclickablelinksinawebpage {
	public static void main(String args[]) {
	
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		
		driver.get("https://www.automationexercise.com/");
	
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	for (WebElement link : allLinks) {
	    try {
	        // Check visibility and enablement
	        if (link.isDisplayed() && link.isEnabled()) {
	            // Wait until the link is clickable
	            wait.until(ExpectedConditions.elementToBeClickable(link));
	            System.out.println("Clickable: " + link.getText() + " --> " + link.getAttribute("href"));
	        } else {
	            System.out.println("Not Clickable (Not visible or enabled): " + link.getText());
	        }
	    } catch (Exception e) {
	        System.out.println("Not Clickable (Exception): " + link.getText() + " --> " + e.getMessage());
	    }
	}
	}
}
