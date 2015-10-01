package com.blindcarboncopy.emotionalrobot.model.cloudant.messages;

import com.blindcarboncopy.emotionalrobot.model.nodered.NodeRedMessage;

/**
 * Created by DrPepper80 on 01/10/2015.
 */
public class CloudantMessageRecord {
    private String id;
    private String key;
    private NodeRedMessage doc;

    public CloudantMessageRecord() {
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

    public NodeRedMessage getDoc() {
        return doc;
    }

    public void setDoc(NodeRedMessage doc) {
        this.doc = doc;
    }
}
