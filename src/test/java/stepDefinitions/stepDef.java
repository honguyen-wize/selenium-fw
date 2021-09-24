package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDef {
    @Given("^User is on landing page")
    public void user_is_on_landing_page(){
        System.out.println("Hello: on landing page");
    }

    @When("^I open the page")
    public void user_open_the_page(){
        System.out.println("He open the page");
    }

    @Then("^I see my user name \"([^\"]*)\"$")
    public void i_see_my_user_name(String userName) {
        System.out.println("user name: " + userName);
    }
}
