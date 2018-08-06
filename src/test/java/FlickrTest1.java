import classes.FileWriter;
import classes.FlickrItem;
import classes.RestAPIHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class FlickrTest1 {
    public Properties prop;
    @BeforeTest
    public void before() throws IOException {
        prop = new Properties();
        FileInputStream dataFile = new FileInputStream("C:\\imgur.project\\src\\main\\resources\\data.properties");
        prop.load(dataFile);
     // RestAssured.baseURI = prop.getProperty("flickrbaseUrl");
      RestAssured.baseURI = prop.getProperty("jsonplaceholderUrl");
    }
    @Test
    public void test() throws IOException {
       Response response = RestAPIHandler.getRequest(prop.getProperty("flickrpath"));
        RestAPIHandler.setCode(200);
        RestAPIHandler.assertResponseCode();
        FileWriter.writeToFile(prop.getProperty("filenameget"), response.asString());
        List<String> jsonResponse = response.jsonPath().getList("items");
        System.out.println(jsonResponse.size());
        String item = response.jsonPath().getString("items[0]");
        System.out.println(item);
        String title = response.jsonPath().getString("items[0].title");
        System.out.println("Title of the first item is: " + title);



      /*  classes.Model model = new classes.Model("21","24", "this is a POST request", "this is REST-Assured Tutorial");
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", model.getId());
        requestParams.put("title", model.getTitle());
        requestParams.put("body", model.getBody());
        Response response = classes.RestAPIHandler.postRequest("/posts/", requestParams);
        classes.RestAPIHandler.setCode(201);
        classes.RestAPIHandler.assertResponseCode();
        classes.FileWriter.writeToFile(prop.getProperty("filenamepost"), response.asString());*/

        ObjectMapper mapper = new ObjectMapper();
        try{
            FlickrItem flickrItem = mapper.readValue(new File(prop.getProperty("filenameget")), FlickrItem.class);
            printParsedItems(flickrItem);
        }catch (IOException e){
            e.printStackTrace();
        }
        FlickrItem item1 = mapper.readValue( "{\"title\": \"Pineapple_0232\"}", FlickrItem.class);
        System.out.println(item1.getTitle());

    }
    private static  void printItem(FlickrItem flickitem){
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

    private static void printItems(FlickrItem [] items) {
        System.out.println("Items: ");
        System.out.println();
        for (FlickrItem flickrItem : items) {
            printItem(flickrItem);
            System.out.println();
            System.out.println();
        }

    }
        private static void printParsedItems(FlickrItem flickrItem){
            printItems(flickrItem.getItems());
    }
    }


