package airlines;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.Airline;
import java.io.IOException;

public class AirlinesTests extends AirlinesAPIs{

    @Test
    public void CreateAirLine() throws IOException {

        Airline payLoad =new Airline().toBuilder().build();
    }
    @Test
    public void fa() throws IOException {
       Assert.assertTrue(false);

    }
}