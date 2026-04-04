package main_running;

// Manager user class
// @author jiahe
public class Manager extends User {

    private String employeeId;

    public Manager() {
        super();
    }

    public Manager(String userId, String username, String password,
                   String fullName, String email, String employeeId) {
        super(userId, username, password, fullName, email, "MANAGER");
        this.employeeId = employeeId;
    }

    @Override
    public String getDashboardTitle() {
        return "Cinema Manager Dashboard";
    }

    @Override
    public String getDetailedInfo() {
        return getDisplayInfo() + " | Employee ID: " + employeeId;
    }

    @Override
    public String toFileString() {
        return getUserId() + "|" + getUsername() + "|" + getPassword() + "|"
                + getFullName() + "|" + getEmail() + "|MANAGER|" + employeeId;
    }

    public static Manager fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new Manager(parts[0], parts[1], parts[2], parts[3],
                parts[4], parts[6]);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
