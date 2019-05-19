package hse.t.alicemaster.Model.Url;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataUrl {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("close_time")
    @Expose
    private int closeTime;
    @SerializedName("drm_version")
    @Expose
    private int drmVersion;
    @SerializedName("result")
    @Expose
    private int result;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    public int getDrmVersion() {
        return drmVersion;
    }

    public void setDrmVersion(int drmVersion) {
        this.drmVersion = drmVersion;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

}