package cases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Admin_Employee;
import pageObject.Employee_listAttributes;
import resouce.base;

public class Employee_List extends base{
public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void driverrun() throws IOException
	{
		driver = initializedriver();
		log.info("Admin Employee Page Testing");
		log.info("Browser initialized successfully");
	}
	
	@Test
	public void BaseNavigation() throws IOException, InterruptedException
	{	
		
		driver.get(prop.getProperty("url"));	
		Admin_Employee admemp = new Admin_Employee(driver);
		admemp.getloginbutton().click();
		log.info("succesfully open the login page");
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
		
		log.info("Admin succesfully logged in");
	}
	
	//view icon check
	@Test
	public void Employeepage()
	{
		Employee_listAttributes ela = new Employee_listAttributes(driver);
		ela.getEmployee().click();
		ela.getEmpList().click();
		ela.getViewIcon().click();
		driver.navigate().back();
	}
	
	//Search Check
	@Test(dataProvider = "search")
	public void searchbox(String Name) throws InterruptedException
	{
		Employee_listAttributes ela = new Employee_listAttributes(driver);
		ela.getEmployee().click();
		ela.getEmpList().click();
		ela.getsearchbox().click();
		ela.getsearchbox().sendKeys(Name);
		Thread.sleep(5000);
	}
	
	
		//Update employee data
		@Test(dataProvider = "getUpdateEmployeedata")
		public void employee(String firstname,String lastname,String mobileno, String emergencyNo,String dobyear, String dobmonth, String dobdate, String dojyear, String dojmonth, String dojdate, String Bankname, String BranchName, String IFSCCode, String AccountNo, String AccHolderName, String PanNo, String Salary, String PFNo, String ESINo, String StreetAddr, String city, String zipcode, String state, String country, String Employeemailid, String EmployeePwd, String Employeecode, String empdeptname, String emprole, String emplogintime) throws InterruptedException
		{
			Employee_listAttributes ela = new Employee_listAttributes(driver);
			ela.getEmployee().click();
			ela.getEmpList().click();
			
			ela.getShowlist().click();
			int show = ela.getShow().size();
			for(int i=0;i<show;i++)
			{
				String nmbemp = ela.getShow().get(i).getAttribute("value");
				
				if(nmbemp.equals("25"))
				{
					ela.getShow().get(i).click();
					break;
				}
				
			}
			
			int nmbofemp = ela.getEmployeeList().size();
			System.out.println(nmbofemp);
			for(int i=0;i<nmbofemp;i++)
			{
				ela.getEmployeeList().get(i).getText();
				
			}
			
			ela.getEditIcon().click();
			
			//First name
			ela.getFirstName().clear();
			ela.getFirstName().sendKeys(firstname);
			//Lastname
			ela.getLastName().clear();
			ela.getLastName().sendKeys(lastname);
			//mobile number
			ela.getmobileno().clear();
			ela.getmobileno().sendKeys(mobileno);
			//emergency number
			ela.getEmergencyNo().clear();
			ela.getEmergencyNo().sendKeys(emergencyNo);
			//date of birth
			ela.getdateofbirth().click();
			ela.getdobMonth().click();
			
			//Date Of Birth calendar 
			while(!ela.getdobYear().getText().equalsIgnoreCase(dobyear))
			{
				ela.getdobPrevbutton().click();
			}
			
			int monthcount = ela.getmonth().size();
			
			for(int i=0;i<monthcount;i++)
			{
				String text = ela.getmonth().get(i).getText();
				
				if(text.equalsIgnoreCase(dobmonth))
				{
					ela.getmonth().get(i).click();
					break;
				}
			}

			int datecount =ela.getDate().size();
			
			for(int i=0;i<datecount;i++)
			{
				String text = ela.getDate().get(i).getText();
				
				if(text.equalsIgnoreCase(dobdate))
				{
					ela.getDate().get(i).click();
					break;
				}
			}
			
			//Date of Joining calendar
			ela.getDOJ().click();
			ela.getdobMonth().click();
			
			while(!ela.getdobYear().getText().equalsIgnoreCase(dojyear))
			{
				ela.getdobPrevbutton().click();
			}
			
			for(int i=0;i<monthcount;i++)
			{
				String text = ela.getmonth().get(i).getText();
				
				if(text.equalsIgnoreCase(dojmonth))
				{
					ela.getmonth().get(i).click();
					break;
				}
			}
			
			for(int i=0;i<datecount;i++)
			{
				String text = ela.getDate().get(i).getText();
				
				if(text.equalsIgnoreCase(dojdate))
				{
					ela.getDate().get(i).click();
					break;
				}
			}
			
			//Employee Bank Details
			ela.getBankName().click();
			ela.getBankName().clear();
			ela.getBankName().sendKeys(Bankname);
			ela.getBranchName().click();
			ela.getBranchName().clear();
			ela.getBranchName().sendKeys(BranchName);
			ela.getIFSCcode().click();
			ela.getIFSCcode().clear();
			ela.getIFSCcode().sendKeys(IFSCCode);
			ela.getAccountNo().click();
			ela.getAccountNo().clear();
			ela.getAccountNo().sendKeys(AccountNo);
			ela.getACHolderName().click();
			ela.getACHolderName().clear();
			ela.getACHolderName().sendKeys(AccHolderName);
			ela.getPanNo().click();
			ela.getPanNo().clear();
			ela.getPanNo().sendKeys(PanNo);
			ela.getSalary().click();
			ela.getSalary().clear();
			ela.getSalary().sendKeys(Salary);
			ela.getPFNo().click();
			ela.getPFNo().clear();
			ela.getPFNo().sendKeys(PFNo);
			ela.getESINo().click();
			ela.getESINo().clear();
			ela.getESINo().sendKeys(ESINo);
			
			//Address Details
			ela.getstreetAddr().click();
			ela.getstreetAddr().clear();
			ela.getstreetAddr().sendKeys(StreetAddr);
			ela.getCity().click();
			ela.getCity().clear();
			ela.getCity().sendKeys(city);
			ela.getZipCode().click();
			ela.getZipCode().clear();
			ela.getZipCode().sendKeys(zipcode);
			ela.getState().click();
			ela.getState().clear();
			ela.getState().sendKeys(state);
			ela.getCountry().click();
			
			
			int countrycount = ela.getCountryName().size();
			
			for(int i=0;i<countrycount;i++)
			{
				String text = ela.getCountryName().get(i).getText();
				if(text.equalsIgnoreCase(country))
				{
					ela.getCountryName().get(i).click();
					break;
				}
			}
			
			ela.getpermanentaddr().click();
			
			ela.getLoginDetails().click();
			ela.getLoginDetails().clear();
			ela.getLoginDetails().sendKeys(Employeemailid);
			ela.getupdatepwd().click();
			ela.getupdatepwd().clear();
			ela.getupdatepwd().sendKeys(EmployeePwd);
			ela.getempcode().click();
			ela.getempcode().sendKeys(Employeecode);
			ela.getRole().click();
			
			int Role = ela.getRoleName().size();
			for(int i=0;i<Role;i++)
			{
				String text = ela.getRoleName().get(i).getText();
				if(text.equalsIgnoreCase(emprole))
				{
					ela.getRoleName().get(i).click();
					break;
				}
			}
			
			int Department = ela.getchoosendept().size();
		
			
			for(int i=0; i<Department;i++)
			{
				String text = ela.getchoosendept().get(i).getAttribute("deptname");
				System.out.println(text);
				if(text.equalsIgnoreCase("SQL developer"))
				{
					ela.getchoosendept().get(i).click();
					break;
				}
			}
			ela.getLoginTime().click();
			ela.getLoginTime().sendKeys(emplogintime);
			ela.getLoginTime().sendKeys(Keys.ARROW_UP);
			
			ela.getupdate().click();
			ela.getDeletebutton().click();
		}
		
