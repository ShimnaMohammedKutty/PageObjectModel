package pageobjectmodel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
import pompages.SearchPage;

public class Search {
	
WebDriver  driver;
Properties prop;
HomePage hpage;
SearchPage spage;
	
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
	
	}
	
	@Test(priority=1)
	public void verifySearchForExistingProduct()
	{
		hpage=new HomePage(driver);
		hpage.enterProduct(prop.getProperty("validproduct"));
		driver=hpage.clickSearchButton();
		
		spage=new SearchPage(driver);
	    Assert.assertTrue(spage.validProductIsDisplayed());
	}
	
	
	@Test(priority=2)
	public void verifySearchForNonExistingProduct()
	{
		hpage=new HomePage(driver);
		hpage.enterProduct(prop.getProperty("invalidproduct"));
		driver=hpage.clickSearchButton();
		
		spage=new SearchPage(driver); 
		 
		 String expected="There is no product that matches the search criteria.";
		
		 Assert.assertEquals(spage.invalidProductMessage(), expected);
	}
	
	@Test(priority=3)
	public void verifySearchWithOutProduct()
	{
		
		hpage=new HomePage(driver);
		driver=hpage.clickSearchButton();
		
				 
		spage=new SearchPage(driver); 
		 
		 String expected="There is no product that matches the search criteria.";
		
		 Assert.assertEquals(spage.invalidProductMessage(), expected);
	}
}
