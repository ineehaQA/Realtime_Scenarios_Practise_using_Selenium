import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class DropdownMultipleSelect {
	    public static void main(String[] args) {
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://the-internet.herokuapp.com/");  // Replace with actual URL
            driver.manage().window().maximize();
	        WebElement dropdownElement = driver.findElement(By.xpath("//a[normalize-space()='Dropdown']"));  // Replace with actual locator
             dropdownElement.click();
	        WebElement ddselect= driver.findElement(By.id("dropdown"));
             Select select = new Select(ddselect);
	        if (select.isMultiple()) {
	            System.out.println("The dropdown is a multi-select dropdown.");
	        } else {
	            System.out.println("The dropdown is a single-select dropdown.");
	        }
	        
	        List<WebElement> options = select.getOptions();

	        System.out.println("Dropdown options are:");
	        for (WebElement option : options) {
	            System.out.println(option.getText());
	        }

	        driver.quit();
	    }
	}
