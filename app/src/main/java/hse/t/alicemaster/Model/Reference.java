package hse.t.alicemaster.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reference {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("urn")
    @Expose
    private String urn;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("total")
    @Expose
    private int total;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Reference withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public Reference withUrn(String urn) {
        this.urn = urn;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Reference withType(String type) {
        this.type = type;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Reference withTotal(int total) {
        this.total = total;
        return this;
    }

}