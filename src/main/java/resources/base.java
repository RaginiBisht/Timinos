
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	public static Properties prop;
	public WebDriver initializedriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\maven files\\Timinos1\\src\\main\\java\\resource\\data.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D://geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		return driver;
	}
}
