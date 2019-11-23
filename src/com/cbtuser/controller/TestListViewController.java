package com.cbtuser.controller;

import com.cbtuser.entity.Subtest;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Redwolfer
 */
public class TestListViewController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private ListView<Subtest> listViewSubtest;
    
    private MainViewController mainController;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setMainController(MainViewController mainController) {
        this.mainController = mainController;
        listViewSubtest.setItems(this.mainController.getSubtest());
        
    }

    @FXML
    private void btnListViewClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
}
