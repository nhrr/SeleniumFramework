
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BrowserTest {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: "+ projectPath);
		
		//System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//System.setProperty("webdriver.ie.driver",projectPath+"/drivers/iedriver/IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.google.com/");
		//WebElement textBox= driver.findElement(By.id("lst-ib"));
		//textBox.sendKeys("Automation Test");
		
		//driver.findElement(By.id("lst-ib")).sendKeys("Automation Test by id");
		
		//driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("Automation Test by xpath");
		
		//List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		//int count = listOfInputElements.size();
		//System.out.println("count of elements :"+count);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		//driver.quit();
		
	}
	
}
