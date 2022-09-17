package com.example.websocket;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebsocketApplicationTests {

    @Test
    void contextLoads() throws JSONException {

        String example = "{\n" +
                "\t\"id\": \"0001\",\n" +
                "\t\"type\": \"donut\",\n" +
                "\t\"name\": \"Cake\",\n" +
                "\t\"image\":\n" +
                "\t\t{\n" +
                "\t\t\t\"url\": \"images/0001.jpg\",\n" +
                "\t\t\t\"width\": 200,\n" +
                "\t\t\t\"height\": 200\n" +
                "\t\t},\n" +
                "\t\"thumbnail\":\n" +
                "\t\t{\n" +
                "\t\t\t\"url\": \"images/thumbnails/0001.jpg\",\n" +
                "\t\t\t\"width\": 32,\n" +
                "\t\t\t\"height\": 32\n" +
                "\t\t}\n" +
                "}";

        JSONObject jsonObject = new JSONObject(example);
        String[] strings = JSONObject.getNames(jsonObject);
        for(String key : strings){
            System.out.println(key);
        }


    }

}
