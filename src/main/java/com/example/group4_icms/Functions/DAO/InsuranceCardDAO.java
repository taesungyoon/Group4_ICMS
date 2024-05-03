package com.example.group4_icms.Functions.DAO;

import com.example.group4_icms.Functions.DTO.AdminDTO;
import com.example.group4_icms.entities.Admin.SystemAdmin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.group4_icms.Functions.DTO.InsuranceCardDTO;
import com.example.group4_icms.entities.InsuranceCard;

public class InsuranceCardDAO {
    public boolean addInsuranceCard(InsuranceCardDTO insuranceCardDTO) {
        String sql = "INSERT INTO insurancecard (cardnumber, cardholder, expirationdate, policyowner) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, insuranceCardDTO.getCardNum());
            pstmt.setString(2, insuranceCardDTO.getCardHolder().toString());
            pstmt.setString(3, String.valueOf(insuranceCardDTO.getExpirationDate()));
            pstmt.setString(4, insuranceCardDTO.getPolicyOwner());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateInsuranceCard(InsuranceCardDTO insuranceCardDTO) {
        String sql = "UPDATE insurancecard SET cardnumber = ?, cardholder = ?, expirationdate = ?, policyowner = ? WHERE cardnumber = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, insuranceCardDTO.getCardNum());
            pstmt.setString(2, insuranceCardDTO.getCardHolder().getFullName());
            pstmt.setString(3, insuranceCardDTO.getExpirationDate().toString());
            pstmt.setString(4, insuranceCardDTO.getPolicyOwner());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getAllInsuranceCard(InsuranceCardDTO insuranceCardDTO) {
        List<String> InsuranceCards = new ArrayList<>();
        String sql = "SELECT * FROM insurancecard";
        try (Connection conn = JDBCUtil.connectToDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String systemadminData = "ID: " + rs.getString("cardnumber") + ", cardholder: " + rs.getString("cardholder") + ", expiration date: " + rs.getString("expirationdate") + ", policy owner: " + rs.getString("policyowner");
                InsuranceCards.add(systemadminData);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching : " + e.getMessage());
            e.printStackTrace();
        }
        return InsuranceCards;
    }

    public boolean deleteInsuranceCard(InsuranceCardDTO insuranceCardDTO) {
        String sql = "DELETE FROM insurancecard WHERE cardnumber = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, insuranceCardDTO.getCardNum());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
