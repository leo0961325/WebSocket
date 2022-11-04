package com.example.websocket;

import com.example.websocket.model.requestEntity.SocialMessageRequestEntity;
import com.example.websocket.model.template.WhatsappMessageTemplate;
import com.example.websocket.model.template.WhatsappMessageTemplateExtension;
import com.example.websocket.model.template.WhatsappTemplateButton;
import com.example.websocket.model.template.WhatsappTemplateComponent;
import com.example.websocket.model.template.WhatsappTemplateExtensionEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SpringBootTest
class WhatsAppTemplatesTests {

    @Test
    void contextLoads() throws JSONException {

        String example = "{\n" + "\t\"id\": \"0001\",\n" + "\t\"type\": \"donut\",\n" + "\t\"name\": \"Cake\",\n" + "\t\"image\":\n" + "\t\t{\n" + "\t\t\t\"url\": \"images/0001.jpg\",\n" + "\t\t\t\"width\": 200,\n" + "\t\t\t\"height\": 200\n" + "\t\t},\n" + "\t\"thumbnail\":\n" + "\t\t{\n" + "\t\t\t\"url\": \"images/thumbnails/0001.jpg\",\n" + "\t\t\t\"width\": 32,\n" + "\t\t\t\"height\": 32\n" + "\t\t}\n" + "}";

        String example2 = "{\n" + " \"copy\":{\n" + "   \"key\":\"copyKey\",\n" + "   \"value\":\"copyValue\"\n" + "  }\n" + "}\n";

        JSONObject jsonObject = new JSONObject(example); //obj1
        JSONObject jsonObjectForCopy = new JSONObject(example2); //obj2

        //Copy new one for merge use
//        JSONObject mergeJson = new JSONObject(jsonObject,JSONObject.getNames(jsonObject));

//        this will return JsonObj keys
//        String[] strings = JSONObject.getNames(jsonObject);

//        for(String key : JSONObject.getNames(jsonObjectForCopy)){
//            mergeJson.put(key,jsonObjectForCopy.get(key));
//            System.out.println(mergeJson);
//        }
    }


    @Test
    void formatTemplateTest() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        WhatsappMessageTemplateExtension whatsappMessageTemplateExtension = new WhatsappMessageTemplateExtension();
        WhatsappMessageTemplateExtension.messageContent messageContent = new WhatsappMessageTemplateExtension.messageContent();
        WhatsappMessageTemplateExtension.messageContent.Button button = new WhatsappMessageTemplateExtension.messageContent.Button();
        button.setTitle("title1");
        button.setUrl("google.com");
        button.setType("1");

        WhatsappMessageTemplateExtension.messageContent.Button button2 = new WhatsappMessageTemplateExtension.messageContent.Button();
        button2.setTitle("title2");
        button2.setUrl("facebook");
        button2.setType("2");

        List<WhatsappMessageTemplateExtension.messageContent.Button> buttonList = new ArrayList<>();
        buttonList.add(button);
        buttonList.add(button2);
        messageContent.setButtons(buttonList);
        whatsappMessageTemplateExtension.setMessageContent(messageContent);
        String toJSON = objectMapper.writeValueAsString(whatsappMessageTemplateExtension);

