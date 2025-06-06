import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

	public class SwitchToTenthWindow {
	    public static void main(String[] args) throws InterruptedException {
	        
	    	WebDriver driver = new ChromeDriver();
	        
	        driver.get("https://the-internet.herokuapp.com/windows");
	        
	        driver.manage().window().maximize();
	       
	        WebElement link = driver.findElement(By.linkText("Click Here"));

	        // Click the link 19 times (1 main + 19 = 20 windows)
	        for (int i = 0; i < 19; i++) {
	            link.click();
	        }
	        // Assume code that opens 20 windows here

	        Set<String> windowHandleSet = driver.getWindowHandles();
	        Thread.sleep(3000);
	        List<String> windowHandles = new ArrayList<>(windowHandleSet);
	        Thread.sleep(3000);
	        int targetWindowIndex = 9; // 10th window (0-based index)
	        Thread.sleep(3000);
	        if (windowHandles.size() > targetWindowIndex) {
	            driver.switchTo().window(windowHandles.get(targetWindowIndex));
	            Thread.sleep(3000);
	            System.out.println("Switched to 10th window with handle: " + windowHandles.get(targetWindowIndex));
	            Thread.sleep(3000);
	        } else {
	            System.out.println("Less than 10 windows are open. Total: " + windowHandles.size());
	            Thread.sleep(3000);
	        }
	        
	      //  Optional: Close all windows
	         for (String handle : windowHandles) {
	             driver.switchTo().window(handle);
	             Thread.sleep(1500);
	             driver.close();
	    }
	}
	}
