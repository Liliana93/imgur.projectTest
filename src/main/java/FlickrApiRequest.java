import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.IOException;




public class FlickrApiRequest {
    @Test
    public void test()throws IOException{
      //  classes.RestAPIHandler.getResponse( "/photos_public.gne?tags=pineapple&format=json");
    }

   public void getResponse() throws IOException {
        RestAssured.baseURI = "https://api.flickr.com/services/feeds";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/photos_public.gne?tags=pineapple&format=json");
        ResponseBody body = response.getBody();
     //   System.out.println("Response:  " + body.asString());

       /* classes.FileWriter file = new classes.FileWriter("/Flickr/response.json");
        try{
            file.write(body.asString());
            System.out.println("Successfully copied response to a json file...");

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            file.close();
        }*/
    }


}
