package com.example.group4_icms.Functions.DAO;

import com.example.group4_icms.Functions.DTO.AdminDTO;
import com.example.group4_icms.Functions.DTO.ClaimDTO;
import com.example.group4_icms.entities.Claim;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClaimDAO {

    Connection conn;
    PreparedStatement pstmt;

    public boolean addClaim(ClaimDTO claim) {

        String sql = "INSERT INTO claim (f_id, claimdate,examdate, claimamount, insuredpersonid, submittedbyid) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, claim.getId());
            pstmt.setObject(2, claim.getClaimDate());
            pstmt.setObject(3, claim.getExamDate());
            pstmt.setDouble(4, claim.getClaimAmount());
            pstmt.setString(5, claim.getInsuredPersonId());
            pstmt.setString(6, claim.getSubmittedById());


            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateClaim(ClaimDTO claim) {
        String sql = "UPDATE claim SET examdate = ?, claimamount = ? WHERE f_id = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, claim.getExamDate());
            pstmt.setDouble(2, claim.getClaimAmount());
            pstmt.setString(3, claim.getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getAllClaims() {
        List<String> claims = new ArrayList<>();
        String sql = "SELECT * FROM claim";
        try (Connection conn = JDBCUtil.connectToDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String customerData = "ID: " + rs.getString("f_id") + ", ExamDate: " + rs.getString("examdate") + ", claimAmount: " + rs.getString("claimamount");
                claims.add(customerData);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching customers: " + e.getMessage());
            e.printStackTrace();
        }
        return claims;
    }

    public Claim getOneClaim(String claimID){
        String sql = "SELECT * FROM claim WHERE f_id = ?";
        Claim result = null;

        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, claimID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new Claim();
                result.setID(rs.getString("f_id"));
                result.setExamDate(LocalDate.parse(rs.getString("examdate")));
                result.setClaimAmount(Integer.parseInt(rs.getString("claimamount")));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching claim: " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }
    public boolean deleteClaim(String claimID) {
        String sql = "DELETE FROM claim WHERE c_id = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, claimID);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public ClaimDTO returnClaim(String claimID){
//        ClaimDTO claim = null;
//        String sql = "SELECT * FROM claim WHERE c_id = ?";
//        try (Connection conn = JDBCUtil.connectToDatabase();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, claimID);
//            ResultSet rs = pstmt.executeQuery();
//
//            // 결과 처리
//            if (rs.next()) {
//                claim = new ClaimDTO();
//                claim.setId(rs.getString("c_id"));
//                claim.setClaimDate(LocalDate.parse(rs.getString("password")));
//                claim.setInsuredPersonId(rs.getString(""));
//                claim.setCardNum(rs.getString("address"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return claim;
//    }





    public boolean addClaimbyPolicyOwner(ClaimDTO claim, String policyOwnerId) {
        String sql = "INSERT INTO claim (f_id, claimdate, examdate, claimamount, insuredpersonid, submittedbyid, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, claim.getId());
            pstmt.setObject(2, claim.getClaimDate());
            pstmt.setObject(3, claim.getExamDate());
            pstmt.setDouble(4, claim.getClaimAmount());
            pstmt.setString(5, claim.getInsuredPersonId());
            pstmt.setString(6, policyOwnerId);
            pstmt.setString(7, claim.getStatus().toString());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateClaimbyPolicyOwner(ClaimDTO claim, String policyOwnerId) {
        String sql = "UPDATE claim SET claimdate = ?, examdate = ?, claimamount = ?, insuredpersonid = ?, submittedbyid = ?, status = ? WHERE f_id = ? AND submittedbyid = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, claim.getClaimDate());
            pstmt.setObject(2, claim.getExamDate());
            pstmt.setDouble(3, claim.getClaimAmount());
            pstmt.setString(4, claim.getInsuredPersonId());
            pstmt.setString(5, policyOwnerId);
            pstmt.setString(6, claim.getStatus().toString());
            pstmt.setString(7, claim.getId());
            pstmt.setString(8, policyOwnerId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<ClaimDTO> findClaimsByPolicyHolder(String policyHolderId) {
        List<ClaimDTO> claims = new ArrayList<>();
        String sql = "SELECT * FROM claim WHERE submittedbyid = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, policyHolderId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                claims.add(mapRowToClaimDTO(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return claims;
    }
    public List<ClaimDTO> findClaimsByInsuredPersonId(String insuredPersonId) {
        List<ClaimDTO> claims = new ArrayList<>();
        String sql = "SELECT * FROM claim WHERE insuredpersonid = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, insuredPersonId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                claims.add(mapRowToClaimDTO(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return claims;
    }
    public ClaimDTO findClaimById(String claimId) {
        String sql = "SELECT * FROM claim WHERE f_id = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, claimId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapRowToClaimDTO(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private ClaimDTO mapRowToClaimDTO(ResultSet rs) throws SQLException {
        ClaimDTO claim = new ClaimDTO();
        claim.setId(rs.getString("f_id"));
        // LocalDateTime으로 변경
        claim.setExamDate(rs.getObject("examdate", LocalDate.class));
        claim.setClaimAmount(rs.getDouble("claimamount"));
        claim.setInsuredPersonId(rs.getString("insuredpersonid"));
        claim.setSubmittedById(rs.getString("submittedbyid"));
        return claim;
    }

    public boolean deleteClaimbyPolicyOwner(String claimId, String policyOwnerId) {
        String sql = "DELETE FROM claim WHERE f_id = ? AND submittedbyid = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, claimId);
            pstmt.setString(2, policyOwnerId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> searchClaimsByPolicyOwner(String policyOwnerId) {
        List<String> claims = new ArrayList<>();
        String sql = "SELECT * FROM claim WHERE submittedbyid = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, policyOwnerId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String claimDetail = "ID: " + rs.getString("f_id") +
                        ", Claim Date: " + rs.getDate("claimdate") +
                        ", Exam Date: " + rs.getDate("examdate") +
                        ", Claim Amount: " + rs.getDouble("claimamount") +
                        ", Insured Person ID: " + rs.getString("insuredpersonid") +
                        ", Submitted By ID: " + rs.getString("submittedbyid") +
                        ", Status: " + rs.getString("status");
                claims.add(claimDetail);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching claims for policy owner: " + e.getMessage());
            e.printStackTrace();
        }
        return claims;
    }



}
