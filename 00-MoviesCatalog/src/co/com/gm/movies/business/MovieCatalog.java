package co.com.gm.movies.business;

public interface MovieCatalog {

    public abstract void addMovie(String movieName, String fileName);

    public abstract void movieList(String fileName);

    public abstract void searchMovie(String movieName, String fileName);

    public abstract void fileInit(String fileName);

}
