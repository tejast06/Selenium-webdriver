package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCounter {
	public static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\Desktop\\selenium4\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.guru99.com/");
		
		List<WebElement> linkList =driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img")));
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		for(int i=0; i<linkList.size(); i++)
		{
			if(linkList.get(i).getAttribute("href")!=null && (!linkList.get(i).getAttribute("href").contains("javascript")))
			{
				activeLinks.add(linkList.get(i));
			}
		}
		System.out.println("size of active links: " +activeLinks.size());
		System.out.println("size of total links: " +linkList.size());
		
		for(int j=0; j<activeLinks.size(); j++)
		{
			HttpURLConnection connection =(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response =connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"---->" +response);
		}

	}

}
