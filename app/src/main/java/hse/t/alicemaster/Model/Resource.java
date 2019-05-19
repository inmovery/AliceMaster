package hse.t.alicemaster.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resource {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("drm")
    @Expose
    private String drm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Resource withId(int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Resource withType(String type) {
        this.type = type;
        return this;
    }

    public String getDrm() {
        return drm;
    }

    public void setDrm(String drm) {
        this.drm = drm;
    }

    public Resource withDrm(String drm) {
        this.drm = drm;
        return this;
    }

}