package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Department_add_attribute {

	WebDriver driver;
	By Dept = By.xpath("//div[@class='hide-scroll']//li[3]//a[1]//span[3]");
	By addDept = By.xpath("//a[@href='/home/department/add']//span");
	By deptCode = By.name("sr_no");
	By deptName = By.name("department_name");
	By deptDescription = By.name("action");
	By manager = By.name("managerId");
	By managerName = By.xpath("//select[@name='managerId']//option");
	By addDeptButton = By.cssSelector("button.btn.btn-primary.save-dprtmt.pull-right");
	

	public Department_add_attribute(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement dept()
	{
		return driver.findElement(Dept);
	}
	
	public WebElement adddept()
	{
		return driver.findElement(addDept);
	}
	
	public WebElement deptCode()
	{
		return driver.findElement(deptCode);
	}

	public WebElement deptName()
	{
		return driver.findElement(deptName);
	}

	public WebElement deptDescription()
	{
		return driver.findElement(deptDescription);
	}
	
	public WebElement deptManger()
	{
		return driver.findElement(manager);
	}
	
	public List<WebElement> deptManagerName()
	{
		return driver.findElements(managerName);
	}
	
	public WebElement AddDeptbutton()
	{
		return driver.findElement(addDeptButton);
	}
}
