package com.example.jsonparsingwithglideandvolley.Class;

//              Anime
public class AboutMovies {

    public String name;
    public String description;
    public String rating;
    public String img;
    public String categories;
    public String studio;
    public int episode;

    public AboutMovies() {
    }

    public AboutMovies(String name, String description, String rating, String img, String categories, String studio, int episode) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.img = img;
        this.categories = categories;
        this.studio = studio;
        this.episode = episode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }
}
