package Test1;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class AlwefaqSiteExample {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	@BeforeSuite	
	public void setUp() {
		// start reporters
		htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);


	}

	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
	}
	
	
	@Test
	public void test1() throws Exception {
  
		ExtentTest test = extent.createTest("Alwefaq", "Automation Run");
		driver.get("https://www.alwefaq.com");
		test.pass("Navigated to alwefaq.com");

		driver.findElement(By.cssSelector("a[class='nav-item menu-home']")).click();
		test.pass("Click on About us ");
		
		driver.findElement(By.cssSelector("h1[class='orangeTitle upper-case bold']")).isDisplayed(); 
		test.pass("About us page load properly "); 
		
		driver.findElement(By.cssSelector("button[class='btn dropdown-toggle dropdown-toggle-img']")).click();
		test.pass("Click on change language button ");
		
		driver.findElement(By.cssSelector("label[for='ex7_5']")).click();
		test.pass("Click on arabic language button ");
		
		driver.findElement(By.cssSelector("h1[class='orangeTitle']")).isDisplayed(); 
		test.pass("About us arabic page load properly "); 
		
	}
	
	
	@AfterTest
	public void tearDownTest() {
		//close browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Succsssfully");
	}
	@AfterSuite
	public void tearDown() {
		extent.flush();
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.navigate().to(projectPath+"/extent.html");

	}

}
