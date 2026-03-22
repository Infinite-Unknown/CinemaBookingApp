package main_running;

/**
 * Represents a movie in the cinema system.
 * @author jiahe
 */
public class Movie implements Displayable, Saveable {

    private String movieId;
    private String title;
    private String genre;
    private int durationMinutes;
    private String language;
    private String rating;
    private String description;
    private boolean isActive;

    public Movie() {
    }

    public Movie(String movieId, String title, String genre, int durationMinutes,
                 String language, String rating, String description, boolean isActive) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.durationMinutes = durationMinutes;
        this.language = language;
        this.rating = rating;
        this.description = description;
        this.isActive = isActive;
    }

    @Override
    public String getDisplayInfo() {
        return title + " (" + genre + ") - " + rating;
    }

    @Override
    public String getDetailedInfo() {
        return title + " | " + genre + " | " + durationMinutes + " min | "
                + language + " | " + rating + " | " + description;
    }

    @Override
    public String toFileString() {
        return movieId + "|" + title + "|" + genre + "|" + durationMinutes + "|"
                + language + "|" + rating + "|" + description + "|" + isActive;
    }

    public static Movie fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new Movie(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]),
                parts[4], parts[5], parts[6], Boolean.parseBoolean(parts[7]));
    }

    // Getters and Setters
    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isIsActive() { return isActive; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }

    @Override
    public String toString() {
        return title;
    }
}
