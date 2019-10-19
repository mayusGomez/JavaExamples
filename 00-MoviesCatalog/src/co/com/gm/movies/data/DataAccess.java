package co.com.gm.movies.data;

import co.com.gm.movies.domain.Movie;
import co.com.gm.movies.exceptions.DataReadEx;
import co.com.gm.movies.exceptions.DataWriteEx;

import java.util.List;

public interface DataAccess {

    public abstract boolean exists(String fileName);

    public abstract List<Movie> listMovies(String fileName) throws DataReadEx;

    public abstract void writeMovie(Movie movie, String fileName, boolean add) throws DataWriteEx;

    public abstract String search(String movie, String fileName)  throws DataReadEx ;

    public abstract void create(String fileName);

    public abstract void delete(String fileName);

}
