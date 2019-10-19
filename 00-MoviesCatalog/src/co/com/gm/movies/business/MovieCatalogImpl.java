package co.com.gm.movies.business;

import co.com.gm.movies.data.DataAccess;
import co.com.gm.movies.data.DataAccessImpl;
import co.com.gm.movies.domain.Movie;
import co.com.gm.movies.exceptions.DataReadEx;
import co.com.gm.movies.exceptions.DataWriteEx;

import java.util.List;

public class MovieCatalogImpl implements MovieCatalog {

    DataAccess data;

    public MovieCatalogImpl(){
        this.data = new DataAccessImpl();
    }

    @Override
    public void addMovie(String movieName, String fileName) {
        Movie movie = new Movie(movieName);
        boolean add = this.data.exists(fileName);
        try {
            this.data.writeMovie(movie, fileName, add);
        } catch (DataWriteEx ex){
            System.out.println("Write data error");
            ex.printStackTrace();
        }
    }

    @Override
    public void movieList(String fileName) {
        try{
            List<Movie> movieList = this.data.listMovies(fileName);
            for (Movie movie: movieList){
                System.out.println("Movie: " + movie.getName());
            }
        } catch (DataReadEx ex){
            System.out.println("Read data error");
            ex.printStackTrace();
        }
    }

    @Override
    public void searchMovie(String movieName, String fileName) {
        String result=null;
        try{
            result = this.data.search(movieName, fileName);
        }catch (DataReadEx ex){
            System.out.println("Search error");
            ex.printStackTrace();
        }
        System.out.println("The movie founded: " + result);
    }

    @Override
    public void fileInit(String fileName) {
        this.data.create(fileName);
    }
}
