package com.cbtuser.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

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
    }

}
