package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingOnSpiceJet {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\Desktop\\selenium4\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(2000);
		
		//Departure
		driver.findElement(By.xpath("//input[@name='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='AMD']")).click();
		Thread.sleep(4000);
		
		//Arrival
		driver.findElement(By.xpath("//input[@name='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[2]/div[3]/div[1]/div/ul[4]/li[7]/a"));
		Thread.sleep(2000);
		
		//Calendar:
		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_view_date1\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[2]/td[3]/a")).click();
		//Passenger:
		driver.findElement(By.xpath("//div[@class='paxinfo']")).click();
		Thread.sleep(2000);
		WebElement Adult =driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[6]/div[2]/div[2]/p[1]/select"));
        Select select = new Select(Adult);
        select.selectByVisibleText("2");
        Thread.sleep(2000);
        
        WebElement child =driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_Child\"]"));
        Select selectChild = new Select(child);
        selectChild.selectByVisibleText("2");
        Thread.sleep(2000);
        //Currency:
        WebElement currency =driver.findElement(By.xpath("//select[@class='valid']"));
        Select selectCurrency = new Select(currency);
        selectCurrency.selectByVisibleText("INR");
        Thread.sleep(2000);
        
        //search:
        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_btn_FindFlights\"]")).click();
        
        
        
	}

}
