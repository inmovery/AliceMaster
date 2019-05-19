package hse.t.alicemaster.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("showcases")
    @Expose
    private List<Showcase> showcases = null;
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
    @SerializedName("references")
    @Expose
    private List<Reference> references = null;

    public List<Showcase> getShowcases() {
        return showcases;
    }

    public void setShowcases(List<Showcase> showcases) {
        this.showcases = showcases;
    }

    public Data withShowcases(List<Showcase> showcases) {
        this.showcases = showcases;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Data withTotal(int total) {
        this.total = total;
        return this;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public Data withLinks(List<Object> links) {
        this.links = links;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data withType(String type) {
        this.type = type;
        return this;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public Data withUrn(String urn) {
        this.urn = urn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Data withTitle(String title) {
        this.title = title;
        return this;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public void setReferences(List<Reference> references) {
        this.references = references;
    }

    public Data withReferences(List<Reference> references) {
        this.references = references;
        return this;
    }

}