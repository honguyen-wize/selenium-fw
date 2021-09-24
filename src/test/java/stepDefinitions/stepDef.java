package stepDefinitions;

import common.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LandingPage;
import pages.LoginPage;

public class stepDef extends BaseTest {

    @Given("^Initialize the browser$")
    public void initialize_the_browser() {
        driver = initializeDriver();

    }

    @Given("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_site(String baseURL) {
        driver.get(baseURL);
    }

    @Given("^Click on Login link in the home page and land on Secure sign in page$")
    public void click_on_Login_link_in_the_home_page_and_land_on_Secure_sign_in_page() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getLogin().click();

    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
    public void user_enters_and_and_logs_in(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(userName);
        loginPage.getPass().sendKeys(password);
        loginPage.getLoginButton().click();

    }

    @Then("^Verify the user is successfully login$")
    public void verify_the_user_is_successfully_login() {
        driver.close();

    }
}