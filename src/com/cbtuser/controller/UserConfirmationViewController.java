package com.cbtuser.controller;

import com.cbtuser.MainApp;
import com.cbtuser.dao.TestDaoImpl;
import com.cbtuser.entity.Participant;
import com.cbtuser.entity.Test;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
public class UserConfirmationViewController implements Initializable {

    //  FXML attributes
    @FXML
    private BorderPane root;
    @FXML
    private Pane pane;
    @FXML
    private ImageView imgCbt;
    @FXML
    private Label lblNameHead;
    @FXML
    private TextField txtToken;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblPtcpNo;
    @FXML
    private Label lblNo;
    @FXML
    private Label lblPtcpName;
    @FXML
    private Label lblName;
    @FXML
    private Label lblPtcpGen;
    @FXML
    private Label lblGen;
    @FXML
    private Label lblTkn;
    @FXML
    private Button btnConfirm;
    @FXML
    private Label lblWelcomeHead;
    @FXML
    private Label lblNrpHead;
    @FXML
    private Label lblInstitute;

    //  Create main controller
    private LoginViewController mainController;

    //  Create temp objects
    private Participant loginParticipant;
    private Test test;

    //  Create dao controller
    private TestDaoImpl testDao;

    //  Create window stage
    private Stage startStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initFxmlControls();
        testDao = new TestDaoImpl();
    }

    /*
    *   Function for initialization
    */
    private void initFxmlControls() {
        //  Lock the imgCbt size to parent container
        imgCbt.fitWidthProperty().bind(pane.widthProperty());
        imgCbt.fitHeightProperty().bind(pane.heightProperty());

        //  Disable the TextField focus
        final BooleanProperty firstTime = new SimpleBooleanProperty(true);
        txtToken.focusedProperty().addListener((observable, oldValue,
                newValue) -> {
            if (newValue && firstTime.get()) {
                root.requestFocus();
                firstTime.setValue(false);
            }
        });
    }
    
    private boolean checkToken() {
        boolean valid;
        Test tempTest = new Test();
        tempTest.setToken(txtToken.getText());
        test = testDao.getOneData(tempTest);
        valid = (test != null);
        return valid;
    }
    
    /*
    *   Main controller initialize
     */
    public void setMainController(LoginViewController mainController) {
        this.mainController = mainController;
        loginParticipant = this.mainController.getLoginParticipant();
        lblNo.setText(loginParticipant.getId());
        lblName.setText(loginParticipant.getName());
        lblNameHead.setText(loginParticipant.getName());
        lblNrpHead.setText(loginParticipant.getId());
        lblGen.setText(loginParticipant.getGender());
        lblInstitute.setText(String.valueOf(loginParticipant.getInstitute().getName()));
    }

    @FXML
    private void btnConfirmClick(ActionEvent event) throws ParseException {
        if (checkToken()) {
            try {
                startStage = new Stage();
                startStage.setTitle("Konfirmasi Tes");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/TestConfirmationView.fxml"));
                BorderPane paneroot = loader.load();
                TestConfirmationViewController controller = loader.getController();
                controller.setMainController(this);
                Scene scene = new Scene(paneroot);
                startStage.setScene(scene);
                startStage.setFullScreen(true);
                startStage.setResizable(false);
                startStage.initStyle(StageStyle.UNDECORATED);
                startStage.initOwner(root.getScene().getWindow());
                startStage.initModality(Modality.APPLICATION_MODAL);
                startStage.setFullScreenExitHint("");
                startStage.
                        setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                if (!startStage.isShowing()) {
                    startStage.show();
                } else {
                    startStage.toFront();
                    root.getScene().getWindow().hide();
                }
            } catch (IOException ex) {
                Logger.getLogger(UserConfirmationViewController.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Token invalid");
            alert.setContentText("Token salah!");
            alert.initOwner(root.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.show();
        }
    }

    /*
    *   Getter / Setter
    */
    public Participant getLoginParticipant() {
        return loginParticipant;
    }

    public Test getTest() {
        return test;
    }
}
