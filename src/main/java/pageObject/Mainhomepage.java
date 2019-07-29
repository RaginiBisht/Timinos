package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mainhomepage {
	
	public WebDriver driver;
	By login = By.className("sign-in-btn");
	By reg = By.className("crm-in-btn");
	By home = By.xpath("//div[@id= 'navbar'] //a[@href='/']");
	By whyus = By.xpath("//div[@id='navbar'] //a[@href='/why-us']");
	By pricing = By.xpath("//div[@id='navbar'] //a[@href='/pricing']");
	By reqdemo = By.xpath("//div[@id='navbar'] //a[@href='/request-a-demo']");
	By loginlink = By.className("already-login-EMS");
	By emsbutton = By.className("crm-free-btn");
	By FB = By.xpath("//i[@class='fa fa-facebook']");
	By twitter = By.xpath("//i[@class='fa fa-twitter']");
	
	public Mainhomepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement getloginbutton()
	{
		return driver.findElement(login);
	}

	public WebElement getEMSbutton()
	{
		return driver.findElement(reg);
	}

	public WebElement getHome()
	{
		return  driver.findElement(home);
	}
	
	public WebElement getWhyUs()
	{
		return  driver.findElement(whyus);
	}
	
	public WebElement getpricing()
	{
		return  driver.findElement(pricing);
	}
	
	public WebElement getreqdemo()
	{
		return  driver.findElement(reqdemo);
	}

	public WebElement getloginlink()
	{
		return  driver.findElement(loginlink);
	}
	
	public WebElement getEmsButton()
	{
		return  driver.findElement(emsbutton);
	}
	
	public WebElement getFb()
	{
		return  driver.findElement(FB);
	}

	public WebElement gettwitter()
	{
		return  driver.findElement(twitter);
	}




}
