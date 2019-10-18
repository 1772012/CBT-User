package com.cbtuser.controller;

import com.cbtuser.MainApp;
import java.io.IOException;
import java.net.URL;
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
    private Label lblGen1;
    @FXML
    private Button btnConfirm;
    @FXML
    private Label lblPtcpGen1;
    @FXML
    private Label lblGen2;
    
    private Stage testStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgCbt.fitWidthProperty().bind(pane.widthProperty());
        imgCbt.fitHeightProperty().bind(pane.heightProperty());
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
            Logger.getLogger(UserConfirmationViewController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

}
