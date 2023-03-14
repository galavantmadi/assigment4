package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */
    private List<User> userList;
    private List<TVShow> tvShowList;
    private List<Movie> movieList;
    private  User user;

    public NetflixService(List<User> userList, List<TVShow> tvShowList, List<Movie> movieList, User user) {
        this.userList = userList;
        this.tvShowList = tvShowList;
        this.movieList = movieList;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<TVShow> getTvShowList() {
        return tvShowList;
    }

    public void setTvShowList(List<TVShow> tvShowList) {
        this.tvShowList = tvShowList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }


    public void addTVShow(TVShow tvShow){
        // Implement add tv show logic here
        tvShowList.add(tvShow);
    }

    public void addMovie(Movie movie){
        // Implement add movie logic here
        movieList.add(movie);
    }

    public void createAccount(String username, String password) {
        // Implement create account logic here
        Optional<User> optionalUser=searchUser(username);
        if(optionalUser.isPresent()){
            System.out.println("UserName Is Exist");
        }else {
            User newUser=new User(username,password,"",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
            this.userList.add(newUser);
            System.out.println("User With UserName : ( "+(newUser.getUsername()+" ) has been Created"));
            System.out.println("Welcome to NetflixService");
        }
    }

    public Optional<User> searchUser(String username){

        return this.userList.stream().filter(c->c.getUsername().equals(username)).findFirst();

    }

    public boolean login(String username, String password) {
        // Implement login logic here
        Optional<User> user =searchUser(username);
        if(user.isPresent() && user.get().getPassword().equals(password)){
            user.get().setToken("Ab32587DA");
            setUser(user.get());
            return true;

        }else {
            return false;

        }

    }

    public void logout() {
        // Implement logout logic here
        if(user.getToken()!=null && !user.getToken().equals("")){
            user.setToken("");
            updateUser(user);
            setUser(null);

        }
    }

    public void updateUser(User user){

        this.userList.forEach(c->{
            if(c.getUsername().equals(user.getUsername())){
                c.setToken(user.getToken()!=null?user.getToken():c.getToken());
                c.setPassword(user.getPassword()!=null?user.getPassword():c.getPassword());
                ;
            }
        });

    }

    public ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title logic here
       return (ArrayList<TVShow>) this.tvShowList.stream().filter(c->c.getTitle().equals(title)).collect(Collectors.toList());

    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre logic here
        return (ArrayList<TVShow>) this.tvShowList.stream().filter(c->c.getGenre().equals(genre)).collect(Collectors.toList());

    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year logic here
        return (ArrayList<TVShow>) this.tvShowList.stream().filter(c->c.getReleaseYear()==year).collect(Collectors.toList());
    }


}

