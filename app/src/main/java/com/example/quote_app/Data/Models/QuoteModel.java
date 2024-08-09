package com.example.quote_app.Data.Models;
import java.io.Serializable;

public class QuoteModel implements Serializable {
    private static final long serialVersionUID = 1L; // Add this line
    private final String quote;
    private final String movieName;
    private final String movieYear;
    private final int moviePhoto;
    private final String characterName;

    public QuoteModel(String quote, String movieName, String movieYear, int moviePhoto, String characterName) {
        this.quote = quote;
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.moviePhoto = moviePhoto;
        this.characterName = characterName;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getQuote() {
        return quote;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public int getMoviePhoto() {
        return moviePhoto;
    }

    public String getCharacterName() {
        return characterName;
    }
}
