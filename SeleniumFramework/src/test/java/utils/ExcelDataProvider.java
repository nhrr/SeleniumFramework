package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class ExcelDataProvider {
	WebDriver driver = null;
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		
	}
@Test(dataProvider="test1data")

	public void test1(String username,String password) {
	System.out.println(username+ "  "+password );
		//add your test here
	//driver.get("https://opensource-demo.orangehrmlive.com");	
	}
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelPath = "C:\\Users\\noor\\Desktop\\SeleniumFramework\\excel\\data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;

	}

	public Object[][] testData(String excelPath, String sheetName ) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][] = new Object [rowCount-1][colCount];

		for (int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {

				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data;
	}

}
