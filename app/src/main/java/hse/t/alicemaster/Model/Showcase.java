package hse.t.alicemaster.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Showcase {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("urn")
    @Expose
    private String urn;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("recommendationId")
    @Expose
    private String recommendationId;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Showcase withItems(List<Item> items) {
        this.items = items;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Showcase withTotal(int total) {
        this.total = total;
        return this;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public Showcase withLinks(List<Object> links) {
        this.links = links;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Showcase withType(String type) {
        this.type = type;
        return this;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public Showcase withUrn(String urn) {
        this.urn = urn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Showcase withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }

    public Showcase withRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
        return this;
    }

}