		//page change
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
	
		@AfterTest
		public void closingTest()
		{
			driver.close();
			driver = null; 
		}
		
	@DataProvider//login page
	public Object[][] getdata()
	{
		Object[][] data = new Object[1][2];
		
		String Admin_EmailID = prop.getProperty("Admin_EmailID");
		data[0][0] = Admin_EmailID;
		String Admin_Password = prop.getProperty("Admin_Password");
		data[0][1] = Admin_Password;

		return data;
		
	}
	
	//search
	@DataProvider 
	public Object[][] search()
	{
		Object[][] data = new Object[1][1];
		data[0][0] = "ragini bisht";
		
		return data;
	}
	//update employee data
	@DataProvider
	public Object[][] getUpdateEmployeedata()
	
	{
		Object[][] data = new Object[1][30];
		// first name
		data[0][0] = "prachi";
		//last name
		data[0][1] = "tamata";
		//mobile number
		data[0][2] = (String)"1234567890";
		//Emergency number
		data[0][3] = (String)"1234567890";
		//DOB Year
		data[0][4] = (String)"1985";
		//DOB Month
		data[0][5] = "mar";
		//DOB Date
		data[0][6] = (String)"1";
		//DOJ Year
		data[0][7] = (String)"2015";
		//DOJ Month
		data[0][8] = "jan";
		//DOJ Date
		data[0][9] = (String)"25";
		//Bank Name
		data[0][10] = "PNB";
		//Branch Name
		data[0][11] = "Noida";
		//IFSC Code
		data[0][12] = (String)"213245";
		//Account Number
		data[0][13] = (String)"1234567890";
		//Account Holder Number
		data[0][14] = "Prachi Tamta";
		//Pan Number
		data[0][15] = (String)"16546654";
		//Salary
		data[0][16] = (String)"5000";
		//PF number
		data[0][17] = (String)"513551";
		//ESI number
		data[0][18] = (String)"646eaf64";
		//Street Address
		data[0][19] = (String)"sector 21";
		//City
		data[0][20] = "Noida";
		//zipcode
		data[0][21] = (String)"213546";
		//state
		data[0][22] = (String)"Uttar Pradesh";
		//country
		data[0][23] = (String)"India";
		//Employee Mail id
		data[0][24] = (String)"prcahitamta@gmail.com";
		//Employee password
		data[0][25] = (String)"123456";
		//Employee Code
		data[0][26] = (String)"106";
		//Employee department Name
		data[0][27] = "Testing department";
		//Employee Role
		data[0][28] = "employee";
		//Employee login time
		data[0][29] = (String)"1000";
		return data;
	}
}
