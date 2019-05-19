package hse.t.alicemaster.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("type")
    @Expose
    private Object type;
    @SerializedName("name")
    @Expose
    private Object name;

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Source withType(Object type) {
        this.type = type;
        return this;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Source withName(Object name) {
        this.name = name;
        return this;
    }

}