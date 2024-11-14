package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	
	public void clickMyAccount()
	{

		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
	
		
	}
	public WebDriver loginClick()
	{
		WebElement login = driver.findElement(By.linkText("Login"));
		login.click();
		return driver;
	}
	public WebDriver registerClick()
	{

		WebElement register = driver.findElement(By.linkText("Register"));
		register.click();
		return driver;
	}
	public void enterValidProduct(String validProductText)
	{
		WebElement searchBox = driver.findElement(By.name("search"));
		searchBox .sendKeys(validProductText);
	}
	public WebDriver clickSearchButton()
	{
		WebElement searchClick = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
		searchClick.click();
		return driver;
	}
	public void enterInvalidProduct(String invalidProductText)
	{
		WebElement searchBox = driver.findElement(By.name("search"));
		searchBox .sendKeys(invalidProductText);
	}
}
