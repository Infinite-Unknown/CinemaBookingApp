package main_logics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main_running.Showtime;

// showtime service for managing showtimes
public class ShowtimeService {

    private static final String SHOWTIMES_FILE = "showtimes.txt";

    public List<Showtime> getAllShowtimes() throws IOException {
        List<Showtime> showtimes = new ArrayList<>();
        List<String> lines = FileHandler.readLines(SHOWTIMES_FILE);
        for (String line : lines) {
            showtimes.add(Showtime.fromFileString(line));
        }
        return showtimes;
    }

    public List<Showtime> getShowtimesByMovie(String movieId) throws IOException {
        List<Showtime> showtimes = new ArrayList<>();
        List<String> lines = FileHandler.readLines(SHOWTIMES_FILE, movieId, 1);
        for (String line : lines) {
            showtimes.add(Showtime.fromFileString(line));
        }
        return showtimes;
    }

    public Showtime getShowtimeById(String showtimeId) throws IOException {
        List<String> lines = FileHandler.readLines(SHOWTIMES_FILE);
        for (String line : lines) {
            Showtime st = Showtime.fromFileString(line);
            if (st.getShowtimeId().equals(showtimeId)) {
                return st;
            }
        }
        return null;
    }

    public void addShowtime(Showtime showtime) throws IOException {
        FileHandler.appendLine(SHOWTIMES_FILE, showtime.toFileString());
    }

    public void updateShowtime(Showtime showtime) throws IOException {
        FileHandler.updateLine(SHOWTIMES_FILE, showtime.getShowtimeId(), showtime.toFileString());
    }

    public void deleteShowtime(String showtimeId) throws IOException {
        FileHandler.deleteLine(SHOWTIMES_FILE, showtimeId);
    }

    public String generateShowtimeId() throws IOException {
        return FileHandler.generateNextId(SHOWTIMES_FILE, "ST");
    }
}
