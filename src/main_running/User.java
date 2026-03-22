package main_running;

/**
 * Abstract base class for all user types in the cinema system.
 * Demonstrates: abstract class, interfaces, encapsulation, constructor overloading.
 */
public abstract class User implements Displayable, Saveable {

    private String userId;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String role;

    // No-arg constructor (constructor overloading)
    public User() {
    }

    // Parameterized constructor (constructor overloading)
    public User(String userId, String username, String password,
                String fullName, String email, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }

    // Abstract method - subclasses must override
    public abstract String getDashboardTitle();

    @Override
    public String getDisplayInfo() {
        return fullName + " (" + role + ")";
    }

    // Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return getDisplayInfo();
    }
}
