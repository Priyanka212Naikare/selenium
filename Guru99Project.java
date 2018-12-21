package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Guru99Project {
	ChromeDriver driver;
	
	public void invokeBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\S.Lappy House\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/v4/");
		
	}
	
	public void login(String userId,String usrpwd){
		driver.findElement(By.name("uid")).sendKeys(userId);
		driver.findElement(By.name("password")).sendKeys(usrpwd);
		driver.findElement(By.name("btnLogin")).click();
		
	}
	
	public void printTitle()
	{
		System.out.println(" window title:"+driver.getTitle());
	}
	
	public void addCustomer()
	{
		driver.findElement(By.linkText("New Customer")).click();
		driver.findElement(By.name("name")).sendKeys("Priyanka");
		driver.findElement(By.xpath("//input[@value='f']")).click();
		driver.findElement(By.name("dob")).sendKeys("06/12/1989");
		driver.findElement(By.name("addr")).sendKeys("Pune\n Maharashtra");
		driver.findElement(By.name("city")).sendKeys("Pune");
		driver.findElement(By.name("state")).sendKeys("Maharastra");
		driver.findElement(By.name("pinno")).sendKeys("789456");
		driver.findElement(By.name("telephoneno")).sendKeys("9898989898");
		
		String emailid = "aa"+System.currentTimeMillis()+"@gmail.com";
		System.out.println("email id : "+emailid);
		driver.findElement(By.name("emailid")).sendKeys(emailid);
		driver.findElement(By.name("password")).sendKeys("abc@212S");
		
	driver.findElement(By.name("sub")).click();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		
	}
	
	public String getCustomerId(){
		return driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();
	}
	
	public void addAccount(String customerId){
		
		driver.findElement(By.linkText("New Account")).click();
		driver.findElement(By.name("cusid")).sendKeys(customerId);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement accountDropdown = driver.findElement(By.name("selaccount"));
		Select selectAccount = new Select(accountDropdown);
		selectAccount.selectByVisibleText("Savings");
		//System.out.println(selectAccount.isMultiple());
		//System.out.println(selectAccount.getWrappedElement());
		driver.findElement(By.name("inideposit")).sendKeys("424422");
        driver.findElement(By.name("button2")).click();		
		
	}
	public void closeBrowser(){
		driver.quit();
	}

}
