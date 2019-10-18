package com.cbtuser.controller;

import com.cbtuser.MainApp;
import java.io.IOException;
import java.net.URL;
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

    private Stage confirmStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

    @FXML
    private void btnLoginClick(ActionEvent event) {
        try {
            confirmStage = new Stage();
            confirmStage.setTitle("Konfirmasi Peserta");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/UserConfirmationView.fxml"));
            BorderPane paneroot = loader.load();
            Scene scene = new Scene(paneroot);
            confirmStage.setScene(scene);
            confirmStage.setFullScreen(true);
            confirmStage.setResizable(false);
            confirmStage.initStyle(StageStyle.UNDECORATED);
            confirmStage.initOwner(root.getScene().getWindow());
            confirmStage.initModality(Modality.APPLICATION_MODAL);
            confirmStage.setFullScreenExitHint("No Escape :)");

            if (!confirmStage.isShowing()) {
                confirmStage.show();
            } else {
                confirmStage.toFront();
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginViewController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

}
