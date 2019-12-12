package com.cbtuser.container;

import com.cbtuser.controller.MainViewController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;

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
        setId("box-navigation");
        this.btnNumber = navigationNumber + 1;

        //  Create button and put attributes on it
        this.btn.setId("button-blue");
        this.btn.setText(String.valueOf(this.btnNumber));
        this.btn.setMaxWidth(Double.MAX_VALUE);
        this.btn.setMaxHeight(Double.MAX_VALUE);

        this.btn.setOnAction((ActionEvent e) -> {

            nav.setPreviousNav(nav.getNavigationNumber());

            navigationVbox.get(nav.getPreviousNav()).getChildren().forEach(
                    (qst) -> {
                        if (qst instanceof VideoPlayer) {
                            VideoPlayer vp = (VideoPlayer) qst;
                            if (vp.getPlayer().getStatus() == MediaPlayer.Status.PLAYING) {
                                vp.getPlayer().pause();
                                vp.getController().getBtnPlay().setId(
                                        "button-play");
                            }
                        } else if (qst instanceof AudioPlayer) {
                            AudioPlayer ap = (AudioPlayer) qst;
                            if (ap.getPlayer().getStatus() == MediaPlayer.Status.PLAYING) {
                                ap.getPlayer().pause();
                                ap.getBtnPlay().setId("button-play");
                            }
                        }
                    });

            QuestionContainer qst = (QuestionContainer) navigationVbox.get(
                    this.btnNumber - 1);

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

            if (((QuestionContainer) nav.getNavigationVbox().get(
                    this.btnNumber - 1)).getUserAnswerKey() == -1) {
                if (!((QuestionContainer) nav.getNavigationVbox().get(
                        this.btnNumber - 1)).isChecked()) {
                    nav.getBoxNumberChange().setId("box-container-blue");
                    nav.getBoxLayout1Change().setId("box-container-blue");
                    nav.getBoxLayout2Change().setId("box-container-blue");
                    nav.getVboxQuestion().setId("box-border-blue");
                } else {
                    nav.getBoxNumberChange().setId("box-container-yellow");
                    nav.getBoxLayout1Change().setId("box-container-yellow");
                    nav.getBoxLayout2Change().setId("box-container-yellow");
                    nav.getVboxQuestion().setId("box-border-yellow");
                }
            } else {
                if (!((QuestionContainer) nav.getNavigationVbox().get(
                        this.btnNumber - 1)).isChecked()) {
                    nav.getBoxNumberChange().setId("box-container-green");
                    nav.getBoxLayout1Change().setId("box-container-green");
                    nav.getBoxLayout2Change().setId("box-container-green");
                    nav.getVboxQuestion().setId("box-border-green");
                } else {
                    nav.getBoxNumberChange().setId("box-container-yellow");
                    nav.getBoxLayout1Change().setId("box-container-yellow");
                    nav.getBoxLayout2Change().setId("box-container-yellow");
                    nav.getVboxQuestion().setId("box-border-yellow");
                }
            }

        });

        //  Add this button to VBox
        getChildren().add(this.btn);
    }
}
