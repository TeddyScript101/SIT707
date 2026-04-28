package ontrack;

public class StudentProfile {

    private String studentId;
    private String firstName;
    private String lastName;
    private String preferredName;
    private String email;
    private boolean notifyMessages;
    private boolean notifyPortfolio;
    private boolean notifyNewTasks;

    public StudentProfile(String studentId, String firstName, String lastName, String email) {
        if (studentId == null || studentId.trim().isEmpty())
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        if (firstName == null || firstName.trim().isEmpty())
            throw new IllegalArgumentException("First name cannot be null or empty.");
        if (lastName == null || lastName.trim().isEmpty())
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email address.");

        this.studentId = studentId.trim();
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.email = email.trim();
        this.preferredName = firstName.trim();
        this.notifyMessages = true;
        this.notifyPortfolio = true;
        this.notifyNewTasks = true;
    }

    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

    public String getPreferredName() { return preferredName; }

    public void setPreferredName(String preferredName) {
        if (preferredName == null || preferredName.trim().isEmpty())
            throw new IllegalArgumentException("Preferred name cannot be null or empty.");
        this.preferredName = preferredName.trim();
    }

    public boolean isNotifyMessages() { return notifyMessages; }
    public void setNotifyMessages(boolean notifyMessages) { this.notifyMessages = notifyMessages; }

    public boolean isNotifyPortfolio() { return notifyPortfolio; }
    public void setNotifyPortfolio(boolean notifyPortfolio) { this.notifyPortfolio = notifyPortfolio; }

    public boolean isNotifyNewTasks() { return notifyNewTasks; }
    public void setNotifyNewTasks(boolean notifyNewTasks) { this.notifyNewTasks = notifyNewTasks; }

    @Override
    public String toString() {
        return "StudentProfile{studentId='" + studentId + "', firstName='" + firstName
                + "', lastName='" + lastName + "', preferredName='" + preferredName
                + "', email='" + email + "', notifyMessages=" + notifyMessages
                + ", notifyPortfolio=" + notifyPortfolio + ", notifyNewTasks=" + notifyNewTasks + "}";
    }
}
