package io.corecode.testing.dataProviders;

import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class WriterDataProvider {

    public static List<Integer> writersAdded;
    private int limit = 2;

    @DataProvider(name = "getWriters")
    public Iterator<Object[]> getWriters() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < this.limit; i++){
            JSONObject bodyContent = new JSONObject();
            bodyContent.put("name","writer qa test"+i);
            data.add(new Object[]{bodyContent.toString()});
        }
        return data.iterator();
    }
    @DataProvider(name = "getUpdateWriters")
    public Iterator<Object[]> getUpdateWritersAdded() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < writersAdded.size(); i++){
            JSONObject bodyContent = new JSONObject();
            bodyContent.put("name","writer qa update test "+i);
            data.add(new Object[]{writersAdded.get(i),bodyContent.toString()});
        }
        return data.iterator();
    }
    @DataProvider(name = "getWritersAdded")
    public Iterator<Object[]> getWritersAdded() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < writersAdded.size(); i++){
            data.add(new Object[]{writersAdded.get(i)});
        }
        return data.iterator();
    }

}
