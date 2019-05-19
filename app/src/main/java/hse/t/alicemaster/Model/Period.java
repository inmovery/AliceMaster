package hse.t.alicemaster.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Period {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private int value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Period withType(String type) {
        this.type = type;
        return this;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Period withValue(int value) {
        this.value = value;
        return this;
    }

}