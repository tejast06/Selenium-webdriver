package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicSearch {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\Desktop\\selenium4\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwjfxp6Os_nqAhU64zgGHXngB_AQPAgH");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Testing");
		Thread.sleep(2000);
		List<WebElement>list =driver.findElements(By.xpath("//ul[@role='listbox']"));
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getText().contains("testing interview questions"))
			{   
				System.out.println(list.get(i).getText());
				list.get(i).click();
				break;
			}
		}

	}

}
