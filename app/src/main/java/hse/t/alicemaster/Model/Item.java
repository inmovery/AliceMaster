package hse.t.alicemaster.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("urn")
    @Expose
    private String urn;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("adult")
    @Expose
    private Adult adult;
    @SerializedName("resources")
    @Expose
    private List<Resource> resources = null;
    @SerializedName("releasedAt")
    @Expose
    private String releasedAt;
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("favorite")
    @Expose
    private Favorite favorite;
    @SerializedName("personsUrn")
    @Expose
    private Object personsUrn;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;
    @SerializedName("offersUrn")
    @Expose
    private String offersUrn;
    @SerializedName("available")
    @Expose
    private Available available;
    @SerializedName("offer")
    @Expose
    private Offer offer;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("duration")
    @Expose
    private int duration;
    @SerializedName("position")
    @Expose
    private int position;
    @SerializedName("estimate")
    @Expose
    private Estimate estimate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item withId(int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item withType(String type) {
        this.type = type;
        return this;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public Item withUrn(String urn) {
        this.urn = urn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Item withTitle(String title) {
        this.title = title;
        return this;
    }

    public Adult getAdult() {
        return adult;
    }

    public void setAdult(Adult adult) {
        this.adult = adult;
    }

    public Item withAdult(Adult adult) {
        this.adult = adult;
        return this;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public Item withResources(List<Resource> resources) {
        this.resources = resources;
        return this;
    }

    public String getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
    }

    public Item withReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
        return this;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Item withRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    public Favorite getFavorite() {
        return favorite;
    }

    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
    }

    public Item withFavorite(Favorite favorite) {
        this.favorite = favorite;
        return this;
    }

    public Object getPersonsUrn() {
        return personsUrn;
    }

    public void setPersonsUrn(Object personsUrn) {
        this.personsUrn = personsUrn;
    }

    public Item withPersonsUrn(Object personsUrn) {
        this.personsUrn = personsUrn;
        return this;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public Item withCategories(List<Object> categories) {
        this.categories = categories;
        return this;
    }

    public String getOffersUrn() {
        return offersUrn;
    }

    public void setOffersUrn(String offersUrn) {
        this.offersUrn = offersUrn;
    }

    public Item withOffersUrn(String offersUrn) {
        this.offersUrn = offersUrn;
        return this;
    }

    public Available getAvailable() {
        return available;
    }

    public void setAvailable(Available available) {
        this.available = available;
    }

    public Item withAvailable(Available available) {
        this.available = available;
        return this;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Item withOffer(Offer offer) {
        this.offer = offer;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item withDescription(String description) {
        this.description = description;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Item withDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Item withPosition(int position) {
        this.position = position;
        return this;
    }

    public Estimate getEstimate() {
        return estimate;
    }

    public void setEstimate(Estimate estimate) {
        this.estimate = estimate;
    }

    public Item withEstimate(Estimate estimate) {
        this.estimate = estimate;
        return this;
    }

}