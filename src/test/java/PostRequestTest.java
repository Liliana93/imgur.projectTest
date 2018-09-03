import classes.FileWriter;
import classes.Model;
import classes.RestAPIHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;


public class PostRequestTest {
    public Properties prop;

    @BeforeTest
    public void before() throws IOException {
        prop = new Properties();
    //    FileInputStream dataFile = new FileInputStream("C:\\FlickrApiProject\\imgur.projectTest\\src\\main\\resources\\data.properties");
        FileInputStream dataFile = new FileInputStream("C:\\imgur update\\imgur.projectTest\\src\\main\\resources\\data.properties");
        prop.load(dataFile);
        RestAssured.baseURI = prop.getProperty("jsonplaceholderUrl");
    }
    @Test
    public void testPostRequest() throws IOException{
        Model model = new Model("21", "24", "this is a POST request", "this is REST-Assured Tutorial");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(model, Map.class);
        JSONObject jsonObject = new JSONObject(map);
        Response response = RestAPIHandler.sendPostRequest("/posts/", jsonObject);
        Assert.assertEquals(response.getStatusCode(), 201, "Incorrect status code returned");
        FileWriter.writeToFile(prop.getProperty("filenamepost"), response.asString());

    }
}