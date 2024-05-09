package com.example.group4_icms.Functions.DTO;

<<<<<<< Updated upstream
import java.time.LocalDateTime;
=======
import java.sql.Timestamp;
>>>>>>> Stashed changes

public class LogHistoryDTO {
    private final String userId;
    private final String role;
<<<<<<< Updated upstream
    private final LocalDateTime time;
    private final String log;

    public LogHistoryDTO(String userId, String role, LocalDateTime time, String log) {
        this.userId = userId;
        this.role = role;
        this.time = time;
=======
    private final Timestamp time;
    private final String log;

    public LogHistoryDTO(String userId, String role, String log) {
        Long datetime = System.currentTimeMillis(); // Return time now.
        Timestamp timestamp = new Timestamp(datetime);
        this.userId = userId;
        this.role = role;
        this.time = timestamp;
>>>>>>> Stashed changes
        this.log = log;
    }

    public String getRole() {
        return role;
    }

    public String getUserId() {
        return userId;
    }

<<<<<<< Updated upstream
    public LocalDateTime getTime() {
=======
    public Timestamp getTime() {
>>>>>>> Stashed changes
        return time;
    }

    public String getLog() {
        return log;
    }
}
