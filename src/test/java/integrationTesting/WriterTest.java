package integrationTesting;

import io.corecode.testing.MyConstants;
import io.corecode.testing.dataProviders.WriterDataProvider;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class WriterTest {

    private String path = "writer/";

    @Test(priority = 100, dataProviderClass = WriterDataProvider.class, dataProvider = "getWriters")
    public void createWriter(String bodyContent) {
        Response response = RequestTemplate.postRequest(MyConstants.url+path, bodyContent);
        System.out.println("Writer " + WriterDataProvider.addWriter(response) + " added successfully");
    }

    @Test(priority = 200)
    public void getAll() {
        RequestTemplate.getRequest(MyConstants.url+path);
        System.out.println("All writers obtained successfully");
    }

    @Test(priority = 300, dataProviderClass = WriterDataProvider.class, dataProvider = "getWritersAdded")
    public void getWriter(int id) {
        RequestTemplate.getRequest(MyConstants.url+path + id);
        System.out.println("Writer " + id + " obtained successfully");
    }

    @Test(priority = 400, dataProviderClass = WriterDataProvider.class, dataProvider = "getUpdateWriters")
    public void updateWriter(int id, String bodyContent) {
        RequestTemplate.putRequest(MyConstants.url+path + id, bodyContent);
        System.out.println("Writer " + id + " updated successfully");
    }

    @Test(priority = 500, dataProviderClass = WriterDataProvider.class, dataProvider = "getWritersAdded")
    public void deleteWriter(int id) {
        RequestTemplate.deleteRequest(MyConstants.url+path+ id);
        System.out.println("Writer " + id + " deleted successfully");
    }
}
