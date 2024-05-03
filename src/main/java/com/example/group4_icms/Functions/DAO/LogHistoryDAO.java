package com.example.group4_icms.Functions.DAO;

import com.example.group4_icms.Functions.DTO.AdminDTO;
import com.example.group4_icms.Functions.DTO.CustomerDTO;
import com.example.group4_icms.Functions.DTO.LogHistoryDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogHistoryDAO {
    public boolean addLogHistory(LogHistoryDTO logHistoryDTO) {
        String sql = "INSERT INTO log_history (user_id, create_at, role, log) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.connectToDatabase();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, logHistoryDTO.getUserId());
            pstmt.setString(2, String.valueOf(logHistoryDTO.getTime()));
            pstmt.setString(3, logHistoryDTO.getRole());
            pstmt.setString(4, logHistoryDTO.getLog());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
    }
    public List<String> getAllLogHistory(LogHistoryDTO logHistoryDTO) {
        List<String> LogHistories = new ArrayList<>();
        String sql = "SELECT * FROM log_history";
        try (Connection conn = JDBCUtil.connectToDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String systemLogHistoryData = "ID: " + rs.getString("user_id") + ", time : " + rs.getString("create_at") + ", role: " + rs.getString("role") + ", address: " + rs.getString("address") + ", log: " + rs.getString("log");
                LogHistories.add(systemLogHistoryData);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching: " + e.getMessage());
            e.printStackTrace();
        }
        return LogHistories;
    }

    public boolean deleteLogHistory(LogHistoryDTO logHistoryDTO) {
        String sql = "DELETE FROM LogHistories WHERE user_id = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, logHistoryDTO.getUserId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



}
