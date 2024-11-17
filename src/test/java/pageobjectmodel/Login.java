package pageobjectmodel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompages.AccountSuccessPage;
import pompages.HomePage;
import pompages.LoginPage;

public class Login {
	
	WebDriver  driver;
	Properties prop;
	LoginPage lpage;
	HomePage hpage;
	AccountSuccessPage accountpage;
	
	
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
		driver=hpage.loginClick();
	    
		
	}
	
	@Test(priority=1)
	public void loginWithValidCredentials()
	{
		
		lpage=new LoginPage(driver);
		
		lpage.enterEmailField(prop.getProperty("email"));
		lpage.enterPasswordField(prop.getProperty("epassword"));
		driver=lpage.clickOnLoginButton();
		
		accountpage=new AccountSuccessPage(driver);
		
		Assert.assertTrue(accountpage.logoutOptionIsDisplayed());
		
	}


@Test(priority=2)
public void loginWithInValidCredentials()
{
	

	lpage=new LoginPage(driver);
	
	lpage.enterEmailField(generateEmailWithTimeStamp());
	lpage.enterPasswordField(prop.getProperty("invalidpassword"));
	lpage.clickOnLoginButton();
	

	
	String expectedText="Warning: No match for E-Mail Address and/or Password.";
	
	
	Assert.assertTrue(lpage.invalidMessage().contains(expectedText));
	
}
@Test(priority=3)
public void loginWithInValidEmailValidPassword()
{
	
    lpage=new LoginPage(driver);
	
	lpage.enterEmailField(generateEmailWithTimeStamp());
	lpage.enterPasswordField(prop.getProperty("invalidpassword"));
	lpage.clickOnLoginButton();
	
		
	String expectedText="Warning: No match for E-Mail Address and/or Password.";
	
	
	Assert.assertTrue(lpage.invalidMessage().contains(expectedText));
	
}
@Test(priority=4)
public void loginWithValidEmailInValidPassword()
{
    lpage=new LoginPage(driver);
	
	lpage.enterEmailField(randomEmail());
	lpage.enterPasswordField(prop.getProperty("invalidpassword"));
	lpage.clickOnLoginButton();
	

	String expectedText="Warning: No match for E-Mail Address and/or Password.";
	
	
	Assert.assertTrue(lpage.invalidMessage().contains(expectedText));
	
}

@Test(priority=5)
public void loginWithOutAnyCredentials()
{
	 lpage=new LoginPage(driver);
	 lpage.clickOnLoginButton();
	 
	
	
	String expectedText="Warning: No match for E-Mail Address and/or Password.";
	
	
	Assert.assertTrue(lpage.invalidMessage().contains(expectedText));
	
}
public String randomEmail()
{
	String[] validEmail= {"amotooricap1@gmail.com","amotooricap2@gmail.com","amotooricap3@gmail.com",
			"amotooricap4@gmail.com","amotooricap5@gmail.com","amotooricap6@gmail.com",
			         "amotooricap7@gmail.com","amotooricap8@gmail.com"};
	

  
	 return validEmail[new Random().nextInt(8)];
}

public String generateEmailWithTimeStamp()
{
	return "shimna"+new Date().toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
}

}
