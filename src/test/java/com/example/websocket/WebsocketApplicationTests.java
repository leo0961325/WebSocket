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

        String example2 = "{\n" +
                " \"copy\":{\n" +
                "   \"key\":\"copyKey\",\n" +
                "   \"value\":\"copyValue\"\n" +
                "  }\n" +
                "}\n";

        JSONObject jsonObject = new JSONObject(example); //obj1
        JSONObject jsonObjectForCopy = new JSONObject(example2); //obj2

        JSONObject mergeJson = new JSONObject(jsonObject,JSONObject.getNames(jsonObject)); //for merge use

//        this will return JsonObj keys
//        String[] strings = JSONObject.getNames(jsonObject);

        for(String key : JSONObject.getNames(jsonObjectForCopy)){
            mergeJson.put(key,jsonObjectForCopy.get(key));
            System.out.println(mergeJson);
        }


    }

}
