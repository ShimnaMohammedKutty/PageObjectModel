package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	

	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	    
    public String getFirstNameWarningMessage()
    {
    	WebElement firstNameWarningMessage= driver.findElement(By.xpath("//*[@id='input-firstname']/following-sibling::div"));
    	return firstNameWarningMessage.getText();
    }
	
    public String getlastNameWarningMessage()
    {
    	WebElement lastNameWarningMessage=driver.findElement(By.xpath("//*[@id='input-lastname']/following-sibling::div"));
    	return lastNameWarningMessage.getText();
    }
	
    public String getEmailWarningMessage()
    {
    	WebElement emailWarningMessage=driver.findElement(By.xpath("//*[@id='input-email']/following-sibling::div"));
    	return  emailWarningMessage.getText();
    }
	
    public String getPhoneWarningMessage()
    {
    	  WebElement phoneWarningMessage=driver.findElement(By.xpath("//*[@id='input-telephone']/following-sibling::div"));
    	return phoneWarningMessage.getText();
    }
	
    public String getPasswordWarningMessage()
    {
    	WebElement passwordWarningMessage=driver.findElement(By.xpath("//*[@id='input-password']/following-sibling::div"));	
    	return passwordWarningMessage.getText();
    }
    public String getPrivacyWarningMessage()
    {
    	WebElement privacyWarningMessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
    	return privacyWarningMessage.getText();
    }
	
	
    
	public void enterFirstName(String firstNameData)
	{
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys(firstNameData);
	}
	public void enterLastName(String lastNameData)
	{
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys(lastNameData);
	}
	public void enterEmailFeld(String email)
	{
		WebElement emailField = driver.findElement(By.id("input-email"));
		emailField.sendKeys(email);
	}
	public void enterPhoneFeld(String telephone)
	{
		WebElement phone = driver.findElement(By.id("input-telephone"));
		 phone.sendKeys("telephone");
	}
	public void enterPassword(String password)
	{
		WebElement passwordField = driver.findElement(By.id("input-password"));	
		
		passwordField.sendKeys(password);
	}
	public void enterConfirmPassword(String confirmPassword)
	{
		WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
		confirmPasswordField .sendKeys(confirmPassword);
	}
	public void clickPrivacyPolicy()
	{
		WebElement privacyPolicy = driver.findElement(By.name("agree"));
		privacyPolicy .click();
	}
	public void clickContinue()
	{
		WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
		 continueButton.click();
	}
	public void newsLetterOption()
	{
		WebElement newsLetter = driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']"));
	
		newsLetter.click();
	}
	
	
	
}
