package samples.testNG_demo;

import org.testng.annotations.*;

public class TestNGDemo3 {

    @BeforeSuite
    public void beforeSuite(){

        System.out.println("[BeforeSuite]");
    }

    @AfterSuite
    public void afterSuite(){

        System.out.println("[AfterSuite]");
    }

    @BeforeClass
    public void BeforeClass(){

        System.out.println("[BeforeClass]");
    }

    @AfterClass
    public void AfterClass(){

        System.out.println("[AfterClass]");
    }

    @BeforeTest
    public void beforeTest(){

        System.out.println("[Before Test]");
    }

    @AfterTest
    public void afterTest(){

        System.out.println("[afterTest]");
    }


    @BeforeMethod
    public void beforeMethod(){

        System.out.println("[Before Method]");
    }

    @Parameters({"URL", "APIKey"})
    @Test
    public void webLoginHomeLoan(String urlAddress, String myAPIKey){

        System.out.println("webLoginHomeLoan");
        System.out.println(urlAddress);
        System.out.println(myAPIKey);
    }

    @Test
    public void mobileLoginHomeLoanWithPhoneNumber(){

        System.out.println("mobileLoginHomeLoan");
    }

    @Test(groups = {"smoke"})
    public void mobileLoginHomeLoanWithGoogle(){

        System.out.println("mobileLoginHomeLoan");
    }

    @Test
    public void loginWithAPIHomeLoan(){

        System.out.println("loginWithAPIHomeLoan");
    }
}
