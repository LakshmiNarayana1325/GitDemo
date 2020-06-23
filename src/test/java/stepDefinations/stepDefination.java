package stepDefinations;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.junit.runner.RunWith;

import Pageobjects.Landingpageobjects;
import Pageobjects.loggingpageobjects;
import Pageobjects.portalhomepage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import resource.base;

@RunWith(Cucumber.class)
public class stepDefination extends base{

	@Given("^Initialize browser with chrome$")
	public void initialize_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=initializedriver();
	   
	}

	@Given("^Load the page with \"([^\"]*)\"$")
	public void load_the_page_with(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(arg1);
	}

	@Given("^click on login link$")
	public void click_on_login_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Landingpageobjects l=new Landingpageobjects(driver);
		l.login().click();
	   
	}

	
	@When("^enter the user enters (.+) and (.+)$")
    public void enter_the_user_enters_and(String username, String password) throws Throwable {
		loggingpageobjects lg=new loggingpageobjects(driver);
		lg.getemail().sendKeys(username);
		lg.getpassword().sendKeys(password);
		lg.getloginbutton().click();
    }

	@Then("^verify user successfully loged in$")
	public void verify_user_successfully_loged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		portalhomepage ph=new portalhomepage(driver);
		Assert.assertTrue(ph.searchbox().isDisplayed());
	
	}

	@And("^close all browsers$")
    public void close_all_browsers() throws Throwable {
        driver.quit();
    }

}