package com.example.group4_icms.Functions.DAO;

import com.example.group4_icms.Functions.DTO.AdminDTO;
import com.example.group4_icms.Functions.DTO.CustomerDTO;
import com.example.group4_icms.entities.Admin.SystemAdmin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminDAO {
    Connection conn;
    PreparedStatement  pstmt;
    public boolean addAdmin(AdminDTO adminDTO) {
        String sql = "INSERT INTO systemadmin (a_id, password,fullname,  email, phonenumber,address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, adminDTO.getID());
            pstmt.setString(2, adminDTO.getPassword());
            pstmt.setString(3, adminDTO.getFullName());
            pstmt.setString(4, adminDTO.getEmail());
            pstmt.setString(5, adminDTO.getPhone());
            pstmt.setString(6, adminDTO.getAddress());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCustomer(AdminDTO adminDTO) {
        String sql = "UPDATE systemadmin SET password = ?, fullname = ?, phonenumber = ?, address = ?, email = ? WHERE a_id = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(2, adminDTO.getPassword());
            pstmt.setString(3, adminDTO.getFullName());
            pstmt.setString(4, adminDTO.getEmail());
            pstmt.setString(5, adminDTO.getPhone());
            pstmt.setString(6, adminDTO.getAddress());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getAllAdmins(AdminDTO adminDTO) {
        List<String> Admins = new ArrayList<>();
        String sql = "SELECT * FROM systemadmin";
        try (Connection conn = JDBCUtil.connectToDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String systemadminData = "ID: " + rs.getString("c_id") + ", password: " + rs.getString("password") + ", phoneNumber: " + rs.getString("phonenumber") + ", address: " + rs.getString("address") + ", email: " + rs.getString("email");
                Admins.add(systemadminData);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching customers: " + e.getMessage());
            e.printStackTrace();
        }
        return Admins;
    }

    public boolean deleteAdmin(AdminDTO adminDTO) {
        String sql = "DELETE FROM systemadmin WHERE a_id = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, adminDTO.getID());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public AdminDTO returnAdmin(String adminID){
        AdminDTO admin = null;
        String sql = "SELECT * FROM systemadmin WHERE a_id = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, adminID);
            ResultSet rs = pstmt.executeQuery();

            // 결과 처리
            if (rs.next()) {
                admin = new AdminDTO();
                admin.setID(rs.getString("a_id"));
                admin.setPassword(rs.getString("password"));
                admin.setPhone(rs.getString("phonenumber"));
                admin.setAddress(rs.getString("address"));
                admin.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }


}
