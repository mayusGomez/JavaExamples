package co.com.gm.movies.main;

import co.com.gm.movies.business.MovieCatalog;
import co.com.gm.movies.business.MovieCatalogImpl;

import java.util.Scanner;

public class Main {

    private static final String fileName = "c:\\pruebaJava\\movieCatalog.txt";
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int option= 0;
        MovieCatalog movieCatalog = new MovieCatalogImpl();

        printOptions();
        option = scan.nextInt();

        while (option != 0){

            switch (option){
                case 1:
                    movieCatalog.fileInit(fileName);
                    break;
                case 2:
                    System.out.println("-------------");
                    System.out.println("Please input the movie name");
                    String movieName = scan.next();
                    System.out.println("The movie " + movieName.toString()+ " will be write to the catalog");
                    movieCatalog.addMovie(movieName, fileName);
                    break;
                case 3:
                    System.out.println("-------------");
                    movieCatalog.movieList(fileName);
                    break;
                case 4:
                    System.out.println("Input movie name:");
                    String search = scan.next();
                    movieCatalog.searchMovie(search, fileName);
                    break;
                case 0:
                    break;
            }
            System.out.println("-----------------");
            printOptions();
            option = scan.nextInt();
        }

    }

    public static void printOptions(){
        System.out.println("Please choice your option:");
        System.out.println("1 - Init Catalog");
        System.out.println("2 - Add movie");
        System.out.println("3 - List movies");
        System.out.println("4 - Search movie");
        System.out.println("0 - exit");
    }

}
