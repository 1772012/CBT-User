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

    private Stage startStage;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgCbt.fitWidthProperty().bind(pane.widthProperty());
        imgCbt.fitHeightProperty().bind(pane.heightProperty());

        final BooleanProperty firstTime = new SimpleBooleanProperty(true);
        txtToken.focusedProperty().addListener((observable, oldValue,
                newValue) -> {
            if (newValue && firstTime.get()) {
                root.requestFocus();
                firstTime.setValue(false);
            }
        });
    }

    @FXML
    private void btnConfirmClick(ActionEvent event) {
        try {
            startStage = new Stage();
            startStage.setTitle("Konfirmasi Tes");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/TestConfirmationView.fxml"));
            BorderPane paneroot = loader.load();
            Scene scene = new Scene(paneroot);
            startStage.setScene(scene);
            startStage.setFullScreen(true);
            startStage.setResizable(false);
            startStage.initStyle(StageStyle.UNDECORATED);
            startStage.initOwner(root.getScene().getWindow());
            startStage.initModality(Modality.APPLICATION_MODAL);
            startStage.setFullScreenExitHint("No Escape :)");
            startStage.
                    setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

            if (!startStage.isShowing()) {
                startStage.show();
            } else {
                startStage.toFront();
            }
        } catch (IOException ex) {
            Logger.getLogger(UserConfirmationViewController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

}
