package cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Admin_Employee;
import pageObject.Employee_listAttributes;
import resouce.base;

public class Tryclass extends base{
	
	@BeforeTest
	public void driverrun() throws IOException
	{
		driver = initializedriver();
	}
	
	@Test
	public void BaseNavigation() throws IOException, InterruptedException
	{	
		
		driver.get(prop.getProperty("url"));	
		Admin_Employee admemp = new Admin_Employee(driver);
		admemp.getloginbutton().click();
		
	}

	@Test(dataProvider = "getdata" )
	public void Emailtextblock(String username, String password)
	{
		Admin_Employee admemp = new Admin_Employee(driver);
		admemp.getEmailID().clear();
		admemp.getEmailID().sendKeys(username);
		admemp.getPassword().clear();
		admemp.getPassword().sendKeys(password);
		admemp.getLoginclick().click();
	}
	

	@Test
	public void Employeepage()
	{
		Employee_listAttributes ela = new Employee_listAttributes(driver);
		ela.getEmployee().click();
		ela.getEmpList().click();
	
	}
	
	@Test
	public void emp_page() throws InterruptedException
	{
		Employee_listAttributes ela = new Employee_listAttributes(driver);
		int range = ela.getrange().size();
		for(int i=0; i<range;i++)
		{
			ela.getNext().click();
			Thread.sleep(5000);
		}
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data = new Object[1][2];
		
		data[0][0] = "2211ragini@gmail.com";
		data[0][1] = "123456";

		return data;
		
	}

}
