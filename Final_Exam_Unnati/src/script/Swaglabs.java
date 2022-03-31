package script;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Swaglabs
{
    WebDriver driver = new ChromeDriver();
    
    @BeforeTest
    public void LunchBrowser() throws InterruptedException
    {
        //First it's start the web browser and then opening the URL
        System.out.println("Lunching the webbrowser...");
        System.out.println();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    
    @Test(priority = -1)
    public void LoginWithWrongData() throws InterruptedException
    {
        //We are passing wrong username and password 
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("Unnati");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("unnati0998");
        Thread.sleep(1000);
        
        //clicking login button 
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
    }
    
    @Test(priority = 0)
    public void LoginWithRightData() throws InterruptedException
    {
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
   
    
//Here we are selecting price low to high by selecting it from drop down
    @Test(priority = 1)
    public void dropdown() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//select[@class='product_sort_container']//option[3]")).click();
    	Thread.sleep(2000);
    }
    
 //Here we are adding iteams in cart
    @Test(priority = 2)
    public void addtocart() throws InterruptedException
    {
        String[] itemsNeeded = {
            "Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"
        };
        Thread.sleep(2000);
        int j = 0;
        List < WebElement > products = driver.findElements(By.cssSelector("div.inventory_item_name"));
        for(int i = 0; i < products.size(); i++)
        {
            Thread.sleep(1000);
            WebElement name = products.get(i);
            String Name_text = name.getText();
            List iteamneededList = Arrays.asList(itemsNeeded);
            if(iteamneededList.contains(Name_text))
            {
                j++;
                Thread.sleep(1000);
                driver.findElements(By.xpath("//div[@class='pricebar']//button")).get(i).click();
                if(j == itemsNeeded.length)
                {
                    break;
                }
            }
        }
    }
    
    
 // Goto cart
    @Test(priority = 3)
    public void cart() throws InterruptedException
    {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }
    
    
 //Now we are removing some iteams from cart
    @Test(priority = 4)
    public void removefromcart() throws InterruptedException
    {
        Thread.sleep(1000);
        String[] itemsNeeded = {
        		"Sauce Labs Onesie","Sauce Labs Bike Light"
        };
        Thread.sleep(1000);
        int j = 0;
        List < WebElement > products = driver.findElements(By.cssSelector("div.inventory_item_name"));
        for(int i = 0; i < products.size(); i++)
        {
            Thread.sleep(1000);
            WebElement name = products.get(i);
            String Name_text = name.getText();
            List iteam = Arrays.asList(itemsNeeded);
            if(iteam.contains(Name_text))
            {
                j++;
                Thread.sleep(2000);
                driver.findElements(By.xpath("//div[@class='cart_item_label']//button")).get(i).click();
                if(j == itemsNeeded.length)
                {
                    break;
                }
            }
        }
    }
    
    
 //Here we are testing that the "continueshopping" button is working fine or not
    @Test(priority = 5)
    public void continueshopping() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }
    
    
 //Now checkout 
    @Test(priority = 6)
    public void checkout() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }
    
    
  //Giving information for checkout
    @Test(priority = 7)
    public void information() throws InterruptedException
    {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Yash");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Patel");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("HE3C11");
    }
   
  //continue checkout process
    @Test(priority = 8)
    public void continuecheckout() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
  
    
  // We are about to finishing process and the testing 
    @Test(priority = 9)
    public void finish() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='finish']")).click();
    }
  
  //clicking on back to home
    @Test(priority = 10)
    public void backtohome() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
    }
    
  // Now we are closing the browser 
    @AfterSuite
    public void closedriver() throws InterruptedException
    {
        Thread.sleep(3000);
        driver.close();
    }
}