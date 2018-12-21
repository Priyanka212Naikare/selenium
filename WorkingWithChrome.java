package day3;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChrome {

	ChromeDriver driver;
	public void invokeBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\S.Lappy House\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		Dimension dim =new Dimension(786, 1024);
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://qatechhub.com");
		
	}
	
	public void printTitle()
	{
		System.out.println(driver.getTitle());
	}
	
	public void closeBrowser()
	{
		driver.close();//closes current active window
		driver.quit();//closes all  windows which are open
	}
	
}
