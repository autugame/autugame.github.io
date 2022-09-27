package com.vince.xml.json;

import com.google.gson.stream.JsonReader;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONDemo {

    @Test
    public void parseJSONName() {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/xml/json/name.json");
        InputStreamReader in = new InputStreamReader(is);
        JsonReader reader = new JsonReader(in);
        ArrayList<Name> list = new ArrayList<>();
        try {
            reader.beginArray();
            while (reader.hasNext()) {
                list.add(parseName(reader));
            }
            reader.endArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    private Name parseName(JsonReader jsonReader) {
        Name name = null;
        try {
            jsonReader.beginObject();
            name = new Name();
            while (jsonReader.hasNext()) {
                String attrName = jsonReader.nextName();
                if ("firstName".equals(attrName)) {
                    name.setFirstName(jsonReader.nextString());
                } else if ("lastName".equals(attrName)) {
                    name.setLastName(jsonReader.nextString());
                } else if ("email".equals(attrName)) {
                    name.setEmail(jsonReader.nextString());
                }
            }
            jsonReader.endObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return name;
    }
}
