package com.example.model;

/**
 * Created by faisalabdillah on 24/11/15.
 */
public class TvProgram extends EntityBase{

    private String title;

    private String year;

    private boolean favorite;

    public TvProgram(String title, String year, boolean favorite){
        this.title = title;
        this.year = year;
        this.favorite = favorite;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
