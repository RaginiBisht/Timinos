package cases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Admin_Employee;
import pageObject.Department_add_attribute;
import resouce.base;

public class Department_add extends base {

	@BeforeTest
	public void driverrun() throws IOException
	{
		driver= initializedriver();
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
	
	@Test(dataProvider="getdeptinfm")
	public void add_department(String Department_Code, String Department_Name, String DepartmentDescription, String ManagerName) throws InterruptedException
	{
		Department_add_attribute daa = new Department_add_attribute(driver);
		daa.dept().click();
		Thread.sleep(2000);
		daa.adddept().click();
		daa.deptCode().click();
		daa.deptCode().sendKeys(Department_Code);
		daa.deptName().sendKeys(Department_Name);
		daa.deptDescription().sendKeys(DepartmentDescription);
		daa.deptManger().click();
		int numofemp = daa.deptManagerName().size();
		for(int i=0; i<numofemp;i++ )
		{
			if(daa.deptManagerName().get(i).getText().equalsIgnoreCase(ManagerName))
			{
				daa.deptManagerName().get(i).click();
			}
		}
		
		daa.AddDeptbutton().click();
		
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
		Object[][] data = new Object[1][2];
		String Admin_EmailID = prop.getProperty("Admin_EmailID");
		data[0][0] = Admin_EmailID;
		String Admin_Password = prop.getProperty("Admin_Password");
		data[0][1] = Admin_Password;
		return data;
		
	}
	
	//new department information
	@DataProvider
	public Object[][] getdeptinfm()
	{
		Object[][] data = new Object[1][4];
		
		data[0][0] = "1234"; //Department Code
		data[0][1] = "php dept."; //Department Name
		data[0][2] = "Web Implementation"; //Department Description
		data[0][3] = "rahul shahi"; //Department Manager Name
		
		return data;
	}
	
}
