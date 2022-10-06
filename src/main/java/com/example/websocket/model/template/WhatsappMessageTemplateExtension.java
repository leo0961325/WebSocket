package com.example.websocket.model.template;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WhatsappMessageTemplateExtension {

    public static final String CAROUSEL = "carousel";
    public static final String BUTTON_TEMPLATE = "buttonTemplate";
    public static final String TEXT = "text";

    private String messageFormat;

    private messageContent messageContent;


    public String getMessageFormat() {
        return messageFormat;
    }

    public void setMessageFormat(String messageFormat) {
        this.messageFormat = messageFormat;
    }

    public WhatsappMessageTemplateExtension.messageContent getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(WhatsappMessageTemplateExtension.messageContent messageContent) {
        this.messageContent = messageContent;
    }

    /**
     * inner class messageContent
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class messageContent {

        private List<Button> buttons;
        private String mediaUrl;
        private String mediaType;
        private String title;

        public List<Button> getButtons() {
            return buttons;
        }

        public void setButtons(List<Button> buttons) {
            this.buttons = buttons;
        }

        public String getMediaUrl() {
            return mediaUrl;
        }

        public void setMediaUrl(String mediaUrl) {
            this.mediaUrl = mediaUrl;
        }

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * inner class button
         */
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Button {

            private String title;
            private String type;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
