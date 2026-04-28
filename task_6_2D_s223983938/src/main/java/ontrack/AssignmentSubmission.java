package ontrack;

public class AssignmentSubmission {

    public enum SubmissionStatus {
        READY_FOR_FEEDBACK, RESUBMIT, DISCUSS, COMPLETE, NOT_STARTED
    }

    private final String unitCode;
    private final String studentId;
    private final String taskId;
    private final String fileName;
    private final byte[] fileContent;
    private final String comment;
    private SubmissionStatus status;
    private final long submittedAt;

    public AssignmentSubmission(String unitCode, String studentId, String taskId,
                                String fileName, byte[] fileContent, String comment) {
        if (unitCode == null || unitCode.trim().isEmpty())
            throw new IllegalArgumentException("Unit code cannot be null or empty.");
        if (studentId == null || studentId.trim().isEmpty())
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        if (taskId == null || taskId.trim().isEmpty())
            throw new IllegalArgumentException("Task ID cannot be null or empty.");
        if (fileName == null || fileName.trim().isEmpty())
            throw new IllegalArgumentException("File name cannot be null or empty.");
        if (fileContent == null || fileContent.length == 0)
            throw new IllegalArgumentException("File content cannot be null or empty.");
        if (!fileName.toLowerCase().endsWith(".pdf"))
            throw new IllegalArgumentException("Only PDF files are accepted.");

        this.unitCode = unitCode.trim();
        this.studentId = studentId.trim();
        this.taskId = taskId.trim();
        this.fileName = fileName.trim();
        this.fileContent = fileContent;
        this.comment = comment;
        this.status = SubmissionStatus.READY_FOR_FEEDBACK;
        this.submittedAt = System.currentTimeMillis();
    }

    public String getUnitCode() { return unitCode; }
    public String getStudentId() { return studentId; }
    public String getTaskId() { return taskId; }
    public String getFileName() { return fileName; }
    public byte[] getFileContent() { return fileContent; }
    public String getComment() { return comment; }
    public long getSubmittedAt() { return submittedAt; }

    public SubmissionStatus getStatus() { return status; }

    public void setStatus(SubmissionStatus s) {
        if (s == null) throw new IllegalArgumentException("Status cannot be null.");
        this.status = s;
    }
}
