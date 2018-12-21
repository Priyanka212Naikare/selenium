package assignments;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentThree {
WebDriver driver;
	
  public void selectSrcViaScrollDown() {

	  WebElement select = driver.findElement(By.name("or-src"));
 	  select.click();
		//List<WebElement> allCities = driver.findElements(By.xpath("//div[@class='autocomplete-result station-result clearfix airport-item']/div[@class='airport-city']"));
 	List<WebElement> allCities = driver.findElements(By.xpath("//div/div/div/div/div[@class='airport-city']"));
 // 	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action = new Actions(driver);

		for (WebElement city : allCities) {

			action.moveToElement(city).build().perform();
			if("Bengaluru, India".equals(city.getText()))
			{
			System.out.println("--------------------------------------------");
			System.out.println(city.getText());
			city.submit();
			}
			
		}
		
		 	  //select1.click();
		waitTillElementVisible(10,By.name("or-dest"));
		driver.findElement(By.name("or-dest")).click();
		//List<WebElement> destCities = driver.findElements(By.xpath("//div/div/div/div/div[@class='airport-city']"));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fluentWait(20, 10, By.xpath("(//div[text()='Lucknow, India'])[1]"));	
		WebElement dest=driver.findElement(By.xpath("(//div[text()='Lucknow, India'])[1]"));
		action.moveToElement(dest).click().build().perform();
		/*Actions action1 = new Actions(driver);

				for (WebElement city : destCities) {

					action1.moveToElement(city).build().perform();
					if("Lucknow, India".equals(city.getText()))
					{
					System.out.println("--------------------------------------------");
					System.out.println(city.getText());
					driver.findElement(By.name("or-dest")).sendKeys(city.getText());
					city.sendKeys(Keys.ENTER);
					}
				}
			*/	
		
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
  
  public void selectDestViaScrollDown() {
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.findElement(By.xpath("//input[@class='form-control or-depart igInitCalendar parsley-success focus']")).click();
	       driver.findElement(By.xpath("//td[@class=' selected-date ui-datepicker-current-day']")).click();
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       driver.findElement(By.name("passenger")).click();
	    	driver.findElement(By.xpath("(//li[@class='adult-pax-list']/div/button[@class='pax-plus btn btn-info'])[1]")).click();
	    	driver.findElement(By.xpath("(//li[@class='adult-pax-list']/div/button[@class='pax-plus btn btn-info'])[1]")).click();
	    	driver.findElement(By.xpath("(//li[@class='child-pax-list']/div/button[@class='pax-plus btn btn-info'])[1]")).click();
	    	driver.findElement(By.xpath("(//li[@class='child-pax-list']/div/button[@class='pax-plus btn btn-info'])[1]")).click();
	    	driver.findElement(By.xpath("//button[@class='btn btn-primary block bold ig-search-btn ig-common-cta addLoader']")).submit();
	    	
	       //dest.submit();
 			/*List<WebElement> allCities1 = driver.findElements(By.xpath("//div[@class='autocomplete-result station-result clearfix airport-item']/div[@class='airport-city']"));
 			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 			Actions action1 = new Actions(driver);

		    for (WebElement city1 : allCities1) 
		    {
			action1.moveToElement(city1).build().perform();
			if("Lucknow, India".equals(city1.getText()))
			{
			System.out.println("--------------------------------------------");
			System.out.println(city1.getText());
			city1.submit();
			}
		}*/
}
    public void invokeBrowser()
    {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\S.Lappy House\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.get("https://www.goindigo.in/?linkNav=home_header");
    	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
       	driver.findElement(By.id("oneWayTrip")).click();
       	/*driver.findElement(By.name("or-src")).clear();
    	 WebElement select = driver.findElement(By.name("or-src"));
    	 select.click();
    	   List<WebElement> options = select.findElements(By.xpath("//div[@class='autocomplete-result station-result clearfix airport-item']/div[@class='airport-city']"));

    	   for (WebElement option1 : options) 
    	   {
       	   if("Amritsar, India".equals(option1.getText()))
    	    option1.submit();   
    	   }  
    	   WebElement select1 = driver.findElement(By.name("or-dest"));
      	 select.click();
      	   List<WebElement> options1 = select.findElements(By.xpath("//div[@class='autocomplete-result station-result clearfix airport-item']/div[@class='airport-city']"));

      	   for (WebElement option1 : options1) 
      	   {
         	   if("Amritsar, India".equals(option1.getText()))
      	    option1.submit();   
      	   }  
    	WebElement src=driver.findElement(By.name("or-src"));
    	src.clear();
    	src.sendKeys("Bangalore");
    	src.submit();
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	WebElement dest=driver.findElement(By.name("or-dest"));
    	dest.sendKeys("Lucknow");
    	dest.submit();
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    	Date today = Calendar.getInstance().getTime();
    	String date = dateFormat.format(today);
    	driver.findElement(By.name("or-depart")).clear();
    	WebElement todate= driver.findElement(By.name("or-depart"));
    	todate.clear();
    	todate.sendKeys(date);*/
    	
    	
			
    }
    
  

}


