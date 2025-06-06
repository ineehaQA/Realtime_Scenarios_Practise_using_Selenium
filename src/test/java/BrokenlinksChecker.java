import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenlinksChecker {

	public static void main(String args[]) {
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("http://www.deadlinkcity.com/");
	
	List<WebElement> all_links = driver.findElements(By.tagName("a"));
	
	System.out.println("Size of all Links : " +all_links.size());
	
	for(int a=0;a<all_links.size();a++) {
		
		@SuppressWarnings("deprecation")
		String url = all_links.get(a).getAttribute("href");
		
		System.out.println("The url is : " +url);
		
		try {
			HttpURLConnection con =  (HttpURLConnection) new URL(url).openConnection();
			
			con.setConnectTimeout(3000);
			
			con.connect();
			
			int response_code = con.getResponseCode();
			
			if(response_code > 400) {
				System.out.println("Link is Broken : "+url+" : "+response_code);
			} else {
				System.out.println("Link is Safe : "+url+" : "+response_code);
			}
		} catch(MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}	
	}
}
}
