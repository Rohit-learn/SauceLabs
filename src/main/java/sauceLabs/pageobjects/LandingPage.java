package sauceLabs.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sauceLabs.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement submit;
	
	
	public void loginApp(String email,  String Password) {
		
		username.sendKeys(email);
		password.sendKeys(Password);
		submit.click();
	}
	
	public void goTo() {
		
		driver.get("https://www.saucedemo.com/");
			
			
}
	
	
	
	
}
 