package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpageobjects {
	
	WebDriver driver;
	public Landingpageobjects (WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By Login=By.cssSelector("a[href*='sign_in']");
	private By text=By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navigationbar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By academytext1=By.cssSelector("div[class*='video-banner'] h3");
	
	public WebElement login()
	{
		return driver.findElement(Login);
	}
	public WebElement gettext()
	{
		return driver.findElement(text);
	}
	public WebElement getnavbar()
	{
		return driver.findElement(navigationbar);
	}
	
	public WebElement getacademy()
	{
		return driver.findElement(academytext1);
	}

}
