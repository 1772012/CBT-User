package com.cbtuser.controller;

import com.cbtuser.MainApp;
import com.cbtuser.dao.SubtestDaoImpl;
import com.cbtuser.entity.Participant;
import com.cbtuser.entity.Subtest;
import com.cbtuser.entity.Test;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    private Stage subtestStage;

    //  Create main controller
    private UserConfirmationViewController mainController;

    //  Create temp object
    private Participant loginParticipant;
    private Test test;
    private ObservableList<Subtest> subtests;

    //  Create dao controller
    private SubtestDaoImpl subtestDao;

    //  Create coordinate config
    private double xOffset;
    private double yOffset;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initFxmlControls();
        subtestDao = new SubtestDaoImpl();
        subtests = FXCollections.observableArrayList();
//        Test test = new Test();
//        test.setId(this.mainController.getTest().getId());   
//        this.mainController.getSubtest().addAll(this.mainController.getSubtestDaoImpl().getSpecificSubtest(test));
    }

    /*
    *   Main controller initialize
     */
    public void setMainController(UserConfirmationViewController mainController) throws ParseException {
        this.mainController = mainController;
        loginParticipant = this.mainController.getLoginParticipant();
        test = this.mainController.getTest();
        subtests.addAll(subtestDao.getSpecificSubtest(test));
        lblNameHead.setText(loginParticipant.getFirstName() + " " + loginParticipant.getLastName());
        lblNrpHead.setText(loginParticipant.getId());
        lblTestname.setText(test.getName());
        lblTestDate.setText(String.valueOf(dateFormatter(String.valueOf(test.getDate()))));
        lblTestTime.setText(String.valueOf(test.getStartTime()) + " - " + String.valueOf(test.getFinishTime()));
        lblDuration.setText(String.valueOf(test.getTime() + " menit"));
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
            QuestionContainerViewController controller = loader.getController();
            controller.setMainController(this);
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
                root.getScene().getWindow().hide();
            }

        } catch (IOException ex) {
            Logger.getLogger(TestConfirmationViewController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnCekSubtes(ActionEvent event) {
        try {
            subtestStage = new Stage();
            subtestStage.setTitle("Cek Subtest");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/TestCheckView.fxml"));
            GridPane gridpane = loader.load();
            TestCheckViewController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(gridpane);
            subtestStage.setScene(scene);
            subtestStage.setResizable(false);
            subtestStage.initStyle(StageStyle.UNDECORATED);
            subtestStage.initOwner(root.getScene().getWindow());
            subtestStage.initModality(Modality.APPLICATION_MODAL);
            subtestStage.setFullScreenExitHint("");
            
            gridpane.setOnMousePressed((MouseEvent event1) -> {
                xOffset = subtestStage.getX() - event1.getScreenX();
                yOffset = subtestStage.getY() - event1.getScreenY();
            });

            gridpane.setOnMouseDragged((MouseEvent event1) -> {
                subtestStage.setX(event1.getScreenX() + xOffset);
                subtestStage.setY(event1.getScreenY() + yOffset);
            });
            
            if (!subtestStage.isShowing()) {
                subtestStage.show();
            } else {
                subtestStage.toFront();
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

    /*
    *   Getter / Setter
     */
    public Participant getLoginParticipant() {
        return loginParticipant;
    }

    public Test getTest() {
        return test;
    }

    public SubtestDaoImpl getSubtestDaoImpl() {
        return subtestDao;
    }

    public ObservableList<Subtest> getSubtest() {
        return subtests;
    }

}
