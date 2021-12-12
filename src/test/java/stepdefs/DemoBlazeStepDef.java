package stepdefs;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class DemoBlazeStepDef extends TestBase {
	LoginPage lp;
	HomePage home;
	
	@Before
	public void setup() {
		initialize();
		lp=new LoginPage();
		home=new HomePage();
	}
	@When("User is at Test Page")
	public void user_is_at_test_page() {
	    // Write code here that turns the phrase above into concrete actions
		String pageTitle=driver.getTitle();
		Assert.assertEquals("STORE",pageTitle);
	}

	@Then("User enters credentials & clicks login")
	public void user_enters_credentials_clicks_login() {
	    // Write code here that turns the phrase above into concrete actions
		lp.login("anjali2","anjali");
		System.out.println("user logged in");
	}
	@Given("User selects Category")
	public void user_selects_category() {
	    // Write code here that turns the phrase above into concrete actions
	   home.selectCategory();
	   System.out.println("user selected category");
	}
@Then("User adds items to Cart")
public void user_adds_items_to_cart(DataTable table) throws InterruptedException {
    List <String> row=table.asList();
    	home.addItem(row.get(0),row.get(1));
}

	@Then("close the browser")
	public void close_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		driver.close();
	}
}
