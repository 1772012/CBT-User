package com.cbtuser.container;

import com.cbtuser.controller.MainViewController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class ButtonNavigationContainer extends VBox {

    //  Set class attributes
    private Button btn = new Button();
    private int btnNumber;

    //  Class constructor
    public ButtonNavigationContainer(
            int navigationNumber,
            VBox vboxQuestion,
            ObservableList<VBox> navigationVbox,
            Label lblNavigation,
            Button prev,
            Button next,
            int size,
            MainViewController nav) {

        //  Set the VBox CSS Style
        setId("vbox-button-question-view");
        this.btnNumber = navigationNumber + 1;

        //  Create button and put attributes on it
        this.btn.setId("button-question-view");
        this.btn.setText(String.valueOf(this.btnNumber));
        this.btn.setMaxWidth(Double.MAX_VALUE);
        this.btn.setMaxHeight(Double.MAX_VALUE);
        this.btn.setOnAction((ActionEvent e) -> {
            nav.setNavigationNumber(this.btnNumber - 1);
            if (this.btnNumber - 1 == 0) {
                prev.setDisable(true);
                next.setDisable(false);
            } else if (this.btnNumber - 1 == size - 1) {
                next.setDisable(true);
                prev.setDisable(false);
            } else {
                prev.setDisable(false);
                next.setDisable(false);
            }
            vboxQuestion.getChildren().clear();
            vboxQuestion.getChildren().add(navigationVbox.
                    get(this.btnNumber - 1));
            lblNavigation.setText(String.valueOf(this.btnNumber));
        });

        //  Add this button to VBox
        getChildren().add(this.btn);
    }
}
