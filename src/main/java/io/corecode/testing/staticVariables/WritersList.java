package io.corecode.testing.staticVariables;

import com.google.gson.Gson;
import io.corecode.testing.model.Writer;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class WritersList {
    private static List<Integer> writersAdded= new ArrayList<Integer>();
    public static int addWriter(Response response){
        int id = new Gson().fromJson(response.asString(), Writer.class).getWriterId();
        writersAdded.add(id);
        return id;
    }
    public static List<Integer> getWriterAdded(){
        return writersAdded;
    }
}
