package sauceLabs.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {
	

	private WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="data-test='shopping-cart-link")
	WebElement cartHeader;
	
	public void goToCartPage() {
		
		cartHeader.click();
		
	}
	
		
		
		
	

}
