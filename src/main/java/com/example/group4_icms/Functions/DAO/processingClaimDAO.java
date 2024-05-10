package com.example.group4_icms.Functions.DAO;

import com.example.group4_icms.Functions.DTO.ClaimDTO;
import com.example.group4_icms.Functions.DTO.ProcessingClaimDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class processingClaimDAO {

    public boolean addProcessingClaim(ProcessingClaimDTO processingClaimDTO){String sql = "INSERT INTO processingClaim (Claim_ID,Surveyor_ID,Applicator_ID,processingClaim_ID,created_at,Manager_ID,Message) VALUES (?, ?, ?, ?, ?, ?,?)";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, processingClaimDTO.getClaim_ID());
            pstmt.setString(2, processingClaimDTO.getSurveyor_ID());
            pstmt.setString(3, processingClaimDTO.getApplicator_ID());
            pstmt.setInt(4,processingClaimDTO.getProcessingClaim_id());
            pstmt.setTimestamp(5, processingClaimDTO.getCreated_at());
            pstmt.setString(6, processingClaimDTO.getManager_ID());
            pstmt.setString(7, processingClaimDTO.getMessage());


            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void deleteProcessingClaim(ProcessingClaimDTO processingClaimDTO){}
    public boolean updateProcessingClaim(ProcessingClaimDTO processingClaimDTO){String sql = "UPDATE processingClaim SET Surveyor_ID = ?, Manager_ID = ?, Message = ? WHERE processingClaim_ID = ?";
        try (Connection conn = JDBCUtil.connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, processingClaimDTO.getSurveyor_ID());
            pstmt.setString(2, processingClaimDTO.getManager_ID());
            pstmt.setString(3, processingClaimDTO.getMessage());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }}
    public void updateSurveyorID(ProcessingClaimDTO processingClaimDTO,String surveyorID){
        processingClaimDTO.setSurveyor_ID(surveyorID);
        updateProcessingClaim(processingClaimDTO);

    }
    public void updateManagerID(ProcessingClaimDTO processingClaimDTO,String managerID){
        processingClaimDTO.setSurveyor_ID(managerID);
        updateProcessingClaim(processingClaimDTO);
    }
    public void confirmProcessingClaim(ProcessingClaimDTO processingClaimDTO){
        ClaimDAO c1 = new ClaimDAO();
        ClaimDTO target = c1.getClaimByID(processingClaimDTO.getClaim_ID());
        target.setStatus("Done");
        c1.updateClaim(target);
        updateProcessingClaim(processingClaimDTO);
    }
    public void denyProcessingClaim(ProcessingClaimDTO processingClaimDTO,String message){
        processingClaimDTO.setMessage(message);
        updateProcessingClaim(processingClaimDTO);
    }

}
