package com.example.group4_icms.Functions.Filtering;

import com.example.group4_icms.Functions.DTO.ClaimDTO;

import java.util.ArrayList;

public class ClaimSearching {
    private ArrayList<ClaimDTO> Claims = new ArrayList<>();

    public ClaimSearching(ArrayList<ClaimDTO> claims) {
        Claims = claims;
    }
    public ArrayList<ClaimDTO> ClaimSearchingUserID(String UserID){
        ArrayList<ClaimDTO> result = new ArrayList<>();
        for (ClaimDTO claim : Claims) {
            if(claim.getId().equals(UserID)){

            }
        }
        return result;

    }
    public ArrayList<ClaimDTO> ClaimSearchingCardNum(String CardNum){
        ArrayList<ClaimDTO> result = new ArrayList<>();
        for (ClaimDTO claim : Claims) {
            if(claim.getCardNum().equals(CardNum)){
            }
        }
        return result;

    }
    public ArrayList<ClaimDTO> ClaimSearchingExamDate(String ExamDate){
        ArrayList<ClaimDTO> result = new ArrayList<>();
        for (ClaimDTO claim : Claims) {
            if(claim.getExamDate().equals(ExamDate)){
                result.add(claim);
            }
        }
        return result;
    }
    public ArrayList<ClaimDTO> ClaimSearchingStatus(ClaimDTO.Status Status){
        ArrayList<ClaimDTO> result = new ArrayList<>();
        for (ClaimDTO claim : Claims) {
            if(claim.getStatus().equals(Status)){            result.add(claim);
            }
        }
        return result;
    }
    public ArrayList<ClaimDTO> ClaimSearchingSearchingByID(String SearchingByID){
        ArrayList<ClaimDTO> result = new ArrayList<>();
        for (ClaimDTO claim : Claims) {
            if(claim.getId().equals(SearchingByID)){
                result.add(claim);
            }
        }
        return result;
    }
}
