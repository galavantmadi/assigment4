package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class User {
    /*
    * The user should contain username password.
    * The user should contain an ArrayList of favorite shows and watch history.
    * FUNCTION: the user should have a function to watch a show and add it to watch history.
    *  *** NOTE: All search functions in user are for searching in favorite shows ***
    */
    private int id;
    private String username;
    private String password;
    private String token;
    private ArrayList<TVShow> favoriteList;
    private ArrayList<TVShow> recommendationList;
    private ArrayList<TVShow> historyList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<TVShow> getFavoriteList() {
        return favoriteList;
    }

    public List<TVShow> getRecommendationList() {
        return recommendationList;
    }

    public void setRecommendationList(ArrayList<TVShow> recommendationList) {
        this.recommendationList = recommendationList;
    }

    public void setFavoriteList(ArrayList<TVShow> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public ArrayList<TVShow> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(ArrayList<TVShow> historyList) {
        this.historyList = historyList;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title in favorite shows  logic here
       return (ArrayList<TVShow>) favoriteList.stream().filter(c->c.getTitle().contains(title)).collect(Collectors.toList());
        //return null;
    }
    public ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre in favorite shows  logic here
        return  (ArrayList<TVShow>) favoriteList.stream().filter(c -> c.getGenre().contains(genre)).collect(Collectors.toList());
        //return null;
    }
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year in favorite shows logic here
        return (ArrayList<TVShow>) favoriteList.stream().filter(c->c.getReleaseYear()==year).collect(Collectors.toList());
        //return null;
    }
    public void addToFavorites(TVShow show) {
        // Implement add to favorites logic here
        favoriteList.add(show);
    }
    public List<TVShow> viewFavorites() {
        // Implement view favorites logic here
        return favoriteList;
    }
    public ArrayList<TVShow> getRecommendations() {
       return (ArrayList<TVShow>) recommendationList;

    }

    public void addToHistories(TVShow show){
        historyList.add(show);
    }
    public List<TVShow> viewHistories(){
        return historyList;
    }
    public void addToRecommendations(TVShow show){
        recommendationList.add(show);
    }
    public List<TVShow> viewRecommendations(){
        return recommendationList;
    }

    public User(int id, String username, String password, String token, ArrayList<TVShow> favoriteList, ArrayList<TVShow> recommendationList, ArrayList<TVShow> historyList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.favoriteList = favoriteList;
        this.recommendationList = recommendationList;
        this.historyList = historyList;
    }

    public User(String username, String password, String token, ArrayList<TVShow> favoriteList, ArrayList<TVShow> recommendationList, ArrayList<TVShow> historyList) {
        this.username = username;
        this.password = password;
        this.token = token;
        this.favoriteList = favoriteList;
        this.recommendationList = recommendationList;
        this.historyList = historyList;
    }

    public User() {
    }
}
