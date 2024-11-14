package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterEmailField(String email)
	{
	WebElement emailEnter = driver.findElement(By.id("input-email"));
	emailEnter.sendKeys(email);
	
	}
	
	public void enterPasswordField(String password)
	{
	WebElement passwordEnter = driver.findElement(By.id("input-password"));
	passwordEnter.sendKeys(password);
	}
	
	public WebDriver clickOnLoginButton()
	{
		WebElement loginclick = driver.findElement(By.xpath("//input[@value='Login']"));
		loginclick.click();
		return driver;
		
	}
	public String invalidCredentialMessage()
	{
		WebElement expected=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		return expected.getText();
	}
	public String invalidEmailMessage()
	{
		WebElement emailMessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		return emailMessage.getText();
	}
	public String invalidPasswordMessage()
	{
		WebElement passwordMessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		return passwordMessage.getText();
	}
	public String withoutCredentialsMessage()
	{
		WebElement withoutEmailPassword=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		 return withoutEmailPassword.getText();
	}

}
