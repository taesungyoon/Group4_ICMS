package com.example.group4_icms.entities;

import java.time.LocalDateTime;

public class LogHistory {
    private final String userId;
    private final String role;
    private final LocalDateTime time;
    private final String log;

    public LogHistory(String userId, String role, LocalDateTime time, String log) {
        this.userId = userId;
        this.role = role;
        this.time = time;
        this.log = log;
    }
}
