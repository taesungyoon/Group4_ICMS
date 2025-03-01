package app;



import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Timestamp;
import java.util.List;

public class prcoessingClaimController {

    @FXML
    private TableView<ProcessingClaimDTO> processingClaimsTable;

    @FXML
    private TableColumn<ProcessingClaimDTO, Integer> processingClaimIdCol;

    @FXML
    private TableColumn<ProcessingClaimDTO, String> claimIdCol;

    @FXML
    private TableColumn<ProcessingClaimDTO, String> applicatorIdCol;

    @FXML
    private TableColumn<ProcessingClaimDTO, String> surveyorIdCol;

    @FXML
    private TableColumn<ProcessingClaimDTO, String> managerIdCol;

    @FXML
    private TableColumn<ProcessingClaimDTO, Timestamp> createdAtCol;

    @FXML
    private TableColumn<ProcessingClaimDTO, String> messageCol;

    private processingClaimDAO dao = new processingClaimDAO();

    @FXML
    public void initialize() {
        // Retrieve all processing claims from the database
        List<ProcessingClaimDTO> processingClaims = dao.getAllProcessingClaims();

        // Populate the TableView
        processingClaimsTable.getItems().addAll(processingClaims);

        // Bind column value factories
        processingClaimIdCol.setCellValueFactory(cellData -> cellData.getValue().getProcessingClaim_id().asObject());
        claimIdCol.setCellValueFactory(cellData -> {
            return cellData.getValue().getClaim_ID();
        });
        applicatorIdCol.setCellValueFactory(cellData -> cellData.getValue().getApplicator_ID());
        surveyorIdCol.setCellValueFactory(cellData -> cellData.getValue().getSurveyor_ID());
        managerIdCol.setCellValueFactory(cellData -> cellData.getValue().getManager_ID());
        createdAtCol.setCellValueFactory(cellData -> cellData.getValue().getCreated_at());
        messageCol.setCellValueFactory(cellData -> cellData.getValue().getMessage());
    }
}
