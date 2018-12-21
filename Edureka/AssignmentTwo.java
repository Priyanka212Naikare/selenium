package assignments;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class AssignmentTwo {
WebDriver driver;
	
    public void invokeBrowser()
    {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\S.Lappy House\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.get("https://www.edureka.co/");
    	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	//	((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 500);");
			
    }
    
	public void searchCourse()
	{
		
		WebElement home= driver.findElement(By.id("homeSearchBar"));
		home.sendKeys("Selenium");
		//home.sendKeys(Keys.ENTER);
		home.submit();
	
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//driver.findElement(By.id("homeSearchBarIcon")).click();
    	//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	
		waitTillElementVisible(20, By.cssSelector("div.card.giTrackElement.giTrackElementHover"));
    	driver.findElement(By.cssSelector("div.card.giTrackElement.giTrackElementHover")).click();
    	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	String title=driver.getTitle();
    	String name="Selenium Online Training & Certification Course- Edureka";
    	System.out.println("title:"+ driver.getTitle());
    	if(name.equals(title))
    	{
    		System.out.println("titles are matching");
    	}
    	//driver.navigate().back();
    	driver.navigate().to("https://www.edureka.co/");
    	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.id("dLabel")).click();
		fluentWait(20, 5, By.id("add-master-courses"));
	
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
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
	
}
