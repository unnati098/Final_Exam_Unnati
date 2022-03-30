package script;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Swaglabs {
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	  public void LunchBrowser() throws InterruptedException {
		//First it's start the web browser and then opening the URL
	    System.out.println("Lunching the webbrowser...");
	    System.out.println();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	
	@Test  (priority = -1)
	public void LoginWithWrongData() throws InterruptedException {
		
	//We are passing wrong username and password 
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("Unnati");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("unnati0998");
		Thread.sleep(1000);
		
	//clicking login button 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
	}
  @Test   (priority = 0)
  public void LoginWithRightData() throws InterruptedException {
		
	//Now we are passing the username and password by using sendkeys method
	  driver.findElement(By.xpath("//input[@id='user-name']")).clear();
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		
	//Now by reaching login button we are able to login into website
		driver.findElement(By.xpath("//input[@type='submit']")).click();
  }
  @Test (priority =1)
  public void addtocart() throws InterruptedException {
	  
	  String[] itemsNeeded = {"Sauce Labs Fleece Jacket","Test.allTheThings() T"};
		Thread.sleep(2000);
	  int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("div.inventory_item_name"));
		
		
		for(int i =0; i<products.size(); i++) {
			Thread.sleep(1000);
			String[] name = products.get(i).getText().split("-");
			String formattedname = name[0].trim();
			List iteamneededList = Arrays.asList(itemsNeeded);
			System.out.println(formattedname);
			if(iteamneededList.contains(formattedname)) {
				j++;
				Thread.sleep(1000);
				driver.findElements(By.xpath("//div[@class='pricebar']//button")).get(i).click();	
				if(j == itemsNeeded.length) {
					break;
				}
			}
		}
  }
  	
  @AfterSuite
  public void closedriver() throws InterruptedException {
	  Thread.sleep(1000); 
	  driver.close();
	  }
	 
}
