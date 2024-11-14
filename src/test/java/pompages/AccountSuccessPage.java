package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSuccessPage {
	
	WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean logoutOptionIsDisplayed()
	{
       WebElement displayLogout=driver.findElement(By.linkText("Logout"));
       return displayLogout.isDisplayed();
	}

}
