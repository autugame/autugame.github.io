package com.vince.xml.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonDemo3 {

    @Test
    public void gson2() {
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/xml/json/name.json");
        InputStreamReader in = new InputStreamReader(is);
        TypeToken<List<Name>> typeToken = new TypeToken<List<Name>>() {};
        List<Name> list = gson.fromJson(in, typeToken.getType());
        System.out.println(list);

        String s = gson.toJson(list, typeToken.getType());
        System.out.println(s);
    }

    @Test
    public void gson1() {
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/xml/json/names.json");
        InputStreamReader in = new InputStreamReader(is);
        Name name = gson.fromJson(in, Name.class);
        System.out.println(name);

        String json = gson.toJson(name);
        System.out.println(json);
    }

    @Test
    public void createJSON() {
        List<Name> list = new ArrayList<>();
        list.add(new Name("vince", "ma", "1783748@qq.com"));
        list.add(new Name("jack", "wang", "jeck@qq.com"));
        JsonArray array = new JsonArray();
        for (Name n : list) {
            JsonObject obj = new JsonObject();
            obj.addProperty("firstName", n.getFirstName());
            obj.addProperty("lastName", n.getLastName());
            obj.addProperty("email", n.getEmail());
            array.add(obj);
        }
        System.out.println(array.toString());
    }
}
