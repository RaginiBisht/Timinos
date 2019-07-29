package cases;

import java.io.IOException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.Mainhomepage;
import resouce.base;

public class HomePage extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void driverrun() throws IOException
	{
		driver = initializedriver();
		log.info("Home page testing");
		log.info("browser is initialized");
	}
	
	@Test
	
	public void BaseNavigation() throws IOException, InterruptedException
	{	
	
		driver.get(prop.getProperty("url"));
		Mainhomepage mhp = new Mainhomepage(driver);
		mhp.getloginbutton().click();
		log.info("login page is connecting");
		
		
	}
	
	@Test
	public void RegistrationGetEMS() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		Mainhomepage mhp = new Mainhomepage(driver);
		mhp.getEMSbutton().click();
		log.info("Registration Page is opening");
	
	}
	
	@Test
	public void NavbarHome() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		Mainhomepage mhp = new Mainhomepage(driver);
		mhp.getHome().click();	
		log.info("home button is working");
	}
	
	@Test
	
	public void NavbarWhyUs()
	{
		driver.get(prop.getProperty("url"));
		Mainhomepage mhp = new Mainhomepage(driver);
		mhp.getWhyUs().click();
		log.info("Why us button is working");
	}

	@Test
	public void NavbarPricing()
	{
		driver.get(prop.getProperty("url"));
		Mainhomepage mhp = new Mainhomepage(driver);
		mhp.getpricing().click();
		log.info("Pricing button is working");
		
	}
	
	@Test
	public void NavbarReqDemo()
	{
		driver.get(prop.getProperty("url"));
		Mainhomepage mhp = new Mainhomepage(driver);
		mhp.getreqdemo().click();
		log.info("request demo");
	}
	
	@Test
	public void loginlink()
	{
		driver.get(prop.getProperty("url"));
		Mainhomepage mhp = new Mainhomepage(driver);
		mhp.getloginlink().click();
		log.info("login link is working");
	}
	
	@Test
	public void EMSButton()
	{
		driver.get(prop.getProperty("url"));
		Mainhomepage mhp = new Mainhomepage(driver);
		mhp.getEmsButton().click();
		log.info("EMS buttons are working");
	}
	
	@Test
	public void Facebook() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		String parentwindow = driver.getWindowHandle();
		Mainhomepage mhp = new Mainhomepage(driver);
		mhp.getFb().click();
		Set<String> winHandles = driver.getWindowHandles();
		for(String handle: winHandles){
		if(!handle.equals(parentwindow)){
            driver.switchTo().window(handle);
            Thread.sleep(2000);
            driver.close();
		}
			driver.switchTo().window(parentwindow);
		}
		
		
	}
	
	@Test
	public void Twitter() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		String parentwindow = driver.getWindowHandle();
		Mainhomepage mhp = new Mainhomepage(driver);
		mhp.gettwitter().click();
		
		Set<String> winHandles = driver.getWindowHandles();
		for(String handle: winHandles){
		if(!handle.equals(parentwindow)){
            driver.switchTo().window(handle);
            Thread.sleep(2000);
            driver.close();
		}
			driver.switchTo().window(parentwindow);
		}
	}
	
	@AfterTest
	
	public void closingTestcase() throws InterruptedException
	{
		driver.close();
		driver=null;
	}
	
	

}
