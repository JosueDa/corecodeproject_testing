package integrationTesting;

import io.corecode.testing.MyConstants;
import io.corecode.testing.dataProviders.ReviewDataProvider;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ReviewTest {

    private String path = "review/";

    @Test(priority = 100, dataProviderClass = ReviewDataProvider.class, dataProvider = "getReviews")
    public void createReview(String bodyContent) {
        Response response = RequestTemplate.postRequest(MyConstants.url + path, bodyContent);
        System.out.println("Review " + ReviewDataProvider.addReview(response) + " added successfully");
    }

    @Test(priority = 200)
    public void getAll() {
        RequestTemplate.getRequest(MyConstants.url + path);
        System.out.println("All reviews obtained successfully");
    }

    @Test(priority = 300, dataProviderClass = ReviewDataProvider.class, dataProvider = "getReviewsAdded")
    public void getReview(int id) {
        RequestTemplate.getRequest(MyConstants.url + path + id);
        System.out.println("Review " + id + " obtained successfully");
    }

    @Test(priority = 400, dataProviderClass = ReviewDataProvider.class, dataProvider = "getUpdateReviews")
    public void updateReview(int id, String bodyContent) {
        RequestTemplate.putRequest(MyConstants.url + path + id, bodyContent);
        System.out.println("Review " + id + " updated successfully");
    }

    @Test(priority = 500, dataProviderClass = ReviewDataProvider.class, dataProvider = "getReviewsAdded")
    public void deleteReview(int id) {
        RequestTemplate.deleteRequest(MyConstants.url + path + id);
        System.out.println("Review " + id + " deleted successfully");
    }

    @AfterClass
    public void deleteAuxiliaryEntities() {
        ReviewDataProvider.deleteAuxiliaryEntities();
    }
}
