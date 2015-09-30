package com.blindcarboncopy.emotionalrobot.model.messagecomponent;

import com.blindcarboncopy.emotionalrobot.model.interfaces.NodeRedMessageComponent;

import java.util.List;

/**
 * Created by chris on 30/09/2015.
 */
public class NodeRedArticle implements NodeRedMessageComponent {

    private String title;
    private String description;
    private String summary;
    private String date;
    private String pubdate;
    private String pubDate;
    private String link;
    private String guid;
    private String author;
    private String comments;
    private String origlink;
    private List categories;
    private List enclosures;
    private NodeRedArticleMetadata nodeRedArticleMetadata;

    public NodeRedArticle(String title, String description, String summary, String date,
                          String pubdate, String pubDate, String link, String guid, String author,
                          String comments, String origlink, List categories, List enclosures,
                          NodeRedArticleMetadata nodeRedArticleMetadata) {
        this.title = title;
        this.description = description;
        this.summary = summary;
        this.date = date;
        this.pubdate = pubdate;
        this.pubDate = pubDate;
        this.link = link;
        this.guid = guid;
        this.author = author;
        this.comments = comments;
        this.origlink = origlink;
        this.categories = categories;
        this.enclosures = enclosures;
        this.nodeRedArticleMetadata = nodeRedArticleMetadata;
    }

    public NodeRedArticle() {
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getOriglink() {
        return origlink;
    }

    public void setOriglink(String origlink) {
        this.origlink = origlink;
    }

    public List getCategories() {
        return categories;
    }

    public void setCategories(List categories) {
        this.categories = categories;
    }

    public List getEnclosures() {
        return enclosures;
    }

    public void setEnclosures(List enclosures) {
        this.enclosures = enclosures;
    }

    public NodeRedArticleMetadata getNodeRedArticleMetadata() {
        return nodeRedArticleMetadata;
    }

    public void setNodeRedArticleMetadata(NodeRedArticleMetadata nodeRedArticleMetadata) {
        this.nodeRedArticleMetadata = nodeRedArticleMetadata;
    }
}
