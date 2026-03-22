package main_logics;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import main_running.*;

/**
 * Handles user authentication and registration.
 * Demonstrates: polymorphism (returns User but actual type varies).
 * @author jiahe
 */
public class AuthService {

    private static final String USERS_FILE = "users.txt";

    // Login - returns polymorphic User object
    public User login(String username, String password) throws Exception {
        List<String> lines = FileHandler.readLines(USERS_FILE);
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts[1].equals(username) && parts[2].equals(password)) {
                return parseUser(line);
            }
        }
        throw new Exception("Invalid username or password");
    }

    // Register a new customer
    public Customer registerCustomer(String username, String password,
                                      String fullName, String email,
                                      String phoneNumber) throws Exception {
        if (usernameExists(username)) {
            throw new Exception("Username already exists");
        }
        String userId = FileHandler.generateNextId(USERS_FILE, "U");
        String regDate = LocalDate.now().toString();
        Customer customer = new Customer(userId, username, password,
                fullName, email, phoneNumber, regDate);
        FileHandler.appendLine(USERS_FILE, customer.toFileString());
        return customer;
    }

    // Check if username already exists
    public boolean usernameExists(String username) throws IOException {
        List<String> lines = FileHandler.readLines(USERS_FILE);
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts[1].equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Update user profile
    public void updateUser(User user) throws IOException {
        FileHandler.updateLine(USERS_FILE, user.getUserId(), user.toFileString());
    }

    // Parse a user line into the correct subclass based on role field
    private User parseUser(String line) {
        String[] parts = line.split("\\|");
        String role = parts[5];
        switch (role) {
            case "MANAGER":
                return Manager.fromFileString(line);
            case "CLERK":
                return TicketingClerk.fromFileString(line);
            case "CUSTOMER":
                return Customer.fromFileString(line);
            default:
                return null;
        }
    }
}
