package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    /*
     *Movie is extended from TVShow and has extra attribute length.
     */
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Movie()
    {
        super();
    }

    public Movie(int length) {
        this.length = length;
    }

    public Movie(int id, String title, String genre, int releaseYear, String duration, String rating, ArrayList<String> cast, int length) {
        super(id, title, genre, releaseYear, duration, rating, cast);
        this.length = length;
    }
}
