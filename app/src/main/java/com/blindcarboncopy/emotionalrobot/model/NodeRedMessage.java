package com.blindcarboncopy.emotionalrobot.model;


import com.blindcarboncopy.emotionalrobot.model.interfaces.NodeRedMessageComponent;

import java.util.HashSet;
import java.util.Set;

/**
 * A data model for the Node Red Message object
 * All Node Red Message objects comes with a minimum of:
 * Topic - String
 * Payload -String
 * MsgId - String
 *
 * Can also optionally have additional other message objects
 * nested within.
 *
 * We only need Article and Sentiment for this project.
 */
public class NodeRedMessage {

    private String topic;
    private String payload;
    private String msgid;
    private HashSet<NodeRedMessageComponent> componentSet;

    public NodeRedMessage() {
        this.topic = topic;
        this.payload = payload;
        this.msgid = msgid;
        componentSet = new HashSet();
    }

    public NodeRedMessage(String topic, String payload, String msgid) {
        this.topic = topic;
        this.payload = payload;
        this.msgid = msgid;
        componentSet = new HashSet();
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public Set getComponentSet() {
        return componentSet;
    }

    public void setComponentSet(HashSet<NodeRedMessageComponent> componentSet) {
        this.componentSet = componentSet;
    }
}

