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
import resouce.base;

public class AdminEmployee extends base {

	
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
	
	//Add Employee data
	
	@Test(dataProvider = "getAddEmployeedata")
	public void employee(String firstname,String lastname,String mobileno, String emergencyNo,String dobyear, String dobmonth, String dobdate, String dojyear, String dojmonth, String dojdate, String Bankname, String BranchName, String IFSCCode, String AccountNo, String AccHolderName, String PanNo, String Salary, String PFNo, String ESINo, String StreetAddr, String city, String zipcode, String state, String country, String Employeemailid, String EmployeePwd, String Employeecode, String empdeptname, String emprole, String emplogintime  ) throws InterruptedException
	{
		Admin_Employee admemp = new Admin_Employee(driver);
		admemp.getEmployee().click();
		log.info("successfully clicked on employee");
		admemp.getAddEmployee().click();
		Thread.sleep(2000);
		log.info("successfully open add employee page");
		//First name
		admemp.getFirstName().sendKeys(firstname);
		//Lastname
		admemp.getLastName().sendKeys(lastname);
		//mobile number
		admemp.getmobileno().sendKeys(mobileno);
		//emergency number
		admemp.getEmergencyNo().sendKeys(emergencyNo);
		//date of birth
		admemp.getdateofbirth().click();
		admemp.getdobMonth().click();
		
		//Date Of Birth calendar 
		while(!admemp.getdobYear().getText().equalsIgnoreCase(dobyear))
		{
			admemp.getdobPrevbutton().click();
		}
		
		int monthcount = admemp.getmonth().size();
		
		for(int i=0;i<monthcount;i++)
		{
			String text = admemp.getmonth().get(i).getText();
			
			if(text.equalsIgnoreCase(dobmonth))
			{
				admemp.getmonth().get(i).click();
				break;
			}
		}

		int datecount =admemp.getDate().size();
		
		for(int i=0;i<datecount;i++)
		{
			String text = admemp.getDate().get(i).getText();
			
			if(text.equalsIgnoreCase(dobdate))
			{
				admemp.getDate().get(i).click();
				break;
			}
		}
		
		//Date of Joining calendar
		admemp.getDOJ().click();
		admemp.getdobMonth().click();
		
		while(!admemp.getdobYear().getText().equalsIgnoreCase(dojyear))
		{
			admemp.getdobPrevbutton().click();
		}
		
		for(int i=0;i<monthcount;i++)
		{
			String text = admemp.getmonth().get(i).getText();
			
			if(text.equalsIgnoreCase(dojmonth))
			{
				admemp.getmonth().get(i).click();
				break;
			}
		}
		
		for(int i=0;i<datecount;i++)
		{
			String text = admemp.getDate().get(i).getText();
			
			if(text.equalsIgnoreCase(dojdate))
			{
				admemp.getDate().get(i).click();
				break;
			}
		}
	
		//Employee Bank Details
		admemp.getBankName().click();
		admemp.getBankName().sendKeys(Bankname);
		admemp.getBranchName().click();
		admemp.getBranchName().sendKeys(BranchName);
		admemp.getIFSCcode().click();
		admemp.getIFSCcode().sendKeys(IFSCCode);
		admemp.getAccountNo().click();
		admemp.getAccountNo().sendKeys(AccountNo);
		admemp.getACHolderName().click();
		admemp.getACHolderName().sendKeys(AccHolderName);
		admemp.getPanNo().click();
		admemp.getPanNo().sendKeys(PanNo);
		admemp.getSalary().click();
		admemp.getSalary().sendKeys(Salary);
		admemp.getPFNo().click();
		admemp.getPFNo().sendKeys(PFNo);
		admemp.getESINo().click();
		admemp.getESINo().sendKeys(ESINo);
		
		//Address Details
		admemp.getstreetAddr().click();
		admemp.getstreetAddr().sendKeys(StreetAddr);
		admemp.getCity().click();
		admemp.getCity().sendKeys(city);
		admemp.getZipCode().click();
		admemp.getZipCode().sendKeys(zipcode);
		admemp.getState().click();
		admemp.getState().sendKeys(state);
		admemp.getCountry().click();
		
		
		int countrycount = admemp.getCountryName().size();
		
		for(int i=0;i<countrycount;i++)
		{
			String text = admemp.getCountryName().get(i).getText();
			if(text.equalsIgnoreCase(country))
			{
				admemp.getCountryName().get(i).click();
				break;
			}
		}
		
		admemp.getpermanentaddr().click();
		
		admemp.getLoginDetails().click();
		admemp.getLoginDetails().sendKeys(Employeemailid);
		admemp.getupdatepwd().click();
		admemp.getupdatepwd().sendKeys(EmployeePwd);
		admemp.getempcode().click();
		admemp.getempcode().sendKeys(Employeecode);
		admemp.getdept().click();
		
		int deptcount = admemp.getdeptName().size();
		
		for(int i=0;i<deptcount;i++)
		{
			String text = admemp.getdeptName().get(i).getText();
			if(text.equalsIgnoreCase(empdeptname))
			{
				admemp.getdeptName().get(i).click();
				break;
			}
		}
		
		admemp.getRole().click();
		
		int Role = admemp.getRoleName().size();
		
		for(int i=0;i<Role;i++)
		{
			String text = admemp.getRoleName().get(i).getText();
			if(text.equalsIgnoreCase(emprole))
			{
				admemp.getRoleName().get(i).click();
				break;
			}
		}
		
		admemp.getLoginTime().click();
		admemp.getLoginTime().sendKeys(emplogintime);
		admemp.getLoginTime().sendKeys(Keys.ARROW_UP);
		
		admemp.getRegister().click();
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
	
	@DataProvider
	public Object[][] getAddEmployeedata()
	
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
