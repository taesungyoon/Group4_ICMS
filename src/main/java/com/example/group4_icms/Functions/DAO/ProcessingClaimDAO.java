package com.example.group4_icms.Functions.DAO;

import com.example.group4_icms.Functions.DTO.InsuranceCardDTO;
import com.example.group4_icms.Functions.DTO.ProcessingClaimDTO;
import com.example.group4_icms.entities.ProcessingClaim;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProcessingClaimDAO {
    public boolean addProcessingClaim(ProcessingClaimDTO processingClaimDTO) {
        String sql = "INSERT INTO processingClaim (Claim_ID, Applicator_ID, Surveyor_ID, Manager_ID) VALUES (?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, processingClaimDTO.getClaimID());
            pstmt.setString(2, processingClaimDTO.getApplicator_ID());
            pstmt.setString(3, processingClaimDTO.getSurveyor_ID());
            pstmt.setString(4, processingClaimDTO.getManager_ID());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateProcessingClaim(ProcessingClaimDTO processingClaimDTO) {
        String sql = "UPDATE processingClaim (Claim_ID, Applicator_ID, Surveyor_ID, Manager_ID) VALUES (?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, processingClaimDTO.getClaimID());
            pstmt.setString(2, processingClaimDTO.getApplicator_ID());
            pstmt.setString(3, processingClaimDTO.getSurveyor_ID());
            pstmt.setString(4, processingClaimDTO.getManager_ID());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getAllProcessingClaim(ProcessingClaimDTO processingClaimDTO) {
        List<String> processingClaims = new ArrayList<>();
        String sql = "SELECT * FROM processingClaim";
        try (Connection conn = JDBCUtil.connectToDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String systemadminData = "ID: " + rs.getString("cardnumber") + ", cardholder: " + rs.getString("cardholder") + ", expiration date: " + rs.getString("expirationdate") + ", policy owner: " + rs.getString("policyowner");
                processingClaims.add(systemadminData);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching : " + e.getMessage());
            e.printStackTrace();
        }
        return processingClaims;
    }


    public boolean deleteProcessingClaimByID(String ClaimID) {
        String sql = "DELETE FROM processingClaim WHERE Claim_ID = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ClaimID);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ProcessingClaimDTO getProcessingClaimById(String processingClaimID) {
        String sql = "SELECT * FROM processingClaim WHERE id = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(2, processingClaimID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                ProcessingClaimDTO processingClaim = new ProcessingClaimDTO();
                processingClaim.setClaimID(rs.getString("Claim_ID"));
                processingClaim.setID(rs.getString("ID"));
                processingClaim.setApplicator_ID(rs.getString("Applicator_ID"));
                processingClaim.setSurveyor_ID(rs.getString("Surveyor_ID"));
                processingClaim.setManager_ID(rs.getString("Mangager_ID"));
                processingClaim.setMessage(rs.getString("Message"));

                // Set additional fields if they are stored in the database
                return processingClaim;
            }
        } catch (SQLException e) {
            System.err.println("Error fetching customer by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }



}
