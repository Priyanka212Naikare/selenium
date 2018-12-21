package day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleBrowserTesting {
WebDriver driver;
	
	public void invokeBrowser(String browserType)
	{
		if(browserType.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\S.Lappy House\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/v4/");
		}
		else if(browserType.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver-v0.23.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("http://demo.guru99.com/v4/");
			
		}
		else if(browserType.equals("Firefox"))
		{
			System.setProperty("webdriver.edge.driver", "D:\\Selenium\\MicrosoftWebDriver.exe");
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("http://demo.guru99.com/v4/");
			
		}
		
	}

	public void printTitle()
	{
		System.out.println(" window title:"+driver.getTitle());
	}
}
