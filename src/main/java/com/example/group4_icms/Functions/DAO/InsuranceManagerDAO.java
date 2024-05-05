package com.example.group4_icms.Functions.DAO;

import com.example.group4_icms.Functions.DTO.CustomerDTO;
import com.example.group4_icms.Functions.DTO.InsuranceEmployeeDTO;
import com.example.group4_icms.Functions.DTO.InsuranceManagerDTO;
import com.example.group4_icms.entities.InsuranceEmployee.InsuranceManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsuranceManagerDAO {
    Connection conn;
    PreparedStatement pstmt;
// 수정해야됨

    public boolean addInsuranceManager(InsuranceManagerDTO InsuranceManagerDTO) {
        String sql = "INSERT INTO insurancemanager (c_id, password, phonenumber, address, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, InsuranceManagerDTO.getID());
            pstmt.setString(2, InsuranceManagerDTO.getPassword());
            pstmt.setString(3, InsuranceManagerDTO.getPhone());
            pstmt.setString(4, InsuranceManagerDTO.getAddress());
            pstmt.setString(5, InsuranceManagerDTO.getEmail());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateInsuranceManager(InsuranceManagerDTO InsuranceManagerDTO) {
        String sql = "UPDATE insurancemanager SET password = ?, phonenumber = ?, address = ?, email = ? WHERE c_id = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, InsuranceManagerDTO.getPassword());
            pstmt.setString(2, InsuranceManagerDTO.getPhone());
            pstmt.setString(3, InsuranceManagerDTO.getAddress());
            pstmt.setString(4, InsuranceManagerDTO.getEmail());
            pstmt.setString(5, InsuranceManagerDTO.getID());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getAllInsuranceManager(InsuranceManagerDTO InsuranceManagerDTO) {
        List<String> customers = new ArrayList<>();
        String sql = "SELECT * FROM insurancemanager";
        try (Connection conn = JDBCUtil.connectToDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String customerData = "ID: " + rs.getString("c_id") + ", password: " + rs.getString("password") + ", phoneNumber: " + rs.getString("phonenumber") + ", address: " + rs.getString("address") + ", email: " + rs.getString("email");
                customers.add(customerData);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching customers: " + e.getMessage());
            e.printStackTrace();
        }
        return customers;
    }

    public boolean deleteInsuranceManager(InsuranceManagerDTO InsuranceManagerDTO) {
        String sql = "DELETE FROM insurancemanager WHERE p_id = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, InsuranceManagerDTO.getID());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
