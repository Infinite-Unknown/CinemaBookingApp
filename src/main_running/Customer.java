package main_running;

/**
 * Customer user who can register, book tickets, and view bookings.
 */
public class Customer extends User {

    private String phoneNumber;
    private String registrationDate;

    public Customer() {
        super();
    }

    public Customer(String userId, String username, String password,
                    String fullName, String email, String phoneNumber,
                    String registrationDate) {
        super(userId, username, password, fullName, email, "CUSTOMER");
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
    }

    @Override
    public String getDashboardTitle() {
        return "Customer Dashboard";
    }

    @Override
    public String getDetailedInfo() {
        return getDisplayInfo() + " | Phone: " + phoneNumber + " | Registered: " + registrationDate;
    }

    @Override
    public String toFileString() {
        return getUserId() + "|" + getUsername() + "|" + getPassword() + "|"
                + getFullName() + "|" + getEmail() + "|CUSTOMER|"
                + phoneNumber + "|" + registrationDate;
    }

    public static Customer fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new Customer(parts[0], parts[1], parts[2], parts[3],
                parts[4], parts[6], parts[7]);
    }

    // Getters and Setters
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(String registrationDate) { this.registrationDate = registrationDate; }
}
