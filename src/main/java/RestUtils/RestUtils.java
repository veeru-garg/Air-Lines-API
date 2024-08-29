package RestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;
import java.util.Map;

public class RestUtils {
    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String, String> headers)    {

       return RestAssured.
                given().baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }
    private static void printRequestLogReport(RequestSpecification requestSpecification){

        QueryableRequestSpecification queryableRequestSpecification= SpecificationQuerier.query(requestSpecification);

        ExtentReportManager.logInfoDetails("End point is: " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is: " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are: " );
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request body is: ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());

    }

    private static void printResponseLogReport(Response response){

        ExtentReportManager.logInfoDetails("Response status is: " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response headers are: " );
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is ");
        ExtentReportManager.logJson(response.getBody().asPrettyString());

    }
    public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
      Response response = requestSpecification.post();
      printRequestLogReport(requestSpecification);
     printResponseLogReport(response);
return response;
    }

 public static Response performPost(String endPoint,Object requestPayloadAsPojo, Map<String, String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayloadAsPojo, headers);
      Response response = requestSpecification.post();
      printRequestLogReport(requestSpecification);
     printResponseLogReport(response);
return response;
    }

    public static Response performPost(String endPoint, Map<String, Object> requestPayload, Map<String, String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
        printRequestLogReport(requestSpecification);
        printResponseLogReport(response);
        return response;
    }
}
