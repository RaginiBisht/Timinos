package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Employee_listAttributes {
	
	WebDriver driver;
	
	By login = By.className("sign-in-btn");
	By email =  By.id("email");
	By pwd = By.id("password");
	By lgbutton = By.xpath("//button[@class='btn btn-primary']");
	By employee = By.xpath("//ul[@class='nav'] //li[4]//a//span[3] ");
	By empList = By.cssSelector(" a[href = '/home/employees']");
	By viewicon = By.xpath("//table[@id='datatables']//tr[1]//td[7]//a[1]//i[1]");
	By editicon = By.xpath("//table[@id='datatables']//tr[1]//td[7]//a[2]//i[1]");
	By deleteicon = By.xpath("//table[@id='datatables']//tr[1]//td[7]//a[@class='delete-button']");
	By list_employees = By.xpath("//table[@id ='datatables'] //td[@class='sorting_1']");
	By show = By.xpath("//select[@name='datatables_length'] //option");
	By searchbox = By.xpath("//input[@type='search']");
	
	//Update employee details
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
		
		By role = By.name("role_id");
		By role_name = By.cssSelector("select[name= 'role_id'] option");
		By LoginTime = By.name("shift_time");
		By selectdepartment = By.xpath("//div[@class='mutliSelect']//li");
		By choosedepartment = By.name("department_id");
		By updateButton = By.className("btn btn-primary save-emp");
		
		//Previous and next button
		By firstpage = By.xpath("//a[contains(text(),'1')]");
		By range = By.xpath("//a[@aria-controls='datatables']");
		By Nextclick = By.xpath("//a[contains(text(),'Next')]");
	
	
	public Employee_listAttributes(WebDriver driver) {
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
	
	public WebElement getEmpList()
	{
		return driver.findElement(empList);
	}
	
	public WebElement getsearchbox()
	{
		return driver.findElement(searchbox);
	}
	
	public WebElement getEmployeeListss()
	{
		return driver.findElement(list_employees);
	}
	
	public List<WebElement> getEmployeeList()
	{
		return driver.findElements(list_employees);
	}
	
	public WebElement getShowlist()
	{
		return driver.findElement(show);
	}
	public List<WebElement> getShow()
	{
		return driver.findElements(show);
	}
	public WebElement getViewIcon()
	{
		return driver.findElement(viewicon);
	}
	
	public WebElement getEditIcon()
	{
		return driver.findElement(editicon);
	}
	
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
	
	public List<WebElement> getDepartment()
	{
		return driver.findElements(selectdepartment);
	}
	
	public List<WebElement> getchoosendept()
	{
		return driver.findElements(choosedepartment);
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
	
	public WebElement getupdate()
	{
		return driver.findElement(updateButton);
	}
	
	public WebElement getDeletebutton()
	{
		return driver.findElement(deleteicon);
	}

	public WebElement getfirst()
	{
		return driver.findElement(firstpage);
	}
	
	public List<WebElement> getrange()
	{
		return driver.findElements(range);
	}
	
	public WebElement getNext()
	{
		return driver.findElement(Nextclick);
	}
	
}
