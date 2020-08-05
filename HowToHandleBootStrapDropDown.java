package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HowToHandleBootStrapDropDown {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\Desktop\\selenium4\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://getbootstrap.com/docs/4.5/components/dropdowns/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
		
		  List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown show']//child::div"));
		  System.out.println(list.size());
		  for(int i=0; i<list.size(); i++)
		  {
			  System.out.println(list.get(i).getText());
			  if(list.get(i).getText().contains("Action"))
			  {
				  list.get(i).click();
			  }
		  }
		
       
	}

}
