package com.blindcarboncopy.emotionalrobot.model.messagecomponent;

import com.blindcarboncopy.emotionalrobot.model.interfaces.NodeRedMessageComponent;

import java.util.List;

/**
 * Created by chris on 30/09/2015.
 */
public class NodeRedArticleMetadata implements NodeRedMessageComponent {

   private String type;
    private String version;
    private String title;
    private String description;
    private String date;
    private String pubdate;
    private String pubDate;
    private String link;
    private String xmlurl;
    private String xmlUrl;
    private String author;
    private String language;
    private String favicon;
    private String copyright;
    private NodeRedArticleMetadataImage articleMetadataImage;

    public NodeRedArticleMetadata() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getXmlurl() {
        return xmlurl;
    }

    public void setXmlurl(String xmlurl) {
        this.xmlurl = xmlurl;
    }

    public String getXmlUrl() {
        return xmlUrl;
    }

    public void setXmlUrl(String xmlUrl) {
        this.xmlUrl = xmlUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public NodeRedArticleMetadataImage getArticleMetadataImage() {
        return articleMetadataImage;
    }

    public void setArticleMetadataImage(NodeRedArticleMetadataImage articleMetadataImage) {
        this.articleMetadataImage = articleMetadataImage;
    }
}
