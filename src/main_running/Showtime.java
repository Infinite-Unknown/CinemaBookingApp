package main_running;

/**
 * Represents a movie showtime/screening.
 * @author Chan Hao Wen
 */
public class Showtime implements Displayable, Saveable {

    private String showtimeId;
    private String movieId;
    private String hallNumber;
    private String date;
    private String time;
    private double basePrice;
    private int totalSeats;
    private int availableSeats;

    public Showtime() {
    }

    public Showtime(String showtimeId, String movieId, String hallNumber,
                    String date, String time, double basePrice,
                    int totalSeats, int availableSeats) {
        this.showtimeId = showtimeId;
        this.movieId = movieId;
        this.hallNumber = hallNumber;
        this.date = date;
        this.time = time;
        this.basePrice = basePrice;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    @Override
    public String getDisplayInfo() {
        return hallNumber + " | " + date + " " + time + " | RM " + String.format("%.2f", basePrice);
    }

    @Override
    public String getDetailedInfo() {
        return hallNumber + " | " + date + " " + time + " | RM " + String.format("%.2f", basePrice)
                + " | Seats: " + availableSeats + "/" + totalSeats;
    }

    @Override
    public String toFileString() {
        return showtimeId + "|" + movieId + "|" + hallNumber + "|" + date + "|"
                + time + "|" + basePrice + "|" + totalSeats + "|" + availableSeats;
    }

    public static Showtime fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new Showtime(parts[0], parts[1], parts[2], parts[3],
                parts[4], Double.parseDouble(parts[5]),
                Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
    }

    // Getters and Setters
    public String getShowtimeId() { return showtimeId; }
    public void setShowtimeId(String showtimeId) { this.showtimeId = showtimeId; }

    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }

    public String getHallNumber() { return hallNumber; }
    public void setHallNumber(String hallNumber) { this.hallNumber = hallNumber; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }

    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }

    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

    @Override
    public String toString() {
        return getDisplayInfo();
    }
}