        System.out.println(toJSON);
    }

    /**
     * 總共有三種要處理
     * 1.有header   format=IMAGE/VIDEO/DOCUMENT  有 button
     * 2.沒header   format=IMAGE/VIDEO/DOCUMENT  有 button
     * 3.其餘 的
     */
    @Test
    void formatTemplateToJson() throws JsonProcessingException {

        /**
         * must take off _id;
         */
        String template =
                            "{\n" +
                                    "    \"id\" : \"378881204331613\",\n" +
                                    "    \"team\" : \"Easychat-2\",\n" +
                                    "    \"accId\" : \"24e3c17b-fa49-403a-a3de-398831f39394\",\n" +
                                    "    \"type\" : \"template\",\n" +
                                    "    \"name\" : \"doc_test\",\n" +
                                    "    \"namespace\" : \"904212ab_d06f_4441_b3af_5fd57f10709b\",\n" +
                                    "    \"components\" : [ \n" +
                                    "        {\n" +
                                    "            \"type\" : \"HEADER\",\n" +
                                    "            \"format\" : \"DOCUMENT\",\n" +
                                    "            \"example\" : {\n" +
                                    "                \"header_handle\" : [ \n" +
                                    "                    \"https://scontent.whatsapp.net/v/t61.29466-34/299826941_378881207664946_3677727754011328572_n.pdf?ccb=1-7&_nc_sid=57045b&_nc_ohc=Z9RKJJqtK8gAX8KmUGU&_nc_ht=scontent.whatsapp.net&edm=AH51TzQEAAAA&oh=01_AdQY7snJMIAYjDmT3XMtGUgeeLt83eaksftdeguTN-fMow&oe=6383233C\"\n" +
                                    "                ]\n" +
                                    "            }\n" +
                                    "        }, \n" +
                                    "        {\n" +
                                    "            \"type\" : \"BODY\",\n" +
                                    "            \"text\" : \"\uD83D\uDE06123\"\n" +
                                    "        }, \n" +
                                    "        {\n" +
                                    "            \"type\" : \"FOOTER\",\n" +
                                    "            \"text\" : \"456\"\n" +
                                    "        }, \n" +
                                    "        {\n" +
                                    "            \"type\" : \"BUTTONS\",\n" +
                                    "            \"buttons\" : [ \n" +
                                    "                {\n" +
                                    "                    \"type\" : \"PHONE_NUMBER\",\n" +
                                    "                    \"text\" : \"click me\",\n" +
                                    "                    \"phone_number\" : \"+886965667678\"\n" +
                                    "                }\n" +
                                    "            ]\n" +
                                    "        }\n" +
                                    "    ],\n" +
                                    "    \"template\" : \"\uD83D\uDE06123\",\n" +
                                    "    \"language\" : \"zh_TW\",\n" +
                                    "    \"category\" : \"TRANSACTIONAL\",\n" +
                                    "    \"status\" : \"APPROVED\"\n" +
                                    "}";

        String requestBody = "{\n" +
                "    \"messageId\": \"336af3b0-c229-4514-b066-2c96b8d0880d\",\n" +
                "    \"fromUsername\": null,\n" +
                "    \"roomId\": \"wh24e3c17b-fa49-403a-a3de-398831f39394-886979611619\",\n" +
                "    \"body\": \"\uD83D\uDE06123\",\n" +
                "    \"type\": 602,\n" +
                "    \"extraData\": {\n" +
                "        \"namespace\": \"904212ab_d06f_4441_b3af_5fd57f10709b\",\n" +
                "        \"language\": {\n" +
                "            \"code\": \"zh_TW\",\n" +
                "            \"policy\": \"deterministic\"\n" +
                "        },\n" +
                "        \"name\": \"doc_test\",\n" +
                "        \"components\": [\n" +
                "            {\n" +
                "                \"type\": \"header\",\n" +
                "                \"parameters\": [\n" +
                "                    {\n" +
                "                        \"type\": \"document\",\n" +
                "                        \"document\": {\n" +
                "                            \"link\": \"https://s3-ap-southeast-1.amazonaws.com/uat-caas-media-storage/upload/photos/user-upload-whatsapp-media/fb04e0e8-4004-4417-b6f3-e464b48813e7-24425fb24c1b44659b8fcd551a775a4e/24425fb24c1b44659b8fcd551a775a4e.pdf\",\n" +
                "                            \"filename\": \"test.pdf\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": \"body\",\n" +
                "                \"parameters\": []\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        WhatsappMessageTemplate whatsappMessageTemplate = objectMapper.readValue(template, WhatsappMessageTemplate.class);
//        for(WhatsappTemplateComponent component : whatsappMessageTemplate.getComponents()){
//            System.out.println(component.getType());
//        }
        List<WhatsappTemplateComponent> componentList = whatsappMessageTemplate.getComponents();

        SocialMessageRequestEntity requestEntity = objectMapper.readValue(requestBody, SocialMessageRequestEntity.class);

        WhatsappTemplateExtensionEntity whatsappTemplateExtensionEntity = new WhatsappTemplateExtensionEntity();
        whatsappTemplateExtensionEntity.setBody(requestEntity.getBody());
        whatsappTemplateExtensionEntity.setExtraData(requestEntity.getExtraData());

        String Json = handleTemplateToExtension(componentList, whatsappTemplateExtensionEntity);

        System.out.println(Json);
    }

    public static String handleTemplateToExtension(List<WhatsappTemplateComponent> componentList, WhatsappTemplateExtensionEntity whatsappTemplateExtensionEntity) throws JsonProcessingException {

        WhatsappMessageTemplateExtension templateExtension = new WhatsappMessageTemplateExtension();
        WhatsappMessageTemplateExtension.messageContent messageContent = new WhatsappMessageTemplateExtension.messageContent();

        try {

            List<String> componentTypeList = componentList.stream()
                                                          .map(WhatsappTemplateComponent::getType)
                                                          .collect(Collectors.toList());

            Boolean hasMediaHeader = componentList.stream()
                    .filter(c -> c.getType().equals(WhatsappTemplateComponent.TYPE_HEADER))
                    .anyMatch(component -> (component.getFormat().equals(WhatsappTemplateComponent.TYPE_HEADER_FORMAT_IMAGE) ||
                            component.getFormat().equals(WhatsappTemplateComponent.TYPE_HEADER_FORMAT_VIDEO) ||
                            component.getFormat().equals(WhatsappTemplateComponent.TYPE_HEADER_FORMAT_DOCUMENT)));


            Boolean matchFormat = componentList.stream()
                                               .filter(c -> c.getType()
                                               .equals(WhatsappTemplateComponent.TYPE_HEADER)).anyMatch(component -> (component.getFormat().equals(WhatsappTemplateComponent.TYPE_HEADER_FORMAT_IMAGE) || component.getFormat().equals(WhatsappTemplateComponent.TYPE_HEADER_FORMAT_VIDEO) || component.getFormat().equals(WhatsappTemplateComponent.TYPE_HEADER_FORMAT_DOCUMENT)));

            Boolean isCarousel = componentTypeList.contains(WhatsappTemplateComponent.TYPE_BUTTONS) &&
                                 componentTypeList.contains(WhatsappTemplateComponent.TYPE_HEADER) &&
                                 hasMediaHeader &&
                                 matchFormat;

            Boolean isHeaderTemplate = componentTypeList.contains(WhatsappTemplateComponent.TYPE_HEADER) &&
                                      !componentTypeList.contains(WhatsappTemplateComponent.TYPE_BUTTONS) &&
                                      matchFormat;

            Boolean isButtonTemplate = componentTypeList.contains(WhatsappTemplateComponent.TYPE_BUTTONS) &&
                                       !componentTypeList.contains(WhatsappTemplateComponent.TYPE_HEADER) &&
                                       !hasMediaHeader &&
                                       !matchFormat;



            if(isCarousel){
                templateExtension.setMessageFormat(WhatsappMessageTemplateExtension.CAROUSEL);
            }
            if (isButtonTemplate){
                templateExtension.setMessageFormat(WhatsappMessageTemplateExtension.BUTTON_TEMPLATE);
            }

            String headerText = "";
            String headerParam = "";
            String footerText = "";
            List<WhatsappMessageTemplateExtension.messageContent.Button> buttonList = new ArrayList<>();
            for (WhatsappTemplateComponent component : componentList) {

                if (isCarousel || isHeaderTemplate || isButtonTemplate) {


                        try {
                        if (component.getType().equals(WhatsappTemplateComponent.TYPE_HEADER )&& hasMediaHeader) {
                            messageContent.setMediaType(component.getFormat());
                        }
                        String buttonParam = "";
                        Gson gson = new Gson();
                        String json = gson.toJson(whatsappTemplateExtensionEntity.getExtraData());
                        JSONObject jsonObject = new JSONObject(json);
                        JSONArray components = jsonObject.optJSONArray("components");

                        if (null != components) {

                            for (int i = 0; i < components.length(); i++) {

                                JSONObject compJSON = components.getJSONObject(i);
                                //get requestbody > extraData > components > type = header > parameters
                                if (hasMediaHeader && compJSON.get("type").equals("header")) {
                                    JSONArray parameters = compJSON.getJSONArray("parameters");
                                    for(int m = 0 ; m < parameters.length() ; m ++){
                                        String type = parameters.getJSONObject(m).optString("type");
                                        if(parameters.getJSONObject(m).has(type)){
                                            String mediaUrl = parameters.optJSONObject(m).optJSONObject(type).optString("link");
                                            messageContent.setMediaUrl(mediaUrl);
                                        }
                                        if(type.equals("document")){
                                            String mediaFileName = parameters.optJSONObject(m).optJSONObject(type).optString("filename");
                                            messageContent.setMediaFilename(mediaFileName);
                                        }
                                    }
                                }

                                if (compJSON.get("type").equals("button")) {
                                    JSONArray buttonParameters = compJSON.getJSONArray("parameters");
                                    for (int k = 0; k < buttonParameters.length(); k++) {
                                        try {
                                            buttonParam = buttonParameters.optJSONObject(k).optString("text");
                                        } catch (NullPointerException exception) {
                                            //TODO ADD LOG
                                        }
                                    }
                                }


                            }
                        }
                        if (Objects.nonNull(component.getButtons())) {
                            for (WhatsappTemplateButton templateButton : component.getButtons()) {
                                WhatsappMessageTemplateExtension.messageContent.Button button = new WhatsappMessageTemplateExtension.messageContent.Button();
                                button.setTitle(templateButton.getText());

                                if (templateButton.getType().equals(WhatsappTemplateButton.TYPE_URL)) {
                                    button.setType(WhatsappTemplateButton.TYPE_URL);
                                } else if (templateButton.getType().equals(WhatsappTemplateButton.TYPE_QUICK_REPLY)) {
                                    button.setType(WhatsappTemplateButton.TYPE_QUICK_REPLY);
                                } else if (templateButton.getType().equals(WhatsappTemplateButton.TYPE_PHONE_NUMBER)) {
                                    button.setType(WhatsappTemplateButton.TYPE_PHONE_NUMBER);
                                }
                                //如果requestbody url有傳參數的話
                                if (templateButton.getType().equals(WhatsappTemplateButton.TYPE_URL)) {
                                    if (StringUtils.isNotBlank(buttonParam)) {
                                        String[] splitUrls = templateButton.getUrl().split("[?url]");
                                        String url = splitUrls[0];
                                        String urlAndParam = url + "?url=" + buttonParam;
                                        button.setUrl(urlAndParam);
                                    } else {
                                        button.setUrl(templateButton.getUrl());
                                    }

                                }
                                if(templateButton.getType().equals(WhatsappTemplateButton.TYPE_PHONE_NUMBER)){
                                    button.setPhoneNumber(templateButton.getPhone_number());
                                }
                                buttonList.add(button);
                            }
                        }
                    }catch (Exception ex){
                        //TODO
                    }
                        messageContent.setButtons(buttonList);
                    }else {
                        templateExtension.setMessageFormat(WhatsappMessageTemplateExtension.TEXT);
                        Gson gson = new Gson();
                        String json = gson.toJson(whatsappTemplateExtensionEntity.getExtraData());
                        JSONObject jsonObject = new JSONObject(json);
                        JSONArray components = jsonObject.optJSONArray("components");

                        if (null != components) {

                            for (int i = 0; i < components.length(); i++) {
                                JSONObject compJSON = components.getJSONObject(i);
                                if (compJSON.get("type").equals("header")) {
                                    JSONArray parameters = compJSON.getJSONArray("parameters");
                                    for(int m = 0 ; m < parameters.length() ; m ++){
                                        String type = parameters.getJSONObject(m).getString("type");
                                        if(type.equals("text")){
                                            headerParam = parameters.optJSONObject(m).getString("text");
                                        }
                                    }
                                }
                            }
                            {
                            }
                        }
                    }
                if (component.getType().equals(WhatsappTemplateComponent.TYPE_HEADER)) {
                    if(component.getFormat().equals(WhatsappTemplateComponent.TYPE_HEADER_FORMAT_TEXT)){
                        headerText = component.getText();
                    }
                }
                if(component.getType().equals(WhatsappTemplateComponent.TYPE_FOOTER)){
                    footerText = component.getText();
                }
            }

            if(StringUtils.isNotBlank(headerText)){
                if(headerText.contains("{{1}}")){
                    String assembleHeader = headerText.replace("{{1}}",headerParam);
                    messageContent.setHeader(assembleHeader);
                }else {
                    messageContent.setHeader(headerText);
                }
            }
            messageContent.setBody(whatsappTemplateExtensionEntity.getBody());
            if(StringUtils.isNotBlank(footerText)){
                messageContent.setFooter(footerText);
            }
            templateExtension.setMessageContent(messageContent);

        } catch (Exception ex) {
            //TODO add log
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String templateExtensionString = objectMapper.writeValueAsString(templateExtension);
        return templateExtensionString;
    }

    @Test
    void parseFormatTest() throws JSONException, IOException {

        String requestBody = "{\n" +
                "    \"messageId\": \"d2efa2ec-084a-42f2-bb8b-364d7d51073c\",\n" +
                "    \"fromUsername\": null,\n" +
                "    \"roomId\": \"wh24e3c17b-fa49-403a-a3de-398831f39394-886979611619\",\n" +
                "    \"body\": \"1<br>2<br>3<br><br>If you do not want to receive WhatsApp message, please send \\\"Unsubscribe\\\"\",\n" +
                "    \"type\": 602,\n" +
                "    \"extraData\": {\n" +
                "        \"namespace\": \"904212ab_d06f_4441_b3af_5fd57f10709b\",\n" +
                "        \"language\": {\n" +
                "            \"code\": \"en_US\",\n" +
                "            \"policy\": \"deterministic\"\n" +
                "        },\n" +
                "        \"name\": \"cart_abandonment_reminder_uat_test_1_en\",\n" +
                "        \"components\": [\n" +
                "            {\n" +
                "                \"type\": \"header\",\n" +
                "                \"parameters\": [\n" +
                "                    {\n" +
                "                        \"type\": \"image\",\n" +
                "                        \"image\": {\n" +
                "                            \"link\": \"https://s3-ap-southeast-1.amazonaws.com/uat-caas-media-storage/upload/photos/user-upload-photo/fb04e0e8-4004-4417-b6f3-e464b48813e7-0d0b9e91cd494b07a63454322355f0e0.jpg\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": \"button\",\n" +
                "                \"sub_type\": \"url\",\n" +
                "                \"index\": \"0\",\n" +
                "                \"parameters\": [\n" +
                "                    {\n" +
                "                        \"type\": \"text\",\n" +
                "                        \"text\": \"www.yahoo.com.tw\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": \"body\",\n" +
                "                \"parameters\": [\n" +
                "                    {\n" +
                "                        \"type\": \"text\",\n" +
                "                        \"text\": \"1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"type\": \"text\",\n" +
                "                        \"text\": \"2\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"type\": \"text\",\n" +
                "                        \"text\": \"3\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";

            String parseJson = "[\n" +
                    "{\n" +
                    "\"type\":\"header\",\n" +
                    "\"parameters\":[\n" +
                    "{\n" +
                    "\"image\":{\n" +
                    "\"link\":\"https://s3-ap-southeast-1.amazonaws.com/uat-caas-media-storage/upload/photos/user-upload-photo/fb04e0e8-4004-4417-b6f3-e464b48813e7-5572aec119c24c448d29d2ecbdd3bc6f.jpg\"\n" +
                    "},\n" +
                    "\"type\":\"image\"\n" +
                    "}\n" +
                    "]\n" +
                    "},\n" +
                    "{\n" +
                    "\"sub_type\":\"url\",\n" +
                    "\"index\":0,\n" +
                    "\"type\":\"button\",\n" +
                    "\"parameters\":[\n" +
                    "{\n" +
                    "\"text\":\"www.facebook.com.tw\",\n" +
                    "\"type\":\"text\"\n" +
                    "}\n" +
                    "]\n" +
                    "},\n" +
                    "{\n" +
                    "\"type\":\"body\",\n" +
                    "\"parameters\":[\n" +
                    "{\n" +
                    "\"text\":\"QWERTY\",\n" +
                    "\"type\":\"text\"\n" +
                    "},\n" +
                    "{\n" +
                    "\"text\":\"QWERTY\",\n" +
                    "\"type\":\"text\"\n" +
                    "},\n" +
                    "{\n" +
                    "\"text\":\"QWERTY\",\n" +
                    "\"type\":\"text\"\n" +
                    "}\n" +
                    "]\n" +
                    "}\n" +
                    "],";

            Gson gson = new Gson();
            JSONArray component = new JSONArray(parseJson);
            WhatsappTemplateExtensionEntity whatsappTemplateExtensionEntity = covertToEntityExtraData(component);

            String json = gson.toJson(whatsappTemplateExtensionEntity.getExtraData());
            JSONObject jsonObject = new JSONObject(json);
            JSONArray components = jsonObject.optJSONArray("components");
            System.out.println(components);

    }
    public static WhatsappTemplateExtensionEntity covertToEntityExtraData(JSONArray components) throws IOException{

        try {

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("components",components);
            JSONObject object = new JSONObject();
            object.put("extraData",jsonObj);
            ObjectMapper objectMapper = new ObjectMapper();
            WhatsappTemplateExtensionEntity whatsappTemplateExtensionEntity = objectMapper.readValue(object.toString(), WhatsappTemplateExtensionEntity.class);

            return whatsappTemplateExtensionEntity;
        }catch (JSONException ex){
            ex.getCause();
        }
        return new WhatsappTemplateExtensionEntity();



    }

    @Test
    void TestuserName(){

        String param = "param";
        String test = "開頭 {{1}} 這裡有變數";
        StringBuilder builder = new StringBuilder();
        if(test.contains("{{1}}")){
            String replace = test.replace("{{1}}", param);
            System.out.println(replace);
        }
    }

    @Test
    void parseStringExtension() throws JSONException, ParseException {

        String ext2 = "{\n" +
                "        \"messageFormat\" : \"carousel\",\n" +
                "        \"messageContent\" : {\n" +
                "            \"buttons\" : [ \n" +
                "                {\n" +
                "                    \"title\" : \"View Product\",\n" +
                "                    \"type\" : \"URL\",\n" +
                "                    \"url\" : \"https://api.omnichat.ai/?url=www.facebook.com.tw\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"mediaUrl\" : \"https://s3-ap-southeast-1.amazonaws.com/uat-caas-media-storage/upload/photos/user-upload-photo/fb04e0e8-4004-4417-b6f3-e464b48813e7-ec68bfcaafc44cdcad07b768fd0f4fd2.jpg\",\n" +
                "            \"mediaType\" : \"IMAGE\",\n" +
                "            \"body\" : \"ＣＳ<br>sdgdg<br>awfawf<br><br>If you do not want to receive WhatsApp message, please send \\\"Unsubscribe\\\"\"\n" +
                "        }\n" +
                "    }";

        try {
            //to satisfy json format ,to handle Double quotes in string
            String toJson = ext2.replace("\\\"", "\"");
            toJson = toJson.replace("\\","tempToReplace");
            toJson = toJson.replaceAll("tempToReplacetempToReplace","\\\\");
            JSONObject jsonObject = new JSONObject(toJson);
            System.out.println("!!!!!" + jsonObject);
            handleJsonData(jsonObject);
        }catch (JSONException e){
            try {
                String replace = ext2.replace("\t", "");
                JsonParser parser = new JsonParser();
                String toJson = parser.parse(replace).toString();
                JSONObject jsonObject = new JSONObject(toJson);
                System.out.println("@@@@@"+jsonObject);
                handleJsonData(jsonObject);
            }catch (Exception exception){

            }
        }
  }

    private void handleJsonData(JSONObject jsonObject) throws JSONException {
        String messageFormat = jsonObject.getString("messageFormat");
        if (Objects.equals(messageFormat, "carousel")) {
            JSONObject msgContentObj = jsonObject.getJSONObject("messageContent");
            String mediaUrl = msgContentObj.getString("mediaUrl");
            String mediaType = msgContentObj.getString("mediaType").toLowerCase();
            System.out.println(mediaUrl);
            System.out.println(mediaType);
        }
}
}


