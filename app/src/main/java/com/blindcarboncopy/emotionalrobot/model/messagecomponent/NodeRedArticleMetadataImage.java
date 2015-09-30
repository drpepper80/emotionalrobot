package com.blindcarboncopy.emotionalrobot.model.messagecomponent;

/**
 * Created by chris on 30/09/2015.
 */
public class NodeRedArticleMetadataImage {


    private String url;
    private String title;

    public NodeRedArticleMetadataImage(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public NodeRedArticleMetadataImage() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
