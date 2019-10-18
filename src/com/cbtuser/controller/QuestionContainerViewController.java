package com.cbtuser.controller;

import com.cbtuser.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Redwolfer
 */
public class QuestionContainerViewController implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private Pane logoPane;
    @FXML
    private ImageView imgCbt;
    @FXML
    private Label lblNameHead;
    @FXML
    private Label lblWelcomeHead;
    @FXML
    private Label lblNrpHead;
    @FXML
    private HBox hoxpane;
    @FXML 
    private Button btn1, btn2;
    
    private ObservableList<Button> btnList;
    
    private ObservableList<Label> lblList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource(("/com/cbtuser/view/NormalQuestionView.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(QuestionContainerViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        parent.prefHeight(10);
        parent.prefWidth(10);
        
    }
    
}
