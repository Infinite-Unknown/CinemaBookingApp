package main_logics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main_running.Movie;

public class MovieService {

    private static final String MOVIES_FILE = "movies.txt";
   
    
    public List<Movie> getAllMovies() throws IOException {
        List<Movie> movies = new ArrayList<>();
        List<String> lines = FileHandler.readLines(MOVIES_FILE);
        for (String line : lines) {
            movies.add(Movie.fromFileString(line));
        }
        System.out.println("Movies loaded: " + movies.size());
        return movies;
    }

    public List<Movie> getActiveMovies() throws IOException {
        List<Movie> movies = new ArrayList<>();
        List<String> lines = FileHandler.readLines(MOVIES_FILE);
        for (String line : lines) {
            Movie movie = Movie.fromFileString(line);
            if (movie.isIsActive()) {
                movies.add(movie);
            }
        }
        return movies;
    }

    public Movie getMovieById(String movieId) throws IOException {
        List<String> lines = FileHandler.readLines(MOVIES_FILE);
        for (String line : lines) {
            Movie movie = Movie.fromFileString(line);
            if (movie.getMovieId().equals(movieId)) {
                return movie;
            }
        }
        return null;
    }

    public void addMovie(Movie movie) throws IOException {
        FileHandler.appendLine(MOVIES_FILE, movie.toFileString());
    }

    public void updateMovie(Movie movie) throws IOException {
        FileHandler.updateLine(MOVIES_FILE, movie.getMovieId(), movie.toFileString());
    }

    // dont actually delete, just set inactive
    public void deleteMovie(String movieId) throws IOException {
        Movie movie = getMovieById(movieId);
        if (movie != null) {
            movie.setIsActive(false);
            updateMovie(movie);
        }
    }

    public String generateMovieId() throws IOException {
        return FileHandler.generateNextId(MOVIES_FILE, "M");
    }
}
