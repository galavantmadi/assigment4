package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    //don't limit yourself to our template ***


    public static void main(String[] args) {

        //Insert Data
        ArrayList<TVShow> tvShowList= new ArrayList<>();
        ArrayList<String> cast1=new ArrayList<>();
        cast1.add("Tim Robbins");
        cast1.add("Bob Gunton");
        cast1.add("Clancy Brown");
        TVShow tvShow1=new TVShow(1,"TVShow1","Action film",1994,"duration1","rating1",cast1);
        tvShowList.add(tvShow1);

        ArrayList<String> cast2=new ArrayList<>();
        cast2.add("Mark Rolston");
        cast2.add("Jeffrey DeMunn");
        cast2.add("Neil Giuntoli");
        TVShow tvShow2=new TVShow(2,"TVShow2","Comedy film",1995,"duration2","rating2",cast2);
        tvShowList.add(tvShow2);

        ArrayList<String> cast3=new ArrayList<>();
        cast3.add("David Proval");
        cast3.add("Jude Ciccolella");
        cast3.add("Brian Libby");
        TVShow tvShow3=new TVShow(3,"TVShow3","Drama",1996,"duration3","rating3",cast3);
        tvShowList.add(tvShow3);

        ArrayList<String> cast4=new ArrayList<>();
        cast4.add("Larry Brandenburg");
        cast4.add("James Whitmore");
        cast4.add("Gil Bellows");
        TVShow tvShow4=new TVShow(4,"TVShow4","Fantasy film",1997,"duration4","rating4",cast4);
        tvShowList.add(tvShow4);

        ArrayList<String> cast5=new ArrayList<>();
        cast5.add("William Sadler");
        cast5.add("Morgan Freeman");
        cast5.add("Al Lettieri");
        TVShow tvShow5=new TVShow(5,"TVShow5","Musical film",1998,"duration5","rating5",cast5);
        tvShowList.add(tvShow5);

        ArrayList<String> cast6=new ArrayList<>();
        cast6.add("Diane Keaton");
        cast6.add("Robert Duvall");
        cast6.add("Marlon Brando");
        TVShow tvShow6=new TVShow(6,"TVShow6","Historical film",2000,"duration6","rating6",cast6);
        tvShowList.add(tvShow6);

        ArrayList<String> cast7=new ArrayList<>();
        cast7.add("Morgana King");
        cast7.add("Lenny Montana");
        cast7.add("Rudy Bond");
        TVShow tvShow7=new TVShow(7,"TVShow7","Horror film",2001,"duration7","rating7",cast7);
        tvShowList.add(tvShow7);

        ArrayList<Movie> movieList=new ArrayList<>();
        Movie movie1=new Movie(1,"TVShow1","Action film",1994,"duration1","rating1",cast1,100);
        movieList.add(movie1);
        Movie movie2=new Movie(2,"TVShow2","Comedy film",1995,"duration2","rating2",cast2,101);
        movieList.add(movie2);
        Movie movie3=new Movie(3,"TVShow3","Drama",1996,"duration3","rating3",cast3,101);
        movieList.add(movie3);
        Movie movie4=new Movie(4,"TVShow4","Fantasy film",1997,"duration4","rating4",cast4,102);
        movieList.add(movie4);
        Movie movie5=new Movie(5,"TVShow5","Musical film",1998,"duration5","rating5",cast5,102);
        movieList.add(movie5);
        Movie movie6=new Movie(6,"TVShow6","Historical film",2000,"duration6","rating6",cast6,102);
        movieList.add(movie6);
        Movie movie7=new Movie(7,"TVShow7","Horror film",2001,"duration7","rating7",cast7,102);
        movieList.add(movie7);

        ArrayList<User> userList=new ArrayList<>();
        ArrayList<TVShow> favoriteListUser1=new ArrayList<>();
        TVShow favoriteTvShow1=new TVShow(1,"TVShow1","Action film",1994,"duration1","rating1",cast1);
        TVShow favoriteTvShow2=new TVShow(2,"TVShow2","Comedy film",1995,"duration2","rating2",cast2);
        favoriteListUser1.add(favoriteTvShow1);
        favoriteListUser1.add(favoriteTvShow2);
        ArrayList<TVShow> recommendationListUser1=new ArrayList<>();
        TVShow recommendTvShow1=new TVShow(3,"TVShow3","Drama",1996,"duration3","rating3",cast3);
        recommendationListUser1.add(recommendTvShow1);
        recommendationListUser1.add(favoriteTvShow2);
        ArrayList<TVShow> historyListUser1=new ArrayList<>();
        historyListUser1.add(favoriteTvShow1);
        historyListUser1.add(favoriteTvShow2);
        historyListUser1.add(recommendTvShow1);
        User user=new User(1,"User1","Pass1","",favoriteListUser1,recommendationListUser1,historyListUser1);
        userList.add(user);

        ArrayList<TVShow> favoriteListUser2=new ArrayList<>();
        TVShow favoriteTvShow3=new TVShow(4,"TVShow4","Fantasy film",1997,"duration4","rating4",cast4);
        TVShow favoriteTvShow4=new TVShow(5,"TVShow5","Musical film",1998,"duration5","rating5",cast5);
        favoriteListUser2.add(favoriteTvShow3);
        favoriteListUser2.add(favoriteTvShow4);
        ArrayList<TVShow> recommendationListUser2=new ArrayList<>();
        TVShow recommendTvShow2=new TVShow(6,"TVShow6","Historical film",2000,"duration6","rating6",cast6);
        recommendationListUser2.add(recommendTvShow2);
        recommendationListUser2.add(favoriteTvShow3);
        ArrayList<TVShow> historyListUser2=new ArrayList<>();
        historyListUser2.add(favoriteTvShow3);
        historyListUser2.add(favoriteTvShow4);
        historyListUser2.add(recommendTvShow2);
        //


        NetflixService netflixService=new NetflixService(userList,tvShowList,movieList,null);

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=0){
            runMenu();
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1://Create Account:
                        Scanner myObj = new Scanner(System.in);
                        myObj = new Scanner(System.in);
                        System.out.println("Welcome to create User");
                        System.out.println("Enter Username :");
                        String username = myObj.nextLine();
                        System.out.println("Enter Password :");
                        String passwordUser = myObj.nextLine();
                        netflixService.createAccount(username,passwordUser);
                        break;
                    case 2:// LogIn User
                        myObj = new Scanner(System.in);
                        System.out.println("Sample for Login--> Username : User1 , Password : Pass1");
                        System.out.println("Please UserName :");
                        String userName = myObj.nextLine();
                        System.out.println("Please Password :");
                        String password = myObj.nextLine();
                        boolean flagLogin=netflixService.login(userName,password);
                        if (flagLogin) {
                            System.out.println("Login Success and token is " + netflixService.getUser().getToken());
                            break;
                        }
                        System.out.println("Login Fail");
                        break;

                    case 3://LogOut User
                        if(netflixService.getUser()!=null ){
                            netflixService.logout();
                            System.out.println("LogOut Success");
                        }else {
                            System.out.println("The user is not logged in yet!!! ");
                        }
                        break;
                    case 4://Search Movie By Title :
                        if(netflixService.getUser()!=null ){
                            myObj = new Scanner(System.in);
                            System.out.println("Please enter the desired title :");
                            String title = myObj.nextLine();
                            ArrayList<TVShow> tvShowArrayList=netflixService.searchByTitle(title);
                            FoundResult(tvShowArrayList);
                        }else {
                            System.out.println("The user is not logged in yet!!! ");
                        }
                        break;
                    case 5://Search Movie By Genre :
                        if(netflixService.getUser()!=null ){
                            myObj = new Scanner(System.in);
                            System.out.print("You can Search Genres : ");

                            netflixService.getTvShowList().forEach(d->{
                                System.out.print(d.getGenre()+" , ");
                            });
                            System.out.println("");
                            System.out.println("Please enter the desired genre :");
                            String genre = myObj.nextLine();
                            ArrayList<TVShow> tvShowArrayList=netflixService.searchByGenre(genre);
                            FoundResult(tvShowArrayList);
                        }else {
                            System.out.println("The user is not logged in yet!!! ");
                        }
                        break;
                    case 6://Search Movie By Year :
                        if(netflixService.getUser()!=null ){
                            myObj = new Scanner(System.in);
                            System.out.println("Please enter the desired year movie :");
                            int year = myObj.nextInt();
                            ArrayList<TVShow> tvShowArrayList=netflixService.searchByReleaseYear(year);
                            FoundResult(tvShowArrayList);
                        }else {
                            System.out.println("The user is not logged in yet!!! ");
                        }
                        break;
                    case 7://Search Favorite User Movie By Title :
                        if(netflixService.getUser()!=null ){
                            myObj = new Scanner(System.in);
                            System.out.println("Please enter the desired title :");
                            String title = myObj.nextLine();
                            ArrayList<TVShow> tvShowArrayList=netflixService.getUser().searchByTitle(title);
                            FoundResult(tvShowArrayList);
                        }else {
                            System.out.println("The user is not logged in yet!!! ");
                        }
                        break;
                    case 8://Search Favorite User Movie By Genre :
                        if(netflixService.getUser()!=null ){
                            myObj = new Scanner(System.in);
                            System.out.print("You can Search Genres : ");

                            netflixService.getTvShowList().forEach(d->{
                                System.out.print(d.getGenre()+" , ");
                            });
                            System.out.println("");
                            System.out.println("Please enter the desired genre :");
                            String genre = myObj.nextLine();
                            ArrayList<TVShow> tvShowArrayList=netflixService.getUser().searchByGenre(genre);
                            FoundResult(tvShowArrayList);
                        }else {
                            System.out.println("The user is not logged in yet!!! ");
                        }
                        break;
                    case 9://Search Favorite User Movie By Year :
                        if(netflixService.getUser()!=null ){
                            myObj = new Scanner(System.in);
                            System.out.println("Please enter the desired year movie :");
                            int year = myObj.nextInt();
                            ArrayList<TVShow> tvShowArrayList=netflixService.getUser().searchByReleaseYear(year);
                            FoundResult(tvShowArrayList);
                        }else {
                            System.out.println("The user is not logged in yet!!! ");
                        }
                        break;
                    case 10:
                        if(netflixService.getUser()!=null ){
                            myObj = new Scanner(System.in);
                            System.out.println("Netflix Movie List Is :");
                            netflixService.getTvShowList().forEach(f->{
                                System.out.println("Id :"+f.getId()+" ,Title :"+f.getTitle()+" ,Genre :"+f.getGenre());
                            });
                            boolean flag=true;
                            int selectItem=0;
                            do{
                                System.out.println("Please Chose Id :");
                                int select = myObj.nextInt();
                                flag=netflixService.getTvShowList().stream().anyMatch(g->g.getId()==select);
                                if(!flag){
                                    System.out.println("Chose Item Incorrect !!!!");
                                }else {
                                    selectItem=select;
                                }
                            }  while (!flag);
                            int finalSelectItem = selectItem;
                            //if tvShow is existed
                            Optional<TVShow> tvShowSelected=netflixService.getTvShowList().stream().filter(w->w.getId()== finalSelectItem).findAny();
                            if(tvShowSelected.isPresent()){
                                //if tvShow is existed Favorite User List
                                if(netflixService.getUser().getFavoriteList().stream().noneMatch(x->x.getId()==tvShowSelected.get().getId())){
                                    netflixService.getUser().addToFavorites(tvShowSelected.get());
                                    System.out.println("Movie was added to favorites list");
                                }else {
                                    System.out.println("The selected movie has already been added to favorites list");
                                }

                            }

                        }else {
                            System.out.println("The user is not logged in yet!!! ");
                        }
                        break;
                    case 11:
                        if(netflixService.getUser()!=null ){
                            if(netflixService.getUser().getFavoriteList().size()>0){
                                System.out.println("Favorite List User is :");
                                FoundResult((ArrayList<TVShow>) netflixService.getUser().getFavoriteList());
                            }else {
                                System.out.println("Favorite List Is Empty.");
                            }


                        }else {
                            System.out.println("The user is not logged in yet!!! ");
                        }
                        break;
                    case 12:
                        if(netflixService.getUser()!=null ){
                            if(netflixService.getUser().getFavoriteList().size()>0){
                                System.out.println("Recommendation List User is :");
                                FoundResult((ArrayList<TVShow>) netflixService.getUser().getRecommendationList());
                            }else {
                                System.out.println("Recommendation List Is Empty.");
                            }


                        }else {
                            System.out.println("The user is not logged in yet!!! ");
                        }
                        break;
                    case 13:
                        if(netflixService.getUser()!=null ){
                            if(netflixService.getUser().getFavoriteList().size()>0){
                                System.out.println("All Movie List :");
                                FoundResult((ArrayList<TVShow>) netflixService.getTvShowList());
                            }else {
                                System.out.println("Recommendation List Is Empty.");
                            }


                        }else {
                            System.out.println("The user is not logged in yet!!! ");
                        }
                        break;

                }


            }catch (InputMismatchException ex){
                System.out.println("Please enter an integer value between 1 and 11" );
                scanner.next();
            }
            catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }

        }


    }

    private static void FoundResult(ArrayList<TVShow> tvShowArrayList) {
        if(tvShowArrayList.size()==0){
            System.out.println("Result Not Found");
        }else {
            AtomicInteger count= new AtomicInteger(1);
            tvShowArrayList.forEach(d->{

                System.out.println("Number "+count+" : "+d.getTitle()+" "+d.getGenre()+" "+d.getReleaseYear()+" "+d.getRating());
                count.getAndIncrement();
            });
        }
    }

    public static void runMenu(){
        //TODO:

        //Menu
        String[] options = {
                "0- Exist Menu",
                "1- Create Account",
                "2- LogIn User",
                "3- LogOut User",
                "4- Search Movie By Title :",
                "5- Search Movie By Genre :",
                "6- Search Movie By Year :",
                "7- Search Favorite User Movie By Title :",
                "8- Search Favorite User Movie By Genre :",
                "9- Search Favorite User Movie By Year :",
                "10- Add Favorite Movie :",
                "11- Viw Favorite Movie :",
                "12- Viw Recommendation Movie :",
                "13- Viw All Movie In Netflix:",
        };

        System.out.println("------------------MAIN MENU-----------------");

        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
}
