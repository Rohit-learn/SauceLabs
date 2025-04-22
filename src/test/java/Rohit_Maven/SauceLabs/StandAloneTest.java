package Rohit_Maven.SauceLabs;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import sauceLabs.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		   ChromeOptions options = new ChromeOptions();
	        
	        // Disable Chrome password manager
	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("credentials_enable_service", false);
	        prefs.put("profile.password_manager_enabled", false);
	        options.setExperimentalOption("prefs", prefs);
	        
	        // Optional: Incognito mode (adds further suppression)
	        options.addArguments("--incognito");

	        // Optional: Reduce automation detection
	        options.addArguments("--disable-blink-features=AutomationControlled");

	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver(options);
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement> products = driver.findElements(By.className("inventory_item"));
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='Sauce Labs Fleece Jacket']"));
		
		
		WebElement prod= products.stream().filter(product->
		product.findElement(By.cssSelector("[data-test='inventory-item-name']")).getText().equals("Sauce Labs Fleece Jacket")).findFirst().orElse(null);
		Thread.sleep(2000);
	
		prod.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
	
		
		driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();
		

		driver.findElement(By.cssSelector("[data-test='checkout']")).click();
		
		
		driver.findElement(By.id("first-name")).sendKeys("Joe");
		
		driver.findElement(By.id("last-name")).sendKeys("Doe");
		
		driver.findElement(By.id("postal-code")).sendKeys("37128");
		
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("finish")).click();
		
	
	}

}
