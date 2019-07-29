package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeaveApply_Attr {

	WebDriver driver;
	By leave = By.xpath("//ul[@class='nav']//li[7]//span[3]");
	By applyLeave = By.xpath("//a[@href='/home/apply/leave']//span[@class='nav-text']");
	By leaveType = By.name("Leave-Type");
	By leaveoption = By.xpath("//select[@name='Leave-Type']//option");
	By leavefrom = By.id("start");
	By fromyear = By.cssSelector("div.datepicker-days th.datepicker-switch");
	By frommonth = By.xpath("//div[@class='datepicker-months']//span[@class='month']");
	By calendarmonths = By.cssSelector("div.datepicker-months th.datepicker-switch");
	By calendarnext = By.cssSelector("div.datepicker-months th.next");
	By day = By.cssSelector("div.datepicker-days td.day");
	By leavetill = By.id("end");
	By Reason = By.name("reason");
	
	
	public LeaveApply_Attr(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement leaveSection()
	{
		return driver.findElement(leave);
	}
	
	public WebElement getapplyleave()
	{
		return driver.findElement(applyLeave);
	}
	
	public WebElement getLeaveType()
	{
		return driver.findElement(leaveType);
	}
	
	public List<WebElement> getLeaveOption()
	{
		return driver.findElements(leaveoption);
	}
	
	public WebElement getLeaveFrom()
	{
		return driver.findElement(leavefrom);
	}
	
	public WebElement getleaveYear()
	{
		return driver.findElement(fromyear);
	}
	
	public List<WebElement> getleavemonth()
	{
		return driver.findElements(frommonth);
	}
	
	public WebElement getYear()
	{
		return driver.findElement(calendarmonths);
	}
	
	public WebElement getNextyear()
	{
		return driver.findElement(calendarnext);
	}
	
	public List<WebElement> getDay()
	{
		return driver.findElements(day);
	}
	
	public WebElement getlastdate()
	{
		return driver.findElement(leavetill);
	}
	
	public WebElement getreason()
	{
		return driver.findElement(Reason);
	}
}
