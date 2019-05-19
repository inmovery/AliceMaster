package hse.t.alicemaster.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("urn")
    @Expose
    private String urn;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("purchaseAt")
    @Expose
    private Object purchaseAt;
    @SerializedName("expireAt")
    @Expose
    private Object expireAt;
    @SerializedName("ivod")
    @Expose
    private Ivod ivod;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("provider")
    @Expose
    private Provider provider;
    @SerializedName("period")
    @Expose
    private Period period;
    @SerializedName("adult")
    @Expose
    private Adult_ adult;
    @SerializedName("root")
    @Expose
    private Root root;
    @SerializedName("stocks")
    @Expose
    private List<Object> stocks = null;
    @SerializedName("quality")
    @Expose
    private List<Quality> quality = null;
    @SerializedName("store")
    @Expose
    private Store store;
    @SerializedName("source")
    @Expose
    private Source source;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Offer withId(int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Offer withType(String type) {
        this.type = type;
        return this;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public Offer withUrn(String urn) {
        this.urn = urn;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Offer withPrice(int price) {
        this.price = price;
        return this;
    }

    public Object getPurchaseAt() {
        return purchaseAt;
    }

    public void setPurchaseAt(Object purchaseAt) {
        this.purchaseAt = purchaseAt;
    }

    public Offer withPurchaseAt(Object purchaseAt) {
        this.purchaseAt = purchaseAt;
        return this;
    }

    public Object getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Object expireAt) {
        this.expireAt = expireAt;
    }

    public Offer withExpireAt(Object expireAt) {
        this.expireAt = expireAt;
        return this;
    }

    public Ivod getIvod() {
        return ivod;
    }

    public void setIvod(Ivod ivod) {
        this.ivod = ivod;
    }

    public Offer withIvod(Ivod ivod) {
        this.ivod = ivod;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Offer withStatus(Status status) {
        this.status = status;
        return this;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Offer withProvider(Provider provider) {
        this.provider = provider;
        return this;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Offer withPeriod(Period period) {
        this.period = period;
        return this;
    }

    public Adult_ getAdult() {
        return adult;
    }

    public void setAdult(Adult_ adult) {
        this.adult = adult;
    }

    public Offer withAdult(Adult_ adult) {
        this.adult = adult;
        return this;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public Offer withRoot(Root root) {
        this.root = root;
        return this;
    }

    public List<Object> getStocks() {
        return stocks;
    }

    public void setStocks(List<Object> stocks) {
        this.stocks = stocks;
    }

    public Offer withStocks(List<Object> stocks) {
        this.stocks = stocks;
        return this;
    }

    public List<Quality> getQuality() {
        return quality;
    }

    public void setQuality(List<Quality> quality) {
        this.quality = quality;
    }

    public Offer withQuality(List<Quality> quality) {
        this.quality = quality;
        return this;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Offer withStore(Store store) {
        this.store = store;
        return this;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Offer withSource(Source source) {
        this.source = source;
        return this;
    }

}