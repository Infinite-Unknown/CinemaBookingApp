package main_running;

/**
 * Represents a payment transaction.
 * @author jiahe
 */
public class Payment implements Displayable, Saveable {

    private String paymentId;
    private String bookingId;
    private double amount;
    private String paymentMethod;
    private String paymentDate;
    private String status;
    private double discountApplied;

    public Payment() {
    }

    public Payment(String paymentId, String bookingId, double amount,
                   String paymentMethod, String paymentDate, String status,
                   double discountApplied) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.status = status;
        this.discountApplied = discountApplied;
    }

    @Override
    public String getDisplayInfo() {
        return paymentId + " | RM " + String.format("%.2f", amount) + " | " + paymentMethod + " | " + status;
    }

    @Override
    public String getDetailedInfo() {
        return paymentId + " | Booking: " + bookingId + " | RM " + String.format("%.2f", amount)
                + " | Method: " + paymentMethod + " | Date: " + paymentDate
                + " | Status: " + status + " | Discount: RM " + String.format("%.2f", discountApplied);
    }

    @Override
    public String toFileString() {
        return paymentId + "|" + bookingId + "|" + amount + "|" + paymentMethod
                + "|" + paymentDate + "|" + status + "|" + discountApplied;
    }

    public static Payment fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new Payment(parts[0], parts[1], Double.parseDouble(parts[2]),
                parts[3], parts[4], parts[5], Double.parseDouble(parts[6]));
    }

    // Getters and Setters
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public String getBookingId() { return bookingId; }
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getDiscountApplied() { return discountApplied; }
    public void setDiscountApplied(double discountApplied) { this.discountApplied = discountApplied; }
}
