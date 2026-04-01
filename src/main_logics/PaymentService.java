package main_logics;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import main_running.*;

/**
 * Handles payment processing and receipt generation.
 * @author Chan Hao Wen
 */
public class PaymentService {

    private static final String PAYMENTS_FILE = "payments.txt";

    // Process a payment
    public Payment processPayment(String bookingId, double amount,
                                   String paymentMethod, double discount) throws IOException {
        String paymentId = FileHandler.generateNextId(PAYMENTS_FILE, "P");
        String paymentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Payment payment = new Payment(paymentId, bookingId, amount,
                paymentMethod, paymentDate, "COMPLETED", discount);
        FileHandler.appendLine(PAYMENTS_FILE, payment.toFileString());
        return payment;
    }

    // Refund a payment
    public void refundPayment(String bookingId) throws IOException {
        List<String> lines = FileHandler.readLines(PAYMENTS_FILE);
        for (String line : lines) {
            Payment payment = Payment.fromFileString(line);
            if (payment.getBookingId().equals(bookingId)) {
                payment.setStatus("REFUNDED");
                FileHandler.updateLine(PAYMENTS_FILE, payment.getPaymentId(), payment.toFileString());
                break;
            }
        }
    }

    // Get all payments
    public List<Payment> getAllPayments() throws IOException {
        List<Payment> payments = new ArrayList<>();
        List<String> lines = FileHandler.readLines(PAYMENTS_FILE);
        for (String line : lines) {
            payments.add(Payment.fromFileString(line));
        }
        return payments;
    }

    // Get payment by booking ID
    public Payment getPaymentByBooking(String bookingId) throws IOException {
        List<String> lines = FileHandler.readLines(PAYMENTS_FILE);
        for (String line : lines) {
            Payment payment = Payment.fromFileString(line);
            if (payment.getBookingId().equals(bookingId)) {
                return payment;
            }
        }
        return null;
    }

    // Calculate total revenue
    public double getTotalRevenue() throws IOException {
        double total = 0;
        List<Payment> payments = getAllPayments();
        for (Payment p : payments) {
            if (p.getStatus().equals("COMPLETED")) {
                total += p.getAmount();
            }
        }
        return total;
    }

    // Generate receipt string
    public String generateReceipt(Booking booking, Payment payment,
                                   Movie movie, Showtime showtime) {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("         CINEMA BOOKING RECEIPT         \n");
        sb.append("========================================\n");
        sb.append("Booking ID  : ").append(booking.getBookingId()).append("\n");
        sb.append("Movie       : ").append(movie.getTitle()).append("\n");
        sb.append("Hall        : ").append(showtime.getHallNumber()).append("\n");
        sb.append("Date        : ").append(showtime.getDate()).append("\n");
        sb.append("Time        : ").append(showtime.getTime()).append("\n");
        sb.append("Seats       : ").append(booking.getSeatNumbers()).append("\n");
        sb.append("----------------------------------------\n");
        sb.append("Subtotal    : RM ").append(String.format("%.2f", payment.getAmount() + payment.getDiscountApplied())).append("\n");
        if (payment.getDiscountApplied() > 0) {
            sb.append("Discount    : RM ").append(String.format("%.2f", payment.getDiscountApplied())).append("\n");
        }
        sb.append("Total Paid  : RM ").append(String.format("%.2f", payment.getAmount())).append("\n");
        sb.append("Payment     : ").append(payment.getPaymentMethod()).append("\n");
        sb.append("Status      : ").append(payment.getStatus()).append("\n");
        sb.append("Date        : ").append(payment.getPaymentDate()).append("\n");
        sb.append("========================================\n");
        sb.append("        Thank you for your visit!       \n");
        sb.append("========================================\n");
        return sb.toString();
    }
}
