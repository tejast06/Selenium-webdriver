package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovment {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\Desktop\\selenium4\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(2000);
		WebElement addOnn =driver.findElement(By.xpath("//a[@id='highlight-addons']"));
		Actions action = new Actions(driver);
		action.moveToElement(addOnn).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"header-addons\"]/ul/li[2]/a")).click();

	}

}
