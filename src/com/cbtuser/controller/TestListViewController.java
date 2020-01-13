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
 * @author Kafka Febianto Agiharta - 1772012
 *
 * TestListViewController is controller class used to show test
 */
public class TestListViewController implements Initializable {

    /**
     * Class FXML Attributes
     */
    @FXML
    private VBox root;
    @FXML
    private ListView<Subtest> listViewSubtest;

    /**
     * Main Controller
     */
    private MainViewController mainController;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Initialize the controller class
     *
     * @param mainController
     */
    public void setMainController(MainViewController mainController) {
        this.mainController = mainController;
        listViewSubtest.setItems(this.mainController.getSubtest());
    }

    /**
     * Close button clicked
     *
     * @param event
     */
    @FXML
    private void btnListViewClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
