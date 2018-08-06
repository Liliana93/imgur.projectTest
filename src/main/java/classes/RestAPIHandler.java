package classes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.io.IOException;

public class RestAPIHandler {
    public static int code;
    public static Response response;
    public static  RequestSpecification httpRequest;

    public static Response getRequest (String path) throws IOException {
        httpRequest = RestAssured.given();
        response = httpRequest.contentType("application/json").when().get(path);
        return response;
    }
    public static Response postRequest (String path, JSONObject jsonObject) throws IOException{
        httpRequest = RestAssured.given();
        response = httpRequest.body(jsonObject.toJSONString()).when().post(path);
        return response;
    }

    public static void setCode(int code){
         RestAPIHandler.code = code;
     }
    public static void assertResponseCode() {
        int responseStatusCode = response.getStatusCode();

       Assert.assertEquals(responseStatusCode, code, "Incorrect status code returned");
    }
}
