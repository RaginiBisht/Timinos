package pageObject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Admin_Employee {

	public WebDriver driver;
	
	By login = By.className("sign-in-btn");
	By email =  By.id("email");
	By pwd = By.id("password");
	By lgbutton = By.xpath("//button[@class='btn btn-primary']");
	By employee = By.xpath("//ul[@class='nav'] //li[4]//a//span[3] ");
	By addEmp = By.xpath("//a[@href='/home/employee/add'] //span");
	//Employee data filling path
	By firstname = By.name("first_name");
	By lastname = By.name("last_name");
	By mobileno = By.name("mobile_no");
	By emergencyno = By.name("emergency_no");
	
	//Employee dob filling
	By dob = By.id("datePicker1");
	By dobMonth = By.cssSelector("div[class = 'datepicker-days'] th[class='datepicker-switch']");
	By dobYear =By.cssSelector("div[class='datepicker-months'] th[class='datepicker-switch']");
	By dobPrevYear = By.cssSelector("div[class='datepicker-months'] th[class='prev']");
	By dobmonthlist = By.cssSelector("div[class='datepicker-months'] span[class='month']");
	By dobdatelist = By.cssSelector("div[class='datepicker-days'] td[class='day']");
	
	//Employee doj 
	By doj = By.id("datePicker2");
	
	// Employee bank details
	By BankName = By.name("bank_name");
	By BankBranch = By.name("branch_name");
	By IFSCcode = By.name("IFSC_code");
	By Accountno = By.name("account_no");
	By ACHolderName = By.name("ac_holder_name");
	By PanCardNo = By.name("pan_card_no");
	By Salary = By.name("salary");
	By PFNo = By.name("PF_no");
	By ESINo = By.name("ESI_no");
	
	
	//Address Details
	By streetaddr = By.id("permanent_street");
	By city = By.id("permanent_city");
	By Zipcode = By.id("permanent_zip_code");
	By state = By.id("permanent_state");
	By country = By.id("country1");
	By countryname = By.cssSelector("select[id = 'country1'] option[name='ccountry']");
	By permanentaddr = By.name("sameAddress");
	
	//Login Details
	By Emp_Email = By.name("email");
	By updatepass = By.name("password");
	By empcode = By.name("employee_code");
	By dept = By.name("department_id");
	By dept_name = By.cssSelector("select[name='department_id'] option");
	By role = By.name("role_id");
	By role_name = By.cssSelector("select[name= 'role_id'] option");
	By LoginTime = By.name("shift_time");
	By Register_button = By.cssSelector("button[class='btn btn-primary save-emp']");
	
	
	public Admin_Employee(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getloginbutton()
	{
		return driver.findElement(login);
	}

	public WebElement getEmailID()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(pwd);
	}
	
	public WebElement getLoginclick()
	{
		return driver.findElement(lgbutton);
	}
	
	public WebElement getEmployee()
	{
		return driver.findElement(employee);
	}
	
	public WebElement getAddEmployee()
	{
		return driver.findElement(addEmp);
	}
	
   //Employee data filling method
	//Profile details method
	public WebElement getFirstName()
	{
		return driver.findElement(firstname);
	}
	
	public WebElement getLastName()
	{
		return driver.findElement(lastname);
	}
	
	public WebElement getmobileno()
	{
		return driver.findElement(mobileno);
	}

	public WebElement getEmergencyNo()
	{
		return driver.findElement(emergencyno);
	}

	public WebElement getdateofbirth()
	{
		return driver.findElement(dob);
	}
	
	public WebElement getdobMonth()
	{
		return driver.findElement(dobMonth);
	}

	public WebElement getdobYear()
	{
		return driver.findElement(dobYear);
	}
	
	public WebElement getdobPrevbutton()
	{
		return driver.findElement(dobPrevYear);
	}
	
	public List<WebElement> getmonth()
	{
		return driver.findElements(dobmonthlist);
	}
	
	public List<WebElement> getDate()
	{
		return driver.findElements(dobdatelist);
	}
	
	public WebElement getDOJ()
	{
		return driver.findElement(doj);
	}
	
	//Bank Details Method
	public WebElement getBankName()
	{
		return driver.findElement(BankName);
	}
	
	public WebElement getBranchName()
	{
		return driver.findElement(BankBranch);
	}
	
	public WebElement getIFSCcode()
	{
		return driver.findElement(IFSCcode);
	}
	
	public WebElement getAccountNo()
	{
		return driver.findElement(Accountno);
	}
	
	public WebElement getACHolderName()
	{
		return driver.findElement(ACHolderName);
	}
	
	public WebElement getPanNo()
	{
		return driver.findElement(PanCardNo);
	}
	
	public WebElement getSalary()
	{
		return driver.findElement(Salary);
	}
	
	public WebElement getPFNo()
	{
		return driver.findElement(PFNo);
	}
	
	public WebElement getESINo()
	{
		return driver.findElement(ESINo);
	}
	
	
	//Address details method
	public WebElement getstreetAddr()
	{
		return driver.findElement(streetaddr);
	}
	
	public WebElement getCity()
	{
		return driver.findElement(city);
	}

	public WebElement getZipCode()
	{
		return driver.findElement(Zipcode);
	}
	
	public WebElement getState()
	{
		return driver.findElement(state);
	}

	public WebElement getCountry()
	{
		return driver.findElement(country);
	}
	
	public List<WebElement> getCountryName()
	{
		return driver.findElements(countryname);
	}

	public WebElement getpermanentaddr()
	{
		return driver.findElement(permanentaddr);
	}
	
	public WebElement getLoginDetails()
	{
		return driver.findElement(Emp_Email);
	}
	
	public WebElement getupdatepwd()
	{
		return driver.findElement(updatepass);
	}
	
	public WebElement getempcode()
	{
		return driver.findElement(empcode);
	}
	
	public WebElement getdept()
	{
		return driver.findElement(dept);
	}
	
	public List<WebElement> getdeptName()
	{
		return driver.findElements(dept_name);
	}
	
	public WebElement getRole()
	{
		return driver.findElement(role);
	}
	
	public List<WebElement> getRoleName()
	{
		return driver.findElements(role_name);
	}
	

	public WebElement getLoginTime() {
		// TODO Auto-generated method stub
		return driver.findElement(LoginTime);
	}
	
	public WebElement getRegister()
	{
		return driver.findElement(Register_button);
	}
}

