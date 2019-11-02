package com.cbtuser.controller;

import com.cbtuser.entity.Subtest;
import com.cbtuser.entity.Test;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Redwolfer
 */
public class TestCheckViewController implements Initializable {

    @FXML
    private TableView<Subtest> tblSubtest;
    @FXML
    private TableColumn<Subtest, String> colSubTestName;
    @FXML
    private TableColumn<Subtest, String> conSubTestQty;
    @FXML
    private GridPane root;
    
    //  Create main controller
    private TestConfirmationViewController mainController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setMainController(TestConfirmationViewController mainController) {
        this.mainController = mainController;
        Test test = new Test();
        test.setId(this.mainController.getTest().getId());   
        this.mainController.getSubtest().addAll(this.mainController.getSubtestDaoImpl().getSpecificSubtest(test));
        tblSubtest.setItems(this.mainController.getSubtest());
        colSubTestName.setCellValueFactory(data -> {
            Subtest subtest = data.getValue();
            return new SimpleStringProperty(subtest.getName());
        });
        conSubTestQty.setCellValueFactory(data -> {
            Subtest subtest = data.getValue();
            return new SimpleStringProperty(String.valueOf(subtest.getAmount()));
        });
    }

    @FXML
    private void btnOkClick(ActionEvent event) {
        root.getScene().getWindow().hide();
    }
    
}
