package classes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.io.IOException;

public class RestAPIHandler {
    public static Response response;
    public static RequestSpecification httpRequest;

    public static Response sendGetRequest(String path) throws IOException {
        httpRequest = RestAssured.given();
        response = httpRequest.contentType("application/json").when().get(path);
        return response;
    }

    public static Response sendPostRequest(String path, JSONObject jsonObject) throws IOException {
        httpRequest = RestAssured.given();
        response = httpRequest.body(jsonObject.toJSONString()).when().post(path);
        return response;
    }
}