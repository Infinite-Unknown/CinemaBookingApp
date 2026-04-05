package main_logics;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import main_running.*;

/**
 * Handles booking operations including seat management.
 * @author Chan Hao Wen
 */
public class BookingService {

    private static final String BOOKINGS_FILE = "bookings.txt";
    private static final String SEATS_FILE = "seats.txt";
    private static final String SHOWTIMES_FILE = "showtimes.txt";

    // Create a booking
    public Booking createBooking(String customerId, String showtimeId, List<String> seatNumbers, String bookedBy) throws Exception {
        // Check seats are available
        for (String seatNum : seatNumbers) {
            Seat seat = getSeatByShowtimeAndNumber(showtimeId, seatNum);
            if (seat == null || seat.isIsBooked()) {
                throw new Exception("Seat " + seatNum + " is not available");
            }
        }

        // Mark seats as booked
        for (String seatNum : seatNumbers) {
            Seat seat = getSeatByShowtimeAndNumber(showtimeId, seatNum);
            seat.setIsBooked(true);
            FileHandler.updateLine(SEATS_FILE, seat.getSeatId(), seat.toFileString());
        }

        // Update available seats count on showtime
        ShowtimeService stService = new ShowtimeService();
        Showtime showtime = stService.getShowtimeById(showtimeId);
        showtime.setAvailableSeats(showtime.getAvailableSeats() - seatNumbers.size());
        stService.updateShowtime(showtime);

        // Calculate total
        double total = showtime.getBasePrice() * seatNumbers.size();

        // Create booking record
        String bookingId = FileHandler.generateNextId(BOOKINGS_FILE, "B");
        String bookingDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String seats = String.join(",", seatNumbers);

        Booking booking = new Booking(bookingId, customerId, showtimeId, seats, bookingDate, "CONFIRMED", total, bookedBy);
        FileHandler.appendLine(BOOKINGS_FILE, booking.toFileString());

        return booking;
    }

    // Cancel a booking
    public void cancelBooking(String bookingId) throws Exception {
        Booking booking = getBookingById(bookingId);
        if (booking == null) {
            throw new Exception("Booking not found");
        }

        // Free the seats
        String[] seatNumbers = booking.getSeatNumbers().split(",");
        for (String seatNum : seatNumbers) {
            Seat seat = getSeatByShowtimeAndNumber(booking.getShowtimeId(), seatNum);
            if (seat != null) {
                seat.setIsBooked(false);
                FileHandler.updateLine(SEATS_FILE, seat.getSeatId(), seat.toFileString());
            }
        }

        // Update available seats count
        ShowtimeService stService = new ShowtimeService();
        Showtime showtime = stService.getShowtimeById(booking.getShowtimeId());
        if (showtime != null) {
            showtime.setAvailableSeats(showtime.getAvailableSeats() + seatNumbers.length);
            stService.updateShowtime(showtime);
        }

        // Update booking status
        booking.setStatus("CANCELLED");
        FileHandler.updateLine(BOOKINGS_FILE, bookingId, booking.toFileString());
    }

    // Get booking by ID
    public Booking getBookingById(String bookingId) throws IOException {
        List<String> lines = FileHandler.readLines(BOOKINGS_FILE);
        for (String line : lines) {
            Booking b = Booking.fromFileString(line);
            if (b.getBookingId().equals(bookingId)) {
                return b;
            }
        }
        return null;
    }

    // Get bookings for a customer
    public List<Booking> getBookingsByCustomer(String customerId) throws IOException {
        List<Booking> bookings = new ArrayList<>();
        List<String> lines = FileHandler.readLines(BOOKINGS_FILE, customerId, 1);
        for (String line : lines) {
            bookings.add(Booking.fromFileString(line));
        }
        return bookings;
    }

    // Get all bookings
    public List<Booking> getAllBookings() throws IOException {
        List<Booking> bookings = new ArrayList<>();
        List<String> lines = FileHandler.readLines(BOOKINGS_FILE);
        for (String line : lines) {
            bookings.add(Booking.fromFileString(line));
        }
        return bookings;
    }

    // Get available seats for a showtime
    public List<Seat> getAvailableSeats(String showtimeId) throws IOException {
        List<Seat> seats = new ArrayList<>();
        List<String> lines = FileHandler.readLines(SEATS_FILE, showtimeId, 1);
        for (String line : lines) {
            Seat seat = Seat.fromFileString(line);
            if (!seat.isIsBooked()) {
                seats.add(seat);
            }
        }
        return seats;
    }

    // Get all seats for a showtime
    public List<Seat> getSeatsByShowtime(String showtimeId) throws IOException {
        List<Seat> seats = new ArrayList<>();
        List<String> lines = FileHandler.readLines(SEATS_FILE, showtimeId, 1);
        for (String line : lines) {
            seats.add(Seat.fromFileString(line));
        }
        return seats;
    }

    // Initialize seats for a new showtime (5 rows x 10 cols = 50 seats)
    public void initializeSeats(String showtimeId) throws IOException {
        String[] rows = {"A", "B", "C", "D", "E"};
        int seatCounter = 1;
        for (String row : rows) {
            for (int col = 1; col <= 10; col++) {
                String seatId = FileHandler.generateNextId(SEATS_FILE, "SE");
                String seatNumber = row + col;
                String seatType = "STANDARD";
                if (row.equals("D") || row.equals("E")) {
                    seatType = "PREMIUM";
                }
                Seat seat = new Seat(seatId, showtimeId, seatNumber, seatType, false);
                FileHandler.appendLine(SEATS_FILE, seat.toFileString());
                seatCounter++;
            }
        }
    }

    // Get seat by showtime and seat number
    private Seat getSeatByShowtimeAndNumber(String showtimeId, String seatNumber) throws IOException {
        List<String> lines = FileHandler.readLines(SEATS_FILE, showtimeId, 1);
        for (String line : lines) {
            Seat seat = Seat.fromFileString(line);
            if (seat.getSeatNumber().equals(seatNumber)) {
                return seat;
            }
        }
        return null;
    }

    // Calculate total with discount
    public double calculateTotal(Showtime showtime, int numSeats, double discountPercent) {
        double subtotal = showtime.getBasePrice() * numSeats;
        double discount = subtotal * (discountPercent / 100.0);
        return subtotal - discount;
    }
}
