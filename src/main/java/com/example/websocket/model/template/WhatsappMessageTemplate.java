package com.example.websocket.model.template;

import java.util.List;

public class WhatsappMessageTemplate {

    public static final String COLLECTION_NAME = "whatsappMessageTemplate";
    public static final String FIELD_TEAM = "team";
    public static final String FIELD_ACC_ID = "accId";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_ID = "id";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_NAMESPACE = "namespace";
    public static final String FIELD_COMPONENTS = "components";
    public static final String FIELD_TEMPLATE = "template";
    public static final String FIELD_LANGUAGE = "language";
    public static final String FIELD_CATEGORY = "category";

    public static final String TYPE_HSM = "hsm";
    public static final String TYPE_TEMPLATE = "template";

    public static final String STATUS_REJECTED = "REJECTED";
    public static final String STATUS_APPROVED = "APPROVED";
    public static final String STATUS_PENDING = "PENDING";

    public static final String LANGUAGE_POLICY_FALLBACK = "fallback";
    public static final String LANGUAGE_POLICY_DETERMINISTOC = "deterministic";

    private String id;

    private String team;

    private String accId;

    private String type = TYPE_TEMPLATE;

    private String name;

    private String namespace;

    private List<WhatsappTemplateComponent> components;

    private String template;

    private String language;

    private String category;

    private String status;

    public WhatsappMessageTemplate(){

    }



    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public List<WhatsappTemplateComponent> getComponents() {
        return components;
    }

    public void setComponents(List<WhatsappTemplateComponent> components) {
        this.components = components;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getElementName() {
        return name;
    }

    public String getLocale() {
        return language;
    }

    public String getPolicy() {
        return LANGUAGE_POLICY_DETERMINISTOC;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisplayName() {
        return String.format("%s (%s)", this.name, this.language);
    }
}
