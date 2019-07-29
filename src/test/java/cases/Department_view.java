package cases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Admin_Employee;
import pageObject.Department_view_attr;
import resouce.base;

public class Department_view extends base{

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
	
	@Test(dataProvider="getdept")
	public void deptView(String Department_Name) throws InterruptedException
	{
		Department_view_attr dv = new Department_view_attr(driver);
		dv.getdept().click();
		dv.getdept_list().click();
		int nodept = dv.getdeptName().size();
		for(int i=1;i<=nodept;i++)
		{
			if(dv.getdeptName().get(i).getText().equals(Department_Name))
			{
				++i;
				String path = "//table[@id='datatables']//tr["+i+"]//a[1]";
				driver.findElement(By.xpath(path)).click();
				Assert.assertEquals(dv.getDeptNameView().getAttribute("value"), Department_Name);
				break;
			}
		}
		
		dv.getEdit().click();
		for(int i=1; i<nodept; i++)
		{
			Assert.assertEquals(dv.getDeptNameView().getAttribute("value"), Department_Name);
		}
		
		dv.getUpdateButton().click();
		Thread.sleep(2000);
		
		//Assert.assertSame(dv.getpopup().getText(), popup);
		
	}
	
	@Test(dataProvider="getupdatedept")
	public void addEmpinDept(String departmentupdate, String Employee_Name, String reaction, String popup) throws InterruptedException
	{
		Department_view_attr dv = new Department_view_attr(driver);
		dv.getdept().click();
		dv.getdept_list().click();
		int nodept = dv.getdeptName().size();
		for(int i=0;i<nodept;i++)
		{	
			if(dv.getdeptName().get(i).getText().equals(departmentupdate))
			{
				++i;
				String path = "//table[@id='datatables'] //tr["+i+"] //a[2]";
				driver.findElement(By.xpath(path)).click();
				//Assert.assertEquals(dv.getDeptNameView().getAttribute("value"), departmentupdate);
				break;
			}
		}
		
		dv.getSelectall().click();
		Thread.sleep(5000);
		
		dv.getSelectall().click();
		Thread.sleep(5000);
		
		int numdept = dv.getdeptName().size();
		for(int i=0;i<numdept;i++)
		{
			System.out.println(i);
			System.out.println(dv.getdeptName().get(i).getText());
			if(dv.getdeptName().get(i).getText().equalsIgnoreCase(Employee_Name))
			{
				++i;
				String path = "//table[@id='datatables'] //tr["+i+"]//td[1]//input";
				Thread.sleep(2000);
				driver.findElement(By.xpath(path)).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		dv.getSelect().click();
		int count1 = dv.getselectOption().size();
		System.out.println(count1);
		for(int i=0; i<count1;i++)
		{
			System.out.println(i);
			System.out.println(dv.getselectOption().get(i).getText());
			if(dv.getselectOption().get(i).getText().equalsIgnoreCase(reaction))
			{
				dv.getselectOption().get(i).click();
				break;
			}
		}
		
		if(popup.equalsIgnoreCase("confirm"))
		{
			dv.getyes().click();
		}
		else
		{
			dv.getNo().click();
		}
		
		Thread.sleep(5000);
		dv.getUpdateButton().click();
		
	}
	
	@Test(dataProvider = "getDeptdel")
	public void deletedept(String popupresult) throws InterruptedException
	{
		Department_view_attr dv = new Department_view_attr(driver);
		dv.getdept().click();
		dv.getdept_list().click();
		int nodept = dv.getdeptName().size();
		for(int i=0;i<nodept;i++)
		{	
			if(dv.getdeptName().get(i).getText().equals("SQL developer"))
			{
				++i;
				String path = "//table[@id='datatables'] //tr["+i+"] //a[3]";
				driver.findElement(By.xpath(path)).click();
				//Assert.assertEquals(dv.getDeptNameView().getAttribute("value"), departmentupdate);
				break;
			}
		}
		
		if(popupresult.equalsIgnoreCase("confirm"))
		{
			dv.getDelyes().click();
		}
		else
		{
			dv.getDelno().click();
		}
		
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void closingTest()
	{
		driver.close();
		driver = null; 
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
	
	@DataProvider
	public Object[][] getdept()
	{
		Object[][] data = new Object[1][1];
		
		data[0][0] = "testing department";
		//data[0][1] = "  
			//	Department updated successfully ";
		
		return data;
	}
	
	@DataProvider
	public Object[][] getupdatedept()
	{
		Object[][] data = new Object[1][4];
		data[0][0] = "SQL developer";
		data[0][1] = "aum joshi";
 		data[0][2] = "remove";// add or remove employee
 		data[0][3] = "confirm";// confirm or reject employee
		return data;
	}
	
	@DataProvider
	public Object[][] getDeptdel()
	{
		Object[][] data = new Object[1][1];
		data[0][0] = "no";
		return data;
	}
	
}
