import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

		public class ChromeOptionsExample {
		    public static void main(String[] args) throws IOException {

		        // ▶ Headless Mode
		        ChromeOptions headlessOptions = new ChromeOptions();
		        headlessOptions.addArguments("--headless");
		        headlessOptions.addArguments("--window-size=1920,1080");

		        WebDriver headlessDriver = new ChromeDriver(headlessOptions);
		        headlessDriver.get("https://www.automationexercise.com/");
		        System.out.println("Headless Mode - Page Title: " + headlessDriver.getTitle());
		        headlessDriver.quit();

		        // ▶ Incognito Mode
		        ChromeOptions incognitoOptions = new ChromeOptions();
		        incognitoOptions.addArguments("--incognito");
		        incognitoOptions.addArguments("--start-maximized");
		        incognitoOptions.addArguments("--disable-notifications");

		        WebDriver incognitoDriver = new ChromeDriver(incognitoOptions);
		        incognitoDriver.get("https://www.automationexercise.com/");
		        File incognito_screenshot = ((TakesScreenshot) incognitoDriver).getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(incognito_screenshot,new File("D:\\Selenium pdfs\\screenshot\\incognito_screenshot.png"));
		        System.out.println("Incognito Mode - Page Title: " + incognitoDriver.getTitle());
		        incognitoDriver.quit();
		    }
		}
