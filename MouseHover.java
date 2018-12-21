package day6;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHover {

WebDriver driver;
	
	public void invokeBrowser(String browserType)
	{
		if(browserType.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\S.Lappy House\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//div[@class='_3Njdz7']//button[@class='_2AkmmA _29YdH8']")).click();
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
			driver.get("https://www.flipkart.com/");
			
		}
		
	}
		public void mouseHover()
		{
			WebElement eleLink=driver.findElement(By.xpath("//span[text()='Electronics']"));
			Actions action= new Actions(driver);
			action.moveToElement(eleLink).build().perform();
			//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			waitTillElementVisible(10, By.xpath("(//a[text()='Samsung'])[1]"));
			fluentWait(20, 10, By.xpath("(//a[text()='Samsung'])[1]"));
			WebElement samsungLink=driver.findElement(By.xpath("(//a[text()='Samsung'])[1]"));
			//WebElement samsungLink=driver.findElement(By.linkText("Samsung"));
			action.moveToElement(samsungLink).click().build().perform();
			System.out.println(samsungLink.getText());
			
		}
		
		private void waitTillElementVisible(int timeOutInSeconds,By by)
		{
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
	
		
		private void fluentWait(int timeout, int pollingTime, By by)
		{
			
            FluentWait <WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
			.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);
			
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}

