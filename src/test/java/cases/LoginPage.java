package cases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPageAttributes;
import resouce.base;

public class LoginPage extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void driverrun() throws IOException
	{
		driver = initializedriver();
		log.info("This is Login page testing");
		log.info("driver installed successfully");
			
	}


	@Test
	public void BaseNavigation() throws IOException, InterruptedException
	{	
		
		driver.get(prop.getProperty("url"));
		LoginPageAttributes mhp = new LoginPageAttributes(driver);
		mhp.getloginbutton().click();
		log.info("Home login button is working");
	}
	
	@Test
	public void title()
	{
		LoginPageAttributes mhp = new LoginPageAttributes(driver);
		Assert.assertTrue(mhp.getTitle().getText().equals("Login"));
		log.info("login title is correct");
		
	}
	@Test(dataProvider = "getdata")
	public void Emailtextblock(String username, String password)
	{
		LoginPageAttributes mhp = new LoginPageAttributes(driver);
		mhp.getEmailID().clear();
		mhp.getEmailID().sendKeys(username);
		mhp.getPassword().clear();
		mhp.getPassword().sendKeys(password);
		mhp.getLoginclick().click();
		
		log.info("Username, password and login button are working");
		
	}
	

	
	@Test
	public void forgetpassword()
	{
		LoginPageAttributes mhp = new LoginPageAttributes(driver);
		mhp.getforgetpass().click();
		driver.navigate().back();
		log.info("forget password link is working");
	}
	
	@Test
	public void NeedAccount()
	{
		LoginPageAttributes mhp = new LoginPageAttributes(driver);
		mhp.getNeedAccount().click();
		driver.navigate().back();
		log.info("Need Account link is working");
		
	}
	
	@AfterTest
	
	public void closingTestcase() throws InterruptedException
	{
		driver.close();
		driver=null;
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data = new Object[2][2];
		
		data[0][0] = "hdhahjf@gmail.com";
		data[0][1] = "5435435";
		
		data[1][0] = "djhbdjz@gmail.com";
		data[1][1] ="sdbjlkd";
		
		return data;
	}
	
	
}
