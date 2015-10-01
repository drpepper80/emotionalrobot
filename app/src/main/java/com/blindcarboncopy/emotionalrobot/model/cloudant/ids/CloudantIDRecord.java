package com.blindcarboncopy.emotionalrobot.model.cloudant.ids;

/**
 * Created by DrPepper80 on 01/10/2015.
 */
public class CloudantIDRecord {
    private String id;
    private String key;
    private CloudantIDRecordValue value;

    public CloudantIDRecord() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public CloudantIDRecordValue getValue() {
        return value;
    }

    public void setValue(CloudantIDRecordValue value) {
        this.value = value;
    }
}
