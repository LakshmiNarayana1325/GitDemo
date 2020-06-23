package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loggingpageobjects {
WebDriver driver;
	public loggingpageobjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By email=By.cssSelector("input[type='email']");
	By password=By.cssSelector("input[id='user_password']");
	By loginbutton=By.cssSelector("input[value='Log In']");
	
	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getloginbutton()
	{
		return driver.findElement(loginbutton);
	}
}
