package samples.properties;

import org.testng.annotations.Test;
import java.util.ResourceBundle;

public class GlobalValuesTest {


    @Test
    public void getDataFromProperties(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("qa_env");

        System.out.println(resourceBundle.getString("base.url"));
        System.out.println(resourceBundle.getString("api.key"));
        System.out.println(resourceBundle.getString("api.token"));




        resourceBundle = ResourceBundle.getBundle("dev_env");

        System.out.println(resourceBundle.getString("base.url"));
        System.out.println(resourceBundle.getString("api.key"));
        System.out.println(resourceBundle.getString("api.token"));
    }
}
