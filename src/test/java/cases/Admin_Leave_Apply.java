package cases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Admin_Employee;
import pageObject.LeaveApply_Attr;
import resouce.base;

public class Admin_Leave_Apply extends base {

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
	
	
	@Test
	public void leaveApply()
	{
		LeaveApply_Attr laa = new LeaveApply_Attr(driver);
		laa.leaveSection().click();
		laa.getapplyleave().click();
		laa.getLeaveType().click();
		int option = laa.getLeaveOption().size();
		for(int i=0;i<option;i++)
		{
			if(laa.getLeaveOption().get(i).getText().equalsIgnoreCase("full day"))
			{
				laa.getLeaveOption().get(i).click();
			}
		}
		
		laa.getLeaveFrom().click();
		
		laa.getleaveYear().click();
		
		while(!laa.getYear().getText().contains("2019"))
		{
			laa.getNextyear().click();
		}
		 int countmonth = laa.getleavemonth().size();
		 for(int i=0;i<countmonth;i++)
		 {
			if(laa.getleavemonth().get(i).getText().equalsIgnoreCase("Dec"))
			{
				laa.getleavemonth().get(i).click();
				break;
			}
		 }
		 int countDay = laa.getDay().size();
		 for(int i=0;i<countDay;i++)
		 {
			 if(laa.getDay().get(i).getText().equalsIgnoreCase("7"))
			 {
				 laa.getDay().get(i).click();
				 break;
			 }
		 }
		 
		 laa.getlastdate().click();
		 
		 laa.getleaveYear().click();
			
			while(!laa.getYear().getText().contains("2019"))
			{
				laa.getNextyear().click();
			}
			 int month = laa.getleavemonth().size();
			 for(int i=0;i<month;i++)
			 {
				if(laa.getleavemonth().get(i).getText().equalsIgnoreCase("Dec"))
				{
					laa.getleavemonth().get(i).click();
					break;
				}
			 }
			 int Day = laa.getDay().size();
			 for(int i=0;i<Day;i++)
			 {
				 if(laa.getDay().get(i).getText().equalsIgnoreCase("14"))
				 {
					 laa.getDay().get(i).click();
					 break;
				 }
			 }
			 
			 laa.getreason().click();
			 laa.getreason().sendKeys("leave");
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
}
