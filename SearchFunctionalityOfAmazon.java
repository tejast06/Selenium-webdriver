package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchFunctionalityOfAmazon {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\CRM\\src\\main\\java\\selenium\\config.properties");
        prop.load(file);
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		//searchbox
		driver.findElement(By.xpath(prop.getProperty("searchBoxXpath"))).sendKeys("selenium webdriver");
		Thread.sleep(1000);
		//click on search button
		driver.findElement(By.xpath(prop.getProperty("searchButtonXpath"))).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(prop.getProperty("productXpath"))).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow=it.next();
		String childWindow =it.next();
		driver.switchTo().window(childWindow);
		
		Thread.sleep(5000);
		//click on add to cart:
		driver.findElement(By.xpath(prop.getProperty("addToCart"))).click();
		//click to buy
		

	}

}
