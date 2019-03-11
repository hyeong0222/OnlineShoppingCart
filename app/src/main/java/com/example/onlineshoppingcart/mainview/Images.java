package com.example.onlineshoppingcart.mainview;

public class Images {

    String image_url;
    String categoryName;

    public Images(String image_url, String categoryName) {
        this.image_url = image_url;
        this.categoryName = categoryName;
    }

    public Images(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCategory() {
        return categoryName;
    }

    public void setCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}
