package integrationTesting;

import com.google.gson.Gson;
import io.corecode.testing.dataProviders.DataProvidersClass;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.corecode.testing.MyConstants;
import io.restassured.response.Response;
import io.corecode.testing.model.Book;
import org.testng.annotations.Test;


public class BooksTest {

    @Test(priority = 5)
    public void getBooks(){

        Response response = RequestTemplate.getRequest(MyConstants.url+"book");
        String responseString=response.asString();
        Gson gson = new Gson();
        Book[] books = gson.fromJson(responseString,Book[].class);
        for (int i = 0; i < books.length; i ++){
            Book book =  books[i];
            System.out.println(book.getBookId());
        }
    }

    @Test(priority = 6)
    public void getBookbyId(){
        Response response = RequestTemplate.getRequest(MyConstants.url+"book/1");
        String responseString=response.asString();
        Gson gson = new Gson();
        Book book = gson.fromJson(responseString, Book.class);
        System.out.println(book.getBookId());
    }

    @Test(priority = 7,dataProviderClass = DataProvidersClass.class, dataProvider = "addBookParameters")
    public void addBook(String body){
        Response response = RequestTemplate.postRequest(MyConstants.url+"book", body);
        String responseString=response.asString();
        System.out.println(responseString);
    }

    @Test(priority = 8,dataProviderClass = DataProvidersClass.class, dataProvider = "updateBookParameters")
    public void updateBook(String body, int id){
        Response response = RequestTemplate.putRequest(MyConstants.url+"book/"+id, body);
        System.out.println(response.asString());
        System.out.println(id);
    }

    @Test(priority = 9,dataProviderClass = DataProvidersClass.class, dataProvider = "deleteBookParameters")
    public void deleteBook(int id){
        Response response = RequestTemplate.deleteRequest(MyConstants.url+"book/"+id);
        String responseString = response.asString();
        System.out.println(responseString);
        System.out.println(id);
    }

}
