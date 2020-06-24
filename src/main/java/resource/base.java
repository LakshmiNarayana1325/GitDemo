package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializedriver() throws IOException
	{
		
	    prop=new Properties();
	   // FileInputStream fis=new FileInputStream("C:\\Users\\Lakshmi Narayana\\eclipse-workspace\\e2e\\src\\main\\java\\resource\\data.properties")
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties");
		prop.load(fis);
		
		
		System.out.println(prop.getProperty("browser"));
		//String browsername=System.getProperty("browser");
		String browsername=prop.getProperty("browser");
		if (browsername.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\downloads\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resource\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browsername.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
		}
		else if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\downloads\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String screenshot(String testcasename,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=((TakesScreenshot) driver);
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(source,new File(destination));
		System.out.println("lastline of screenshot");
		System.out.println("lastline of screenshot");
		System.out.println("lastline of screenshot");
		
		return destination;
	}

	
}
