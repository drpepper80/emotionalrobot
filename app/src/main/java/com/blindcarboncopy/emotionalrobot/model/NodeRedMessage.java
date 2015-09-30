package com.blindcarboncopy.emotionalrobot.model;


import com.blindcarboncopy.emotionalrobot.model.interfaces.NodeRedMessageComponent;
import com.blindcarboncopy.emotionalrobot.model.messagecomponent.NodeRedArticle;
import com.blindcarboncopy.emotionalrobot.model.messagecomponent.NodeRedSentiment;

import java.util.HashSet;
import java.util.Set;

/**
 * A data model for the Node Red Message object
 * All Node Red Message objects comes with a minimum of:
 * Topic - String
 * Payload -String
 * MsgId - String
 * <p/>
 * Can also optionally have additional other message objects
 * nested within.
 * <p/>
 * We only need Article and Sentiment for this project.
 */
public class NodeRedMessage {

    private String topic;
    private String payload;
    private String msgid;

    private NodeRedArticle article;
    private NodeRedSentiment sentiment;

    public NodeRedMessage() {
        article = new NodeRedArticle();
        sentiment = new NodeRedSentiment();
    }

    public NodeRedMessage(String topic, String payload, String msgid) {
        this.topic = topic;
        this.payload = payload;
        this.msgid = msgid;
    }

    public NodeRedArticle getArticle() {
        return article;
    }

    public void setArticle(NodeRedArticle article) {
        this.article = article;
    }

    public NodeRedSentiment getSentiment() {
        return sentiment;
    }

    public void setSentiment(NodeRedSentiment sentiment) {
        this.sentiment = sentiment;
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
}

