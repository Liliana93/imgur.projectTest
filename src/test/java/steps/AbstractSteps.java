package steps;

import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AbstractSteps {
    public Properties prop;

    public void initialize(String baseURI) throws IOException {
        prop = new Properties();
        FileInputStream dataFile = new FileInputStream("C:\\imgur.project\\src\\main\\resources\\data.properties");
        prop.load(dataFile);
        if (baseURI.equals("flickr")) {
            RestAssured.baseURI = prop.getProperty("flickrbaseUrl");
        } else
            RestAssured.baseURI = prop.getProperty("jsonplaceholderUrl");
    }

}
