package integrationTesting;

import io.corecode.testing.MyConstants;
import io.corecode.testing.dataProviders.BookDataProvider;
import io.corecode.testing.dataProviders.UserDataProvider;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class UserTest {

    @Test(priority = 5)
    public void getUsers(){
        RequestTemplate.getRequest(MyConstants.url+"user");
        System.out.println("[TEST PASSED] All users obtained successfully");
    }


    @Test(priority = 10,dataProviderClass = UserDataProvider.class, dataProvider = "addUsersParameters")
    public void addUser(String body){
        Response response = RequestTemplate.postRequest(MyConstants.url+"user", body);
        System.out.println("[TEST PASSED] User " + UserDataProvider.addUser(response) + " added successfully");
    }

    @Test(priority = 15,dataProviderClass = UserDataProvider.class, dataProvider = "deleteUsersParameters")
    public void getUserbyId(int id){
        RequestTemplate.getRequest(MyConstants.url+"user/"+id);
        System.out.println("[TEST PASSED] User " + id + " obtained successfully");
    }

    @Test(priority = 20,dataProviderClass = UserDataProvider.class, dataProvider = "updateUsersParameters")
    public void updateUser(String body, int id){
        RequestTemplate.putRequest(MyConstants.url+"user/"+id, body);
        System.out.println("[TEST PASSED] User " + id + " updated successfully");
    }

    @Test(priority = 25,dataProviderClass = UserDataProvider.class, dataProvider = "deleteUsersParameters")
    public void deleteUser(int id){
        Response response = RequestTemplate.deleteRequest(MyConstants.url+"user/"+id);
        System.out.println("[TEST PASSED] User " + id + " deleted successfully");
    }

}
