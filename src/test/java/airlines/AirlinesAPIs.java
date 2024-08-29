package airlines;

import RestUtils.RestUtils;
import io.restassured.response.Response;
import pojos.Airline;

import java.util.HashMap;
import java.util.Map;

public class AirlinesAPIs {

    public Response createAirline(Map <String, Object> airlinePayload){

       String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndPoint");
        return RestUtils.performPost(endPoint,airlinePayload,new HashMap<>());
     }
     public Response createAirline( Airline airlinePayload){

       String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndPoint");
        return RestUtils.performPost(endPoint,airlinePayload,new HashMap<>());
     }
}
