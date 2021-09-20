package samples.testNG_demo;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDemo2 {

    @Test(groups = {"regression"})
    public void testNGDemo2_1(){
        System.out.println("regression  test case");
    }

    @Test(groups = {"smoke"})
    public void testNGDemo2_2(){
        System.out.println("testNGDemo2_2");
//        Assert.assertTrue(false);
    }

    @Parameters({"URL", "APIKey", "account"})
    @Test
    public void testNGDemo2_3(String myURL, String myApiKey, String myAccount){
        System.out.println("testNGDemo2_3");
        System.out.println(myURL);
        System.out.println(myApiKey);
        System.out.println(myAccount);
    }
}
