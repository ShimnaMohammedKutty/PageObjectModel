package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public boolean validProductIsDisplayed()
	{
		WebElement existingProduct=driver.findElement(By.linkText("HP LP3065"));
		return existingProduct.isDisplayed();
	}
	public String invalidProductMessage()
	{
		WebElement product=driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p"));
	    return product.getText();
	
	}

}
