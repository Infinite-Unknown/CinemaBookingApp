package main_running;

/**
 * Represents an individual seat for a showtime.
 * @author jiahe
 */
public class Seat implements Displayable, Saveable {

    private String seatId;
    private String showtimeId;
    private String seatNumber;
    private String seatType;
    private boolean isBooked;

    public Seat() {
    }

    public Seat(String seatId, String showtimeId, String seatNumber,
                String seatType, boolean isBooked) {
        this.seatId = seatId;
        this.showtimeId = showtimeId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isBooked = isBooked;
    }

    @Override
    public String getDisplayInfo() {
        return seatNumber + " (" + seatType + ") - " + (isBooked ? "Booked" : "Available");
    }

    @Override
    public String getDetailedInfo() {
        return "Seat " + seatNumber + " | Type: " + seatType
                + " | Status: " + (isBooked ? "Booked" : "Available");
    }

    @Override
    public String toFileString() {
        return seatId + "|" + showtimeId + "|" + seatNumber + "|" + seatType + "|" + isBooked;
    }

    public static Seat fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new Seat(parts[0], parts[1], parts[2], parts[3],
                Boolean.parseBoolean(parts[4]));
    }

    // Getters and Setters
    public String getSeatId() { return seatId; }
    public void setSeatId(String seatId) { this.seatId = seatId; }

    public String getShowtimeId() { return showtimeId; }
    public void setShowtimeId(String showtimeId) { this.showtimeId = showtimeId; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public String getSeatType() { return seatType; }
    public void setSeatType(String seatType) { this.seatType = seatType; }

    public boolean isIsBooked() { return isBooked; }
    public void setIsBooked(boolean isBooked) { this.isBooked = isBooked; }
}
