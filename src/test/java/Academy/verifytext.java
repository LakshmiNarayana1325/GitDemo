package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.Landingpageobjects;
import Pageobjects.loggingpageobjects;
import resource.base;

public class verifytext extends base{
	private static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void before() throws IOException
	{
		driver=initializedriver();
		log.info("Driver loaded");
		driver.get(prop.getProperty("url"));
		log.info("page loaded");
	}
	
	@Test
	public void initializehomepage() throws IOException
	{
		
		//we can call the functions in 2 ways either by extending from inheritance or by creating objects
		Landingpageobjects l=new Landingpageobjects(driver);
		
		Assert.assertTrue(l.getnavbar().isEnabled());
		
	}
	@AfterTest
	public void after()
	{
		driver.close();
	}
	
	

}
