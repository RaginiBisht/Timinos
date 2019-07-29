package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageAttributes {
	
	public WebDriver driver;
	By login = By.className("sign-in-btn");
	By email =  By.id("email");
	By pwd = By.id("password");
	By lgbutton = By.xpath("//button[@class='btn btn-primary']");
	By forgetpwd = By.xpath("//div[@class='form-group'] //a[1]");
	By needacc = By.xpath("//div[@class='form-group'] //a[2]");
	By titletext = By.className("panel-heading");
	
	
	public LoginPageAttributes(WebDriver driver) {
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
	
	public WebElement getforgetpass()
	{
		return driver.findElement(forgetpwd);
	}
	
	public WebElement getNeedAccount()
	{
		return driver.findElement(needacc);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(titletext);
	}


}
