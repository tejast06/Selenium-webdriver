package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsEnable {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\Desktop\\selenium4\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://freecrm.co.in/");
		
		Boolean btnSignUpDisplayed = driver.findElement(By.xpath("/html/body/div[2]/main/section[1]/a")).isDisplayed();
		System.out.println(btnSignUpDisplayed);
		
		Boolean btnLoginInDisplayed = driver.findElement(By.xpath("/html/body/div[2]/header/div/nav/div[2]/div/div[2]/ul/a")).isDisplayed();
        System.out.println(btnLoginInDisplayed);                     
	}

}
