package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalhomepage {
	
		
		WebDriver driver;
		public portalhomepage (WebDriver driver)
		{
			this.driver=driver;
		}
		
		private By Search=By.id("search-courses");
		
		public WebElement searchbox()
		{
			return driver.findElement(Search);
		}
		
	}



