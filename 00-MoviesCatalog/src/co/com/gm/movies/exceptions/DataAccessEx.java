package co.com.gm.movies.exceptions;

public class DataAccessEx extends Exception{
    String message;

    public DataAccessEx(String message){
        this.message = message;
    }
}
