package com.cbtuser.controller;

import com.cbtuser.MainApp;
import com.cbtuser.dao.ParticipantDaoImpl;
import com.cbtuser.entity.Participant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class LoginViewController implements Initializable {
    
    //  FXML attributes
    @FXML
    private GridPane root;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Pane pane;
    @FXML
    private ImageView imgCbt;
    @FXML
    private ImageView imgLogo;
    @FXML
    private Pane imgPane;

    //  Create window stage
    private Stage confirmStage;
    
    //  Create dao controller
    private ParticipantDaoImpl participantDao;
    
    //  Create list of objects
    private ObservableList<Participant> participants;
    
    //  Create temp object
    private Participant loginParticipant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initFxmlControls();
        databaseControls();
    }
    
    /*
    *   Function for initialization
    */
    private void initFxmlControls() {
        //  Lock the imgCbt size to parent container
        imgCbt.fitWidthProperty().bind(pane.widthProperty());
        imgCbt.fitHeightProperty().bind(pane.heightProperty());
        imgLogo.fitWidthProperty().bind(imgPane.widthProperty());
        imgLogo.fitHeightProperty().bind(imgPane.heightProperty());

        //  Disable the TextField focus
        final BooleanProperty firstTime = new SimpleBooleanProperty(true);
        txtUsername.focusedProperty().addListener((observable, oldValue,
                newValue) -> {
            if (newValue && firstTime.get()) {
                root.requestFocus();
                firstTime.setValue(false);
            }
        });
    }

    private void databaseControls() {
        participantDao = new ParticipantDaoImpl();
        participants = FXCollections.observableArrayList();
        participants.addAll(participantDao.getAllData());
    }

    private boolean login(String username, String password) {
        boolean valid = false;
        for (int i = 0; i < participants.size(); i++) {
            if (username.equals(participants.get(i).getUsername())
                    && password.equals(participants.get(i).getPassword())) {
                valid = true;
                loginParticipant = new Participant();
                loginParticipant = participants.get(i);
                break;
            } else {
                valid = false;
            }
        }
        return valid;
    }

    @FXML
    private void btnLoginClick(ActionEvent event) {
        if (login(txtUsername.getText(), txtPassword.getText())) {
            try {
                confirmStage = new Stage();
                confirmStage.setTitle("Konfirmasi Peserta");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/UserConfirmationView.fxml"));
                BorderPane paneroot = loader.load();
                UserConfirmationViewController controller = loader.getController();
                controller.setMainController(this);
                Scene scene = new Scene(paneroot);
                confirmStage.setScene(scene);
                confirmStage.setFullScreen(true);
                confirmStage.setResizable(false);
                confirmStage.initStyle(StageStyle.UNDECORATED);
                confirmStage.initOwner(root.getScene().getWindow());
                confirmStage.initModality(Modality.APPLICATION_MODAL);
                confirmStage.setFullScreenExitHint("");
                confirmStage.
                    setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                if (!confirmStage.isShowing()) {
                    confirmStage.show();
                } else {
                    confirmStage.toFront();
                }
            } catch (IOException ex) {
                Logger.getLogger(LoginViewController.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Login Error");
            alert.setContentText("Username atau Password salah!");
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
}