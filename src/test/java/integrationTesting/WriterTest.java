package integrationTesting;

import io.corecode.testing.dataProviders.WriterDataProvider;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.corecode.testing.staticVariables.WritersList;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class WriterTest {

    @Test(priority = 100, dataProviderClass = WriterDataProvider.class, dataProvider = "getWriters")
    public void createWriter(String bodyContent) {
        Response response = RequestTemplate.postRequest("http://myapi-env.eba-3me5caza.us-east-2.elasticbeanstalk.com/writer", bodyContent);
        System.out.println("Writer " + WritersList.addWriter(response) + " added successfully");
    }

    @Test(priority = 200)
    public void getAll() {
        RequestTemplate.getRequest("http://myapi-env.eba-3me5caza.us-east-2.elasticbeanstalk.com/writer");
        System.out.println("All writers obtained successfully");
    }

    @Test(priority = 300, dataProviderClass = WriterDataProvider.class, dataProvider = "getWritersAdded")
    public void getWriter(int id) {
        RequestTemplate.getRequest("http://myapi-env.eba-3me5caza.us-east-2.elasticbeanstalk.com/writer/" + id);
        System.out.println("Writer " + id + " obtained successfully");
    }

    @Test(priority = 400, dataProviderClass = WriterDataProvider.class, dataProvider = "getUpdateWriters")
    public void updateWriter(int id, String bodyContent) {
        RequestTemplate.putRequest("http://myapi-env.eba-3me5caza.us-east-2.elasticbeanstalk.com/writer/" + id, bodyContent);
        System.out.println("Writer " + id + " updated successfully");
    }

    @Test(priority = 500, dataProviderClass = WriterDataProvider.class, dataProvider = "getWritersAdded")
    public void deleteWriter(int id) {
        RequestTemplate.deleteRequest("http://myapi-env.eba-3me5caza.us-east-2.elasticbeanstalk.com/writer/" + id);
        System.out.println("Writer " + id + " deleted successfully");
    }
}
