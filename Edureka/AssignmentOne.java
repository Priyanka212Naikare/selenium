package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentOne {
	WebDriver driver;
	
    public void invokeBrowser(String browserType)
    {
    	if(browserType.equals("chrome"))
    	{
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\S.Lappy House\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.get("https://www.edureka.co/");
    	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }
    	else if(browserType.equals("firefox"))
    	{
    	System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver-v0.23.0-win32\\geckodriver.exe");
    	driver=new FirefoxDriver();
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.get("https://www.edureka.co/");
    	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	}
    	
    
    }
    
	public void searchCourse()
	{
		driver.findElement(By.id("homeSearchBar")).sendKeys("jenkins");
    	driver.findElement(By.id("homeSearchBarIcon")).click();
    	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public void searchAllCourse()
	{
		driver.get("https://www.edureka.co/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.id("dLabel")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	
	public void singUp()
	{
		driver.findElement(By.linkText("Sign Up")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='sg_popup_email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.cssSelector("input[class='control_place mob_vid_vw_nm mobile_country_code popusrphn']"))
		.sendKeys("1234567890");
		driver.findElement(By.cssSelector("button.clik_btn_log.btn-block.signup-new-submit")).click();
		waitTillElementVisible(10, By.xpath("(//button[@type='button' or @class='close'])[3]"));
		driver.findElement(By.xpath("(//button[@type='button' or @class='close'])[3]")).click();
		
	}
	
	public void loginClose()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Log In")).click();
		waitTillElementVisible(10, By.xpath("(//button[@type='button' or @class='close'])[3]"));
		driver.findElement(By.xpath("(//button[@type='button' or @class='close'])[3]")).click();
	}
	
	public void loginIn()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Log In")).click();
		waitTillElementVisible(20, By.id("si_popup_email"));
		driver.findElement(By.id("si_popup_email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("si_popup_passwd")).sendKeys("1234567890");
		driver.findElement(By.cssSelector("button.clik_btn_log.btn-block.pagesense_en_track")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
		
	public void logout()
	{
		
		driver.findElement(By.xpath("//a[@class='dropdown-toggle trackButton']")).click();
		driver.findElement(By.linkText("Log Out")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	private void waitTillElementVisible(int timeOutInSeconds,By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void displayLinksOnPage()
	{
		driver.get("https://www.edureka.co/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		List <WebElement> list= driver.findElements(By.tagName("button"));
		for(int i=0;i<list.size();i++)
		{
			System.out.println(i+"\t"+list.get(i).getText());
		}
		
	}
}
