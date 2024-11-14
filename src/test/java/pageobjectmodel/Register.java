package pageobjectmodel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompages.HomePage;
import pompages.RegisterPage;

public class Register {
	
	WebDriver  driver;
	Properties prop;
	HomePage hpage;
	RegisterPage rpage;
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@BeforeMethod
	public void setup()
	{

		
		try
		{
		 prop=new Properties();
		 File propFile=new File(System.getProperty("user.dir")+"\\src\\test\\java\\pageobjectmodel\\data.properties");
		 FileReader fr=new FileReader(propFile);
		 prop.load(fr);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		hpage=new HomePage(driver);
		hpage.clickMyAccount();
		driver=hpage.registerClick();
		
		
	}
	
	@Test(priority=1)
	public void registerWithMandatoryyField() throws InterruptedException
	{
		
		
		rpage=new RegisterPage(driver);
		
		rpage.enterFirstName(prop.getProperty("firstname"));
		rpage.enterLastName(prop.getProperty("lastname"));
		rpage.enterEmailFeld(generateEmailWithTimeStamp());
		rpage.enterPhoneFeld(prop.getProperty("telephone"));
		rpage.enterPassword(prop.getProperty("password"));
		rpage.enterConfirmPassword(prop.getProperty("password"));
		rpage.clickPrivacyPolicy();
		rpage.clickContinue();
			Thread.sleep(5000);
		
		String expectedTitle = "Your Account Has Been Created!";
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test(priority=2)
	public void registerWithAllFields()
	{
        rpage=new RegisterPage(driver);
		
		rpage.enterFirstName(prop.getProperty("firstname"));
		rpage.enterLastName(prop.getProperty("lastname"));
		rpage.enterEmailFeld(generateEmailWithTimeStamp());
		rpage.enterPhoneFeld(prop.getProperty("telephone"));
		rpage.enterPassword(prop.getProperty("password"));
		rpage.enterConfirmPassword(prop.getProperty("password"));
		rpage.newsLetterOption();
		rpage.clickPrivacyPolicy();
		rpage.clickContinue();
		
		
		String expectedTitle = "Your Account Has Been Created!";
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=3)
	public void registerWithoutFieldsDisplayMessages()
	{
		 rpage=new RegisterPage(driver);
		 rpage.clickContinue();
		
		String firstNameMessage="First Name must be between 1 and 32 characters!";
		String lastNameMessage="Last Name must be between 1 and 32 characters!";
		String emailMessage="E-Mail Address does not appear to be valid!";
		String phoneMessage="Telephone must be between 3 and 32 characters!";
		String passwordMessagge="Password must be between 4 and 20 characters!";
		String privacyPolicyMessage="Warning: You must agree to the Privacy Policy!";
		
	
		Assert.assertEquals(rpage.getFirstNameWarningMessage(),firstNameMessage);
		Assert.assertEquals(rpage.getlastNameWarningMessage(),lastNameMessage);
		Assert.assertEquals(rpage.getEmailWarningMessage(),emailMessage);
		Assert.assertEquals(rpage.getPhoneWarningMessage(),phoneMessage);
		Assert.assertEquals(rpage.getPasswordWarningMessage(),passwordMessagge);
		Assert.assertTrue(rpage.getPrivacyWarningMessage().contains(privacyPolicyMessage));
		
		
		
		
	}
	
	public String generateEmailWithTimeStamp()
	{
		return "shimna"+new Date().toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}


}
