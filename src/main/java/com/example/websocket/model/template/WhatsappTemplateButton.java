package com.example.websocket.model.template;

import java.util.List;

public class WhatsappTemplateButton {

    public static final String TYPE_PHONE_NUMBER = "PHONE_NUMBER";
    public static final String TYPE_URL = "URL";
    public static final String TYPE_QUICK_REPLY = "QUICK_REPLY";
    public static final String POSTBACK = "postback";

    // Values: PHONE_NUMBER, URL, and QUICK_REPLIES
    private String type;

    // The text to be displayed on the button
    private String text;

    // The URL that will be visited on clicking the button
    private String url;

    // The phone number that will be called on clicking the button
    private String phone_number;

    // example to be submitted to whatsapp for approval
    private List<String> example;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public List<String> getExample() {
        return example;
    }

    public void setExample(List<String> example) {
        this.example = example;
    }
}
