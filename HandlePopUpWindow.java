package selenium;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlePopUpWindow {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\Desktop\\selenium4\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("http://popuptest.com/");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font[1]/b/a")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it =handles.iterator();
		String parentWindowID =it.next();
		String childWindowID = it.next();
		System.out.println(parentWindowID);
		System.out.println(childWindowID);
		
		driver.switchTo().window(childWindowID);
		Thread.sleep(2000);
		System.out.println("child window title" +driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		System.out.println("parent window title" +driver.getTitle());
		
	}

}
