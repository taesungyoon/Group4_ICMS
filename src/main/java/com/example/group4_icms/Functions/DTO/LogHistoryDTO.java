package com.example.group4_icms.Functions.DTO;

import java.time.LocalDateTime;

public class LogHistoryDTO {
    private final String userId;
    private final String role;
    private final LocalDateTime time;
    private final String log;

    public LogHistoryDTO(String userId, String role, LocalDateTime time, String log) {
        this.userId = userId;
        this.role = role;
        this.time = time;
        this.log = log;
    }

    public String getRole() {
        return role;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getLog() {
        return log;
    }
}
