package com.cbtuser.controller;

import com.cbtuser.MainApp;
import com.cbtuser.entity.Participant;
import com.cbtuser.entity.Subtest;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Radeon
 */
public class TestConfirmationViewController implements Initializable {

    //  FXML Attributes
    @FXML
    private BorderPane root;
    @FXML
    private Pane pane;
    @FXML
    private ImageView imgCbt;
    @FXML
    private Label lblNameHead;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblPtcpNo;
    @FXML
    private Label lblPtcpName;
    @FXML
    private Label lblName;
    @FXML
    private Label lblPtcpGen;
    @FXML
    private Label lblTkn;
    @FXML
    private Button btnConfirm;
    @FXML
    private Label lblPtcpGen1;
    @FXML
    private Label lblWelcomeHead;
    @FXML
    private Label lblNrpHead;
    @FXML
    private Label lblTestname;
    @FXML
    private Label lblTestDate;
    @FXML
    private Label lblDuration;
    @FXML
    private Label lblTestTime;
    
    //  Create window stage
    private Stage testStage;
    
    //  Create main controller
    private UserConfirmationViewController mainController;
    
    //  Create temp object
    private Participant loginParticipant;
    private Subtest subtest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initFxmlControls();
    }
    
    /*
    *   Main controller initialize
     */
    public void setMainController(UserConfirmationViewController mainController) throws ParseException {
        this.mainController = mainController;
        loginParticipant = this.mainController.getLoginParticipant();
        subtest = this.mainController.getSubtest();
        lblNameHead.setText(loginParticipant.getName());
        lblNrpHead.setText(loginParticipant.getId());
        lblTestname.setText(subtest.getTest().getName());
        lblName.setText(subtest.getName());
        lblTestDate.setText(String.valueOf(dateFormatter(String.valueOf(subtest.getTestDate()))));
        lblTestTime.setText(String.valueOf(subtest.getDateStart()) + " - " + String.valueOf(subtest.getDateFinish()));
        lblDuration.setText(String.valueOf(subtest.getTime() + " menit"));
    }

    @FXML
    private void btnConfirmClick(ActionEvent event) {
        try {
            testStage = new Stage();
            testStage.setTitle("Tes");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/QuestionContainerView.fxml"));
            BorderPane paneroot = loader.load();
            Scene scene = new Scene(paneroot);
            testStage.setScene(scene);
            testStage.setFullScreen(true);
            testStage.setResizable(false);
            testStage.initStyle(StageStyle.UNDECORATED);
            testStage.initOwner(root.getScene().getWindow());
            testStage.initModality(Modality.APPLICATION_MODAL);
            testStage.setFullScreenExitHint("No Escape :)");
            testStage.
                    setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

            if (!testStage.isShowing()) {
                testStage.show();
            } else {
                testStage.toFront();
            }
        } catch (IOException ex) {
            Logger.getLogger(TestConfirmationViewController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    *   Function for initialization
    */
    public void initFxmlControls() {
        imgCbt.fitWidthProperty().bind(pane.widthProperty());
        imgCbt.fitHeightProperty().bind(pane.heightProperty());
    }
    
    /*
    *   Usable functions
    */
    private Date dateFormatter(String dateInput) throws ParseException {
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = dateFormat.parse(dateInput);
        return date;
    }

}
