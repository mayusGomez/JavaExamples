package co.com.gm.movies.data;

import co.com.gm.movies.domain.Movie;
import co.com.gm.movies.exceptions.DataReadEx;
import co.com.gm.movies.exceptions.DataWriteEx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessImpl implements DataAccess{

    @Override
    public boolean exists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    @Override
    public List<Movie> listMovies(String fileName) throws DataReadEx {
        File file = new File(fileName);
        List<Movie> movieList = new ArrayList<Movie>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String movieLine = br.readLine();
            while (movieLine != null){
                Movie movie = new Movie(movieLine);
                movieList.add(movie);
                movieLine = br.readLine();
            }
            br.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return movieList;
    }

    @Override
    public void writeMovie(Movie movie, String fileName, boolean add)  throws DataWriteEx {
        try{
            File file = new File(fileName);
            PrintWriter pw = new PrintWriter(new FileWriter(file, add));
            pw.println(movie.getName());
            pw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String search(String movie, String fileName) throws DataReadEx {
        File file = new File(fileName);
        String result=null;
        try{
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String catalogLine = bf.readLine();
            while (catalogLine != null){
                if (catalogLine.equals(movie)) {
                    result = catalogLine;
                    break;
                }
                else
                    catalogLine = bf.readLine();
            }
            bf.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void create(String fileName) {
        try{
            File file = new File(fileName);
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            pw.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String fileName) {
        File file = new File(fileName);
        file.delete();
    }
}
