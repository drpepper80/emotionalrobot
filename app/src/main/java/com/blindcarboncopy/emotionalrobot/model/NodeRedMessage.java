package com.blindcarboncopy.emotionalrobot.model;

/**
 * NodeRed RSS Feed Data Object.
 */
public class NodeRedMessage {

    private class Article {
        private String title;
        private String link;
    }

    private class Sentiment {

    }

    // The article URL
    private String topic;

    // Description content of the article
    private String payload;

    private Article article;

    private Sentiment sentiment;

    public NodeRedMessage() {
        article = new Article();
        sentiment = new Sentiment();
    }

    public String getTitle() {
        return article.title;
    }

    public String getUrl() {
        return article.link;
    }

    public String getTopic() {
        return topic;
    }

    public String getPayload() {
        return payload;
    }
}

