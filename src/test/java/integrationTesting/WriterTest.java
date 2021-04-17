package integrationTesting;

import com.google.gson.Gson;
import io.corecode.testing.dataProviders.WriterDataProvider;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.corecode.testing.model.Writer;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WriterTest {

    private List<Integer> writersAdded = new ArrayList<Integer>();

    @Test(priority = 100, dataProviderClass = WriterDataProvider.class, dataProvider = "getWriters")
    public void createWriter(String bodyContent) {
        Response response = RequestTemplate.postRequest("http://myapi-env.eba-3me5caza.us-east-2.elasticbeanstalk.com/writer", bodyContent);
        writersAdded.add(new Gson().fromJson(response.asString(), Writer.class).getWriterId());
        System.out.println("Writer " + writersAdded.get(writersAdded.size() - 1) + " added successfully");
    }

    @Test(priority = 200)
    public void getAll() {
        Response response = RequestTemplate.getRequest("http://myapi-env.eba-3me5caza.us-east-2.elasticbeanstalk.com/writer");
        Writer[] writers = new Gson().fromJson(response.asString(), Writer[].class);
        System.out.println("All writers obtained successfully");
    }

    @Test(priority = 300)
    public void setVariableWritersAddedInDataProvider() {
        WriterDataProvider.writersAdded = this.writersAdded;
    }

    @Test(priority = 400, dataProviderClass = WriterDataProvider.class, dataProvider = "getWritersAdded")
    public void getWriter(int id) {
        Response response = RequestTemplate.getRequest("http://myapi-env.eba-3me5caza.us-east-2.elasticbeanstalk.com/writer/" + id);
        System.out.println("Writer " + id + " obtained successfully");
    }

    @Test(priority = 500, dataProviderClass = WriterDataProvider.class, dataProvider = "getUpdateWriters")
    public void updateWriter(int id, String bodyContent) {
        Response response = RequestTemplate.putRequest("http://myapi-env.eba-3me5caza.us-east-2.elasticbeanstalk.com/writer/" + id, bodyContent);
        System.out.println("Writer " + id + " updated successfully");
    }

    @Test(priority = 600, dataProviderClass = WriterDataProvider.class, dataProvider = "getWritersAdded")
    public void deleteWriter(int id) {
        Response response = RequestTemplate.deleteRequest("http://myapi-env.eba-3me5caza.us-east-2.elasticbeanstalk.com/writer/" + id);
        System.out.println("Writer " + id + " deleted successfully");
    }
}
