package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.Landingpageobjects;
import Pageobjects.loggingpageobjects;
import resource.base;

public class baseapp extends base{
	
	 WebDriver driver;
	
	private static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void before() throws IOException
	{
		driver=initializedriver();
		log.info("driver loaded");
		
	}
	
	@Test(dataProvider="getdata")
	public void initializehomepage(String username,String password,String strict) throws IOException
	{
		//driver=initializedriver();
		//driver.get(prop.getProperty("url"));
		//we can call the functions in 2 ways either by extending from inheritance or by creating objects
		driver.get(prop.getProperty("url"));
		Landingpageobjects l=new Landingpageobjects(driver);
		l.login().click();
		loggingpageobjects lg=new loggingpageobjects(driver);
		lg.getemail().sendKeys(username);
		lg.getpassword().sendKeys(password);
		System.out.println(strict);
		lg.getloginbutton().click();
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		//the number that we ae giving in object[2][3] are the number of items not the indexes.
		Object[][] data=new Object[2][3];
		data[0][0]="abc@gmail.com";
		data[0][1]="123456";
		data[0][2]="normal";
		
		data[1][0]="mouse@gmail.com";
		data[1][1]="456789";
		data[1][2]="resticted"; 
		
		return data; 
	}

	@AfterTest
	public void after()
	{
		driver.close();
	}
}
