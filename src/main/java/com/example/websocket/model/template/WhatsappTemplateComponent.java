package com.example.websocket.model.template;

import java.util.List;

public class WhatsappTemplateComponent {

    public static final String TYPE_BODY = "BODY";
    public static final String TYPE_HEADER = "HEADER";
    public static final String TYPE_FOOTER = "FOOTER";
    public static final String TYPE_BUTTONS = "BUTTONS";

    public static final String TYPE_HEADER_FORMAT_TEXT = "TEXT";
    public static final String TYPE_HEADER_FORMAT_IMAGE = "IMAGE";
    public static final String TYPE_HEADER_FORMAT_DOCUMENT = "DOCUMENT";
    public static final String TYPE_HEADER_FORMAT_VIDEO = "VIDEO";

    // Values: BODY, HEADER, FOOTER. and BUTTONS
    // Note: The character limit of the BODY component is 1024 characters,
    // while the character limits of the HEADER and FOOTER components is 60 characters each.
    private String type;

    // Only applies to the HEADER type
    // Values: TEXT, IMAGE, DOCUMENT, VIDEO
    private String format;

    // Text of the message being sent
    private String text;

    private List<WhatsappTemplateButton> buttons;

    private Object example;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<WhatsappTemplateButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<WhatsappTemplateButton> buttons) {
        this.buttons = buttons;
    }

    public Object getExample() {
        return example;
    }

    public void setExample(Object example) {
        this.example = example;
    }
}
