package io.corecode.testing.dataProviders;

import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import  io.corecode.testing.model.Book;
import io.corecode.testing.MyConstants;
import java.util.List;
import com.google.gson.reflect.TypeToken;

public class DataProvidersClass {

    @DataProvider(name = "addBookParameters")
    public Iterator<Object[]> addBookParameters() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < 1; i++){
            JSONObject bodyContent = new JSONObject();
            bodyContent.put("title","dataQA"+i);
            bodyContent.put("writerId", 1);
            bodyContent.put("cover","cover"+i);
            bodyContent.put("picture","picture"+i);
            bodyContent.put("publisherId",1);
            bodyContent.put("description","Book using for integation test"+i);
            data.add(new Object[]{bodyContent.toString()});
        }
        return data.iterator();
    }

    @DataProvider(name = "updateBookParameters")
    public Iterator<Object[]> updateBookParameters() throws Exception {
        List<Book> books= getAllBooks();
        Collection<Object[]> data = new ArrayList<>();
        for (Book book: books){
            if (book.getTitle().contains("dataQA")){
                JSONObject bodyUpdate = new JSONObject();
                bodyUpdate.put("title","dataQAupdate"+book.getBookId());
                bodyUpdate.put("writerId", 2);
                bodyUpdate.put("cover","cover");
                bodyUpdate.put("picture","picture");
                bodyUpdate.put("publisherId",2);
                bodyUpdate.put("description","Book update for integation test");
                data.add(new Object[]{bodyUpdate.toString(),book.getBookId()});
            }
        }
        return data.iterator();
    }

    @DataProvider(name = "deleteBookParameters")
    public Iterator<Object[]> deleteBookParameters() throws Exception {
        List<Book> books= getAllBooks();
        Collection<Object[]> data = new ArrayList<>();
        for (Book book: books){
            if (book.getTitle().contains("dataQA"))
                data.add(new Object[]{book.getBookId()});
        }
        return data.iterator();
    }

    public List<Book> getAllBooks() throws Exception {
        HttpResponse<String> response = Unirest.get(MyConstants.url + "book").asString();
        Type booksListType = new TypeToken<ArrayList<Book>>() {
        }.getType();
        Gson gson = new Gson();
        List<Book> list = gson.fromJson(response.getBody(), booksListType);
        return list;
    }
}
