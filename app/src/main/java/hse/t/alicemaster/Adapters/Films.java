package hse.t.alicemaster.Adapters;

public class Films {
    private String title;
    private String rating;
    private String description;
    private String image_url;
//    private String adult;
//    private String video_url;
//    private int price;
//    private String status;

    public Films(){

    }

    public Films(String title, String rating, String description, String image_url, String adult, String video_url, int price, String status){
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.image_url = image_url;
//        this.adult = adult;
//        this.video_url = video_url;
//        this.price = price;
//        this.status = status;
    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public String getAdult() {
//        return adult;
//    }
//
//    public void setAdult(String adult) {
//        this.adult = adult;
//    }
//
//    public String getVideo_url() {
//        return video_url;
//    }
//
//    public void setVideo_url(String video_url) {
//        this.video_url = video_url;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
