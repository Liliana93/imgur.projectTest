package classes;

import java.net.URI;
import java.util.Map;

public class FlickrItem {

    private FlickrItem[] items;
    private String title;
    private URI link;
    private Map<String, URI> media;
    private String date_taken;
    private String description;
    private String published;
    private String author;
    private String author_id;
    private String tags;

    public FlickrItem(FlickrItem[] items, String title, URI link, Map<String, URI> media, String date_taken, String description, String published, String author, String author_id, String tags) {
        this.items = items;
        this.title = title;
        this.link = link;
        this.media = media;
        this.date_taken = date_taken;
        this.description = description;
        this.published = published;
        this.author = author;
        this.author_id = author_id;
        this.tags = tags;
    }

    public FlickrItem() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(URI link) {
        this.link = link;
    }

    public void setMedia(Map<String, URI> media) {
        this.media = media;
    }

    public void setDate_taken(String date_taken) {
        this.date_taken = date_taken;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setItems(FlickrItem[] items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public URI getLink() {
        return link;
    }

    public Map<String, URI> getMedia() {
        return media;
    }

    public String getDate_taken() {
        return date_taken;
    }

    public String getDescription() {
        return description;
    }

    public String getPublished() {
        return published;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public String getTags() {
        return tags;
    }

    public FlickrItem[] getItems() {
        return items;
    }

}