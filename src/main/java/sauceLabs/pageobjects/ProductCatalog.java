package sauceLabs.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sauceLabs.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(className="inventory_item")
	List<WebElement> products;
	By addToCart = By.id("add-to-cart-sauce-labs-fleece-jacket");
	
	
	public List<WebElement> getProductList() {
		
		
		return products;
		
	}
	
	
	public WebElement getProductByName(String productName)
	
	{
	
		WebElement prod= products.stream().filter(product->
		product.findElement(By.cssSelector("[data-test='inventory-item-name']")).getText().equals("Sauce Labs Fleece Jacket")).findFirst().orElse(null);
		
		return prod;
	}
	
	
	public void addProductToCart(String productName) {
		
		WebElement prod= getProductByName(productName);
		
		prod.findElement(addToCart).click();
	}
	
}
 