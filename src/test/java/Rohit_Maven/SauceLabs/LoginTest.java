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
import sauceLabs.pageobjects.ProductCatalog;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String productName="Sauce Labs Fleece Jacket";
		
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
		
		LandingPage lp = new LandingPage(driver);
		
		lp.goTo();
		
		lp.loginApp("standard_user", "secret_sauce");
		ProductCatalog productCatalog = new ProductCatalog(driver);
		List<WebElement>products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		productCatalog.goToCartPage();
		//driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='Sauce Labs Fleece Jacket']"));
		
		
			
	

		driver.findElement(By.cssSelector("[data-test='checkout']")).click();
		
		driver.findElement(By.id("first-name")).sendKeys("Joe");
		
		driver.findElement(By.id("last-name")).sendKeys("Doe");
		
		driver.findElement(By.id("postal-code")).sendKeys("37128");
		
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("finish")).click();
		

	}

}
