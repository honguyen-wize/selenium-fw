package samples.testNG_demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDemo {
    @Test (dataProvider = "getData")
    public void loginMutileDevices(String userName, String password){
        System.out.println("login mutile times: ");
        System.out.println(userName);
        System.out.println(password);
    }

    @DataProvider
    public Object[][] getData(){

        Object[][] data =  new Object[3][2]; // 3 rows, 2 columns
        data[0][0] = "firstUserName";
        data[0][1] = "password1";
        data[1][0] = "secondUserName";
        data[1][1] = "password2";
        data[2][0] = "thirdUserName";
        data[2][1] = "password3";

        return data;
    }

}
