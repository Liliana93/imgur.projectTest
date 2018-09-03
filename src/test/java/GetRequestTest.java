import classes.FileWriter;
import classes.FlickrItem;
import classes.RestAPIHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class GetRequestTest {
    public Properties prop;

    @BeforeTest
    public void before() throws IOException {
        prop = new Properties();
        // FileInputStream dataFile = new FileInputStream("C:\\FlickrApiProject\\imgur.projectTest\\src\\main\\resources\\data.properties");
        FileInputStream dataFile = new FileInputStream("C:\\imgur update\\imgur.projectTest\\src\\main\\resources\\data.properties");
        prop.load(dataFile);
        RestAssured.baseURI = prop.getProperty("flickrbaseUrl");
    }


    @Test
    public void testGetRequest() throws IOException {
        Response response = RestAPIHandler.sendGetRequest(prop.getProperty("flickrpath"));
        Assert.assertEquals(response.getStatusCode(), 200, "Incorrect status code returned");
        FileWriter.writeToFile(prop.getProperty("filenameget"), response.asString());

        List<String> jsonResponse = response.jsonPath().getList("items");
        System.out.println(jsonResponse.size());
        String item = response.jsonPath().getString("items[0]");
        System.out.println(item);
        String title = response.jsonPath().getString("items[0].title");
        System.out.println("Title of the first item is: " + title);

        ObjectMapper mapper = new ObjectMapper();
        try {
            FlickrItem flickrItem = mapper.readValue(new File(prop.getProperty("filenameget")), FlickrItem.class);
            printParsedItems(flickrItem);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FlickrItem item1 = mapper.readValue("{\"title\": \"Pineapple_0232\"}", FlickrItem.class);
        System.out.println(item1.getTitle());

    }

    private static void printItem(FlickrItem flickitem) {
        System.out.println("Item title: " + flickitem.getTitle());
        System.out.println("Item link: " + flickitem.getLink());
        System.out.println("Media: " + flickitem.getMedia());
        System.out.println("Date taken: " + flickitem.getDate_taken());
        System.out.println("Description: " + flickitem.getDescription());
        System.out.println("Published: " + flickitem.getPublished());
        System.out.println("Author: " + flickitem.getAuthor());
        System.out.println("Author_id: " + flickitem.getAuthor_id());
        System.out.println("Tags: " + flickitem.getTags());
    }

    private static void printItems(FlickrItem[] items) {
        System.out.println("Items: ");
        System.out.println();
        for (FlickrItem flickrItem : items) {
            printItem(flickrItem);
            System.out.println();
            System.out.println();
        }

    }

    private static void printParsedItems(FlickrItem flickrItem) {
        printItems(flickrItem.getItems());
    }
}