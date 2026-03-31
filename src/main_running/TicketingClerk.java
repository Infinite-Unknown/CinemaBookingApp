package main_running;

/**
 * Ticketing Clerk who can book tickets for walk-in customers and manage bookings.
 * Demonstrates: inheritance, method overriding.
 * @author Chan Hao Wen
 */
public class TicketingClerk extends User {

    private String employeeId;
    private String assignedCounter;

    public TicketingClerk() {
        super();
    }

    public TicketingClerk(String userId, String username, String password,
                          String fullName, String email, String employeeId,
                          String assignedCounter) {
        super(userId, username, password, fullName, email, "CLERK");
        this.employeeId = employeeId;
        this.assignedCounter = assignedCounter;
    }

    @Override
    public String getDashboardTitle() {
        return "Ticketing Clerk Dashboard";
    }

    @Override
    public String getDetailedInfo() {
        return getDisplayInfo() + " | Employee ID: " + employeeId + " | Counter: " + assignedCounter;
    }

    @Override
    public String toFileString() {
        return getUserId() + "|" + getUsername() + "|" + getPassword() + "|"
                + getFullName() + "|" + getEmail() + "|CLERK|"
                + employeeId + "|" + assignedCounter;
    }

    public static TicketingClerk fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new TicketingClerk(parts[0], parts[1], parts[2], parts[3],
                parts[4], parts[6], parts[7]);
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getAssignedCounter() { return assignedCounter; }
    public void setAssignedCounter(String assignedCounter) { this.assignedCounter = assignedCounter; }
}
