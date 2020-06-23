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

public class verifynavigation extends base{
	WebDriver driver;
	
	private static Logger log=LogManager.getLogger(base.class.getName());
	Landingpageobjects l;
	
	@BeforeTest
	public void before() throws IOException
	{
		driver=initializedriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void initializehomepage() throws IOException
	{
		
		//we can call the functions in 2 ways either by extending from inheritance or by creating objects
		 l=new Landingpageobjects(driver);
		
		Assert.assertEquals(l.gettext().getText(),"FEATURED COURSES");
		
		Assert.assertEquals(l.getnavbar().isEnabled(), true);
		log.info("text is visible");
		
	}
	@Test
	public void academytext() throws IOException
	{
		
		//we can call the functions in 2 ways either by extending from inheritance or by creating objects
		 l=new Landingpageobjects(driver);
		
		Assert.assertEquals(l.getacademy().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}
	
	@AfterTest
	public void after()
	{
		driver.close();
	}
	

}
