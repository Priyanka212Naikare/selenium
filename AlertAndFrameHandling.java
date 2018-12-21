package day6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAndFrameHandling {
 
	public static void main(String[] args) {
	
		ChromeDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\S.Lappy House\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("button")).click();
	 
		//To come out of the frame
		//driver.switchTo().defaultContent();
		
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText());
		alert.accept();
     }
}
