package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Department_view_attr {
	WebDriver driver;
	
	By dept = By.xpath("//ul[@class='nav']//li[3]//a[1]//span[3]");
	By dept_list = By.xpath("//ul[@class='nav-sub']//a[@href='/home/departments']//span[@class='nav-text']");
	
	By dept_name = By.xpath("//table[@id='datatables']//tr[@role='row']//td[2]");
	By edit = By.cssSelector("a.btn.btn-primary.save-dprtmt.pull-right");
	By CheckDeptName = By.name("department_name"); 
	By Updateclick = By.cssSelector("button.btn.btn-primary.save-dprtmt.pull-right");
	By Popupalert = By.cssSelector("div.alert.alert-success");
	By selectall = By.xpath("//table[@id='datatables']//tr[1]//th[1]//input");
	By select = By.id("action");
	By selectaction = By.xpath("//select[@id='action']//option");
	By confirm = By.id("confirmBtn");
	By reject = By.id("cancelBtn");
	By confirmdel = By.id("modal-btn-si");
	By rejectdel = By.id("modal-btn-no");
	
	public Department_view_attr(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getdept()
	{
		return driver.findElement(dept);
	}
	
	public WebElement getdept_list()
	{
		return driver.findElement(dept_list);
	}
	
	public List<WebElement> getdeptName()
	{
		return driver.findElements(dept_name);
	}
	
	public WebElement getEdit()
	{
		return driver.findElement(edit);
	}
	
	public WebElement getDeptNameView()
	{
		return driver.findElement(CheckDeptName);
	}
	
	public WebElement getUpdateButton()
	{
		return driver.findElement(Updateclick);
	}
	
	public WebElement getpopup()
	{
		return driver.findElement(Popupalert);
	}
	
	public WebElement getSelectall()
	{
		return driver.findElement(selectall);
	}
	
	public WebElement getSelect()
	{
		return driver.findElement(select);
	}
	
	public List<WebElement> getselectOption()
	{
		return driver.findElements(selectaction);
	}
	
	public WebElement getyes()
	{
		return driver.findElement(confirm);
	}
	
	public WebElement getNo()
	{
		return driver.findElement(reject);
	}
	
	public WebElement getDelyes()
	{
		return driver.findElement(confirmdel);
	}
	
	public WebElement getDelno()
	{
		return driver.findElement(rejectdel);
	}

}
