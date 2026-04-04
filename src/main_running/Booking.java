package main_running;

/**
 * Represents a ticket booking.
 * @author Chan Hao Wen
 */
public class Booking implements Displayable, Saveable {

    private String bookingId;
    private String customerId;
    private String showtimeId;
    private String seatNumbers;
    private String bookingDate;
    private String status;
    private double totalAmount;
    private String bookedBy;

    public Booking() {
    }

    public Booking(String bookingId, String customerId, String showtimeId, String seatNumbers, String bookingDate, String status, double totalAmount, String bookedBy) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.showtimeId = showtimeId;
        this.seatNumbers = seatNumbers;
        this.bookingDate = bookingDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.bookedBy = bookedBy;
    }

    @Override
    public String getDisplayInfo() {
        return bookingId + " | Seats: " + seatNumbers + " | RM " + String.format("%.2f", totalAmount) + " | " + status;
    }

    @Override
    public String getDetailedInfo() {
        return bookingId + " | Customer: " + customerId + " | Showtime: " + showtimeId + " | Seats: " + seatNumbers + " | Date: " + bookingDate + " | RM " + String.format("%.2f", totalAmount) + " | " + status;
    }

    @Override
    public String toFileString() {
        return bookingId + "|" + customerId + "|" + showtimeId + "|" + seatNumbers + "|" + bookingDate + "|" + status + "|" + totalAmount + "|" + bookedBy;
    }

    public static Booking fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new Booking(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], Double.parseDouble(parts[6]), parts[7]);
    }

    public String getBookingId() { return bookingId; }
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getShowtimeId() { return showtimeId; }
    public void setShowtimeId(String showtimeId) { this.showtimeId = showtimeId; }

    public String getSeatNumbers() { return seatNumbers; }
    public void setSeatNumbers(String seatNumbers) { this.seatNumbers = seatNumbers; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getBookedBy() { return bookedBy; }
    public void setBookedBy(String bookedBy) { this.bookedBy = bookedBy; }
}
