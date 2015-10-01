package com.blindcarboncopy.emotionalrobot.model.nodered;


import com.blindcarboncopy.emotionalrobot.model.nodered.messagecomponent.NodeRedArticle;
import com.blindcarboncopy.emotionalrobot.model.nodered.messagecomponent.NodeRedSentiment;

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
    private String _msgid;
    private String msgid;
    private String _id;
    private String _rev;

    private NodeRedArticle article;
    private NodeRedSentiment sentiment;

    public NodeRedMessage() {
        article = new NodeRedArticle();
        sentiment = new NodeRedSentiment();
    }

    public NodeRedMessage(String topic, String payload, String msgid) {
        this.topic = topic;
        this.payload = payload;
        this._msgid = msgid;
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

    public String get_msgid() {
        return _msgid;
    }

    public void set_msgid(String _msgid) {
        this._msgid = _msgid;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_rev() {
        return _rev;
    }

    public void set_rev(String _rev) {
        this._rev = _rev;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }
}

